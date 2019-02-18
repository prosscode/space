package com.space.exception;

import java.util.List;

public class PageEntity {
	private List<?> list;
	private Integer count;
	public List<?> getList() {
		return list;
	}
	public void setList(List<?> list) {
		this.list = list;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
}
