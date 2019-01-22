package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Role")
@Data
public class Role {

	@Id
	@Column(name = "role_id")
	private int id;
	
	@Column(name = "role")
	private String role;
}
