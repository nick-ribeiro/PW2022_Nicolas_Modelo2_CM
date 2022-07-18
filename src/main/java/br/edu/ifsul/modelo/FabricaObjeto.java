package br.edu.ifsul.modelo;

import java.util.ArrayList;
import java.util.List;

public class FabricaObjeto {
    
    public static List<UnidadeCondominal> carregaUnidadeCondominal() {
        List<UnidadeCondominal> lista = new ArrayList<>();
        UnidadeCondominal u = new UnidadeCondominal();
        u.setId(12);
        u.setArea(150.0);
        u.setNumero("12");
        u.setNumeroQuarto(1203);
        u.setDescricao("<h1>Apto bem localizado</h1>");
        Condominio c = new Condominio();
        c.setNome("Luisa");
        Pessoa p = new Pessoa();
        u.setCondominio(c);
        p.setNome("Luisa");
        u.setPessoa(p);
        lista.add(u);
        return lista;
    }
    
}
