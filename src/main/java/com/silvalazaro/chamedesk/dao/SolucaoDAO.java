package com.silvalazaro.chamedesk.dao;

import com.silvalazaro.chamedesk.modelo.Solucao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que realiza as operacoes com o banco de dados da entidade Solucao
 *
 * @author Lazaro
 */
public class SolucaoDAO implements DAO<Solucao> {

    @Override
    public Solucao buscaPorId(int id) throws ClassNotFoundException, SQLException {
        Solucao solucao = new Solucao();
        ResultSet resultado;
        Connection conexao = ConexaoDB.getInstancia().getConexao();
        PreparedStatement statement = conexao.prepareStatement("SELECT ID, NOME, CLASSE FROM SOLUCAO WHERE ID = ?");
        statement.setInt(1, id);
        resultado = statement.executeQuery();
        if (resultado.next()) {
            solucao.setId(resultado.getInt(1));
            solucao.setNome(resultado.getString(2));
            solucao.setClasse(resultado.getString(3));
        }
        statement.close();
        return solucao;
    }

    @Override
    public Solucao salvar(Solucao entidade) throws ClassNotFoundException, SQLException {
        Connection conexao = ConexaoDB.getInstancia().getConexao();
        int registros;
        PreparedStatement statement;
        if (entidade.getId() == 0) {
            statement = conexao.prepareStatement("INSERT INTO SOLUCAO (nome, classe)VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
        } else {
            statement = conexao.prepareStatement("UPDATE SOLUCAO SET NOME = ?, CLASSE = ?"
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
    public void excluir(int id) throws ClassNotFoundException, SQLException {
        Connection conexao = ConexaoDB.getInstancia().getConexao();
        PreparedStatement statement = conexao.prepareStatement("DELETE FROM SOLUCAO WHERE ID = ?");
        statement.setInt(1, id);
        statement.execute();
        statement.close();
    }

    @Override
    public List<Solucao> listar() throws ClassNotFoundException, SQLException {
        List<Solucao> solucoes = new ArrayList<>();
        ResultSet registros;
        Connection conexao = ConexaoDB.getInstancia().getConexao();
        PreparedStatement statement = conexao.prepareStatement("SELECT ID, NOME, CLASSE FROM"
                + " SOLUCAO");
        registros = statement.executeQuery();

        while (registros.next()) {
            Solucao solucao = new Solucao();
            solucao.setId(registros.getInt(1));
            solucao.setNome(registros.getString(2));
            solucao.setClasse(registros.getString(3));
            solucoes.add(solucao);
        }
        statement.close();
        return solucoes;

    }

}
