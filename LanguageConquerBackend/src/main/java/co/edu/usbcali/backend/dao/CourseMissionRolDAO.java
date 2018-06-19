package co.edu.usbcali.backend.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.backend.modelo.CourseMissionRol;

@Scope("singleton")
@Repository("courseMissionRolDAO")
public class CourseMissionRolDAO implements ICourseMissionRolDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void crearCourseMissionRol(CourseMissionRol entity) {
		sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public void modificarCourseMissionRol(CourseMissionRol entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public void eliminarCourseMissionRol(CourseMissionRol entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

	@Override
	public CourseMissionRol consultarPorIdCourseMissionRol(Integer id) {
		return sessionFactory.getCurrentSession().get(CourseMissionRol.class, id);
	}

	@Override
	public List<CourseMissionRol> consultarTodosLosCourseMissionRol() {
		String sql="SELECT cmr FROM CourseMissionRol cmr";
		return sessionFactory.getCurrentSession().createQuery(sql).getResultList();
	}

}
