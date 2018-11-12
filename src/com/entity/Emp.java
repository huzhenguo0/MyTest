package com.entity;

public class Emp {
	private Integer id;
	private String name;
	private String dept;
	private String message;
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Emp(Integer id, String name, String dept, String message) {
		super();
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.message = message;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
		return "Emp [id=" + id + ", name=" + name + ", dept=" + dept
				+ ", message=" + message + "]";
	}
	
	
}
