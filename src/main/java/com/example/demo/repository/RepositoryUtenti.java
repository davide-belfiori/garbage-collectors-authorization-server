package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.AppUser;

public interface RepositoryUtenti extends JpaRepository<AppUser, Integer> {

	public AppUser findByUsername(String username);
}
