package com.app.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.inventory.model.Fond;

@Repository
public interface FondRepository extends JpaRepository<Fond, Long> {}