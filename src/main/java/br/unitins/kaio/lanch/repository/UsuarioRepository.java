package br.unitins.kaio.lanch.repository;

import java.util.List;

import javax.persistence.Query;

import br.unitins.kaio.lanch.model.Usuario;

public class UsuarioRepository extends Repository<Usuario>{

	public List<Usuario> buscarTodos() {
		Query query = getEntityManager().createQuery("SELECT e FROM Usuario");
		return query.getResultList(); 
	}
	//salvar e Deletar estão no Repository

	}
