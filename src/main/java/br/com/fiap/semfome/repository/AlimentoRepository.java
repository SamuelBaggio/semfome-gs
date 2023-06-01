package br.com.fiap.semfome.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.semfome.model.Alimento;

public interface AlimentoRepository extends JpaRepository<Alimento, Long>{
    
        // @Query("SELECT d FROM Alimento d WHERE d.nome LIKE %?1%") //JPQL
        Page<Alimento> findByNomeContaining(String busca, Pageable pageable);

        // @Query("SELECT d FROM Alimento d ORDER BY d.id LIMIT ?1 OFFSET ?2")
        // List<Alimento> buscarPaginado(int tamanho, int offset);

}
