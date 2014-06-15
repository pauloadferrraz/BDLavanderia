/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bdlavanderia.peca;

import bdlavanderia.cliente.Cliente;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author pauloadriano
 */

@Entity
@Table(name = "pecas")
public class Peca implements Serializable{
    
    
    @Id
    @SequenceGenerator (name = "seq_pecas", sequenceName = "pecas_seq")
    @GeneratedValue(strategy = GenerationType.AUTO , generator="seq_pecas")
    @Column(name = "cod_peca")
    private Integer cod_peca;
    
    @ManyToOne
    @JoinColumn(name = "cod_cliente")
    private Cliente cliente;
    
    @Column(name = "tipo", length = 30, nullable = true)
    private String tipo;
    
    @Column(name = "tamanho", length = 1, nullable = true)
    private String tamanho;

    public Integer getCod_peca() {
        return cod_peca;
    }

    public void setCod_peca(Integer cod_peca) {
        this.cod_peca = cod_peca;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.cod_peca);
        hash = 23 * hash + Objects.hashCode(this.cliente);
        hash = 23 * hash + Objects.hashCode(this.tipo);
        hash = 23 * hash + Objects.hashCode(this.tamanho);
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
        final Peca other = (Peca) obj;
        if (!Objects.equals(this.cod_peca, other.cod_peca)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.tamanho, other.tamanho)) {
            return false;
        }
        return true;
    }

}
