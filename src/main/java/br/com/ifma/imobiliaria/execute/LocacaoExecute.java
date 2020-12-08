package br.com.ifma.imobiliaria.execute;

import br.com.ifma.imobiliaria.model.Cliente;
import br.com.ifma.imobiliaria.model.Imovel;
import br.com.ifma.imobiliaria.model.Locacao;
import br.com.ifma.imobiliaria.service.ClienteService;
import br.com.ifma.imobiliaria.service.ImovelService;
import br.com.ifma.imobiliaria.service.LocacaoService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class LocacaoExecute {

    public static void main(String[] args) {

        Cliente cliente = new Cliente();
        ClienteService clienteService = new ClienteService();

        List<Imovel> imovelList = new ArrayList<>();
        Imovel imovel = new Imovel();
        ImovelService imovelService = new ImovelService();

        cliente = clienteService.buscaCliente(3);
        imovelList = imovelService.listarImoveis();

        for (Imovel imovel1 : imovelList) {
            if (imovel1.getId().equals(4)) {
                imovel = imovel1;
            }
        }

        Locacao locacao = new Locacao(cliente, imovel);
        List<Locacao> locacao1 = null;
        LocacaoService locacaoService = new LocacaoService();

        locacao.setAtivo(true);
        locacao.setObservacoes("Imovel está alugado");
        locacao.setDiaVencimento(10);

        locacao1 = locacaoService.listarLocacao(cliente);

        for (Locacao loc : locacao1) {

            //loc.setPercentualMulta(new BigDecimal(15.5));
            //locacaoService.save(loc);

            System.out.println(locacaoService.imprimiLocacao(loc));
            System.out.println();

            /*if (loc.getId().equals(1)){
                locacaoService.remove(loc.getId());
            }*/

        }

        //locacaoService.save(locacao);
    }


}
