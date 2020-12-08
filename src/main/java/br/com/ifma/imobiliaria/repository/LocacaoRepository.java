package br.com.ifma.imobiliaria.repository;

import br.com.ifma.imobiliaria.model.Cliente;

import br.com.ifma.imobiliaria.model.Imovel;
import br.com.ifma.imobiliaria.model.Locacao;
import br.com.ifma.imobiliaria.service.ClienteService;

import javax.persistence.EntityManager;
import java.util.List;

public class LocacaoRepository {

    private final EntityManager manager;
    private DAOGenerico<Locacao> daoGenerico;

    public LocacaoRepository(EntityManager manager) {
        this.manager = manager;
        this.daoGenerico = new DAOGenerico<Locacao>(manager);
    }

    public Locacao findById(Integer id) {
        return daoGenerico.findById(Locacao.class, id);
    }

    public List<Locacao> findByCliente(Integer idCliente) {

        Cliente cliente = new Cliente();
        ClienteService clienteService = new ClienteService();

        cliente = clienteService.buscaCliente(idCliente);

        return this.manager.createQuery("from Locacao loc where loc.cliente.idCliente = :id", Locacao.class)
                .setParameter("id", cliente.getId())
                .getResultList();
    }

    public Locacao save(Locacao locacao) {
        return daoGenerico.save(locacao);
    }

    public void remove(Locacao locacao) {
        daoGenerico.remove(locacao);
    }

}
