


package MRQS.entidades;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_pagamento")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE") // vai salvar no banco no padrão UTC
    private Instant momentoDoPagamento;


    // relacionamento um para um:
    @OneToOne
    @MapsId // isso define para mapear por id
    private Pedido pedido;


    public Pagamento() {
    }

    public Pagamento(Integer id, Instant momentoDoPagamento, Pedido pedido) {
        this.id = id;
        this.momentoDoPagamento = momentoDoPagamento;
        this.pedido = pedido;
    }


    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public Instant getMomentoDoPagamento() { return momentoDoPagamento; }

    public void setMomentoDoPagamento(Instant momentoDoPagamento) { this.momentoDoPagamento = momentoDoPagamento; }

    public Pedido getPedido() { return pedido; }

    public void setPedido(Pedido pedido) { this.pedido = pedido; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pagamento pagamento = (Pagamento) o;
        return Objects.equals(id, pagamento.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}





































