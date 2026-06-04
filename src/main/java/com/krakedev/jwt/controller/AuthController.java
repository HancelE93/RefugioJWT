package com.krakedev.jwt.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.krakedev.jwt.entidades.Usuario;
import com.krakedev.jwt.services.UsuarioService;
import com.krakedev.jwt.utils.JwtUtil;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UsuarioService usuarioService;

    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario usuarioLogin) {

        Usuario usuario = usuarioService.login(
                usuarioLogin.getUsername(),
                usuarioLogin.getPassword());

        if (usuario == null) {
            return ResponseEntity.badRequest()
                    .body("Credenciales incorrectas");
        }

        String token = JwtUtil.generarToken(
                usuario.getUsername(),
                usuario.getRol());

        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("token", token);

        return ResponseEntity.ok(respuesta);
    }
    
    @GetMapping("/perfil")
    public ResponseEntity<?> perfil(
            @RequestHeader("Authorization") String authHeader) {

        try {

            String token = authHeader.replace("Bearer ", "");

            DecodedJWT jwt = JwtUtil.validarToken(token);

            String username = jwt.getSubject();
            String rol = jwt.getClaim("rol").asString();

            return ResponseEntity.ok(
                    "Bienvenido " + username + ". Rol: " + rol);

        } catch (Exception e) {

            return ResponseEntity.status(401)
                    .body("Token inválido o expirado");
        }
    }
}