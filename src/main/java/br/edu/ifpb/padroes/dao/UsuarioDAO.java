package br.edu.ifpb.padroes.dao;

import br.edu.ifpb.padroes.modelo.Postagem;
import br.edu.ifpb.padroes.modelo.Usuario;
import br.edu.ifpb.padroes.service.PostagemServiceImpl;
import br.edu.ifpb.padroes.service.UsuarioServiceImpl;

import java.sql.Connection;
import java.util.List;
import java.util.logging.Logger;

public abstract class UsuarioDAO {
  protected abstract Connection connect();
  public abstract void adicionar(Usuario usuario);
  public abstract void remover(Usuario usuario);
  public abstract void atualizar(Usuario usuario);
  public abstract List<Usuario> listar();
  public abstract Usuario getUsuario(Long id);

  public void trataExcecao(Exception ex) {
    Logger.getLogger(UsuarioServiceImpl.class.getName()).warning(ex.getMessage());
  }
}
