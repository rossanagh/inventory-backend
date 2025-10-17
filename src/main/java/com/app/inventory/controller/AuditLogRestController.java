package com.app.inventory.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.inventory.service.AuditLogService;

@RestController
@RequestMapping("/api/audit")
@CrossOrigin(origins = {
		  "https://rossanagh.github.io",
		  "https://rossanagh.github.io/inventory"
		})
public class AuditLogRestController {

  private final AuditLogService audit;

  public AuditLogRestController(AuditLogService audit) { this.audit = audit; }

  @PostMapping("/log")
  public void log(@RequestBody Map<String, String> body) {
      String username = body.getOrDefault("username", "anonymous");
      String action   = body.getOrDefault("action", "");
      System.out.println("[AUDIT] " + username + " - " + action); // <-- debug
      audit.log(username, action);
  }

}