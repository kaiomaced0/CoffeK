package br.unitins.kaio.coffeK.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.unitins.kaio.lanch.model.ModeloEmpresa;
import br.unitins.kaio.lanch.model.Usuario;


public class Repository <T> {

	protected EntityManager entityManager = null;
	
	protected EntityManager getEntityManager() {
		if(entityManager == null) {
			EntityManagerFactory em = Persistence.createEntityManagerFactory("CoffeK");
			entityManager = em.createEntityManager();
		}
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void salvar(T obj) {
		getEntityManager().getTransaction().begin(); 
		getEntityManager().merge(obj);
		getEntityManager().getTransaction().commit();
	}
	
	public void deletar(T obj) {
		if (obj != null) {
			getEntityManager().getTransaction().begin();
			getEntityManager().remove(getEntityManager().merge(obj));
			getEntityManager().getTransaction().commit();
		}
	}
}
