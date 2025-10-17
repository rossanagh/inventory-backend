package com.app.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.inventory.model.Admin;
import com.app.inventory.repository.AdminRepository;


@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = {
		  "https://rossanagh.github.io",
		  "https://rossanagh.github.io/inventory"
		})// permite requesturi din Angular
public class AuthController {

    @Autowired
    private AdminRepository adminRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        Admin admin = adminRepository.findByUsername(request.getUsername());

        if (admin != null && admin.getPassword().equals(request.getPassword())) {
            return ResponseEntity.ok(true); // logare reușită
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false); // eșec logare
        }
    }
}