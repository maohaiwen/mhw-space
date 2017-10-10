package com.mhw.space.util.system.page;

import java.util.List;

public class Page<T> {

	private int pageNo = 1;
	
	private int pageBegin;
	
	private int pageSize = 20;
	
	private List<T> list;
	
	private int totalCount;
	
	private Object params;
	
	public Page(){
		
	}
	
	public Page(int pageNo) {
		this.pageNo = pageNo;
	}
	
	public Page(int pageNo, int pageSize) {
		this.pageNo = pageNo;
		this.pageSize = pageSize;
	}
	
	public Page<T> setList(List<T> list) {
		this.list = list;
		return this;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<T> getList() {
		return list;
	}

	public int getPageBegin() {
		pageBegin = (pageNo - 1) * pageSize;
		return pageBegin;
	}

	public void setPageBegin(int pageBegin) {
		this.pageBegin = pageBegin;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public Object getParams() {
		return params;
	}

	public void setParams(Object params) {
		this.params = params;
	}
	
}
