package com.ipartek.formacion.uf2215.repositorios;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.ipartek.formacion.uf2215.entidades.Cliente;

public class ClienteRepositorioHibernate implements ClienteRepositorio {
	private SessionFactory sessionFactory;

	public ClienteRepositorioHibernate() {
		// A SessionFactory is set up once for an application!
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure() // configures settings
																									// from
																									// hibernate.cfg.xml
				.build();
		sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		// The registry would be destroyed by the SessionFactory, but we had trouble
		// building the SessionFactory
		// so destroy it manually.
		// StandardServiceRegistryBuilder.destroy( registry );
	}

//	private void cerrarFactory() throws Exception {
//		if ( sessionFactory != null ) {
//			sessionFactory.close();
//		}
//	}

	@Override
	public Iterable<Cliente> getObjetos() {
		Session session = abrirSesion();

		@SuppressWarnings("unchecked")
		List<Cliente> clientes = (List<Cliente>) session.createQuery("from Cliente").list();

		cerrarSesion(session);

		return clientes;
	}

	private void cerrarSesion(Session session) {
		session.getTransaction().commit();
		session.close();
	}

	private Session abrirSesion() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		return session;
	}

	@Override
	public Cliente getObjeto(long id) {
		Session session = abrirSesion();

		Cliente cliente = session.find(Cliente.class, id);

		cerrarSesion(session);

		return cliente;
	}

	@Override
	public Cliente postObjeto(Cliente cliente) {
		Session session = abrirSesion();

		session.save(cliente);

		cerrarSesion(session);

		return cliente;
	}

	@Override
	public Cliente putObjeto(Cliente cliente) {
		Session session = abrirSesion();

		session.merge(cliente);

		cerrarSesion(session);

		return cliente;
	}

	@Override
	public void deleteObjeto(long id) {
		Session session = abrirSesion();

		session.delete(session.find(Cliente.class, id));

		cerrarSesion(session);
	}

}
