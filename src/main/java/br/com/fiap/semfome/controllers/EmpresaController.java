package br.com.fiap.semfome.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.semfome.exceptions.RestNotFoundException;
import br.com.fiap.semfome.model.Empresa;
import br.com.fiap.semfome.repository.EmpresaRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {
    
    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    EmpresaRepository empresaRepository;

    @GetMapping
    public List<Empresa> index(){
        return empresaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Empresa> create(@RequestBody @Valid Empresa empresa){
        log.info("cadastrando empresa" + empresa);
        empresaRepository.save(empresa);
        return ResponseEntity.status(HttpStatus.CREATED).body(empresa);
    }

    @GetMapping("{id}")
    public ResponseEntity<Empresa> show(@PathVariable Long id){
        log.info("detalhando empresa" + id);
        return ResponseEntity.ok(getEmpresa(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Empresa> destroy(@PathVariable Long id){
        log.info("apagando empresa" + id);

        empresaRepository.delete(getEmpresa(id));

        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Empresa> update(@PathVariable Long id, @RequestBody @Valid Empresa empresa){
        log.info("alterando empresa" + id);
        getEmpresa(id);
        empresa.setId(id);
        empresaRepository.save(empresa);
        return ResponseEntity.ok(empresa);
    }

    private Empresa getEmpresa(Long id){
        return empresaRepository.findById(id)
            .orElseThrow(() -> new RestNotFoundException("Empresa não encontrada!"));
    }

}
