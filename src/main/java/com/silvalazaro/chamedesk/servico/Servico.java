package com.silvalazaro.chamedesk.servico;

import com.silvalazaro.chamedesk.dao.DAO;

/**
 *
 * @author Lazaro
 */
public abstract class Servico<E> {

    public abstract DAO<E> getDAO();
    
}
