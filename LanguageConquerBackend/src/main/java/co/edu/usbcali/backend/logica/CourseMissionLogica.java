package co.edu.usbcali.backend.logica;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.backend.dao.ICourseMissionDAO;
import co.edu.usbcali.backend.modelo.Course;
import co.edu.usbcali.backend.modelo.CourseMission;
import co.edu.usbcali.backend.modelo.Mission;
import co.edu.usbcali.backend.modelo.Note;


@Scope("singleton")
@Service("courseMissionLogica")
public class CourseMissionLogica implements ICourseMissionLogica{

	@Autowired
	private ICourseMissionDAO courseMissionDAO;
	
	@Autowired
	private ICourseLogica courseLogica;
	
	@Autowired
	private IMissionLogica missionLogica;
	
	@Autowired
	private INoteLogica noteLogica;
	
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void crearCourseMission(CourseMission entity) throws Exception {
		if(entity == null) {
			throw new Exception("El courseMission es nulo");
		}
		Course course = courseLogica.consultarPorId(entity.getCourse().getIdCourse());
		if(course == null) {
			throw new Exception("El course es nulo");
		}
		Mission mission = missionLogica.consultarPorId(entity.getMission().getIdMission());
		if(mission == null) {
			throw new Exception("La mission es nulo");
		}
		Note note = noteLogica.consultarPorIdNote(entity.getNote().getIdNote());
		if(note == null) {
			throw new Exception("La note es nulo");
		}
		
		courseMissionDAO.crearCourseMission(entity);
	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void modificarCourseMission(CourseMission entity) throws Exception {
		if(entity == null) {
			throw new Exception("El courseMission es nulo");
		}
		Course course = courseLogica.consultarPorId(entity.getCourse().getIdCourse());
		if(course == null) {
			throw new Exception("El course es nulo");
		}
		Mission mission = missionLogica.consultarPorId(entity.getMission().getIdMission());
		if(mission == null) {
			throw new Exception("La mission es nulo");
		}
		Note note = noteLogica.consultarPorIdNote(entity.getNote().getIdNote());
		if(note == null) {
			throw new Exception("La note es nulo");
		}
		
		courseMissionDAO.modificarCourseMission(entity);
	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void eliminarCourseMission(CourseMission entity) throws Exception {
		if(entity == null) {
			throw new Exception("El courseMission es nulo");
		}
		if(entity.getIdCourseMission()==0) {
			throw new Exception("El id es nulo");
		}
		
		courseMissionDAO.eliminarCourseMission(entity);
	}

	@Override
	@Transactional(readOnly=true)
	public CourseMission consultarPorIdCourseMission(Integer id) throws Exception {
		if(id == 0) {
			throw new Exception("El id es nulo");
		}
		return courseMissionDAO.consultarPorIdCourseMission(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<CourseMission> consultarTodosLosCourseMission() throws Exception {
		return courseMissionDAO.consultarTodosLosCourseMission();
	}

	
}
