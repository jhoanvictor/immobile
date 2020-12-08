package br.com.ifma.imobiliaria.service;

import br.com.ifma.imobiliaria.model.Cliente;
import br.com.ifma.imobiliaria.repository.ClienteRepository;
import br.com.ifma.imobiliaria.util.Connection;

import javax.persistence.EntityManager;
import java.util.List;

public class ClienteService {

    private EntityManager manager = Connection.getEntityManager();
    private ClienteRepository repository = new ClienteRepository(manager);

    public Cliente buscaCliente(Integer id){
        return repository.findById(id);
    }

    public List<Cliente> buscarClientes(){
        List<Cliente> clientes = null;
        return clientes = repository.findAll();
    }

    public String salvaCliente(Cliente cliente){

        try {
            if (cliente.getTelefone().isEmpty()){
                throw new Exception("O telefone é obrigatório");
            }
            manager.getTransaction().begin();
            repository.save(cliente);
            manager.getTransaction().commit();
            return "Cliente salvo com sucesso!";
        }catch (Exception e){
            return "Erro ao salvar: " + e.getMessage();
        }
    }

    public void removeCliente(Integer id){
        Cliente cliente = repository.findById(id);
        manager.getTransaction().begin();
        repository.remove(cliente);
        manager.getTransaction().commit();
    }

}
