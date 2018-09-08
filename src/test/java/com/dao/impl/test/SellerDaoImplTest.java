package com.dao.impl.test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dao.impl.SellerDaoImpl;
import com.dto.Comment;
import com.dto.Commodity;
import com.dto.ContactAddress;
import com.dto.SellerOrder;
import com.entity.Seller;
import com.util.DateChange;

/**
 * @author liangjiahong
 * @date 2018年9月7日 下午5:21:49
 * @describe 对商铺、商品、订单、评论的操作测试
 */
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
		for (Seller seller : list) {
			System.out.println(seller.toString());
		}
	}
	
	/**
	 * 修改店铺信息（第一层）
	 */
	@Test
	public void updateSellerFirst() {	
		//修改最后一个商铺里的商品
		List<Seller> list = sellerDaoImpl.findAll();
		Seller seller = list.get(list.size()-1);
		sellerDaoImpl.updateSellerFirst(seller.getId(),"牛三星汤","牛三星旗舰店");
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
		commodity.setStock(50);
		commodity.setImSrc(imSrc);
		commodity.setIsShelf(1);
		commodity.setShelfTime(new Date());
		commodity.setCollectedNum(0);
		commodity.setFormwork(10);
		commodity.setCommodityType("商品类型");
		commodity.setComments(null);
		sellerDaoImpl.insertSellerSecond("shangpin"+new Date(),commodity);
	}
	
	/**
	 * 修改商品信息（第二层）
	 */
	@Test
	public void updateSellerSecond() {	
		//修改最后一个商铺里的商品
		List<Seller> list = sellerDaoImpl.findAll();
		Seller seller = list.get(list.size()-1);

		//修改商铺里最后一个商品
		List<Commodity> commodities = seller.getCommoditys();
		System.out.println(commodities.size());
		Commodity commodity = commodities.get(commodities.size()-1);
		System.out.println(commodity.getId());
		sellerDaoImpl.updateSellerSecond(commodity.getId(), "给你改的名字",111.22);
	}
	
	/**
	 * 删除商品（第二层）
	 */
	@Test
	public void deleteSellerSecond() {
		
		//删除最后一个商铺里的商品
		List<Seller> list = sellerDaoImpl.findAll();
		Seller seller = list.get(list.size()-1);

		//删除商铺里最后一个商品
		List<Commodity> commodities = seller.getCommoditys();
		System.out.println(commodities.size());
		Commodity commodity = commodities.get(commodities.size()-1);
		System.out.println(commodity.getId());
		sellerDaoImpl.deleteSellerSecond(commodity.getId(),commodity);
	}
	
	/**
	 * 单个添加商家(第一、二层)，商铺、商品、订单信息
	 */
	@Test
	public void testInsert(){
		ContactAddress contactAddress = new ContactAddress();
		contactAddress.setProvince("pppp");
		contactAddress.setCity("cccc");
		contactAddress.setCounty("CCCC");
		contactAddress.setDetail("dddd");
		contactAddress.setPostalNumber("666666");
		
		List<Commodity> commoditys = new ArrayList<Commodity>();
		for(int i=1;i<=3;i++)
		{
			String[] imSrc = new String[5];
			for(int j=0;j<imSrc.length;j++) {
				imSrc[j] = "http://///"+i+j;
			}
			Commodity commodity = new Commodity();
			commodity.setId("shangping"+new Date());
			commodity.setName("伊利牛奶22"+i);
			commodity.setPrice(20.2);
			commodity.setSaledNum(0);
			commodity.setScore(0);
			commodity.setStock(50);
			commodity.setImSrc(imSrc);
			commodity.setIsShelf(1);
			commodity.setShelfTime(new Date());
			commodity.setCollectedNum(0);
			commodity.setFormwork(10);
			commodity.setCommodityType("商品类型");
			commodity.setComments(null);
			commoditys.add(commodity);
		}
		
		List<SellerOrder> sellerOrders = new ArrayList<>();
		for (int i=1;i<=3;i++) {
			SellerOrder sellerOrder = new SellerOrder();
			sellerOrder.setOrderId("shangjiadingdan"+new Date());
			sellerOrder.setMember("会员名"+i);
			sellerOrder.setMoney(777.6+i);
			sellerOrder.setDateTime(new Date());
			sellerOrder.setOrderState(i);
			sellerOrder.setLogisticsState(i);
			sellerOrder.setAfterSale(null);
			sellerOrder.setWayBillNum(null);
			sellerOrder.setLogistics(null);
			sellerOrders.add(sellerOrder);
		}
		
		Seller seller = new Seller();
		seller.setName("马云爸爸");
		seller.setStore("阿里巴巴旗舰店");
		seller.setType("店铺类型");
		seller.setPhone("138011110000");
		seller.setIdentity("2223333333332222");
		seller.setSex(1);
		seller.setInfo("店铺简介");
		seller.setContactAddress(contactAddress);
		seller.setStoreImg("店铺标志图片地址");
		seller.setSellerOrders(sellerOrders);
		seller.setState(1);		
		seller.setCommoditys(commoditys);
		sellerDaoImpl.save(seller);
	}
	
	/**
	 * 批量添加商家、商品、订单(第一、二层添加)
	 */
	@Test
	public void testInsert2(){
		List<Seller> list = new ArrayList<>();
		for(int j=0; j<5; j++){
			ContactAddress contactAddress = new ContactAddress();
			contactAddress.setProvince("pppp");
			contactAddress.setCity("cccc");
			contactAddress.setCounty("CCCC");
			contactAddress.setDetail("dddd");
			contactAddress.setPostalNumber("666666");
			
			List<Commodity> commoditys = new ArrayList<Commodity>();
			for(int i=1;i<=3;i++)
			{
				String[] imSrc = new String[5];
				for(int k=0;k<imSrc.length;k++) {
					imSrc[k] = "http://///"+j+i+k;
				}
				Commodity commodity = new Commodity();
				commodity.setId("shangpin"+j+i+new Date());
				commodity.setName("伊利牛奶22"+j+i);
				commodity.setPrice(20.2);
				commodity.setSaledNum(0);
				commodity.setScore(0);
				commodity.setStock(50);
				commodity.setImSrc(imSrc);
				commodity.setIsShelf(1);
				commodity.setShelfTime(new Date());
				commodity.setCollectedNum(0);
				commodity.setFormwork(10);
				commodity.setCommodityType("商品类型");
				commodity.setComments(null);
				commoditys.add(commodity);
			}
			
			List<SellerOrder> sellerOrders = new ArrayList<>();
			for (int i=1;i<=3;i++) {
				SellerOrder sellerOrder = new SellerOrder();
				sellerOrder.setOrderId("shangjiadingdan"+j+i+new Date());
				sellerOrder.setMember("会员名"+j+i);
				sellerOrder.setMoney(777.6+i);
				sellerOrder.setDateTime(new Date());
				sellerOrder.setOrderState(i);
				sellerOrder.setLogisticsState(i);
				sellerOrder.setAfterSale(null);
				sellerOrder.setWayBillNum(null);
				sellerOrder.setLogistics(null);
				sellerOrders.add(sellerOrder);
			}
			
			Seller seller = new Seller();
			seller.setId("shangjia" + j+ new Date());
			seller.setName("ali*" + j); 
			seller.setStore("ali旗舰店*" + j);
			seller.setPhone("138011110000");
			seller.setIdentity("2223333333332222");
			seller.setSex(1);
			seller.setInfo("店铺简介");
			seller.setContactAddress(contactAddress);
			seller.setStoreImg("店铺标志图片地址");
			seller.setSellerOrders(sellerOrders);
			seller.setState(1);		
			seller.setCommoditys(commoditys);
			list.add(seller);
		}
		sellerDaoImpl.save(list);
	}
	
	/**
	 * 给最后一个店铺添加多个商品（第二层修改）
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
				imSrc[j] = "https:www./////"+i+j;
			}
			Commodity commodity = new Commodity();
			commodity.setId("shangpin"+new Date());
			commodity.setName("蒙牛牛奶22"+i);
			commodity.setPrice(20.2);
			commodity.setPrice(20.2);
			commodity.setSaledNum(0);
			commodity.setScore(0);
			commodity.setStock(50);
			commodity.setImSrc(imSrc);
			commodity.setIsShelf(1);
			commodity.setShelfTime(new Date());
			commodity.setCollectedNum(0);
			commodity.setFormwork(10);
			commodity.setCommodityType("商品类型");
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
		sellerDaoImpl.insertComment("222222222222222222",comment);
	}
	
	/**
	 * 给一个店铺的一个商品(商品Id)的一个评论(评论者&评论时间)添加回复（第三层修改）
	 * @throws ParseException 
	 */
	@Test
	public void testUpdateCommentAnswer() throws ParseException{
		Comment comment = new Comment();
		String strDate = "2018-09-07T07:33:00.618Z";
		Date strtodate = DateChange.IOSStringToDate(strDate);		
		comment.setContentTime(strtodate);
		comment.setMember("无名氏");
		
		comment.setAnswer("回复无名氏");
		comment.setAnswerTime(new Date());
		sellerDaoImpl.updateCommentAnswer("222222222222222222",comment);
	}
	
	/**
	 * 给一个店铺的一个商品(商品Id)的一个评论(评论者&评论时间)修改状态（第三层修改）
	 * @throws ParseException 
	 */
	@Test
	public void testUpdateCommentState() throws ParseException{
		Comment comment = new Comment();
		String strDate = "2018-09-07T07:33:00.618Z";
		Date strtodate = DateChange.IOSStringToDate(strDate);		
		comment.setContentTime(strtodate);
		comment.setMember("无名氏");
		comment.setState(222);
		sellerDaoImpl.updateCommentState("222222222222222222",comment);
	}
	
	/**
	 * 批量修改店铺信息（第一层批量修改）
	 */
	@Test
	public void testUpdateSellers(){
		List<Seller> list = sellerDaoImpl.findAll();
		
		//修改数据库里倒数的两个商铺信息
		for(int i=list.size()-2; i<list.size(); i++){
			System.out.println(i);
			Seller seller = list.get(i);
			seller.setName("Mongo咯就*33" + i); 
			seller.setPhone("138000" + i);
			list.set(i, seller);
		}
		
		int count = sellerDaoImpl.save(list);
		System.out.println(count);
	}
	
	/**
	 * 单个修改店铺信息（第一层修改）
	 */
	@Test
	public void testUpdateOneSeller(){
		Seller seller = new Seller();
		seller = sellerDaoImpl.findById("1234561");
		seller.setName("只修改你咯*" + 1); 
		seller.setPhone("138000" + 111);
		int count = sellerDaoImpl.save(seller);
		System.out.println(count);
	}
	
	
	/**
	 * 批量删除店铺（第一层批量删除）
	 */
	@Test
	public void testDeleteSellers() {
		List<Seller> list = sellerDaoImpl.findAll();
		String[] ids = new String[list.size()];
		
		//删除数据库里倒数的两个商铺信息
		for(int i=ids.length-2; i<ids.length; i++)
			ids[i] = list.get(i).getId();
		sellerDaoImpl.deleteById(ids);
	}
	
	/**
	 * 单个删除店铺(第一层删除)
	 */
	@Test
	public void testDeleteOneSeller() {
		List<Seller> list = sellerDaoImpl.findAll();
		//删除数据库最后那个
		String id = list.get(list.size()-1).getId();
		sellerDaoImpl.deleteById(id);
	}
	
	/**
	 * 查询文档数量
	 */
	@Test
	public void testRowsCount() {
		long count = sellerDaoImpl.rowsCount();
		System.out.println(count);
	}
}
