package br.com.ifma.imobiliaria.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Cliente implements EntidadeBase{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;

    private String nome;

    private String cpf;

    @Column(name = "telefone1", nullable = false)
    private String telefone;

    @Column(name = "telefone2")
    private String celular;

    private String email;

    @Temporal(TemporalType.DATE)
    @Column(updatable = false)
    private Date dataNascimento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public Integer getId() {
        return idCliente;
    }
}
