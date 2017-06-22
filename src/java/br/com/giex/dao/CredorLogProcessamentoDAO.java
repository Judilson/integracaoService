/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.giex.dao;

import br.com.giex.hibernate.TbCredorLogProcessamento;
import br.com.giex.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author jjunior
 */
public class CredorLogProcessamentoDAO {

    public TbCredorLogProcessamento mergeCredorLogProcessamento(TbCredorLogProcessamento credorLogProcessamento) {

        Session s = HibernateUtil.getSession();

        s.getTransaction().begin();

        s.merge(credorLogProcessamento);

        s.getTransaction().commit();

        s.close();

        return credorLogProcessamento;

    }

    public TbCredorLogProcessamento saveCredorLogProcessamento(TbCredorLogProcessamento credorLogProcessamento) {

        Session s = HibernateUtil.getSession();

        s.getTransaction().begin();

        s.save(credorLogProcessamento);

        s.getTransaction().commit();

        s.close();

        return credorLogProcessamento;

    }
}
