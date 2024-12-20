package com.example.Myshop.dto;

import com.example.Myshop.entities.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Signup {

	@JsonProperty(access = Access.READ_ONLY)
	private Long id;
	@NotBlank(message = "Name required")
	private String name;
	@Email(message = "email invalid")
	private String email;
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	private Role role;
	private String phone;
	private String address;
	private String code;
	private String city;
	private String state;
	@Override
	public String toString() {
		return "Signup [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", role=" + role
				+ ", phone=" + phone + ", address=" + address + ", code=" + code + ", city=" + city + ", state=" + state
				+ "]";
	}
	
}
