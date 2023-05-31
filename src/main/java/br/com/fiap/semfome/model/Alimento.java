package br.com.fiap.semfome.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

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

    @Column(name = "descricao_alimento")
    private String descricao;

    @NotBlank
    @Column(name = "preco_alimento")
    private Double preco;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
        name = "id_usuario",
        referencedColumnName = "id_usuario",
        foreignKey = @ForeignKey(name = "fk_alimento_usuario")
    )
    private Usuario usuario;
    
    protected Alimento () {}

    public Alimento(@NotBlank String nome, String descricao, @NotBlank Double preco, Usuario usuario) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Alimento [nome=" + nome + ", descricao=" + descricao + ", preco=" + preco + "]";
    }

}
