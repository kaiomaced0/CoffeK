package br.unitins.topicos1.lanch.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
//import javax.enterprise.context.ApplicationScoped;
//import javax.enterprise.context.RequestScoped;
//import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
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
public class FormUsuarioController implements Serializable {

	static final long serialVersionUID = 7733433682235261562L;
	private Usuario usuario = null;
	private List<ModeloEmpresa> listaModeloEmpresa;
	
	public List<ModeloEmpresa> getListaModeloEmpresa() {
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
	
	public FormUsuarioController() {
		//Usuario sendo retornado do Flash Scoped
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flash.keep("flashUsuario");
		setUsuario((Usuario)flash.get("flashUsuario"));
	}
	
	public String cancelar() {
		return "usuarios.xhtml?faces-redirect=true";
		
	}
	
	public String salvar() {
		UsuarioRepository repo = new UsuarioRepository();
		
		repo.salvar(getUsuario());
		// o cancelar retorna para a pagina anterior
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flash.put("mensagem", "Usuario salvo com sucesso");
		return cancelar();
	}
	
	public Usuario getUsuario() {
		if (usuario == null)
			usuario = new Usuario();
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setListaModeloEmpresa(List<ModeloEmpresa> listaModeloEmpresa) {
		this.listaModeloEmpresa = listaModeloEmpresa;
	}

}
