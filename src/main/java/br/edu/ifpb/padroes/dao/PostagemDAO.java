package br.edu.ifpb.padroes.dao;

import br.edu.ifpb.padroes.modelo.Postagem;
import br.edu.ifpb.padroes.modelo.PostagemResposta;
import br.edu.ifpb.padroes.service.PostagemServiceImpl;

import java.sql.Connection;
import java.util.List;
import java.util.logging.Logger;

public abstract class PostagemDAO {
  protected abstract Connection connect();
  public abstract void adicionar(Postagem postagem);
  public abstract void remover(Postagem postagem);
  public abstract void atualizar(Postagem postagem);
  public abstract List<Postagem> listar();
  public abstract void addPostagemResposta(PostagemResposta postagem);
  public abstract Postagem getPostagem(Long id);

  public void trataExcecao(Exception ex) {
    Logger.getLogger(PostagemServiceImpl.class.getName()).warning(ex.getMessage());
  }
}
