package com.app.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.inventory.model.TipPastrare;

@Repository
public interface TipPastrareRepository extends JpaRepository<TipPastrare, Long> {
}