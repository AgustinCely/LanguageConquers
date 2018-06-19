package co.edu.usbcali.backend.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.backend.modelo.CourseMissionRolStudent;

@Scope("singleton")
@Repository("courseMissionRolStudentDAO")
public class CourseMissionRolStudentDAO implements ICourseMissionRolStudentDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void crearCourseMissionRolStudent(CourseMissionRolStudent entity) {
		sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public void modificarCourseMissionRolStudent(CourseMissionRolStudent entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public void eliminarCourseMissionRolStudent(CourseMissionRolStudent entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

	@Override
	public CourseMissionRolStudent consultarPorIdCourseMissionRolStudent(Integer id) {
		return sessionFactory.getCurrentSession().get(CourseMissionRolStudent.class, id);
	}

	@Override
	public List<CourseMissionRolStudent> consultarTodosLosCourseMissionRolStudent() {
		String sql="SELECT cmrs FROM CourseMissionRolStudent cmrs";
		return sessionFactory.getCurrentSession().createQuery(sql).getResultList();
	}

	
	
}
