package com.app.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.inventory.model.Inventar;

@Repository
public interface InventarRepository extends JpaRepository<Inventar, Long> {
	 List<Inventar> findByCompartimentId(Long compartimentId);
}