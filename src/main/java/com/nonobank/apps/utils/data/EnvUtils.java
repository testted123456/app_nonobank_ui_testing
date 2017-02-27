package com.nonobank.apps.utils.data;

import java.io.IOException;
import java.util.Properties;

import com.nonobank.apps.utils.file.ParseProperties;

public class EnvUtils {

	public static Properties prop = null;

	public static Properties getEnvProperties() {

		prop = new Properties();
		try {
			prop.load(ParseProperties.class.getClassLoader().getResourceAsStream("config/config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
	}
	public static String getEnv(){
		String env=getEnvProperties().getProperty("env");
		return env;
	}
	
	
}
