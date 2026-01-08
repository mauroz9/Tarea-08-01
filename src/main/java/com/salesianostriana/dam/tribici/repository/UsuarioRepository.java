package com.salesianostriana.dam.tribici.repository;

import com.salesianostriana.dam.tribici.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
