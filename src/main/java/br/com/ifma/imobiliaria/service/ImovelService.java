package br.com.ifma.imobiliaria.service;

import br.com.ifma.imobiliaria.model.Imovel;
import br.com.ifma.imobiliaria.repository.ImovelRepository;
import br.com.ifma.imobiliaria.util.Connection;

import javax.persistence.EntityManager;
import java.util.List;

public class ImovelService {

    private EntityManager manager = Connection.getEntityManager();
    private ImovelRepository repository = new ImovelRepository(manager);

    public List<Imovel> listarImoveis() {
        List<Imovel> imovels = null;
        return imovels = repository.findAll();
    }

    public String salvaImovel(Imovel imovel) {

        try {
            if (imovel.getTipoImovel().isEmpty()) {
                throw new Exception("O tipo do imóvel é obrigatório");
            }

            manager.getTransaction().begin();
            repository.save(imovel);
            manager.getTransaction().commit();
            return "Imovel salvo com sucesso!";
        } catch (Exception e) {
            return "Erro ao salvar: " + e.getMessage();
        }
    }

    public void removeImovel(Integer id) {
        Imovel imovel = repository.findById(id);
        manager.getTransaction().begin();
        repository.remove(imovel);
        manager.getTransaction().commit();
    }

}
