package br.com.ifma.imobiliaria.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Connection {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("immobile");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void close(){
        emf.close();
    }

}
