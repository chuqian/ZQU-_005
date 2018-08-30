package com.common;

import java.util.List;

/**
 * @author chenchuqian
 * @date 2018年8月30日 上午9:27:40
 * @describe 分页查询包装类
 * @param <T>
 */
public class Pager<T> {

	private long total; 			// 总条数
	private long pageCount;			// 总页数
	private int currentPage = 1; 	// 当前页数
	private static int size = 10; 	// 每页显示条数
	private List<T> rows; 		    // 文档数据
	
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public long getPageCount() {
		return pageCount;
	}
	public void setPageCount(long pageCount) {
		this.pageCount = pageCount;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public static int getSize() {
		return size;
	}
	public static void setSize(int size) {
		Pager.size = size;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	
}
