package co.edu.usbcali.backend.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.backend.modelo.Course;

@Scope("singleton")
@Repository("courseDAO")
public class CourseDAO implements ICourseDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void crearCourse(Course entity) {
		sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public void modificarCourse(Course entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public void eliminarCourse(Course entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

	@Override
	public Course consultarPorIdCourse(Integer id) {
		return sessionFactory.getCurrentSession().get(Course.class, id);
	}

	@Override
	public List<Course> consultarTodosLosCourse() {
		String sql="SELECT c FROM Course c";
		return sessionFactory.getCurrentSession().createQuery(sql).getResultList();
	}

	
	
}
