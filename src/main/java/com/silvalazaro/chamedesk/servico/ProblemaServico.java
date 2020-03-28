package com.silvalazaro.chamedesk.servico;

import com.silvalazaro.chamedesk.dao.ProblemaDAO;
import com.silvalazaro.chamedesk.modelo.Problema;
import com.silvalazaro.chamedesk.dao.DAO;

/**
 *
 * @author Lazaro
 */
public class ProblemaServico extends Servico<ProblemaDAO> {

    private DAO dao;

    public ProblemaServico() {
    }

    @Override
    public DAO<ProblemaDAO> getDAO() {
        if(dao == null){
            dao = new ProblemaDAO();
        }
        return dao;
    }

}
