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
		String sql="SELECT cmr FROM CourseMissionRol cmr, Rol r, CourseMission cm, Mission m, Course c WHERE"
				+"cmr.courseMission.idCourseMission = cm.idCourseMission AND " 
				+"cmr.rol.idRol = r.idRol AND " 
				+"cm.course.idCourse = c.idCourse AND "
				+"cm.mission.idMission = m.idMission";
		return sessionFactory.getCurrentSession().createQuery(sql).getResultList();
	}

}
