/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bdlavanderia.cliente;

import bdlavanderia.peca.Peca;
import bdlavanderia.servico.Servico;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author pauloadriano
 */
@Entity
@Table(name = "clientes")
public class Cliente implements Serializable{

    @Id
    @SequenceGenerator (name = "seq_cliente", sequenceName = "cliente_seq")
    @GeneratedValue(strategy = GenerationType.AUTO , generator="seq_cliente")
    @Column(name = "cod_cliente")
    private Integer cod_cliente;
    
    @Column(name = "nome", length = 50, nullable = true)
    private String nome;
    
    @Column(name = "telefone", length = 50, nullable = true)
    private String telefone;
    
    @Column(name = "email", length = 50, nullable = true)
    private String email;
    
    @Column(name = "dt_cad", nullable = true)
    private Date dataCadastro;
    
    @Column(name = "endereco", length = 40, nullable = true)
    private String endereco;
    
    @OneToMany(mappedBy = "cod_peca")
    private List<Peca> pecas;
    
    @OneToMany(mappedBy = "cod_servico")
    private List<Servico> servicos;

    public Integer getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(Integer cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Peca> getPecas() {
        return pecas;
    }

    public void setPecas(List<Peca> pecas) {
        this.pecas = pecas;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.cod_cliente);
        hash = 97 * hash + Objects.hashCode(this.nome);
        hash = 97 * hash + Objects.hashCode(this.telefone);
        hash = 97 * hash + Objects.hashCode(this.email);
        hash = 97 * hash + Objects.hashCode(this.dataCadastro);
        hash = 97 * hash + Objects.hashCode(this.endereco);
        hash = 97 * hash + Objects.hashCode(this.pecas);
        hash = 97 * hash + Objects.hashCode(this.servicos);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.cod_cliente, other.cod_cliente)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.dataCadastro, other.dataCadastro)) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        if (!Objects.equals(this.pecas, other.pecas)) {
            return false;
        }
        if (!Objects.equals(this.servicos, other.servicos)) {
            return false;
        }
        return true;
    }
    
    
}
