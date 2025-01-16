package com.mantenimiento.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import com.mantenimiento.security.AuthRequest;
import com.mantenimiento.security.AuthResponse;
import com.mantenimiento.security.JwtUtil;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auth")
public class AuthController {
	 @Autowired
	    private AuthenticationManager authenticationManager;

	    @Autowired
	    private JwtUtil jwtUtil;

	    @PostMapping("/login")
	    public ResponseEntity<?> authenticateUser(@RequestBody AuthRequest authRequest) {
	        try {
	            // Autenticar credenciales
	            Authentication authentication = authenticationManager.authenticate(
	                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

	            // Generar token
	            String token = jwtUtil.generateToken(authRequest.getUsername());

	            // Retornar token
	            return ResponseEntity.ok(new AuthResponse(token));
	        } catch (AuthenticationException e) {
	            return ResponseEntity.status(401).body("Credenciales inválidas");
	        }
	    }
}
