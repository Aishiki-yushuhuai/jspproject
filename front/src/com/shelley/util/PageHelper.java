package com.shelley.util;

import java.util.List;

/**
 * 分页的工具类
 * @author Mr.Diao
 *
 * @param <T>
 */
public class PageHelper<T> {
	/**
	 * 当前页
	 */
	private Integer page;
	/**
	 * 总页数
	 */
	private Integer pageCount;
	/**
	 * 每页显示的条数
	 */
	private Integer pageSize = Commons.PAGE_SIZE;
	/**
	 * 总记录数
	 */
	private Long totalRecords;
	/**
	 * 查询出来的数据
	 */
	private List<T> data;
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public Long getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(Long totalRecords) {
		this.totalRecords = totalRecords;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public Integer getPageSize() {
		return pageSize;
	}
}
