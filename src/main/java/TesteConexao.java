import br.com.ifma.imobiliaria.model.Cliente;
import br.com.ifma.imobiliaria.model.Imovel;
import br.com.ifma.imobiliaria.model.Locacao;
import br.com.ifma.imobiliaria.repository.ClienteRepository;
import br.com.ifma.imobiliaria.util.Connection;

import javax.persistence.*;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class TesteConexao {
    public static void main(String[] args) throws ParseException {

        String d1 = "04/12/2010";
        String[] d2 = d1.split("/");
        String data = d2[2] + "-" + d2[1] + "-" + d2[0];

        System.out.println(d2[0]);
        System.out.println(d2[1]);
        System.out.println(d2[2]);

        System.out.println("DATA:" + data);

        //EntityManager em = Connection.getEntityManager();



        //Imovel imovel = new Imovel();
        //Cliente cliente = new Cliente();
        //Locacao locacao = new Locacao();

//        cliente.setNome("Jhoan Victor");
//        cliente.setCpf("01195033109");
//        cliente.setTelefone("984096500");

        /*SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date y1 = sdf1.parse("1997-02-08");*/

        //cliente.setDataNascimento(y1);

        /*Query q = em.createQuery("select a from Cliente a", Cliente.class);*/


        /*EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(cliente);
        tx.commit();*/

        /*Query q = em.createQuery("select a from Imovel a", Imovel.class);
        List<Imovel> imovels = q.getResultList();

        for (Imovel i : imovels) {
            System.out.println(i.getId());
            if (i.getId().equals(1)){
                EntityTransaction tx = em.getTransaction();
                tx.begin();
                i.setTipoImovel("casa");
                em.persist(i);
                tx.commit();
            }
        }

        imovel.setTipoImovel("imovel");
        imovel.setBanheiros(3);
        imovel.setObservacoes("teste de jpa");
        imovel.setEndereco("rua teste");
        imovel.setBairro("bairro");
        imovel.setCep("1234567");
        imovel.setDormitorios(3);
        imovel.setMetragem(new BigDecimal(10.2));
        imovel.setSuites(1);
        imovel.setValorAluguelSugerido(new BigDecimal(100));
        imovel.setVagasGaragem(1);

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(imovel);
        tx.commit();*/


        //em.close();
    }
}
