/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bdlavanderia;

import bdlavanderia.cliente.Cliente;
import bdlavanderia.cliente.ClienteCrud;
import bdlavanderia.peca.Peca;
import bdlavanderia.peca.PecaCrud;
import bdlavanderia.servico.Servico;
import bdlavanderia.servico.ServicoCrud;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pauloadriano
 */
public class BDLavanderia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        BDLavanderia bd = new BDLavanderia();
        //bd.cadastrarClientes();
        //bd.cadastrarPecas();
        bd.cadastrarServico();
        
    }
    
    public void cadastrarClientes() {
        
        Cliente cliente = null;
        ClienteCrud clienteCrud = new ClienteCrud();
        
        String[] nomes = {"Cliente 1 ", "Cliente 2", "Cliente 3"};
        String[] fones = {"(47) 3333-4444", "(47) 7777-5555", "(47) 9090-2525"};
        String[] emails = {"solanu@javapro.com.br", "lunare@javapro.com.br", "venusiana@javapro.com.br"};
        String[] endere = {"end cliente1", "end cliente2", "end cliente3"};
        
        for (int i = 0; i < nomes.length; i++) {
            cliente = new Cliente();
            
            cliente.setNome(nomes[i]);
            cliente.setTelefone(fones[i]);
            cliente.setEmail(emails[i]);
            cliente.setDataCadastro(new Date(System.currentTimeMillis()));
            cliente.setEndereco(endere[i]);
            
            clienteCrud.salvar(cliente);
        }
    }
    
    public void cadastrarPecas() {
        Peca peca = null;
        PecaCrud pecaCrud = new PecaCrud();
        ClienteCrud clienteCrud = new ClienteCrud();
        
        String[] tipo = {"camisa", "bermuda", "calcajeans"};
        String[] tamanho = {"P", "M", "G"};
        
        int b=0;
        for (int j = 0; j < tipo.length; j++) {
            b=j+1;
            peca = new Peca();
            peca.setTipo(tipo[j]);
            peca.setTamanho(tamanho[j]);
            System.out.println("b "+b);
            peca.setCliente(clienteCrud.buscaCliente(b));
            pecaCrud.salvar(peca);
            
        }
    }
    
    public void cadastrarServico() {
        Servico servico = null;
        ServicoCrud serCrud = new ServicoCrud();
        PecaCrud pecaCrud = new PecaCrud();
        ClienteCrud clienteCrud = new ClienteCrud();
        Double[] valores = {10.5, 25.3, 32.2};
        
        int b=0;
        for (int c = 0; c < valores.length; c++) {
            b=c+1;
            servico = new Servico();
            servico.setDataEntrada(new Date(System.currentTimeMillis()));
            servico.setDataSaida(new Date(System.currentTimeMillis()));
            servico.setValor(valores[c]);
            System.out.println("Servico B "+b);
            servico.setCliente(clienteCrud.buscaCliente(b));
            servico.setPeca(pecaCrud.buscaPeca(b));
            serCrud.salvar(servico);
        }
    }
}
