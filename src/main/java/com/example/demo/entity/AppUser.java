package com.example.demo.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "AppUser")
@Data
public class AppUser {

	@Id
	@Column(name = "appUser_Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int appUserId;
	
	@Column(name = "appUser_name")
	@NotNull
	private String username;
	
	@Column(name = "appUser_password")
	@NotNull
	private String appUserPassword;
	
	@ManyToMany
	@JoinTable(name = "AppUser_Role", 
		       joinColumns = @JoinColumn(name = "appUser_id", 
		       		referencedColumnName = "appUser_id"),
	           inverseJoinColumns = @JoinColumn(name = "role_id", 
	           		referencedColumnName = "role_id"))
	private Set<Role> roles;
}
