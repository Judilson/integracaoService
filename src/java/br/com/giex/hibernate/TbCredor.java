package br.com.giex.hibernate;
// Generated 25/10/2012 10:35:04 by Hibernate Tools 3.2.1.GA

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * TbCredor generated by hbm2java
 */
public class TbCredor implements java.io.Serializable {

    private BigDecimal idCredor;
    private boolean statusCredorN;
    private String obsCredorC;
    private String nlsNumericCharacters;
    private Set tbCredorXmls = new HashSet(0);
    private Set tbCredorLoteProcessamentos = new HashSet(0);
    private Set tbCredorLogProcessamentos = new HashSet(0);

    public TbCredor() {
    }

    public TbCredor(BigDecimal idCredor, boolean statusCredorN) {
        this.idCredor = idCredor;
        this.statusCredorN = statusCredorN;
    }

    public TbCredor(BigDecimal idCredor, boolean statusCredorN, String obsCredorC, String nlsNumericCharacters, Set tbCredorXmls, Set tbCredorLoteProcessamentos, Set tbCredorLogProcessamentos) {
        this.idCredor = idCredor;
        this.statusCredorN = statusCredorN;
        this.obsCredorC = obsCredorC;
        this.nlsNumericCharacters = nlsNumericCharacters;
        this.tbCredorXmls = tbCredorXmls;
        this.tbCredorLoteProcessamentos = tbCredorLoteProcessamentos;
        this.tbCredorLogProcessamentos = tbCredorLogProcessamentos;
    }

    public BigDecimal getIdCredor() {
        return this.idCredor;
    }

    public void setIdCredor(BigDecimal idCredor) {
        this.idCredor = idCredor;
    }

    public boolean isStatusCredorN() {
        return this.statusCredorN;
    }

    public void setStatusCredorN(boolean statusCredorN) {
        this.statusCredorN = statusCredorN;
    }

    public String getObsCredorC() {
        return this.obsCredorC;
    }

    public void setObsCredorC(String obsCredorC) {
        this.obsCredorC = obsCredorC;
    }

    public String getNlsNumericCharacters() {
        return this.nlsNumericCharacters;
    }

    public void setNlsNumericCharacters(String nlsNumericCharacters) {
        this.nlsNumericCharacters = nlsNumericCharacters;
    }

    public Set getTbCredorXmls() {
        return this.tbCredorXmls;
    }

    public void setTbCredorXmls(Set tbCredorXmls) {
        this.tbCredorXmls = tbCredorXmls;
    }

    public Set getTbCredorLoteProcessamentos() {
        return this.tbCredorLoteProcessamentos;
    }

    public void setTbCredorLoteProcessamentos(Set tbCredorLoteProcessamentos) {
        this.tbCredorLoteProcessamentos = tbCredorLoteProcessamentos;
    }

    public Set getTbCredorLogProcessamentos() {
        return this.tbCredorLogProcessamentos;
    }

    public void setTbCredorLogProcessamentos(Set tbCredorLogProcessamentos) {
        this.tbCredorLogProcessamentos = tbCredorLogProcessamentos;
    }
}