package br.unitins.topicos1.farmacia.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.topicos1.farmacia.model.Usuario;

@Named
@ApplicationScoped
public class UsuarioController implements Serializable {
	

	private static final long serialVersionUID = 168067236765100328L;
	private Usuario usuario = null;
	private List<Usuario> listaUsuario;
	private int cont = 1;
	
	public void incluir() {
		getUsuario().setId(cont++);
		getListaUsuario().add(getUsuario());
		limpar();
	}
	
	public void alterar() {
		getListaUsuario().
			set(getListaUsuario().
					indexOf(getUsuario()), getUsuario());
		
		
//		// a posicao da lista
//		int index = getListaUsuario().indexOf(getUsuario());
//		// substituindo o usuario da posicao index
//		getListaUsuario().set(index, getUsuario());
		
//		for (int i = 0; i < getListaUsuario().size(); i++) {
//			if (getUsuario().getId()
//					.equals(getListaUsuario().get(i).getId())) {
//				
//				getListaUsuario().set(i, getUsuario());
//			}
//		}
	}
	
	public void excluir() {
//		getListaUsuario().remove(getUsuario());
//		limpar();
		excluir(getUsuario());
		limpar();		
	}
	
	public void excluir(Usuario usu) {
		getListaUsuario().remove(usu);
	}
	
	public void limpar() {
		usuario = null;
	}
	
	public void editar(Usuario usu) {
		setUsuario(usu.getClone());
		
//		setUsuario(new Usuario());
//		getUsuario().setId(usu.getId());
//		getUsuario().setNome(usu.getNome());
//		getUsuario().setLogin(usu.getLogin());
//		getUsuario().setSenha(usu.getSenha());
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
