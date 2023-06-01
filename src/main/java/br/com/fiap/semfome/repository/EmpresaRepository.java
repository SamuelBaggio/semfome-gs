package br.com.fiap.semfome.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.semfome.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    
}
