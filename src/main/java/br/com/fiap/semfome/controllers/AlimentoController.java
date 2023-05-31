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

import br.com.fiap.semfome.model.Alimento;
import br.com.fiap.semfome.repository.AlimentoRepository;

@RestController
@RequestMapping("/api/alimentos")
public class AlimentoController {
    
    Logger log = LoggerFactory.getLogger(AlimentoController.class);

    @Autowired
    AlimentoRepository repository;

    @GetMapping
    public  List<Alimento> index(){
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Alimento> create(@RequestBody Alimento alimento) {
        log.info("cadastrando alimento" + alimento);
        repository.save(alimento);
        return ResponseEntity.status(HttpStatus.CREATED).body(alimento);
    }

    @GetMapping("{id}")
    public ResponseEntity<Alimento> show(@PathVariable Long id){
        log.info("detalhando alimento" + id);
        var alimentoEncontrado = repository.findById(id);

        if(alimentoEncontrado.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(alimentoEncontrado.get());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Alimento> destroy(@PathVariable Long id){
        log.info("apagando alimento" + id);
        var alimentoEncontrado = repository.findById(id);

        if (alimentoEncontrado.isEmpty())
            return ResponseEntity.notFound().build();

        repository.delete(alimentoEncontrado.get());

        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Alimento> update(@PathVariable Long id, @RequestBody Alimento alimento){
        log.info("alterando alimento" + id);
        var alimentoEncontrado = repository.findById(id);

        if (alimentoEncontrado.isEmpty())
            return ResponseEntity.notFound().build();

        alimento.setId(id);
        repository.save(alimento);

        return ResponseEntity.ok(alimento);
    }

}   
