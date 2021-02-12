package br.edu.ifpb.padroes.dao;

import br.edu.ifpb.padroes.modelo.Postagem;
import br.edu.ifpb.padroes.modelo.PostagemResposta;
import br.edu.ifpb.padroes.service.UsuarioServiceImpl;

import java.sql.*;
import java.util.List;
import java.util.logging.Logger;

public class PostagemDAOSqlite extends PostagemDAO {

    private final String arquivoBanco;

    public PostagemDAOSqlite(String arquivoBanco) {
        this.arquivoBanco = arquivoBanco;
    }

    @Override
    public Connection connect() {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:"+this.arquivoBanco)) {
            Statement statement = connection.createStatement();

            //Criando tabela de postagem
            statement.execute("CREATE TABLE IF NOT EXISTS POSTAGEM( ID INTEGER, TITULO VARCHAR, USUARIO_ID VARCHAR, MENSAGEM VARCHAR, TIPO VARCHAR )");

            return connection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void adicionar(Postagem postagem) {
        Connection conexao = connect();
        try (PreparedStatement stmt = conexao.prepareStatement("INSERT INTO POSTAGEM( ID, TITULO, USUARIO_ID, MENSAGEM, TIPO) VALUES (?, ?, ?, ?, ?)")) {
            stmt.setLong(1, postagem.getId());
            stmt.setString(2, postagem.getTitulo());
            stmt.setLong(3, postagem.getUsuario().getId());
            stmt.setString(4, postagem.getMensagem());
            stmt.setString(5, postagem.getPostagemTipo().toString());
            stmt.execute();
        } catch (SQLException ex) {
            this.trataExcecao(ex);
        }
    }

    @Override
    public void addPostagemResposta(PostagemResposta postagem) {
        this.trataExcecao(new Exception("Não implementado ainda"));
    }

    @Override
    public void atualizar(Postagem postagem) {
        this.trataExcecao(new Exception("Não implementado ainda"));
    }

    @Override
    public void remover(Postagem postagem) {
        this.trataExcecao(new Exception("Não implementado ainda"));
    }

    @Override
    public List<Postagem> listar() {
        this.trataExcecao(new Exception("Não implementado ainda"));
        return null;
    }

    public Postagem getPostagem(Long id) {
        this.trataExcecao(new Exception("Não implementado ainda"));
        return null;
    }
}
