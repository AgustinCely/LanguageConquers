package co.edu.usbcali.backend.logica;

import static org.hamcrest.CoreMatchers.theInstance;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.backend.dao.CourseMissionRolStudentDAO;
import co.edu.usbcali.backend.modelo.CourseMissionRolStudent;
import co.edu.usbcali.backend.modelo.Mission;
import co.edu.usbcali.backend.modelo.RolStudent;

@Scope("singleton")
@Service("courseMissionRolStudentLogica")
public class CourseMissionRolStudentLogica implements ICourseMissionRolStudentLogica{

	@Autowired
	private IMissionLogica missionLogica;
	
	@Autowired
	private IRolStudentLogica rolStudentLogica;
	
	@Autowired
	private CourseMissionRolStudentDAO courseMissionRolStudentDAO;
	
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void crearCourseMissionRolStudent(CourseMissionRolStudent entity) throws Exception {
		if(entity == null) {
			throw new Exception("El courseMissionRolStudent es nulo");
		}
		
		Mission mission = missionLogica.consultarPorId(entity.getMission().getIdMission());
		if(mission == null) {
			throw new Exception("La mission es nulo");
		}
		
		RolStudent rolStudent = rolStudentLogica.consultarPorIdRolStudent(entity.getRolStudent().getIdRolStudent());
		if(rolStudent == null) {
			throw new Exception("El rolstudent es nulo");
		}
		if(entity.getScoreRolStudent()==0) {
			throw new Exception("el puntaje por rol debe ser mayor que cero");
		}
		
		courseMissionRolStudentDAO.crearCourseMissionRolStudent(entity);
	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void modificarCourseMissionRolStudent(CourseMissionRolStudent entity) throws Exception {
		if(entity == null) {
			throw new Exception("El courseMissionRolStudent es nulo");
		}
		
		Mission mission = missionLogica.consultarPorId(entity.getMission().getIdMission());
		if(mission == null) {
			throw new Exception("La mission es nulo");
		}
		
		RolStudent rolStudent = rolStudentLogica.consultarPorIdRolStudent(entity.getRolStudent().getIdRolStudent());
		if(rolStudent == null) {
			throw new Exception("El rolstudent es nulo");
		}
		if(entity.getScoreRolStudent()==0) {
			throw new Exception("el puntaje por rol debe ser mayor que cero");
		}
		
		courseMissionRolStudentDAO.modificarCourseMissionRolStudent(entity);
	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void eliminarCourseMissionRolStudent(CourseMissionRolStudent entity) throws Exception {
		if(entity == null) {
			throw new Exception("El courseMissionRolStudent es nulo");
		}
		if(entity.getIdCouseMissionRolStudent()==0) {
			throw new Exception("El id es nulo");
		}
		
		courseMissionRolStudentDAO.eliminarCourseMissionRolStudent(entity);
	}

	@Override
	@Transactional(readOnly=true)
	public CourseMissionRolStudent consultarPorIdCourseMissionRolStudent(Integer id) throws Exception {
		if(id ==0) {
			throw new Exception("El id es nulo");
		}
		return courseMissionRolStudentDAO.consultarPorIdCourseMissionRolStudent(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<CourseMissionRolStudent> consultarTodosLosCourseMissionRolStudent() throws Exception {
		return courseMissionRolStudentDAO.consultarTodosLosCourseMissionRolStudent();
	}

}
