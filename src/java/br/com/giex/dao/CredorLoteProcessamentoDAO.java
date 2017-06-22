/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.giex.dao;

import br.com.giex.hibernate.TbCredorLoteProcessamento;
import br.com.giex.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author jjunior
 */
public class CredorLoteProcessamentoDAO {

    public TbCredorLoteProcessamento saveCredorLoteProcessamento(TbCredorLoteProcessamento credorLoteProcessamento) {

        Session s = HibernateUtil.getSession();

        s.getTransaction().begin();

        s.save(credorLoteProcessamento);

        s.getTransaction().commit();

        s.close();

        return credorLoteProcessamento;
    }

    public TbCredorLoteProcessamento mergeCredorLoteProcessamento(TbCredorLoteProcessamento credorLoteProcessamento) {

        Session s = HibernateUtil.getSession();

        s.getTransaction().begin();

        s.merge(credorLoteProcessamento);

        s.getTransaction().commit();

        s.close();

        return credorLoteProcessamento;
    }
}
