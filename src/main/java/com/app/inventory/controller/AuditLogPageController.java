package com.app.inventory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.inventory.service.AuditLogService;


@Controller
@RequestMapping("/admin/audit")
public class AuditLogPageController {

    private final AuditLogService service;

    public AuditLogPageController(AuditLogService service) {
        this.service = service;
    }

    @GetMapping("/ultimele-12-luni")
    public String auditPage(Model model) {
        model.addAttribute("logs", service.last12Months());
        return "audit-log"; // templates/audit-log.html
    }
}