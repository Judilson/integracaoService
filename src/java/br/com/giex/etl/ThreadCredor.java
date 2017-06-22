/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.giex.etl;
/**
 *
 * @author jjunior
 */
class ThreadCredor extends Thread {

    private int credor;

    ThreadCredor(Integer pCredor) {
        super("Credor " + pCredor);
        credor = pCredor;
    }

    public void run() {
        try {
            GerarArquivo gerente = new GerarArquivo();
            gerente.GerenciaXml(credor);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}