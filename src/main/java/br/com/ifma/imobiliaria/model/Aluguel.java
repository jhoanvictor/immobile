package br.com.ifma.imobiliaria.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Aluguel implements EntidadeBase {

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id_locacao")
    private Locacao locacao;

    @Id
    @Temporal(TemporalType.DATE)
    @Column(updatable = false)
    private Date dataVencimento;

    @Column(updatable = false)
    private BigDecimal valorPago;

    @Temporal(TemporalType.DATE)
    @Column(updatable = false)
    private Date dataPagamento;

    @Column(updatable = false)
    private String observacoes;

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public BigDecimal getValorPago() {
        return valorPago;
    }

    public void setValorPago(BigDecimal valorPago) {
        this.valorPago = valorPago;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Locacao getLocacao() {
        return locacao;
    }

    public void setLocacao(Locacao locacao) {
        this.locacao = locacao;
    }

    @Override
    public Integer getId() {
        return null;
    }
}
