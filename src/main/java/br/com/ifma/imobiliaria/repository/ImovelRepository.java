package br.com.ifma.imobiliaria.repository;

import br.com.ifma.imobiliaria.model.Imovel;
import javax.persistence.EntityManager;
import java.util.List;

public class ImovelRepository {

    private final EntityManager manager;
    private DAOGenerico<Imovel> daoGenerico;

    public ImovelRepository(EntityManager manager) {
        this.manager = manager;
        daoGenerico = new DAOGenerico<Imovel>(manager);
    }

    public Imovel findById(Integer id){
        return daoGenerico.findById(Imovel.class, id);
    }

    public List<Imovel> findAll() {
        return this.manager.createQuery("from Imovel ", Imovel.class).getResultList();
    }

    public Imovel save(Imovel imovel) {
        return daoGenerico.save(imovel);
    }

    public void remove(Imovel imovel) {
        daoGenerico.remove(imovel);
    }

}
