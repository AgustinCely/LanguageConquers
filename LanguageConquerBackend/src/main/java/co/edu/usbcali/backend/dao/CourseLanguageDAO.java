package co.edu.usbcali.backend.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.backend.modelo.CourseLanguage;

@Scope("singleton")
@Repository("courseLanguageDAO")
public class CourseLanguageDAO implements ICourseLanguageDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void crearCourseLanguage(CourseLanguage entity) {
		sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public void modificarCourseLanguage(CourseLanguage entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public void eliminarCourseLanguage(CourseLanguage entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

	@Override
	public CourseLanguage consultarPorIdCourseLanguage(Integer id) {
		return sessionFactory.getCurrentSession().get(CourseLanguage.class, id);
	}

	@Override
	public List<CourseLanguage> consultarTodosLosCourseLanguage() {
		String sql="SELECT cl FROM CourseLanguage cl";
		return sessionFactory.getCurrentSession().createQuery(sql).getResultList();
	}
	
	
	
}
