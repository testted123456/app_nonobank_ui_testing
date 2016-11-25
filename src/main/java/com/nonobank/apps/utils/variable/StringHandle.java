package com.nonobank.apps.utils.variable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringHandle {
	
	//取出字符串中的数字
	public static double numFromString(String a){
		String regEx="[^0-9\\.]";   
		Pattern p = Pattern.compile(regEx);   
		Matcher m = p.matcher(a);   
		String num_str=m.replaceAll("").trim();
		double num=Double.parseDouble(num_str);
		return num;	
	}
	//预期收益处理
	public static double expectEarnings(String a){
		if(a.indexOf("+")!=-1){
			String[] b=a.split("+");
			String[] c=b[0].split("%");
			String[] d=b[1].split("%");
			double earn1=Double.parseDouble(c[0]);
			double earn2=Double.parseDouble(d[0]);
			double earn=earn1+earn2;
			return earn;	
		}
		String[] e=a.split("%");
		double earn3=Double.parseDouble(e[0]);
		return earn3;	
	}
}
