package com.zeedoo.commons.domain;

import java.util.List;
import com.google.common.base.Objects;

public class CollectionResult {
	
	private int count;
	
	private List<? extends Object> result;
	
	public CollectionResult() {
	}
	
	public CollectionResult(List<? extends Object> result, int count) {
		this.result = result;
		this.count = count;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public List<? extends Object> getResult() {
		return result;
	}

	public void setResult(List<? extends Object> result) {
		this.result = result;
	}

	@Override
	public int hashCode(){
		return Objects.hashCode(result, count);
	}
	
	@Override
	public boolean equals(Object object){
		if (object instanceof CollectionResult) {
			CollectionResult that = (CollectionResult) object;
			return Objects.equal(this.result, that.result)
				&& Objects.equal(this.count, that.count);
		}
		return false;
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this)
			.add("result", result)
			.add("count", count)
			.toString();
	}

	
}
