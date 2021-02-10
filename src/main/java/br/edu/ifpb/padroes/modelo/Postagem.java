package br.edu.ifpb.padroes.modelo;

public class Postagem {

    private Long id;

    private String titulo;

    private Usuario usuario;

    private String mensagem;

    private EPostagemTipo postagemTipo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public EPostagemTipo getPostagemTipo() {
        return postagemTipo;
    }

    public void setPostagemTipo(EPostagemTipo postagemTipo) {
        this.postagemTipo = postagemTipo;
    }
}
