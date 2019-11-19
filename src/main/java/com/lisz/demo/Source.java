package com.lisz.demo;

public class Source {
	private String method;
	private String number;
	private int expMonth;
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public int getExpMonth() {
		return expMonth;
	}
	public void setExpMonth(int expMonth) {
		this.expMonth = expMonth;
	}
	
	@Override
	public String toString() {
		return String.format("method: %s, number: %s, expMonth: %s", method, number, expMonth);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Source)) {
			return false;
		}
		Source otherSource = (Source)obj;
		return method.equals(otherSource.getMethod()) && number.equals(otherSource.getNumber()) && expMonth == otherSource.getExpMonth();
	}
	
	@Override
	public int hashCode() {
		return method.hashCode() + number.hashCode() + expMonth;
	}
}
