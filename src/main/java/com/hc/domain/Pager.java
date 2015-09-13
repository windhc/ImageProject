package com.hc.domain;

import java.util.List;


/**
 * mysql分页
 * @param <T>
 */
public class Pager<T> {
//	http://localhost:8080/atlas/atlasPage?count=25&page=1&sorting%5Bpicpath%5D=desc
//	http://localhost:8080/atlas/atlasPage?count=1&filter%5Batlas%5D=%E5%9B%BE%E5%86%8C1&page=1
	/**
	 * 页码
	 */
	private int page;
	
	/**
	 * 每页条数
	 */
	private int count;

	//排序
	private String[] sorting;

	//过滤
	private String[] filter;

	/**
	 * 总条数
	 */
	private int total;

	/**
	 * 查询结果
	 */
	private List<T> result;
	
	public Pager(int page, int size) {
		this.page = page;
		this.count = size;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String[] getSorting() {
		return sorting;
	}

	public void setSorting(String[] sorting) {
		this.sorting = sorting;
	}

	public String[] getFilter() {
		return filter;
	}

	public void setFilter(String[] filter) {
		this.filter = filter;
	}

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}
}
