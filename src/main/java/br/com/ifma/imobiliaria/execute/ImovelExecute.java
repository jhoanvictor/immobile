package br.com.ifma.imobiliaria.execute;

import br.com.ifma.imobiliaria.model.Imovel;
import br.com.ifma.imobiliaria.service.ImovelService;

import java.math.BigDecimal;
import java.util.List;

public class ImovelExecute {

    public static void main(String[] args) {

        Imovel imovel = new Imovel();
        ImovelService imovelService = new ImovelService();
        List<Imovel> imovels = null;

        imovel.setTipoImovel("Casa");
        imovel.setEndereco("Avenida Dois");
        imovel.setVagasGaragem(1);
        imovel.setSuites(2);
        imovel.setMetragem(new BigDecimal(90.00));
        imovel.setBanheiros(3);
        imovel.setDormitorios(3);
        imovel.setBairro("Centro da Cidade");
        imovel.setCep("65000000");
        imovel.setValorAluguelSugerido(new BigDecimal(1500));
        imovel.setObservacoes("Condomíio com piscina e area de lazer");

        imovels = imovelService.listarImoveis();

        for (Imovel imovel1 : imovels) {
            System.out.println(imovel1.getId());
            if (imovel1.getId().equals(1)) {
                imovel1.setBairro("Alemanha");
                imovel1.setMetragem(new BigDecimal(58.30));
                //imovelService.salvaImovel(imovel1);
            }

        }

        System.out.println(imovelService.salvaImovel(imovel));
        imovelService.removeImovel(1);

    }

}
