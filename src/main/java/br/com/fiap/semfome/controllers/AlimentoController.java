package br.com.fiap.semfome.controllers;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
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
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/alimentos")
@Slf4j
@SecurityRequirement(name = "bearer-key")
@Tag(name="alimento")
public class AlimentoController {
    
    @Autowired
    AlimentoRepository alimentoRepository;

    @Autowired
    EmpresaRepository empresaRepository;

    @Autowired
    PagedResourcesAssembler<Object> assembler;

    @GetMapping
    public PagedModel<EntityModel<Object>> index(@RequestParam(required = false) String busca,
        @ParameterObject @PageableDefault(size=3) Pageable pageable){

            Page<Alimento> alimentos = (busca == null) ?
                alimentoRepository.findAll(pageable):
                alimentoRepository.findByNomeContaining(busca, pageable);

            return assembler.toModel(alimentos.map(Alimento::toEntityModel));

        }

    @PostMapping
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Alimento criado com sucesso!"),
        @ApiResponse(responseCode = "400", description = "Os campos são inválidos")
    })
    public ResponseEntity<Object> create(@RequestBody @Valid Alimento alimento) {
        log.info("cadastrando alimento" + alimento);
        alimentoRepository.save(alimento);
        alimento.setEmpresa(empresaRepository.findById(alimento.getEmpresa().getId()).get());
        return ResponseEntity.status(HttpStatus.CREATED).body(alimento.toEntityModel());
    }

    @GetMapping("{id}")
    public EntityModel<Alimento> show(@PathVariable Long id){
        log.info("detalhando alimento" + id);

        var alimento = alimentoRepository.findById(id)
            .orElseThrow(() -> new RestNotFoundException("alimento não encontrado!"));

        return alimento.toEntityModel();
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
    public EntityModel<Alimento> update(@PathVariable Long id, @RequestBody @Valid Alimento alimento){
        log.info("alterando alimento" + id);

        alimentoRepository.findById(id)
            .orElseThrow(() -> new RestNotFoundException("alimento não encontrado!"));

        alimento.setId(id);
        alimentoRepository.save(alimento);

        return alimento.toEntityModel();
    }

}   
