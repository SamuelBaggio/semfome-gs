package br.com.fiap.semfome.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.semfome.model.Alimento;
import br.com.fiap.semfome.model.Empresa;
import br.com.fiap.semfome.repository.AlimentoRepository;
import br.com.fiap.semfome.repository.EmpresaRepository;

@Configuration
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    EmpresaRepository empresaRepository;

    @Autowired
    AlimentoRepository alimentoRepository;

    @Override
    public void run(String... args) throws Exception {
        Empresa u1 = new Empresa(1l,
        "04.577.864/0001-21", 
        "Empresa A", 
        "A Vendas de Esquina", 
        "1234", 
        1, 
        "02079009", 
        "Rua do Seu Geraldo", 
        "120", 
        "", 
        "Vila do Zé", 
        "São Paulo", 
        "SP");

        Empresa u2 = new Empresa(2l,
        "04.577.864/0001-23", 
        "Empresa B", 
        "B Vendas Internacionais", 
        "1234", 
        1, 
        "02079034", 
        "Rua Aleluia", 
        "12", 
        "", 
        "Vila do Zé", 
        "São Paulo", 
        "SP");

        empresaRepository.saveAll(List.of(u1, u2));

        alimentoRepository.saveAll(List.of(
            Alimento.builder().nome("Cenouras").descricao("Crocantes").preco(2.23).empresa(u1).build(),
            Alimento.builder().nome("Maça").descricao("").preco(1.0).empresa(u1).build(),
            Alimento.builder().nome("Almoço Completo").descricao("Arroz, Feijão, Mistura e Batata Frita").preco(10.0).empresa(u1).build(),
            Alimento.builder().nome("Batatas").descricao("").preco(2.23).empresa(u1).build(),
            Alimento.builder().nome("Balas de Goma").descricao("Açúcaradas").preco(0.50).empresa(u2).build(),
            Alimento.builder().nome("Kg de Açúcar").descricao("").preco(0.50).empresa(u2).build(),
            Alimento.builder().nome("Bolo de Chocolate").descricao("Feito Ontem").preco(10.0).empresa(u2).build(),
            Alimento.builder().nome("Pizza").descricao("De Calabresa").preco(10.0).empresa(u2).build(),
            Alimento.builder().nome("Almoço Completo").descricao("Arroz, Feijão, Mistura e Batata Frita").preco(10.0).empresa(u2).build()
        ));
    }

}
