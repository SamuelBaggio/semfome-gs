package br.com.fiap.semfome.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.semfome.model.Alimento;

public interface AlimentoRepository extends JpaRepository<Alimento, Long>{
    
}
