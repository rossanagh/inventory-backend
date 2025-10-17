package com.app.inventory.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;


@Entity @Table(name = "audit_log")
public class AuditLog {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String username;

  @Column(columnDefinition = "TEXT")
  private String action;

  private LocalDateTime ts;

  // getters/setters
  public Long getId() { return id; }
  public String getUsername() { return username; }
  public void setUsername(String username) { this.username = username; }
  public String getAction() { return action; }
  public void setAction(String action) { this.action = action; }
  public LocalDateTime getTs() { return ts; }
  public void setTs(LocalDateTime ts) { this.ts = ts; }

	// TODO Auto-generated method stub
	

}
