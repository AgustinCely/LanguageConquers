package co.edu.usbcali.backend.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.backend.modelo.CourseMissionStudent;

@Scope("singleton")
@Repository("courseMissionStudentDAO")
public class CourseMissionStudentDAO implements ICourseMissionStudentDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void crearCourseMissionStudent(CourseMissionStudent entity) {
		sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public void modificarCourseMissionStudent(CourseMissionStudent entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public void eliminarCourseMissionStudent(CourseMissionStudent entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

	@Override
	public CourseMissionStudent consultarPorId(Integer id) {
		return sessionFactory.getCurrentSession().get(CourseMissionStudent.class, id);
	}

	@Override
	public List<CourseMissionStudent> consultarTodosLosCourseMissionStudent() {
		String sql="SELECT cms FROM CourseMissionStudent cms";
		return sessionFactory.getCurrentSession().createQuery(sql).getResultList();
	}

	
}
