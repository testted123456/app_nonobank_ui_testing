package com.nonobank.apps.utils.file;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ParseProperties {

	private static Properties prop = null;

	private ParseProperties() {
	}

	public static Properties getEnv() {

		prop = new Properties();
		try {
			prop.load(ParseProperties.class.getClassLoader().getResourceAsStream("config/config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
	}

	public static Properties getInstance() {
		if (null == prop) {
			prop = new Properties();
			try {
				String env = getEnv().getProperty("env");
				String os = System.getProperties().getProperty("os.name");
				if (os.startsWith("Mac")) {
					switch (env) {
					case "stb":
						prop.load(ParseProperties.class.getClassLoader()
								.getResourceAsStream("config/config_mac_stb.properties"));
						break;
					case "sit":
						prop.load(ParseProperties.class.getClassLoader()
								.getResourceAsStream("config/config_mac_sit.properties"));
						break;
					case "pre":
						prop.load(ParseProperties.class.getClassLoader()
								.getResourceAsStream("config/config_mac_pre.properties"));
						break;
					case "prod":
						prop.load(ParseProperties.class.getClassLoader()
								.getResourceAsStream("config/config_mac_prod.properties"));
						break;
					default:
						break;
					}
				} else {
					switch (env) {
					case "stb":
						prop.load(ParseProperties.class.getClassLoader()
								.getResourceAsStream("config/config_win_stb.properties"));
						break;
					case "sit":
						prop.load(ParseProperties.class.getClassLoader()
								.getResourceAsStream("config/config_win_sit.properties"));
						break;
					case "pre":
						prop.load(ParseProperties.class.getClassLoader()
								.getResourceAsStream("config/config_win_pre.properties"));
						break;
					case "prod":
						prop.load(ParseProperties.class.getClassLoader()
								.getResourceAsStream("config/config_win_prod.properties"));
						break;
					default:
						break;
					}

				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return prop;
	}

}
