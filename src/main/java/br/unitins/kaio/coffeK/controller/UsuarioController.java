package br.unitins.kaio.coffeK.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
//import javax.enterprise.context.ApplicationScoped;
//import javax.enterprise.context.RequestScoped;
//import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.kaio.hash.HashUtils;
import br.unitins.kaio.coffeK.model.Usuario;
import br.unitins.kaio.coffeK.repository.UsuarioRepository;

@Named
@ViewScoped
public class UsuarioController implements Serializable {
	
	private static final long serialVersionUID = 1585061149808264456L;
	
	private Usuario usuario = null;
	private List<Usuario> listaUsuario;
	
	public void validarLogin() {
		if(getUsuario().getLogin().equals("teste22")) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Login ja existe", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		
	}
	
	public void incluir() {
		UsuarioRepository repo = new UsuarioRepository();
		getUsuario().setSenha(HashUtils.getHashMd5(getUsuario().getSenha()));
		repo.salvar(getUsuario());
		limpar();
		// foi setado como nulo para buscar no banco
		listaUsuario = null;
	}
	
	public void alterar() {
		UsuarioRepository repo = new UsuarioRepository();
		getUsuario().setSenha(HashUtils.getHashMd5(getUsuario().getSenha()));
		repo.salvar(getUsuario());
		limpar();
		// foi setado como nulo para buscar no banco
		listaUsuario = null;
	}
	
	// acionado pelo botao excluir
	public void excluir() {
		excluir(getUsuario());
		limpar();	
	}
	
	// acionado pelo botao da tabela (excluir)
	public void excluir(Usuario usu) {
		UsuarioRepository repo = new UsuarioRepository();
		repo.deletar(usu);
		listaUsuario = null;
	}
	
	public void limpar() {
		usuario = null;
	}
	
	public void editar(Usuario usu) {
		setUsuario(usu);
		
//		setUsuario(usu.getClone());
		
//		setUsuario(new Usuario());
//		getUsuario().setId(usu.getId());
//		getUsuario().setNome(usu.getNome());
//		getUsuario().setLogin(usu.getLogin());
//		getUsuario().setSenha(usu.getSenha());
	}
	
	public List<Usuario> getListaUsuario() {
		if (listaUsuario == null) {
			UsuarioRepository repo = new UsuarioRepository();
			listaUsuario = repo.buscarTodos();
			if (listaUsuario == null)
				listaUsuario = new ArrayList<Usuario>();
		}
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
