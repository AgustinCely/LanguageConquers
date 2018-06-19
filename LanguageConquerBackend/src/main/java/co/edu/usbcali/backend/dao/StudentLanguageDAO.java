package co.edu.usbcali.backend.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.backend.modelo.StudentLanguage;

@Scope("singleton")
@Repository("studentLanguageDAO")
public class StudentLanguageDAO implements IStudentLanguageDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void crearStudentLanguage(StudentLanguage entity) {
		sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public void modificarStudentLanguage(StudentLanguage entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public void eliminarStudentLanguage(StudentLanguage entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

	@Override
	public StudentLanguage consultarPorIdStudentLanguage(Integer id) {
		return sessionFactory.getCurrentSession().get(StudentLanguage.class, id);
	}

	@Override
	public List<StudentLanguage> consultarTodosLosStudentLanguage() {
		String sql="SELECT sl FROM StudentLanguage sl";
		return sessionFactory.getCurrentSession().createQuery(sql).getResultList();
	}

	
	
}
