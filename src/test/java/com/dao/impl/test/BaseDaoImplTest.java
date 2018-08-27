package com.dao.impl.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.dao.impl.BaseDaoImpl;
import com.entity.Commodity;
import com.entity.Seller;

/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring.xml"})*/
public class BaseDaoImplTest {

	BaseDaoImpl<Commodity> baseDaoImpl = new BaseDaoImpl<Commodity>();
	
	@Test
	public void testFindAll(){
		System.out.println(baseDaoImpl.findAll());
	}
	@Test
	public void testInsertOne(){
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("mongo-config.xml");
		MongoTemplate mongoTemplate = (MongoTemplate)applicationContext.getBean("mongoTemplate");
		
		Seller seller = new Seller();
		seller.setName("chenchuqian");
		seller.setIdentity("441522");
		mongoTemplate.insert(seller, "seller");
	}
	
	
	
	
}
