package br.unitins.topicos1.lanch.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.topicos1.application.Util;
import br.unitins.topicos1.lanch.model.Usuario;
import br.unitins.topicos1.lanch.repository.UsuarioRepository;

@Named
@ViewScoped
public class UsuariosController implements Serializable {

	private static final long serialVersionUID = 53956904538222886L;
	
	public UsuariosController() {
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		Util.addInfoMessage((String)flash.get("mensagem"));
	}
	
	private List<Usuario> listaUsuario;

	public List<Usuario> getListaUsuario() {
		if (listaUsuario == null) {
			UsuarioRepository repo = new UsuarioRepository();
			listaUsuario = repo.buscarTodos();
			if (listaUsuario == null)
				listaUsuario = new ArrayList<Usuario>();
		}
		return listaUsuario;
	}
	
	public String adicionar() {
		return "formusuario.xhtml?faces-redirect=true";
	}
	
	public String editar(Usuario usuario) {
		// flash scoped
		Flash flash = FacesContext.
						getCurrentInstance().
						getExternalContext().getFlash();
		
		flash.put("flashUsuario", usuario);
		
		return "formusuario.xhtml?faces-redirect=true";
	}
	
	public void excluir(Usuario usuario) {
		
	}

}
