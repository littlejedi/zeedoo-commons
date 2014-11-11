package com.zeedoo.commons.domain;

import java.util.List;
import com.google.common.base.Objects;

public class Paginator {
	
	private int resultCount;
	
	private int pageCount;
	
	private int pageSize;
	
	private int pageNumber;
	
	private String prev;
	
	private String next;
	
	private List<? extends Object> result;

	public Paginator() {
	}

	public int getResultCount() {
		return resultCount;
	}

	public void setResultCount(int resultCount) {
		this.resultCount = resultCount;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public String getPrev() {
		return prev;
	}

	public void setPrev(String prev) {
		this.prev = prev;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}
	
	public List<? extends Object> getResult() {
		return result;
	}

	public void setResult(List<? extends Object> result) {
		this.result = result;
	}

	@Override
	public int hashCode(){
		return Objects.hashCode(resultCount, pageCount, pageSize, pageNumber, prev, next, result);
	}
	
	@Override
	public boolean equals(Object object){
		if (object instanceof Paginator) {
			Paginator that = (Paginator) object;
			return Objects.equal(this.resultCount, that.resultCount)
				&& Objects.equal(this.pageCount, that.pageCount)
				&& Objects.equal(this.pageSize, that.pageSize)
				&& Objects.equal(this.pageNumber, that.pageNumber)
				&& Objects.equal(this.prev, that.prev)
				&& Objects.equal(this.next, that.next)
				&& Objects.equal(this.result, that.result);
		}
		return false;
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this)
			.add("resultCount", resultCount)
			.add("pageCount", pageCount)
			.add("pageSize", pageSize)
			.add("pageNumber", pageNumber)
			.add("prev", prev)
			.add("next", next)
			.add("result", result)
			.toString();
	}
}
