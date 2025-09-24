package com.automation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigDataProvider {

	Properties pro;

	public ConfigDataProvider() {
		File src = new File("./Config/Config.properties");

		FileInputStream fis;
		try {
			fis = new FileInputStream(src);

			pro = new Properties();

			pro.load(fis);

		} catch (Exception e) {
			System.out.println("Unable to read config file" + e.getMessage());

		}
	}

	public String getDataFromConfig(String keyToSearch) {
		return pro.getProperty(keyToSearch);

	}

	public String getBrowser() {
		return pro.getProperty("Browser");

	}

	public String getUrl() {
		return pro.getProperty("qaUrl");

	}
}
