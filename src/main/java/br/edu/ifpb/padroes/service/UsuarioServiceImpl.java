package br.edu.ifpb.padroes.service;

import br.edu.ifpb.padroes.dao.UsuarioDAO;
import br.edu.ifpb.padroes.modelo.Usuario;

import java.util.List;

public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioDAO usuarioDAO;

    public UsuarioServiceImpl(UsuarioDAO dao) {
        this.usuarioDAO = dao;
    }

    @Override
    public void criarUsuario(Usuario usuario) {
        usuarioDAO.adicionar(usuario);
    }

    @Override
    public void atualizarUsuario(Usuario usuario) {
        usuarioDAO.atualizar(usuario);
    }

    @Override
    public void removerUsuario(Usuario usuario) {
        usuarioDAO.remover(usuario);
    }

    @Override
    public List<Usuario> listarUsuarios(Usuario usuario) {
        return usuarioDAO.listar();
    }

    @Override
    public Usuario recuperarUsuario(Long id) {
        return usuarioDAO.getUsuario(id);
    }

}
