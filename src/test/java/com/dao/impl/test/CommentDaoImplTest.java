package com.dao.impl.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dao.impl.CommentDaoImpl;
import com.dao.impl.CommodityDaoImpl;
import com.dao.impl.SellerDaoImpl;
import com.dto.Comment;
import com.dto.SendAddress;
import com.entity.Commodity;
import com.entity.Seller;

@RunWith(value=SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring.xml"})
public class CommentDaoImplTest {

	@Autowired
	private SellerDaoImpl sellerDaoImpl;
	private CommentDaoImpl commentDaoImpl;
	

	

	
	@Test
	public void testInsert(){
		List<Seller> list = sellerDaoImpl.findAll();
		Seller seller = list.get(list.size()-1);
		List<Commodity> commoditys = seller.getCommoditys();
		Commodity commodity11 = new Commodity();
		commodity11.setName("伊利牛奶222");
		commodity11.setPrice(20.2);
		commodity11.setSaledNum(0);
		commodity11.setScore(0);
		commodity11.setStock(50);
		
		int index = commoditys.indexOf(commodity11);
		System.out.println(index);
		Commodity commodity = commoditys.get(index);
		
		System.out.println(commodity.toString());
		
		
		
		
		//添加评论
		List<Comment> comments = new ArrayList<Comment>();
		if(commodity.getComments()!=null)
		{
			comments = commodity.getComments();
		}
		Comment comment = new Comment();
		comment.setMember("和附件四");
		comment.setContent("bhfdjjkfk");
		comment.setContentTime(new Date());
		comment.setState(1);
		comments.add(comment);
		
		
		
		
	}
}
