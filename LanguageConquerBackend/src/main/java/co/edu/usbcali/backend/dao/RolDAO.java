package co.edu.usbcali.backend.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.backend.modelo.Rol;

@Scope("singleton")
@Repository("rolDAO")
public class RolDAO implements IRolDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void crearRol(Rol entity) {
		sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public void modificarRol(Rol entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public void eliminarRol(Rol entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

	@Override
	public Rol consultarPorIdRol(Integer id) {
		return sessionFactory.getCurrentSession().get(Rol.class, id);
	}

	@Override
	public List<Rol> consultarTodosLosRol() {
		String sql ="SELECT ro FROM Rol ro";
		return sessionFactory.getCurrentSession().createQuery(sql).getResultList();
	}

	
	
}
