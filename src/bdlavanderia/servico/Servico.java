/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bdlavanderia.servico;

import bdlavanderia.cliente.Cliente;
import bdlavanderia.peca.Peca;
import java.io.Serializable;
import java.sql.Date;
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
@Table(name = "servicos")
public class Servico implements Serializable{

    @Id
    @SequenceGenerator (name = "seq_servico", sequenceName = "servico_seq")
    @GeneratedValue(strategy = GenerationType.AUTO , generator="seq_servico")
    private Integer cod_servico;
    
    @ManyToOne
    @JoinColumn(name = "cod_cliente")
    private Cliente cliente;
    
    @ManyToOne
    @JoinColumn(name = "cod_peca")
    private Peca peca;
    
    @Column(name = "dt_entrada", nullable = true, updatable = false)
    private Date dataEntrada;
    
    @Column(name = "dt_saida", nullable = true, updatable = false)
    private Date dataSaida;
    
    @Column(name = "valor", nullable = true)
    private double valor;
    
    

    public Integer getCod_servico() {
        return cod_servico;
    }

    public void setCod_servico(Integer cod_servico) {
        this.cod_servico = cod_servico;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Peca getPeca() {
        return peca;
    }

    public void setPeca(Peca peca) {
        this.peca = peca;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.cod_servico);
        hash = 43 * hash + Objects.hashCode(this.cliente);
        hash = 43 * hash + Objects.hashCode(this.peca);
        hash = 43 * hash + Objects.hashCode(this.dataEntrada);
        hash = 43 * hash + Objects.hashCode(this.dataSaida);
        hash = 43 * hash + (int) (Double.doubleToLongBits(this.valor) ^ (Double.doubleToLongBits(this.valor) >>> 32));
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
        final Servico other = (Servico) obj;
        if (!Objects.equals(this.cod_servico, other.cod_servico)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.peca, other.peca)) {
            return false;
        }
        if (!Objects.equals(this.dataEntrada, other.dataEntrada)) {
            return false;
        }
        if (!Objects.equals(this.dataSaida, other.dataSaida)) {
            return false;
        }
        if (Double.doubleToLongBits(this.valor) != Double.doubleToLongBits(other.valor)) {
            return false;
        }
        return true;
    }

}
