/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silvalazaro.chamedesk.dao;

import com.silvalazaro.chamedesk.modelo.Solucao;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Realiza os testes da classe SolucaoDAO
 *
 * @author Lazaro
 */
public class SolucaoDAOTest {

    DAO dao = new SolucaoDAO();

    @Test
    public void testSalvaSolucao() throws Exception {
        Solucao solucao = new Solucao();
        solucao.setNome("Cadastrado pelo testSalvaSolucao");
        solucao = (Solucao) dao.salvar(solucao);
        assertTrue(solucao.getId() > 0);

    }

    @Test
    public void testAtualizaSolucao() throws Exception {
        Solucao solucao = (Solucao) dao.listar().get(0);
        solucao.setNome("Modificado pelo testSalvaSolucao");
        dao.salvar(solucao);
    }

    @Test
    public void testRecuperaSolucao() throws Exception {
        Solucao solucao = (Solucao) dao.buscaPorId(1);
        assertEquals(solucao.getId(), 1);
    }

    @Test
    public void testListaSolucao() throws Exception {
        List<Solucao> solucaos = dao.listar();
        assertFalse(solucaos.isEmpty());
    }

    @Test
    public void testExcluirSolucao() throws Exception {
        List<Solucao> solucoes = dao.listar();
        Solucao solucao = (Solucao) solucoes.get(solucoes.size() - 1);
        dao.excluir(solucao.getId());
    }
}
