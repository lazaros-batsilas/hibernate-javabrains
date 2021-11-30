package com.javabrains.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class UserDetails {

	@Id
	private int userId;
	private String username;
}
