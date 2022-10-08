package br.unitins.kaio.application;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public class Util {
	public static void addErrorMessage(String erro) {
		addMessage(erro, FacesMessage.SEVERITY_ERROR);				
	}
	
	public static void addInfoMessage(String erro) {
		addMessage(erro, FacesMessage.SEVERITY_INFO);
					
	}
	public static void addWarnMessage(String erro) {
		addMessage(erro, FacesMessage.SEVERITY_WARN);
	}
	private static void addMessage(String erro, Severity severity) {
		FacesMessage message = new FacesMessage(
				severity, erro, null);
		FacesContext.getCurrentInstance().addMessage(erro, message);
	}

}
