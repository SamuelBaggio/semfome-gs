package br.com.fiap.semfome.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.semfome.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
}
