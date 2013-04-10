/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.recepcao.dao;

import br.com.recepcao.model.Pessoa;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author gabriel
 */
public class PessoaDaoImpl {
    
     public void salvar(Pessoa pessoa) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction().begin();
        session.saveOrUpdate(pessoa);
        session.getTransaction().commit();
        session.close();
        System.out.println("Salvo com sucesso");
    }

    public List consultar() {
        List lista = new ArrayList();
        Criteria crit = HibernateUtil.getSession().createCriteria(Pessoa.class);
        lista = crit.list();
        System.out.println("Listado Com Sucesso!");
        return lista;
    }

    public void deletar(Pessoa pessoa) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction().begin();
        session.delete(pessoa);
        session.getTransaction().commit();
        session.close();
        System.out.println("Deletado com sucesso");
    }

}
