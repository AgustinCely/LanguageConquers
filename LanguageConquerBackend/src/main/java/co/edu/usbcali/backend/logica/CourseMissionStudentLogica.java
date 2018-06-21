package co.edu.usbcali.backend.logica;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.backend.dao.ICourseMissionStudentDAO;
import co.edu.usbcali.backend.modelo.CourseMission;
import co.edu.usbcali.backend.modelo.CourseMissionStudent;
import co.edu.usbcali.backend.modelo.MissionState;
import co.edu.usbcali.backend.modelo.Student;


@Scope("singleton")
@Service("courseMissionStudentLogica")
public class CourseMissionStudentLogica implements ICourseMissionStudentLogica{

	@Autowired
	private ICourseMissionLogica courseMissionLogica;
	
	@Autowired
	private IStudenLogica studentLogica;
	
	@Autowired
	private IMissionStateLogica missionStateLogica;
	
	@Autowired
	private ICourseMissionStudentDAO courseMissionStudentDAO;
	
	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void crearCourseMissionStudent(CourseMissionStudent entity) throws Exception {
		if(entity == null) {
			throw new Exception("El courseMissionStudent es nulo");
		}
		Student student = studentLogica.consultarPorIdStudent(entity.getStudent().getIdStudent());
		if(student == null) {
			throw new Exception("El student es nulo");
		}
		MissionState missionState = missionStateLogica.consultarPorIdMissionState(entity.getMissionState().getIdMissionState());
		if(missionState == null) {
			throw new Exception("La missionState es nulo");
		}
		CourseMission courseMission = courseMissionLogica.consultarPorIdCourseMission(entity.getCourseMission().getIdCourseMission());
		if(courseMission == null) {
			throw new Exception("El courseMission es nulo");
		}

		
		courseMissionStudentDAO.crearCourseMissionStudent(entity);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void modificarCourseMissionStudent(CourseMissionStudent entity) throws Exception {
		if(entity == null) {
			throw new Exception("El courseMissionStudent es nulo");
		}
		Student student = studentLogica.consultarPorIdStudent(entity.getStudent().getIdStudent());
		if(student == null) {
			throw new Exception("El student es nulo");
		}
		MissionState missionState = missionStateLogica.consultarPorIdMissionState(entity.getMissionState().getIdMissionState());
		if(missionState == null) {
			throw new Exception("La missionState es nulo");
		}
		CourseMission courseMission = courseMissionLogica.consultarPorIdCourseMission(entity.getCourseMission().getIdCourseMission());
		if(courseMission == null) {
			throw new Exception("El courseMission es nulo");
		}
		if(entity.getScoreStudent() == 0) {
			throw new Exception("El puntaje del estudiante debe ser mayor de cero");
		}
		
		courseMissionStudentDAO.modificarCourseMissionStudent(entity);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void eliminarCourseMissionStudent(CourseMissionStudent entity) throws Exception {
		if(entity == null) {
			throw new Exception("El courseMissionStudent es nulo");
		}
		if(entity.getIdCourseMissionStudent() ==0) {
			throw new Exception("El id es nulo");
		}
		
		courseMissionStudentDAO.eliminarCourseMissionStudent(entity);
	}

	@Override
	@Transactional(readOnly=true)
	public CourseMissionStudent consultarPorIdCourseMissionStudent(Integer id) throws Exception {
		if(id == 0) {
			throw new Exception("El id es nulo");
		}
		return courseMissionStudentDAO.consultarPorId(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<CourseMissionStudent> consultarTodosLosCourseMissionStudent() throws Exception {
		return courseMissionStudentDAO.consultarTodosLosCourseMissionStudent();
	}

	
	
}
