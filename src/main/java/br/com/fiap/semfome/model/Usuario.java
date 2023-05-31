package br.com.fiap.semfome.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(
    name = "tb_usuario",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "uk_cnpj_usuario",
            columnNames = "cnpj_usuario"
        )
    }
)
public class Usuario {
    
    @Id
    @GeneratedValue(
        generator = "seq_usuario",
        strategy = GenerationType.SEQUENCE
    )
    @SequenceGenerator(
        name = "seq_usuario",
        sequenceName = "seq_usuario",
        allocationSize = 1
    )
    @Column(name = "id_usuario")
    private Long id;

    @NotBlank
    @Column(name = "cnpj_usuario")
    private String cnpj;

    @NotBlank
    @Column(name = "rs_usuario")
    private String razaoSocial;

    @NotBlank
    @Column(name = "nf_usuario")
    private String nomeFantasia;

    @NotBlank
    @Column(name = "senha_usuario")
    private String senha;

    @NotBlank
    @Column(name = "tipo_usuario")
    private int tipo;

    @NotBlank
    @Column(name = "cep_endereco_usuario")
    private String cep;

    @NotBlank
    @Column(name = "logradouro_endereco_usuario")
    private String logradouro;

    @NotBlank
    @Column(name = "numero_endereco_usuario")
    private int numero;
    
    @Column(name = "complemento_endereco_usuario")
    private String complemento;
    
    @NotBlank
    @Column(name = "bairro_endereco_usuario")
    private String bairro;
    
    @NotBlank
    @Column(name = "cidade_endereco_usuario")
    private String cidade;
    
    @NotBlank
    @Column(name = "estado_endereco_usuario")
    private String estado;

    protected Usuario( ){ }

    public Usuario(@NotBlank String cnpj, @NotBlank String razaoSocial, @NotBlank String nomeFantasia,
            @NotBlank String senha, @NotBlank int tipo, @NotBlank String cep, @NotBlank String logradouro,
            @NotBlank int numero, String complemento, @NotBlank String bairro, @NotBlank String cidade,
            @NotBlank String estado) {
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.senha = senha;
        this.tipo = tipo;
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Usuario [cnpj=" + cnpj + ", razaoSocial=" + razaoSocial + ", nomeFantasia=" + nomeFantasia + ", senha="
                + senha + ", tipo=" + tipo + ", cep=" + cep + ", logradouro=" + logradouro + ", numero=" + numero
                + ", complemento=" + complemento + ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado
                + "]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getTipo() {
        return tipo;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
