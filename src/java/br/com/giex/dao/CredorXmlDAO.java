/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.giex.dao;

import br.com.giex.hibernate.TbCredorXml;
import br.com.giex.util.HibernateUtil;
import java.math.BigDecimal;
import java.sql.Clob;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author jjunior
 */
public class CredorXmlDAO {
 
    public List<TbCredorXml> listaCredor (Integer pCredor) {
        Session s = HibernateUtil.getSession();
        
        Query q = s.createQuery("from TbCredorXml t where t.tbCredor.idCredor = :pCredor and t.ativoN = 1 order by t.idOrdem");
        q.setInteger("pCredor", pCredor);
        
        List<TbCredorXml> lista = q.list();
        
        s.close();
        
        return lista;
    }
    
    public Clob xmlCredor (BigDecimal pIdXml) {
        Session s = HibernateUtil.getSession();
        
        Query q = s.createQuery("select xmlC from TbCredorXml where idXml = :pIdXml");
        q.setBigDecimal("pIdXml", pIdXml);
        
        Clob xml = (Clob) q.uniqueResult();
        
        s.close();
        
        return xml;
    }
    
}
