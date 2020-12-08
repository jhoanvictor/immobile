package br.com.ifma.imobiliaria.service;

import br.com.ifma.imobiliaria.model.Cliente;
import br.com.ifma.imobiliaria.model.Imovel;
import br.com.ifma.imobiliaria.model.Locacao;
import br.com.ifma.imobiliaria.repository.LocacaoRepository;
import br.com.ifma.imobiliaria.util.Connection;

import javax.persistence.EntityManager;
import java.util.List;


public class LocacaoService {

    private EntityManager manager = Connection.getEntityManager();
    private LocacaoRepository repository = new LocacaoRepository(manager);

    public List<Locacao> listarLocacao(Cliente cliente) {
        List<Locacao> locacao = null;

        return locacao = repository.findByCliente(cliente.getId());
    }

    public void save(Locacao locacao) {

        try {
            if (locacao.getCliente().getId() == null) {
                throw new Exception("Para locar, informe o cliente");
            }

            if (locacao.getImovel().getId() == null) {
                throw new Exception("Para locar, informe o imovel");
            }

            manager.getTransaction().begin();
            repository.save(locacao);
            manager.getTransaction().commit();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

    }

    public void remove(Integer id) {
        Locacao locacao = repository.findById(id);
        manager.getTransaction().begin();
        repository.remove(locacao);
        manager.getTransaction().commit();
    }

    public String imprimiLocacao(Locacao locacao) {
        String nome = locacao.getCliente().getNome();

        return "Nome: " + nome + "\nImovel: " + locacao.getImovel().getTipoImovel();
    }

}
