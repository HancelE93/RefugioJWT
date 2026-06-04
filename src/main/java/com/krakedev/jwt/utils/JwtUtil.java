package com.krakedev.jwt.utils;

import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JwtUtil {

	 private static final String SECRET = "mi_clave_super_secreta";

	    public static String generarToken(String username, String rol) {

	        Algorithm algorithm = Algorithm.HMAC256(SECRET);

	        return JWT.create()
	                .withSubject(username)
	                .withClaim("rol", rol)
	                .withIssuedAt(new Date())
	                .withExpiresAt(new Date(System.currentTimeMillis() + 1800000))
	                .sign(algorithm);
	    }

	    public static DecodedJWT validarToken(String token) {

	        Algorithm algorithm = Algorithm.HMAC256(SECRET);

	        return JWT.require(algorithm)
	                .build()
	                .verify(token);
	    }
	}