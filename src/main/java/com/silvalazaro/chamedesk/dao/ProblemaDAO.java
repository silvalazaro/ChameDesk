package com.silvalazaro.chamedesk.dao;

import com.silvalazaro.chamedesk.modelo.Problema;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que realiza as operacoes com o banco de dados da entidade Problema
 *
 * @author Lazaro
 */
public class ProblemaDAO implements DAO<Problema> {

    /**
     * Buscar Problema utilizando o ID
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Problema buscaPorId(int id) throws Exception {
        Problema problema = new Problema();
        ResultSet resultado;
        Connection conexao = ConexaoDB.getInstancia().getConexao();
        PreparedStatement statement = conexao.prepareStatement("SELECT ID, NOME, CLASSE FROM PROBLEMA WHERE ID = ?");
        statement.setInt(1, id);
        resultado = statement.executeQuery();
        if (resultado.next()) {
            problema.setId(resultado.getInt(1));
            problema.setNome(resultado.getString(2));
            problema.setClasse(resultado.getString(3));
        }
        statement.close();
        return problema;
    }

    @Override
    public Problema salvar(Problema entidade) throws SQLException, ClassNotFoundException {
        Connection conexao = ConexaoDB.getInstancia().getConexao();
        int registros;
        PreparedStatement statement;
        if (entidade.getId() == 0) {
            statement = conexao.prepareStatement("INSERT INTO PROBLEMA (nome, classe)VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
        } else {
            statement = conexao.prepareStatement("UPDATE PROBLEMA SET NOME = ?, CLASSE = ?"
                    + " WHERE ID = ?", Statement.RETURN_GENERATED_KEYS);
            statement.setInt(3, entidade.getId());
        }
        statement.setString(1, entidade.getNome());
        statement.setString(2, entidade.getClasse());
        registros = statement.executeUpdate();
        ResultSet resultado = statement.getGeneratedKeys();
        if (resultado.next() && entidade.getId() == 0) {
            entidade.setId(resultado.getInt(1));
        }
        statement.close();
        return entidade;
    }

    @Override
    public void excluir(int id) throws ClassNotFoundException, ClassNotFoundException, SQLException {
        Connection conexao = ConexaoDB.getInstancia().getConexao();
        PreparedStatement statement = conexao.prepareStatement("DELETE FROM PROBLEMA WHERE ID = ?");
        statement.setInt(1, id);
        statement.execute();
        statement.close();
    }

    @Override
    public List<Problema> listar() throws ClassNotFoundException, SQLException {
        List<Problema> problemas = new ArrayList<>();
        ResultSet registros;
        Connection conexao = ConexaoDB.getInstancia().getConexao();
        PreparedStatement statement = conexao.prepareStatement("SELECT ID, NOME, CLASSE FROM"
                + " PROBLEMA");
        registros = statement.executeQuery();

        while (registros.next()) {
            Problema problema = new Problema();
            problema.setId(registros.getInt(1));
            problema.setNome(registros.getString(2));
            problema.setClasse(registros.getString(3));
            problemas.add(problema);
        }
        statement.close();
        return problemas;
    }

}
