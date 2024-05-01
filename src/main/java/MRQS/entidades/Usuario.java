


package MRQS.entidades;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String email;

    private String celular;

    private LocalDate dataNascimento;

    private String senha;

    // mapeamento um para muitos: (devemos definir uma coleção)
    @OneToMany(mappedBy = "cliente") // deverá ser o nome do atributo na outra classe
    private List<Pedido> pedidos = new ArrayList<>();



    // definindo um construtor sem argumentos:
    public Usuario() {

    }

    // defindo os contrutores com argumentos:

    public Usuario(Integer id, String nome, String email, String celular, LocalDate dataNascimento, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.celular = celular;
        this.dataNascimento = dataNascimento;
        this.senha = senha;
    }

    // definindo os gets e sets:

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getCelular() { return celular; }

    public void setCelular(String celular) { this.celular = celular; }

    public LocalDate getDataNascimento() { return dataNascimento; }

    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }

    public String getSenha() { return senha; }

    public void setSenha(String senha) { this.senha = senha; }



    // para que possamos acessar essa lista, precisamos definir um get para pedidos
    public List<Pedido> getPedidos() { return pedidos; }
}











































