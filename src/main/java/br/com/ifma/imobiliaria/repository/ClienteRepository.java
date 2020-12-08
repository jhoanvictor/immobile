package br.com.ifma.imobiliaria.repository;

import br.com.ifma.imobiliaria.model.Cliente;

import javax.persistence.EntityManager;
import java.util.List;

public class ClienteRepository {

    private final EntityManager manager;
    private DAOGenerico<Cliente> daoGenerico;

    public ClienteRepository(EntityManager manager){
        this.manager = manager;
        daoGenerico = new DAOGenerico<Cliente>(manager);
    }

    public Cliente findById(Integer id){
        return daoGenerico.findById(Cliente.class, id);
    }

    public List<Cliente> findAll() {
        return this.manager.createQuery("from Cliente ", Cliente.class).getResultList();
    }

    public Cliente save(Cliente cliente) {
        return daoGenerico.save(cliente);
    }

    public void remove(Cliente cliente) {
        daoGenerico.remove(cliente );
    }

}
