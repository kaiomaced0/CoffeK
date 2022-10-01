package br.unitins.topicos1.lanch.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.unitins.topicos1.lanch.model.ModeloEmpresa;

public class ModeloEmpresaRepository {
	
	private EntityManager entityManager = null;
	
	public ModeloEmpresa buscarPeloId(Integer id) {
		return getEntityManager().find(ModeloEmpresa.class, id);
	}
	
	public List<ModeloEmpresa> buscarTodos() {
		Query query = getEntityManager().createQuery("SELECT e FROM ModeloEmpresa e ORDER BY e.nome");
		return query.getResultList();
	}

	public EntityManager getEntityManager() {
		if(entityManager == null) {
			EntityManagerFactory em = Persistence.createEntityManagerFactory("Lanch");
			entityManager = em.createEntityManager();
		}
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void Salvar(ModeloEmpresa modeloEmpresa) {
		getEntityManager().getTransaction().begin();
		getEntityManager().merge(modeloEmpresa);
		getEntityManager().getTransaction().commit();
	}
	
	public void deletar(int id) {
		ModeloEmpresa modeloEstado = getEntityManager().find(ModeloEmpresa.class, id);
		if (modeloEstado != null) {
			getEntityManager().getTransaction().begin();
			getEntityManager().remove(modeloEstado);
			getEntityManager().getTransaction().commit();
		}

	}
		
	}

