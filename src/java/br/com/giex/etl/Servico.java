/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.giex.etl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
/**
 *
 * @author jjunior
 */
@javax.jws.WebService
public class Servico {


    @WebMethod
    public void ChamaCredor(@WebParam(name = "credor") Integer pCredor) {
        try {
            ThreadCredor tc = new ThreadCredor(pCredor);
            tc.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
