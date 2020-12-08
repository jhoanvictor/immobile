package br.com.ifma.imobiliaria.execute;

import br.com.ifma.imobiliaria.model.Cliente;
import br.com.ifma.imobiliaria.service.ClienteService;
import br.com.ifma.imobiliaria.util.DataConvert;

import java.util.List;

public class ClienteExecute {

    public static void main(String[] args) {

        Cliente cliente = new Cliente();
        ClienteService clienteService = new ClienteService();
        List<Cliente> clientes = null;

        cliente.setNome("Teste");
        cliente.setDataNascimento(new DataConvert().converterData("10/02/2020"));
        cliente.setTelefone("999999999");
        cliente.setCpf("99999999999");
        cliente.setEmail("email@hotmail.com");

        clientes = clienteService.buscarClientes();

        Cliente cliente1 = clienteService.buscaCliente(3);
        cliente1.setEmail("email@email.com");

        /*for (Cliente c : clientes){
            if (c.getId().equals(1)){
                c.setNome("Teste de Update");
                clienteService.salvaCliente(c);
            }
        }*/

        clienteService.salvaCliente(cliente1);
        //clienteService.removeCliente(5);


    }

}
