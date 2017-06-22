/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.giex.model;

import java.math.BigDecimal;

/**
 *
 * @author jjunior
 */
public class RetornoTransferenciaModel {

    private String retorno;
    private BigDecimal count;

    public RetornoTransferenciaModel() {
    }

    public RetornoTransferenciaModel(String retorno, BigDecimal count) {
        this.retorno = retorno;
        this.count = count;
    }

    public String getRetorno() {
        return retorno;
    }

    public void setRetorno(String retorno) {
        this.retorno = retorno;
    }

    public BigDecimal getCount() {
        return count;
    }

    public void setCount(BigDecimal count) {
        this.count = count;
    }
}