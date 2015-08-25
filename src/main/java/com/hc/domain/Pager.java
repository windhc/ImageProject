//package com.hc.domain;
//
//import java.util.List;
//
//
///**
// * mysql分页
// * @param <T>
// */
//public class Pager<T> {
//
//	/**
//	 * 页码
//	 */
//	private int page;
//
//	/**
//	 * 每页条数
//	 */
//	private int size;
//
//	/**
//	 * 总条数
//	 */
//	private int total;
//
//	private int endNo;
//
//	/**
//	 * 查询结果
//	 */
//	private List<T> result;
//
//	public Pager(int page, int size) {
//		this.page = page;
//		this.size = size;
//		getStartNo();
//	}
//
//	public int getPage() {
//		return page;
//	}
//
//	public void setPage(int page) {
//		this.page = page;
//	}
//
//	public int getSize() {
//		return size;
//	}
//
//	public void setSize(int size) {
//		this.size = size;
//	}
//
//	public int getTotal() {
//		return total;
//	}
//
//	public void setTotal(int total) {
//		this.total = total;
//	}
//
//	public int getStartNo() {
//		return (page-1)*size;
//	}
//
//	public int getEndNo() {
//		return endNo;
//	}
//
//	public void setEndNo() {
//		this.endNo = page*size;
//		if (endNo > total) {
//			endNo = total;
//		}
//	}
//
//	public List<T> getResult() {
//		return result;
//	}
//
//	public void setResult(List<T> result) {
//		this.result = result;
//	}
//}
