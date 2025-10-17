package com.app.inventory.repository;

import com.app.inventory.model.Compartiment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompartimentRepository extends JpaRepository<Compartiment, Long> {}