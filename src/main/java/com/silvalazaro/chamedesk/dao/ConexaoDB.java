/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silvalazaro.chamedesk.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Lazaro
 */
public class ConexaoDB {

    private static Connection connection;
    private static ConexaoDB conexao;

    private ConexaoDB() throws ClassNotFoundException, SQLException {
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        connection = DriverManager.getConnection("jdbc:derby:" + System.getProperty("user.dir") + "\\chamedb;", "demo", "demo");

    }

    public static synchronized ConexaoDB getInstancia() throws ClassNotFoundException, SQLException {
        if (ConexaoDB.conexao == null) {
            conexao = new ConexaoDB();
        } else if (connection.isClosed()) {
            conexao = new ConexaoDB();
        }
        return conexao;
    }

    public Connection getConexao() {
        return connection;
    }

    public void encerrar() throws ClassNotFoundException, SQLException {
        Logger log = LogManager.getLogger();
        log.info("Encerrando conexão com o derby");
        connection = DriverManager.getConnection("jdbc:derby:" + System.getProperty("user.dir") + "\\chamedb;shutdown=true", "demo", "demo");
        log.info("Conexão encerrada");
    }
}
