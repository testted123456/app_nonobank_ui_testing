package com.nonobank.apps.utils.file;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.testng.Assert;

public class ParseXML {
	
	public static Logger logger = LogManager.getLogger(ParseXML.class);
	
	public static File getFile(String filePath){
		URL url = ParseXML.class.getClassLoader().getResource(filePath);
		String path = null;
		
		try {
			path = java.net.URLDecoder.decode(url.getFile(),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		File file = new File(path);
		return file;
	}
	
	/**
	 * 根据子节点的name获取子节点
	 * @param pElement
	 * @param elementName
	 * @return
	 */
	public static Element getElement(Element pElement, String elementName){
		List<Element> list = pElement.elements("element");
		
		for(Element element : list){
			if(element.attribute("name").getText().trim().equals(elementName)){
				return element;
			}
		}
		return null;
	}
	
	/**
	 * 获取ios元素的xpath
	 * @param elementName
	 * @param file
	 * @return
	 */
	public static String getElementXpath(String elementName, String file, String platform){
		SAXReader reader = new SAXReader();
		Document doc;
		
		try {
			file = java.net.URLDecoder.decode(file,"UTF-8");
		} catch (UnsupportedEncodingException e1) {							
			e1.printStackTrace();
		}
		
		File f = getFile(file);
		
		try{
			doc = reader.read(f);
			Element root = doc.getRootElement();
			Element element = getElement(root, elementName);
			
			if(element != root){
				List<Element> propElements = element.elements("prop");
				String propValue = null;
				
				for(Element e : propElements){
					String propName = e.attribute("name").getText();
					
					if(propName.equals(platform)){
						propValue = e.getTextTrim();
						break;
					}
				}
				return propValue;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			doc = null;
			reader = null;
		}
		
		return null;
	}
	
	/**
	 * 获取android元素属性，
	 * @param elementPath 元素在xml文件中的路径
	 * @param file xml文件路径
	 * @return
	 */
	public static String getAndroidUISelector(String elementPath, String file){
		StringBuilder props = new StringBuilder();
		
		SAXReader reader = new SAXReader();
		Document doc;
		
		try {
			file = java.net.URLDecoder.decode(file,"UTF-8");
		} catch (UnsupportedEncodingException e1) {							
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		File f = getFile(file);
		
		try{
			doc = reader.read(f);
			Element root = doc.getRootElement();
			
			String [] pathArray = elementPath.split("-");
			
			int levels = pathArray.length;
			
			for(int i=0;i<levels;i++){
				String prop = "new UiSelector()";
				String elementName = pathArray[i];
				root = getElement(root, elementName);
				
				if(null != root){
					List<Element> propElements = root.elements("prop");
					
					for(Element element : propElements){
						String propName = element.attribute("name").getText();
						String propValue = element.getTextTrim();
						if(!propName.equals("index")){
							propValue = "\"" + propValue + "\"";
						}
						prop = prop + "." + propName + "(" + propValue + ")";
					}
				}else{
					String errMsg = "xml文件" + file + "中找不到元素：" + elementName;
					logger.error(errMsg);
					Assert.fail(errMsg);
				}
				
				if(props.length()>0){
					props.append(".childSelector(");
					props.append(")");
				}else{
					props.append(prop);
				}
			}
		}catch(DocumentException e){
			e.printStackTrace();
		}finally{
			doc = null;
			reader = null;
		}
		return props.toString();
	}
}
