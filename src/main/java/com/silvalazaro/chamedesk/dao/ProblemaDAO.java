package com.silvalazaro.chamedesk.dao;

import com.silvalazaro.chamedesk.modelo.Problema;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
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
        return entidade;
    }

    @Override
    public void exclui(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Problema> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
