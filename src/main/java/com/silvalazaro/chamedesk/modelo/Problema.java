package com.silvalazaro.chamedesk.modelo;

/**
 * Classe que representa um Problema a ser solucionado
 * 
 * @author Lazaro
 */
public class Problema extends Modelo {

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
