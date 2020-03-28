package com.silvalazaro.chamedesk.dao;

import com.silvalazaro.chamedesk.modelo.Problema;
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
        dao.salvar(problema);
    }

    @Test
    public void testAtualizaProblema() throws Exception {
        Problema problema = new Problema();
        problema.setId(1);
        problema.setNome("Modificado pelo testSalvaProblema");
        dao.salvar(problema);
    }
    
    @Test 
    public void testRecuperaProblema() throws Exception{
        Problema problema = (Problema) dao.buscaPorId(1);
        System.out.print("Problema: " + problema.getNome());
    }
}
