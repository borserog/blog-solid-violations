package br.edu.ifpb.padroes.service;

import br.edu.ifpb.padroes.dao.PostagemDAO;
import br.edu.ifpb.padroes.modelo.Postagem;
import br.edu.ifpb.padroes.modelo.PostagemResposta;

import java.util.Date;

public class PostagemServiceImpl implements PostagemService {

  private final PostagemDAO postagemDAO;

  public PostagemServiceImpl(PostagemDAO dao) {
    this.postagemDAO = dao;
  }

  @Override
  public void adicionarPostagem(Postagem postagem) {
    postagemDAO.adicionar(postagem);
  }

  @Override
  public void removerPostagem(Postagem postagem) {
    this.postagemDAO.remover(postagem);
  }

  @Override
  public void atualizarPostagem(Postagem postagem) {
    this.postagemDAO.atualizar(postagem);
  }

  @Override
  public void adicionarResposta(Postagem postagem, Postagem resposta) {
    PostagemResposta postagemResposta = new PostagemResposta();
    postagemResposta.setPostagem(postagem);
    postagemResposta.setUsuario(resposta.getUsuario());
    postagemResposta.setData(new Date());
    this.postagemDAO.addPostagemResposta(postagemResposta);
  }
}
