package br.com.ifma.imobiliaria.repository;

import br.com.ifma.imobiliaria.model.Cliente;
import br.com.ifma.imobiliaria.model.EntidadeBase;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Objects;

public class DAOGenerico<T extends EntidadeBase> {

    private final EntityManager manager;

    public DAOGenerico(EntityManager manager) {
        this.manager = manager;
    }

    public T findById(Class<T> clazz, Integer id) {
        return manager.find(clazz, id);
    }

    public T save(T t) {
        if (Objects.isNull(t.getId()))
            this.manager.persist(t);
        else
            t = this.manager.merge(t);
        return t;
    }

    public void remove(T t) {
        manager.remove(t);
        manager.flush();
    }

}
