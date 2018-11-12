package com.entity;

public class Searcher {
	private String id;
	private String name;
	private String dept;
	private String message;
	public Searcher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Searcher(String id, String name, String dept, String message) {
		super();
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.message = message;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "Searcher [id=" + id + ", name=" + name + ", dept=" + dept
				+ ", message=" + message + "]";
	}
	
	
}
