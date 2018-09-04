package com.dao.impl.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dao.impl.CommodityDaoImpl;
import com.dao.impl.SellerDaoImpl;
import com.dto.Comment;
import com.dto.SendAddress;
import com.entity.Commodity;
import com.entity.Seller;
import com.mongodb.WriteResult;

@RunWith(value=SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring.xml"})
public class SellerDaoImplTest {

	@Autowired
	private SellerDaoImpl sellerDaoImpl;
	/**
	 * 查询所有店铺
	 */
	@Test
	public void testFindAll(){
		List<Seller> list = sellerDaoImpl.findAll();
	}
	
	/**
	 * 修改店铺信息（第一层）
	 */
	@Test
	public void updateSellerFirst() {		
		sellerDaoImpl.updateSellerFirst("5b89faaf5370c741389ff861","牛三星汤","牛三星旗舰店");
	}
	
	/**
	 * 添加商品（第二层）
	 */
	@Test
	public void insertSellerSecond() {
		String[] imSrc = new String[5];
		for(int j=0;j<imSrc.length;j++) {
			imSrc[j] = "http://///"+j;
		}
		Commodity commodity = new Commodity();
		commodity.setId("cd"+new Date());
		commodity.setName("kkkk");
		commodity.setPrice(20.2);
		commodity.setSaledNum(0);
		commodity.setScore(0);
		commodity.setStock(50);
		commodity.setImSrc(imSrc);
		commodity.setIsShelf(1);
		commodity.setCollectedNum(0);
		commodity.setComments(null);
		sellerDaoImpl.insertSellerSecond("5b8df3985370c75880d5c6db",commodity);
	}
	
	/**
	 * 修改商品信息（第二层）
	 */
	@Test
	public void updateSellerSecond() {		
		sellerDaoImpl.updateSellerSecond("23456","伊利牛奶04561",100.00);
	}
	
	/**
	 * 删除商品（第二层）
	 */
	@Test
	public void deleteSellerSecond() {
		String[] imSrc = new String[5];
		for(int j=0;j<imSrc.length;j++) {
			imSrc[j] = "http://///"+j;
		}
		Commodity commodity = new Commodity();
		commodity.setId("cdTue Sep 04 10:10:31 CST 2018");
		commodity.setName("eeee");
		commodity.setPrice(20.2);
		commodity.setSaledNum(0);
		commodity.setScore(0);
		commodity.setStock(50);
		commodity.setImSrc(imSrc);
		commodity.setIsShelf(1);
		commodity.setCollectedNum(0);
		commodity.setComments(null);
		sellerDaoImpl.deleteSellerSecond("cdTue Sep 04 09:23:42 CST 2018",commodity);
	}
	
	/**
	 * 单个添加商家(第一层)
	 */
	@Test
	public void testInsert(){
		SendAddress sendAddress = new SendAddress();
		sendAddress.setProvince("pppp");
		sendAddress.setCity("cccc");
		sendAddress.setCounty("CCCC");
		sendAddress.setDetail("dddd");
		List<Commodity> commoditys = new ArrayList<Commodity>();
		for(int i=1;i<=3;i++)
		{
			String[] imSrc = new String[5];
			for(int j=0;j<imSrc.length;j++) {
				imSrc[j] = "http://///"+i+j;
			}
			Commodity commodity = new Commodity();
			commodity.setId("cd"+new Date());
			commodity.setName("伊利牛奶22"+i);
			commodity.setPrice(20.2);
			commodity.setSaledNum(0);
			commodity.setScore(0);
			commodity.setStock(50);
			commodity.setImSrc(imSrc);
			commodity.setIsShelf(1);
			commodity.setCollectedNum(0);
			commodity.setComments(null);
			commoditys.add(commodity);
		}
		Seller seller = new Seller();
		seller.setName("马云爸爸");
		seller.setStore("阿里巴巴旗舰店");
		seller.setPhone("138011110000");
		seller.setIdentity("2223333333332222");
		seller.setSex(1);
		seller.setSendAddress(sendAddress);
		seller.setScore(0);
		seller.setCommoditys(commoditys);
		seller.setState(1);		
		sellerDaoImpl.save(seller);
	}
	
	/**
	 * 批量添加商家(第一层添加)
	 */
	@Test
	public void testInsert2(){
		List<Seller> list = new ArrayList<>();
		for(int i=0; i<2; i++){
			SendAddress sendAddress = new SendAddress();
			sendAddress.setProvince("pppp");
			sendAddress.setCity("cccc");
			sendAddress.setCounty("CCCC");
			sendAddress.setDetail("dddd");
			
			Seller seller = new Seller();
			seller.setName("ali爸爸*" + i); 
			seller.setStore("sli旗舰店*" + i);
			seller.setPhone("138011110000");
			seller.setIdentity("2223333333332222");
			seller.setSex(1);
			seller.setSendAddress(sendAddress);
			seller.setScore(0);
			seller.setState(1);		
			list.add(seller);
		}
		sellerDaoImpl.save(list);
	}
	
	/**
	 * 给最后一个店铺添加多个商品（第二层添加）
	 */
	@Test
	public void testInsertCommoditys(){
		List<Seller> list = sellerDaoImpl.findAll();
		Seller seller = list.get(list.size()-1);
		System.out.println(seller.toString());
		
		List<Commodity> commoditys = new ArrayList<Commodity>();
		if(seller.getCommoditys()!=null)
		{
			commoditys = seller.getCommoditys();
		}
		for(int i=1;i<=3;i++)
		{
			String[] imSrc = new String[5];
			for(int j=0;j<imSrc.length;j++) {
				imSrc[j] = "http://///"+i+j;
			}
			Commodity commodity = new Commodity();
			commodity.setName("伊利牛奶22"+i);
			commodity.setPrice(20.2);
			commodity.setSaledNum(0);
			commodity.setScore(0);
			commodity.setStock(50);
			commodity.setImSrc(imSrc);
			commodity.setIsShelf(1);
			commodity.setCollectedNum(0);
			commodity.setComments(null);
			commoditys.add(commodity);
		}
		seller.setCommoditys(commoditys);
		int count = sellerDaoImpl.save(seller);
		System.out.println(count);
	}
	
	/**
	 * 给一个店铺的一个商品(商品Id)添加评论（第三层添加）
	 */
	@Test
	public void testInsertComment(){
		Comment comment = new Comment();
		comment.setContent("评论222111");
		comment.setContentTime(new Date());
		comment.setMember("无名氏");
		comment.setState(1);
		sellerDaoImpl.insertComment("1111111111",comment);
	}
	
	/**
	 * 给一个店铺的一个商品(商品Id)的一个评论(评论Id)添加回复（第三层修改，未完成）
	 */
	@Test
	public void testUpdateComment(){
		Comment comment = new Comment();
		comment.setAnswer("回复222111");
		comment.setAnswerTime(new Date());
		sellerDaoImpl.updateComment("1111111111","评论222111",comment);
	}
	
	/**
	 * 批量修改店铺信息
	 */
	@Test
	public void testUpdate(){
		List<Seller> list = sellerDaoImpl.findAll();
		for(int i=list.size()-2; i<list.size(); i++){
			Seller seller = list.get(i);
			seller.setName("星爸爸*" + i); 
			seller.setPhone("138000" + i);
			list.set(i, seller);
		}
		int count = sellerDaoImpl.save(list);
		System.out.println(count);
	}
	
	/**
	 * 单个修改店铺信息
	 */
	@Test
	public void testUpdate2(){
		Seller seller = new Seller();
		seller = sellerDaoImpl.findById("5b89f6415370c73ce4831ba0");
		seller.setName("星爸爸修改*" + 1); 
		seller.setPhone("138000" + 111);
		int count = sellerDaoImpl.save(seller);
		System.out.println(count);
	}
	
	
	/**
	 * 批量删除店铺
	 */
	@Test
	public void testDelete() {
		List<Seller> list = sellerDaoImpl.findAll();
		String[] ids = new String[list.size()];
		for(int i=ids.length-2; i<ids.length; i++)
			ids[i] = list.get(i).getId();
		sellerDaoImpl.deleteById(ids);
	}
	
	/**
	 * 单个删除店铺(删除最后那个)
	 */
	@Test
	public void testDelete2() {
		List<Seller> list = sellerDaoImpl.findAll();
		String id = list.get(list.size()-1).getId();
		sellerDaoImpl.deleteById(id);
	}
	
	@Test
	public void testRowsCount() {
		System.out.println(sellerDaoImpl.rowsCount());
	}
}
