package br.edu.ifpb.padroes.dao;

import br.edu.ifpb.padroes.modelo.Usuario;

import java.sql.*;
import java.util.List;

public class UsuarioDAOSqlite extends UsuarioDAO {

    private DatabaseConfig databaseConfig;

    public UsuarioDAOSqlite(String arquivoBanco) {
        this.databaseConfig = new DatabaseConfig(arquivoBanco);
    }

    @Override
    protected Connection connect() {
        try (Connection connection = databaseConfig.openConnection()) {
            Statement statement = connection.createStatement();

            //Criando tabela de usuários
            statement.execute("CREATE TABLE IF NOT EXISTS USUARIO( ID INTEGER, NOME VARCHAR, LOGIN VARCHAR, SENHA VARCHAR )");
            statement.execute("INSERT INTO USUARIO( ID, NOME, LOGIN, SENHA) VALUES (1, 'admin', 'admin', '123')");

            //Criando tabela de produtos
            statement.execute("CREATE TABLE IF NOT EXISTS USUARIO( ID INTEGER, NOME VARCHAR, LOGIN VARCHAR, SENHA VARCHAR )");
            statement.execute("INSERT INTO USUARIO( ID, NOME, LOGIN, SENHA) VALUES (1, 'admin', 'admin', '123')");

            PreparedStatement stmt = connection.prepareStatement("select * from USUARIO");
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                Integer id = resultSet.getInt("ID");
                String nome = resultSet.getString("NOME");

                System.out.println( id + " - " + nome);
            }

            return connection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void adicionar(Usuario usuario) {
        Connection conexao = connect();
        try (PreparedStatement stmt = conexao.prepareStatement("INSERT INTO USUARIO( ID, NOME, LOGIN, SENHA) VALUES (?, ?, ?, ?)")) {
            stmt.setLong(1, usuario.getId());
            stmt.setString(2, usuario.getNome());
            stmt.setString(3, usuario.getLogin());
            stmt.setString(4, usuario.getSenha());
            stmt.execute();
        } catch (SQLException ex) {
            this.trataExcecao(ex);
        }
    }

    @Override
    public void atualizar(Usuario usuario) {
        this.trataExcecao(new Exception("Não implementado ainda"));
    }

    @Override
    public void remover(Usuario usuario) {
        this.trataExcecao(new Exception("Não implementado ainda"));
    }

    @Override
    public List<Usuario> listar() {
        this.trataExcecao(new Exception("Não implementado ainda"));
        return null;
    }

    public Usuario getUsuario(Long id) {
        this.trataExcecao(new Exception("Não implementado ainda"));
        return null;
    }
}
