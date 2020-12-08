package br.com.ifma.imobiliaria.repository;

import br.com.ifma.imobiliaria.model.Aluguel;
import br.com.ifma.imobiliaria.model.Cliente;
import br.com.ifma.imobiliaria.model.Locacao;
import br.com.ifma.imobiliaria.service.ClienteService;
import br.com.ifma.imobiliaria.service.LocacaoService;

import javax.persistence.EntityManager;
import java.util.List;

public class AluguelRepository {

    private final EntityManager manager;
    private DAOGenerico<Aluguel> daoGenerico;

    public AluguelRepository(EntityManager manager) {
        this.manager = manager;
        this.daoGenerico = new DAOGenerico<Aluguel>(manager);
    }

    public Aluguel findById(Integer id) {
        return daoGenerico.findById(Aluguel.class, id);
    }

    public List<Aluguel> findAluguel(Integer idCliente) {

        List<Aluguel> alugueis = null;

        Cliente cliente = new Cliente();
        ClienteService clienteService = new ClienteService();

        List<Locacao> locacao = null;
        LocacaoService locacaoService = new LocacaoService();

        cliente = clienteService.buscaCliente(idCliente);
        locacao = locacaoService.listarLocacao(cliente);

        for (Locacao loc : locacao) {
            alugueis = this.manager.createQuery("from Aluguel al where al.locacao.idLocacao = :idLocacao and al.locacao.cliente.idCliente = :id", Aluguel.class)
                    .setParameter("idLocacao", loc.getId())
                    .setParameter("id", cliente.getId())
                    .getResultList();
        }

        return alugueis;
    }

    public Aluguel save(Aluguel aluguel) {
        return daoGenerico.save(aluguel);
    }

    public void remove(Aluguel aluguel) {
        daoGenerico.remove(aluguel);
    }


}
