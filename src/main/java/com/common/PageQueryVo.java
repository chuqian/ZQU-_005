package com.common;

/**
 * @author chenchuqian
 * @date 2018年8月25日 上午10:53:12
 * @describe 分页查询传递参数
 */
public class PageQueryVo {

	private Integer page = 1; 		// 当前页数
	private Integer size = 10; 		// 每页显示条数
	
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
}
