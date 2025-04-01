package com.areyes403.oauth2;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "auth")
public class AuthController {
    @GetMapping(value = "user")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<String> user(Authentication authentication){
        return ResponseEntity.ok(authentication.getName());
    }

    @GetMapping(value = "admin")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<String> admin(Authentication authentication){
        return ResponseEntity.ok(authentication.getName());
    }
}
