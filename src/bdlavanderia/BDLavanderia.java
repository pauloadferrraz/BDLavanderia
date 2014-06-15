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


        //Iniciarlizar Crud
        ClienteCrud clienteCrud = new ClienteCrud();
        PecaCrud pecaCrud = new PecaCrud();
        ServicoCrud serCrud = new ServicoCrud();


        String[] nomes = {"Cliente 1 ", "Cliente 2", "Cliente 3"};
        String[] fones = {"(47) 3333-4444", "(47) 7777-5555", "(47) 9090-2525"};
        String[] emails = {"solanu@javapro.com.br", "lunare@javapro.com.br", "venusiana@javapro.com.br"};
        String[] endere = {"end cliente1", "end cliente2", "end cliente3"};

        String[] tipo = {"camisa ", "bermuda", "calca jeans"};
        String[] tamanho = {"P", "M", "G"};

        Double[] valores = {10.5, 25.3, 32.2};


        Peca peca = null;
        Cliente cliente = null;
        Servico servico = null;


        for (int i = 0; i < nomes.length; i++) {

            servico = new Servico();
            cliente = new Cliente();
            
            cliente.setNome(nomes[i]);
            cliente.setTelefone(fones[i]);
            cliente.setEmail(emails[i]);
            cliente.setDataCadastro(new Date(System.currentTimeMillis()));
            cliente.setEndereco(endere[i]);

            peca = new Peca();
            peca.setTipo(tipo[i]);
            peca.setTamanho(tamanho[i]);
            peca.setCliente(cliente);
            
            servico.setCliente(cliente);
            servico.setDataEntrada(new Date(System.currentTimeMillis()));
            servico.setDataSaida(new Date(System.currentTimeMillis()));
            servico.setValor(valores[i]);
            servico.setPeca(peca);
            
            pecaCrud.salvar(peca);
            clienteCrud.salvar(cliente);
            serCrud.salvar(servico);
        }
        System.out.println("Total de pecas cadastrados: " + pecaCrud.listar());
        System.out.println("Total de servicos cadastrados: " + serCrud.listar());
        System.out.println("Total de clientes cadastrados: " + clienteCrud.listar().size());

    }
}
