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

        List<Aluguel> aluguelList = null;
        AluguelService aluguelService = new AluguelService();

        List<Locacao> locacaoList = null;
        LocacaoService locacaoService = new LocacaoService();

        Cliente cliente = new Cliente();
        ClienteService clienteService = new ClienteService();

        cliente = clienteService.buscaCliente(3);

        locacaoList = locacaoService.listarLocacao(cliente);

        aluguelList = aluguelService.listarLocacao(cliente);

        for (Locacao loc : locacaoList) {

            Aluguel aluguel = new Aluguel();
            aluguel.setLocacao(loc);
            aluguel.setValorPago(new BigDecimal(200.00));
            aluguel.setDataVencimento(new DataConvert().converterData("10/11/2020"));
            aluguel.setDataPagamento(new DataConvert().converterData("08/11/2020"));
            aluguel.setObservacoes("Pagamento antes o vencimento");

            aluguelService.save(aluguel);
        }

        for (Aluguel aluguel : aluguelList) {
            //System.out.println("Vencimento: " + new DataConvert().converterDataFromBanco(aluguel.getDataVencimento()) + "\nValor Pago: R$ " + aluguel.getValorPago());
        }

    }

}
