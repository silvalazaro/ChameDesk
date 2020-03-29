package com.silvalazaro.chamedesk.dao;

import com.silvalazaro.chamedesk.modelo.Problema;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Realiza os testes da classe Problema
 *
 * @author Lazaro
 */
public class ProblemaDAOTest {

    DAO dao = new ProblemaDAO();

    @Test
    public void testSalvaProblema() throws Exception {
        Problema problema = new Problema();
        problema.setNome("Cadastrado pelo testSalvaProblema");
        problema = (Problema) dao.salvar(problema);
        assertTrue(problema.getId() > 0);

    }

    @Test
    public void testAtualizaProblema() throws Exception {
        Problema problema = (Problema) dao.buscaPorId(1);
        problema.setNome("Modificado pelo testSalvaProblema");
        dao.salvar(problema);
    }

    @Test
    public void testRecuperaProblema() throws Exception {
        Problema problema = (Problema) dao.buscaPorId(1);
        assertEquals(problema.getId(), 1);
    }

    @Test
    public void testListaProblema() throws Exception {
        List<Problema> problemas = dao.listar();
        assertFalse(problemas.isEmpty());
    }

    @Test
    public void testExcluirProblema() throws Exception {
        dao.excluir(1);
    }
}
