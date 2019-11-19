package com.lisz.demo;

public class Transaction {
	private String email;
	private Source source;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Source getSource() {
		return source;
	}
	public void setSource(Source source) {
		this.source = source;
	}
	
	@Override
	public String toString() {
		return "email: " + email + ", " + source;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Transaction)) {
			return false;
		}
		Transaction otherTransaction = (Transaction)obj;
		return email.equals(otherTransaction.getEmail()) && source.equals(otherTransaction.getSource());
	}
	
	@Override
	public int hashCode() {
		return email.hashCode() + source.hashCode();
	}
}
