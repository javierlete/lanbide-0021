package com.ipartek.formacion.uf2215.repositorios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ipartek.formacion.uf2215.entidades.Cliente;

public class ClienteRepositorioJpa implements ClienteRepositorio {
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory( "com.ipartek.formacion.uf2215.entidades");
	
//	protected void tearDown() throws Exception {
//		entityManagerFactory.close();
//	}
	
	@Override
	public Iterable<Cliente> getObjetos() {
		EntityManager em = abrirSesion();

		@SuppressWarnings("unchecked")
		List<Cliente> clientes = (List<Cliente>) em.createQuery("from Cliente").getResultList();

		cerrarSesion(em);

		return clientes;
	}

	private void cerrarSesion(EntityManager entityManager) {
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	private EntityManager abrirSesion() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		return entityManager;
	}

	@Override
	public Cliente getObjeto(long id) {
		EntityManager em = abrirSesion();

		Cliente cliente = em.find(Cliente.class, id);

		cerrarSesion(em);

		return cliente;
	}

	@Override
	public Cliente postObjeto(Cliente cliente) {
		EntityManager em = abrirSesion();

		em.persist(cliente);

		cerrarSesion(em);

		return cliente;
	}

	@Override
	public Cliente putObjeto(Cliente cliente) {
		EntityManager em = abrirSesion();

		em.merge(cliente);

		cerrarSesion(em);

		return cliente;
	}

	@Override
	public void deleteObjeto(long id) {
		EntityManager em = abrirSesion();

		em.remove(em.find(Cliente.class, id));

		cerrarSesion(em);
	}

}
