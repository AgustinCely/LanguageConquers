package co.edu.usbcali.backend.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.backend.modelo.Student;

@Scope("singleton")
@Repository("studentDAO")
public class StudentDAO implements IStudentDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void crearStudent(Student entity) {
		
		sessionFactory.getCurrentSession().save(entity);
		
	}

	@Override
	public void modificarStudent(Student entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public void borrarStudent(Student entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

	@Override
	public Student consultarPorIdStudent(Integer id) {

		return sessionFactory.getCurrentSession().get(Student.class, id);
	}

	@Override
	public List<Student> consultarTodosLosStudent() {
		String sql="SELECT stu FROM Student stu";
		return sessionFactory.getCurrentSession().createQuery(sql).getResultList();
	}

}
