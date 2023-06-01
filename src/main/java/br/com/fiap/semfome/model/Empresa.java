package br.com.fiap.semfome.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
    name = "tb_empresa",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "uk_cnpj_empresa",
            columnNames = "cnpj_empresa"
        )
    }
)
public class Empresa {
    
    @Id
    @GeneratedValue(
        generator = "seq_empresa",
        strategy = GenerationType.SEQUENCE
    )
    @SequenceGenerator(
        name = "seq_empresa",
        sequenceName = "seq_empresa",
        allocationSize = 1
    )
    @Column(name = "id_empresa")
    private Long id;

    @NotBlank
    @Column(name = "cnpj_empresa")
    private String cnpj;

    @NotBlank
    @Column(name = "rs_empresa")
    private String razaoSocial;

    @NotBlank
    @Column(name = "nf_empresa")
    private String nomeFantasia;

    @NotBlank
    @Column(name = "senha_empresa")
    private String senha;

    @NotNull
    @Min(1)
    @Max(2)
    @Column(name = "tipo_empresa")
    private int tipo;

    @NotBlank
    @Column(name = "cep_endereco_empresa")
    private String cep;

    @NotBlank
    @Column(name = "logradouro_endereco_empresa")
    private String logradouro;

    @NotBlank
    @Column(name = "numero_endereco_empresa")
    private String numero;

    @Size(max = 255)
    @Column(name = "complemento_endereco_empresa")
    private String complemento;
    
    @NotBlank
    @Column(name = "bairro_endereco_empresa")
    private String bairro;
    
    @NotBlank
    @Column(name = "cidade_endereco_empresa")
    private String cidade;
    
    @NotBlank @Size(min = 2,  max = 2)
    @Column(name = "estado_endereco_empresa")
    private String estado;

}
