package com.example.Myshop.dto;

import com.example.Myshop.entities.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class Userdto extends Iddto{
	
	private String name ;
	private String email ;
	private String password ;
	
	private Role role ;
	private String address ;
	private String state; 
	private String city ;
	private String code ;
	private String phone ;
	
	
	public Userdto() {
		super();
	}

	

	public Userdto(String name, String email, String password, Role role, String address, String state, String city,
			String code, String phone) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
		this.address = address;
		this.state = state;
		this.city = city;
		this.code = code;
		this.phone = phone;
	}

	


	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public Role getRole() {
		return role;
	}



	public void setRole(Role role) {
		this.role = role;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	@Override
	public String toString() {
		return "Userdto [name=" + name + ", email=" + email + ", password=" + password + ", role=" + role + ", address="
				+ address + ", state=" + state + ", city=" + city + ", code=" + code + ", phone=" + phone + "]";
	}
	
	
	

}
