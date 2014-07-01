package com.biz.user.vo;

public class Users {

	
	private String id;
	private String password;
	private String name;
	private String role;
	
	
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(String id, String password, String name, String role) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.role = role;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("id == ").append(id);
		sb.append("password == ").append(password);
		sb.append("name == ").append(name);
		sb.append("role == ").append(role);
		
		return sb.toString();
	} 
	
	
}
