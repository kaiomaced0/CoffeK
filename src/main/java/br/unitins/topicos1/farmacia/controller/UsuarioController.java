package br.unitins.topicos1.farmacia.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.topicos1.farmacia.model.Usuario;

@Named
@ViewScoped
public class UsuarioController implements Serializable {
	

	private static final long serialVersionUID = 168067236765100328L;
	private Usuario usuario = null;
	private List<Usuario> listaUsuario;
	
	public void incluir() {
		getListaUsuario().add(getUsuario());
		limpar();
	}
	
	public void limpar() {
		usuario = null;
	}
	
	public void editar(Usuario usu) {
		setUsuario(new Usuario());
		getUsuario().setNome(usu.getNome());
		getUsuario().setLogin(usu.getLogin());
		getUsuario().setSenha(usu.getSenha());
	
	}
	
	public List<Usuario> getListaUsuario() {
		if (listaUsuario == null) 
			listaUsuario = new ArrayList<Usuario>();
		return listaUsuario;
	}

	public Usuario getUsuario() {
		if (usuario == null)
			usuario = new Usuario();
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
