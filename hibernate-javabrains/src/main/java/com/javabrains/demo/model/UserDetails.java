package com.javabrains.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class UserDetails {

	@Id
	private int userId;
	private String username;
}
