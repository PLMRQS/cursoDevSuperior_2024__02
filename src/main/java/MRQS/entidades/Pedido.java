


package MRQS.entidades;

import MRQS.enuns.StatusPedido;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE") // vai salvar no banco no padrão UTC
    private Instant momentoDoPedido;

    private StatusPedido statusPedido;

    // mapeamento de muitos para um:
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private  Usuario cliente;


    @OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
    private Pagamento pagamento;

    @OneToMany(mappedBy = "id.pedido")
    private Set<ItemPedido> itemPedidos = new HashSet<>();



    // construtor vazio sem argumentos:

    public Pedido() {
    }

    // definindo os construtores:


    public Pedido(Integer id, Instant momentoDoPedido, StatusPedido statusPedido, Usuario cliente, Pagamento pagamento) {
        this.id = id;
        this.momentoDoPedido = momentoDoPedido;
        this.statusPedido = statusPedido;
        this.cliente = cliente;
        this.pagamento = pagamento;
    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public Instant getMomentoDoPedido() { return momentoDoPedido; }

    public void setMomentoDoPedido(Instant momentoDoPedido) { this.momentoDoPedido = momentoDoPedido; }

    public StatusPedido getStatusPedido() { return statusPedido; }

    public void setStatusPedido(StatusPedido statusPedido) { this.statusPedido = statusPedido; }

    public Usuario getCliente() { return cliente; }

    public void setCliente(Usuario cliente) { this.cliente = cliente; }

    public Pagamento getPagamento() { return pagamento; }

    public void setPagamento(Pagamento pagamento) { this.pagamento = pagamento; }


    public Set<ItemPedido> getItemPedidos() { return itemPedidos; }


    public List<Produto> setProdutos() { return itemPedidos.stream().map(x -> x.getProduto()).toList(); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}




























