package com.krakedev.jwt.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krakedev.jwt.entidades.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Usuario findByUsername(String username);

}