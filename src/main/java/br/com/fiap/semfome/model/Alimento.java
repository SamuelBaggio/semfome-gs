package br.com.fiap.semfome.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(
    name = "tb_alimento"
)
public class Alimento {
    
    @Id
    @GeneratedValue(
        generator = "seq_alimento",
        strategy = GenerationType.SEQUENCE
    )
    @SequenceGenerator(
        name = "seq_alimento",
        sequenceName = "seq_alimento",
        allocationSize = 1
    )
    @Column(name = "id_alimento")
    private Long id;

    @NotBlank
    @Column(name = "nome_alimento")
    private String nome;

    @Size(max = 255)
    @Column(name = "descricao_alimento")
    private String descricao;

    @Min(value = 0, message = "deve ser positivo") 
    @NotNull
    @Column(name = "preco_alimento")
    private Double preco;

    // @ManyToOne
    // private Usuario usuario;

    @ManyToOne
    private Empresa empresa;

}
