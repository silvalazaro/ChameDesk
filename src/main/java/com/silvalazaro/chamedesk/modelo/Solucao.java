package com.silvalazaro.chamedesk.modelo;

/**
 * Classe Solucao representa a resolução para algum problema
 *
 * @author Lazaro
 */
public class Solucao extends Modelo {

    private String nome;
    private String classe;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

}
