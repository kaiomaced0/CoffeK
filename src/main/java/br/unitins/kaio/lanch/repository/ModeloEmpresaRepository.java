package br.unitins.kaio.lanch.repository;

import java.util.List;

import javax.persistence.Query;

import br.unitins.kaio.lanch.model.ModeloEmpresa;
import br.unitins.kaio.lanch.model.Usuario;

public class ModeloEmpresaRepository extends Repository<ModeloEmpresa>{
	
	//salvar e deletar estão no Repository
	public ModeloEmpresa buscarPeloId(Integer id) {
		return getEntityManager().find(ModeloEmpresa.class, id);
	}	
	public List<ModeloEmpresa> buscarTodos() {
		Query query = getEntityManager().createQuery("SELECT e FROM ModeloEmpresa");
		return query.getResultList(); 
	}
}

