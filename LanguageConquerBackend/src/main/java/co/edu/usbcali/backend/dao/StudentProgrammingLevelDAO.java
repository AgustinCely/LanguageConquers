package co.edu.usbcali.backend.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.backend.modelo.StudentProgrammingLevel;

@Scope("singleton")
@Repository("studentProgrammingLevelDAO")
public class StudentProgrammingLevelDAO implements IStudentProgrammingLevelDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void crearStudentProgrammingLevel(StudentProgrammingLevel entity) {
		sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public void modificarStudentProgrammingLevel(StudentProgrammingLevel entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public void eliminarStudentProgrammingLevel(StudentProgrammingLevel entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

	@Override
	public StudentProgrammingLevel consultarPorIdStudentProgrammingLevel(Integer id) {
		return sessionFactory.getCurrentSession().get(StudentProgrammingLevel.class, id);
	}

	@Override
	public List<StudentProgrammingLevel> consultarTodosLosStudentProgrammingLevel() {
		String sql ="SELECT spl FROM StudentProgrammingLevel spl";
		return sessionFactory.getCurrentSession().createQuery(sql).getResultList();
	}

	
	
}
