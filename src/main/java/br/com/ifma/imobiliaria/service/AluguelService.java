package br.com.ifma.imobiliaria.service;

import br.com.ifma.imobiliaria.model.Aluguel;
import br.com.ifma.imobiliaria.model.Cliente;
import br.com.ifma.imobiliaria.model.Locacao;
import br.com.ifma.imobiliaria.repository.AluguelRepository;
import br.com.ifma.imobiliaria.repository.LocacaoRepository;
import br.com.ifma.imobiliaria.util.Connection;

import javax.persistence.EntityManager;
import java.util.List;

public class AluguelService {

    private EntityManager manager = Connection.getEntityManager();
    private AluguelRepository repository = new AluguelRepository(manager);

    public List<Aluguel> listarLocacao(Cliente cliente) {
        List<Aluguel> aluguels = null;

        return aluguels = repository.findAluguel(cliente.getId());
    }

    public void save(Aluguel aluguel) {

        try {
            manager.getTransaction().begin();
            repository.save(aluguel);
            manager.getTransaction().commit();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

    }

    public void remove(Integer id) {
        Aluguel aluguel = repository.findById(id);
        manager.getTransaction().begin();
        repository.remove(aluguel);
        manager.getTransaction().commit();
    }


}
