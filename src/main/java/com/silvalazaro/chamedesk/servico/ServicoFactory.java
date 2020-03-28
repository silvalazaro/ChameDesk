package com.silvalazaro.chamedesk.servico;

/**
 *
 * @author Lazaro
 */
public class ServicoFactory {

    public Servico criaProblemaServico() {
        return new ProblemaServico();
    }

}
