package br.unitins.topicos1.lanch.controller;

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

import br.unitins.topicos1.hash.HashUtils;
import br.unitins.topicos1.lanch.model.CasasHP;
import br.unitins.topicos1.lanch.model.ModeloEmpresa;
import br.unitins.topicos1.lanch.model.Usuario;
import br.unitins.topicos1.lanch.repository.ModeloEmpresaRepository;
import br.unitins.topicos1.lanch.repository.UsuarioRepository;

@Named
@ViewScoped
public class UsuarioController implements Serializable {
	

	private static final long serialVersionUID = 168067236765100328L;
	private Usuario usuario = null;
	private List<Usuario> listaUsuario;
	private List<ModeloEmpresa> listaModeloEmpresa;
	
	public List<ModeloEmpresa> getListaEstado() {
		if (listaModeloEmpresa == null) { 
			ModeloEmpresaRepository repo = new ModeloEmpresaRepository();
			listaModeloEmpresa = repo.buscarTodos();
		}
		return listaModeloEmpresa;
	}
	
	public CasasHP[] getListaCasasHP() {
		return CasasHP.values();
	}
	
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
		repo.deletar(usu.getId());
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

	public List<ModeloEmpresa> getListaModeloEmpresa() {
		return listaModeloEmpresa;
	}

	public void setListaModeloEmpresa(List<ModeloEmpresa> listaModeloEmpresa) {
		this.listaModeloEmpresa = listaModeloEmpresa;
	}

}
