package com.app.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.inventory.model.Cutie;

@Repository

public interface CutieRepository extends JpaRepository<Cutie, Long> {
}