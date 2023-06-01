package br.com.fiap.semfome.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.semfome.exceptions.RestNotFoundException;
import br.com.fiap.semfome.model.Alimento;
import br.com.fiap.semfome.repository.AlimentoRepository;
import br.com.fiap.semfome.repository.EmpresaRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/alimentos")
@Slf4j
public class AlimentoController {
    
    @Autowired
    AlimentoRepository alimentoRepository;

    @Autowired
    EmpresaRepository empresaRepository;

    @GetMapping
    public Page<Alimento> index(@RequestParam(required = false) String busca, @PageableDefault(size = 10) Pageable pageable){
        if(busca == null) return alimentoRepository.findAll(pageable);
        return alimentoRepository.findByNomeContaining(busca, pageable);
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody @Valid Alimento alimento) {
        log.info("cadastrando alimento" + alimento);
        alimentoRepository.save(alimento);
        alimento.setEmpresa(empresaRepository.findById(alimento.getEmpresa().getId()).get());
        return ResponseEntity.status(HttpStatus.CREATED).body(alimento);
    }

    @GetMapping("{id}")
    public ResponseEntity<Alimento> show(@PathVariable Long id){
        log.info("detalhando alimento" + id);

        var alimento = alimentoRepository.findById(id)
            .orElseThrow(() -> new RestNotFoundException("alimento não encontrado!"));

        return ResponseEntity.ok(alimento);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Alimento> destroy(@PathVariable Long id){
        log.info("apagando alimento" + id);
        var alimento = alimentoRepository.findById(id)
            .orElseThrow(() -> new RestNotFoundException("alimento não encontrado!"));

        alimentoRepository.delete(alimento);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Alimento> update(@PathVariable Long id, @RequestBody @Valid Alimento alimento){
        log.info("alterando alimento" + id);

        alimentoRepository.findById(id)
            .orElseThrow(() -> new RestNotFoundException("alimento não encontrado!"));

        alimento.setId(id);
        alimentoRepository.save(alimento);

        return ResponseEntity.ok(alimento);
    }

}   
