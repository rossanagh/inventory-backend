package com.app.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.inventory.model.AuditLog;
import com.app.inventory.service.AuditLogService;


@RestController
@CrossOrigin(origins = {
		  "https://rossanagh.github.io",
		  "https://rossanagh.github.io/inventory"
		})
@RequestMapping("/api/audit")
public class AuditLogController {

    private final AuditLogService service;

    public AuditLogController(AuditLogService service) {
        this.service = service;
    }

    @GetMapping("/ultimele-12-luni")
    public String auditPage(Model model) {
        model.addAttribute("logs", service.last12Months()); // <-- matches service
        return "audit-log";
    }
		}