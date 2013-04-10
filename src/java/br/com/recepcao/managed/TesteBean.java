/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.

package br.com.recepcao.managed;


import br.com.recepcao.dao.CalendarioDaoImpl;
import br.com.recepcao.dao.PessoaDaoImpl;
import br.com.recepcao.model.Calendario;
import br.com.recepcao.model.Pessoa;
import java.util.Arrays;
import java.util.Collection;

/**
 *
 * @author gabriel
 
public class TesteBean {

    public static void main(String[] args) {
   
       PessoaDaoImpl pessoaDao = new PessoaDaoImpl(); 
       CalendarioDaoImpl calendarioDao = new CalendarioDaoImpl(); 
        
        Pessoa pessoa = new Pessoa();
        pessoa.setAcesso("Sim");
        pessoa.setCategoria("TI");
        pessoa.setNome("Gabriel Araujo");
        pessoa.setRg("123.123.123-9");
        pessoa.setTipo("Tecnologia");
        pessoa.setTelefone("9 8283-8048");
      //  pessoaDao.salvar(pessoa);
        
        Calendario calendario = new Calendario();
        calendario.setPessoa(pessoa);
        calendario.setDataVisita("08/04/2013");
        
        Collection<Calendario> pessoas = Arrays.asList(calendario);
        pessoa.setPessoaCalendario(pessoas);
        
     pessoaDao.salvar(pessoa);
        
     
    }
}
*/