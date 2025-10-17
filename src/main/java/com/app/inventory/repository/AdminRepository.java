package com.app.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.inventory.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByUsername(String username);
}