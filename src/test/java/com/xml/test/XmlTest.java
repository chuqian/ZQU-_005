package com.xml.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlTest {

	@Test
	public void testXml(){
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("spring.xml");
		
	}
}
