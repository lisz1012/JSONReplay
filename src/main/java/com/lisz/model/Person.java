package com.lisz.model;

public class Person {
	private int id;
	private String name;
	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "id: " + id + " name: " + name;
	}
}
