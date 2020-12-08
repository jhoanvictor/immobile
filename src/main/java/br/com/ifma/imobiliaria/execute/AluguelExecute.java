package br.com.ifma.imobiliaria.execute;

import br.com.ifma.imobiliaria.model.Aluguel;
import br.com.ifma.imobiliaria.model.Cliente;
import br.com.ifma.imobiliaria.model.Locacao;
import br.com.ifma.imobiliaria.service.AluguelService;
import br.com.ifma.imobiliaria.service.ClienteService;
import br.com.ifma.imobiliaria.service.LocacaoService;
import br.com.ifma.imobiliaria.util.DataConvert;

import java.math.BigDecimal;
import java.util.List;

public class AluguelExecute {

    public static void main(String[] args) {

        AluguelService aluguelService = new AluguelService();

        List<Locacao> locacao = null;
        LocacaoService locacaoService = new LocacaoService();

        Cliente cliente = new Cliente();
        ClienteService clienteService = new ClienteService();

        cliente = clienteService.buscaCliente(3);

        locacao = locacaoService.listarLocacao(cliente);

        for (Locacao loc : locacao) {

            //System.out.println(loc.getId());

            Aluguel aluguel = new Aluguel();
            aluguel.setLocacao(loc);
            aluguel.setValorPago(new BigDecimal(200.00));
            aluguel.setDataVencimento(new DataConvert().converterData("07/12/2020"));

            System.out.println(aluguel.getLocacao().getAtivo());

            aluguelService.save(aluguel);

        }

    }

}
