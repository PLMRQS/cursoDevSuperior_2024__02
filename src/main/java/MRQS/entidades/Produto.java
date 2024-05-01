


package MRQS.entidades;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @Column(columnDefinition = "TEXT")// para definir que será um texto extenso e não um varchar de 255
    private String descricao;

    private Double preco;

    private String imgUrl; // o jpa irá converter para img_url

    @ManyToMany
    @JoinTable(name = "tb_produto_categoria",
        joinColumns = @JoinColumn(name = "produto_id"), // aqui representamos id da propria tabela
        inverseJoinColumns = @JoinColumn(name = "categoria_id")) // aqui representamos o id da outra tabela
    private Set<Categoria> categorias = new HashSet<>();

    @OneToMany(mappedBy = "id.produto")
    private Set<ItemPedido> itemPedidos = new HashSet<>();

    public Produto() {
    }

    public Produto(Integer id, String nome, String descricao, Double preco, String imgUrl) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.imgUrl = imgUrl;
    }


    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }

    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Double getPreco() { return preco; }

    public void setPreco(Double preco) { this.preco = preco; }

    public String getImgUrl() { return imgUrl; }

    public void setImgUrl(String imgUrl) { this.imgUrl = imgUrl; }


    public Set<Categoria> getCategorias() { return categorias; }

    public Set<ItemPedido> getItemPedidos() { return itemPedidos; }


    public List<Pedido> getPedidos() { return itemPedidos.stream().map(x -> x.getPedido()).toList(); }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}


























