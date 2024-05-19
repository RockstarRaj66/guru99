package com.retail.testscripts.regression.Suite1;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class TestLogs {
	
	public static Logger log = Logger.getLogger(TestLogs.class.getName());

	public static void main(String[] args) {
	
        PropertyConfigurator.configure("./src/test/resources/properties/log4j.properties");
		
		log.info("This is the information log");
		
		log.error("Here the error logs will be printed");

	}

}
