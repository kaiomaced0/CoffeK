package br.unitins.topicos1.farmacia.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.unitins.topicos1.farmacia.model.Usuario;

public class UsuarioRepository {

	private EntityManager entityManager = null;

	private EntityManager getEntityManager() {
		if (entityManager == null) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("Farmacia");
			entityManager = emf.createEntityManager();
		}
		return entityManager;
	}

	public List<Usuario> buscarTodos() {
		Query query = getEntityManager().createQuery("SELECT u FROM Usuario u");
		return query.getResultList();
	}

	public void salvar(Usuario usuario) {
		getEntityManager().getTransaction().begin();
		getEntityManager().merge(usuario);
		getEntityManager().getTransaction().commit();
	}

	public void deletar(int id) {
		Usuario usuario = getEntityManager().find(Usuario.class, id);
		if (usuario != null) {
			getEntityManager().getTransaction().begin();
			getEntityManager().remove(usuario);
			getEntityManager().getTransaction().commit();
		}

	}

}
