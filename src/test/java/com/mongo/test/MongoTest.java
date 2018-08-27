package com.mongo.test;

import org.bson.Document;
import org.junit.Test;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.entity.Address;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class MongoTest {
	
	@Test
	public void testMongoDatabase(){     
		//没有加载mongo-config.xml配置文件
		MongoClient mongoClient = new MongoClient();
		MongoDatabase mongoDatabase = mongoClient.getDatabase("mongoTest");
		MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("colTest");
		Document document = new Document("name", "chuqian");
		mongoCollection.insertOne(document);
		FindIterable<Document> iterable = mongoCollection.find();
		MongoCursor<Document> cursor = iterable.iterator();
		while(cursor.hasNext())
			System.out.println(cursor.next());
		
		mongoClient.close();
	}
	
	@Test
	public void testMongoTemplate(){
		//没有加载mongo-config.xml配置文件
		MongoClient mongoClient = new MongoClient();
		MongoTemplate mongoTemplate = new MongoTemplate(mongoClient, "mongoTest");
		
		Address address = new Address();
		address.setCity("guangdong");
		mongoTemplate.insert(address);
	}
}
