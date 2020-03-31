package com.silvalazaro.chamedesk.dao;

import java.util.List;

/**
 * Interface que define as operacoes com o banco de dados
 *
 * @author Lazaro
 * @param <E>
 */
public interface DAO<E> {

    public E buscaPorId(int id) throws Exception;

    public E salvar(E entidade) throws Exception;

    public void excluir(int id) throws Exception;

    public List<E> listar() throws Exception;

}
