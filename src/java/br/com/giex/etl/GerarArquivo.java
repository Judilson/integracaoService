/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.giex.etl;

import br.com.giex.dao.CredorLogProcessamentoDAO;
import br.com.giex.dao.CredorLoteProcessamentoDAO;
import br.com.giex.dao.CredorXmlDAO;
import br.com.giex.hibernate.TbCredor;
import br.com.giex.hibernate.TbCredorLogProcessamento;
import br.com.giex.hibernate.TbCredorLoteProcessamento;
import br.com.giex.hibernate.TbCredorXml;
import br.com.giex.model.RetornoTransferenciaModel;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.Calendar;
import scriptella.execution.EtlExecutor;
import scriptella.execution.EtlExecutorException;
import scriptella.execution.ExecutionStatistics;

/**
 *
 * @author jjunior
 */
public class GerarArquivo {

    private final String vSucesso = "SUCESSO";

    public void GerenciaXml(Integer pCredor) throws SQLException, Exception {

        TbCredor credor = new TbCredor();
        credor.setIdCredor(new BigDecimal(pCredor));

        TbCredorLoteProcessamento lote = new TbCredorLoteProcessamento();
        lote.setDataInicioD(Calendar.getInstance().getTime());
        lote.setTbCredor(credor);

        TbCredorLoteProcessamento credorLoteProcessamento = new CredorLoteProcessamentoDAO().saveCredorLoteProcessamento(lote);
        
        try {
            for (TbCredorXml id : new CredorXmlDAO().listaCredor(pCredor)) {

                TbCredorXml xml = new TbCredorXml();
                xml.setIdXml(id.getIdXml());

                TbCredorLogProcessamento log = new TbCredorLogProcessamento();
                log.setTbCredor(credor);
                log.setTbCredorXml(xml);
                log.setDataInicioD(Calendar.getInstance().getTime());
                log.setTbCredorLoteProcessamento(credorLoteProcessamento);

                TbCredorLogProcessamento credorLogProcessamento = new CredorLogProcessamentoDAO().saveCredorLogProcessamento(log);

                try {
                    RetornoTransferenciaModel retorno = EtlXml(id.getIdXml());

                    credorLogProcessamento.setDataFimD(Calendar.getInstance().getTime());
                    credorLogProcessamento.setLogC(retorno.getRetorno());
                    credorLogProcessamento.setCountN(retorno.getCount());
                    new CredorLogProcessamentoDAO().mergeCredorLogProcessamento(credorLogProcessamento);

                } catch (Exception e) {

                    credorLogProcessamento.setDataFimD(Calendar.getInstance().getTime());
                    credorLogProcessamento.setLogC(e.toString());
                    new CredorLogProcessamentoDAO().mergeCredorLogProcessamento(credorLogProcessamento);
                }
            }

            credorLoteProcessamento.setDataFimD(Calendar.getInstance().getTime());
            credorLoteProcessamento.setLogC(vSucesso);
            new CredorLoteProcessamentoDAO().mergeCredorLoteProcessamento(credorLoteProcessamento);

        } catch (Exception e) {

            credorLoteProcessamento.setDataFimD(Calendar.getInstance().getTime());
            credorLoteProcessamento.setLogC(e.toString());
            new CredorLoteProcessamentoDAO().mergeCredorLoteProcessamento(credorLoteProcessamento);
        }
    }

    public RetornoTransferenciaModel EtlXml(BigDecimal pId) throws SQLException, Exception {
        Clob arquivo;

        RetornoTransferenciaModel retorno = new RetornoTransferenciaModel();
        arquivo = new CredorXmlDAO().xmlCredor(pId);

        String strng;

        int len = (int) arquivo.length();
        strng = arquivo.getSubString(1, len);

        File temp = File.createTempFile("tempfile", ".tmp");

        BufferedWriter bw;
        bw = new BufferedWriter(new FileWriter(temp));
        bw.write(strng);
        bw.close();

        try {
            ExecutionStatistics es =  EtlExecutor.newExecutor(temp).execute();
            es.getExecutedStatementsCount();
            retorno.setRetorno(vSucesso);
            retorno.setCount(new BigDecimal(es.getExecutedStatementsCount()));
            return retorno;
        } catch (EtlExecutorException ex) {
            retorno.setRetorno(ex.toString());
            return retorno;
        }
    }
}