package com.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class configUtils {
	
	public static Properties readProperties(String filename) throws IOException {
		
		InputStream inputStream = new FileInputStream(filename);
		Properties property = new Properties();
		property.load(inputStream);
		return property;
	}
}
