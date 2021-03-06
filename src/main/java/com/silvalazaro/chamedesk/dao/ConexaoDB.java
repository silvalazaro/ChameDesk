package com.silvalazaro.chamedesk.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe que realiza a conexao com o banco de dados
 *
 * @author Lazaro
 */
public class ConexaoDB {

    private static Connection connection;
    private static ConexaoDB conexao;

    private ConexaoDB() throws ClassNotFoundException, SQLException {
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
        connection = DriverManager.getConnection("jdbc:derby:" + System.getProperty("user.dir") + "\\derby\\chame", "demo", "demo");
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

    public void encerrar() throws SQLException {
        DriverManager.getConnection("jdbc:derby:shutdown=true", "demo", "demo");
    }
}
