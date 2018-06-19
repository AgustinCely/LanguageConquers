package co.edu.usbcali.backend.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.backend.modelo.StudentMission;

@Scope("singleton")
@Repository("studentMissionDAO")
public class StudentMissionDAO implements IStudentMissionDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void crearStudentMission(StudentMission entity) {
		sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public void modificarStudentMission(StudentMission entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public void eliminarStudentMission(StudentMission entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

	@Override
	public StudentMission consultarPorIdStudentMission(Integer id) {
		return sessionFactory.getCurrentSession().get(StudentMission.class, id);
	}

	@Override
	public List<StudentMission> consultarTodosLosStudentMission() {
		String sql="SELECT sm FROM StudentMission sm";
		return sessionFactory.getCurrentSession().createQuery(sql).getResultList();
	}

	
	
}
