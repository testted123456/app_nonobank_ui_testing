package com.nonobank.apps.utils.variable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringHandle {
	
	//取出字符串中的数字
	public static String numFromString(String a){
		String regEx="[^0-9\\.]";   
		Pattern p = Pattern.compile(regEx);   
		Matcher m = p.matcher(a);   
		String num=m.replaceAll("").trim();
		return num;	
	}
}
