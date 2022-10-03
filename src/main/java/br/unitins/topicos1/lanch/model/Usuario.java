package br.unitins.topicos1.lanch.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Usuario implements Cloneable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String login;
	@NotBlank(message = "A Senha deve ser informada!")
	private String senha;
	private LocalDate dataNascimento;
	
	private CasasHP casasHP;
	
	@ManyToOne
	@JoinColumn(name = "idModelEmpresa")
	private ModeloEmpresa modeloEmpresa;
	
	
	public ModeloEmpresa getModeloEmpresa() {
		return modeloEmpresa;
	}
	
	public void setModeloEmpresa(ModeloEmpresa modeloEmpresa) {
		this.modeloEmpresa = modeloEmpresa;
	}
	
	public Usuario getClone() {
		try {
			return (Usuario) super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}
	public CasasHP getCasasHP() {
		return casasHP;
	}
	public void setCasasHP(CasasHP casasHP) {
		this.casasHP = casasHP;
	}	
	

}
