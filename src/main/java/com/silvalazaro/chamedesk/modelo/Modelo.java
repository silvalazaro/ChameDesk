package com.silvalazaro.chamedesk.modelo;

import java.io.Serializable;

/**
 * Classe Modelo representa o topo da generalização das classes que podem ser persistidas no banco de dados
 *
 * @author Lazaro
 */
public abstract class Modelo implements Serializable {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
