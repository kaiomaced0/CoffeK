package br.unitins.topicos1.lanch.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.unitins.topicos1.lanch.model.ModeloEmpresa;
import br.unitins.topicos1.lanch.model.Usuario;


public class Repository <T> {

	protected EntityManager entityManager = null;
	
	protected EntityManager getEntityManager() {
		if(entityManager == null) {
			EntityManagerFactory em = Persistence.createEntityManagerFactory("Lanch");
			entityManager = em.createEntityManager();
		}
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void salvar(T entidade) {
		getEntityManager().getTransaction().begin(); 
		getEntityManager().merge(entidade);
		getEntityManager().getTransaction().commit();
	}
	
	public void deletar(T obj) {
		if (obj != null) {
			getEntityManager().getTransaction().begin();
			getEntityManager().remove(getEntityManager().merge(obj));
			getEntityManager().getTransaction().commit();
		}
	}

//	public T buscarPeloId(T obj) {
//		return getEntityManager().merge(obj);
//	}
}
