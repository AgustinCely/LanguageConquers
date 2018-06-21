package co.edu.usbcali.backend.logica;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.backend.dao.IStudentMissionDAO;
import co.edu.usbcali.backend.modelo.Mission;
import co.edu.usbcali.backend.modelo.Student;
import co.edu.usbcali.backend.modelo.StudentMission;


@Scope("singleton")
@Service("studentMissionLogica")
public class StudentMissionLogica implements IStudentMissionLogica{

	@Autowired
	private IMissionLogica missionLogica;
	
	@Autowired
	private IStudenLogica studentLogica;
	
	@Autowired
	private IStudentMissionDAO studentMissionDAO;
	
	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void crearStudentMission(StudentMission entity) throws Exception {
		if(entity == null) {
			throw new Exception("El studentMission es nulo");
		}
		Mission mission = missionLogica.consultarPorId(entity.getMission().getIdMission());
		if(mission == null) {
			throw new Exception("La mission es nulo");
		}
		Student student = studentLogica.consultarPorIdStudent(entity.getStudent().getIdStudent());
		if(student == null) {
			throw new Exception("El student es nulo");
		}
		
		studentMissionDAO.crearStudentMission(entity);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void modificarStudentMission(StudentMission entity) throws Exception {
		if(entity == null) {
			throw new Exception("El studentMission es nulo");
		}
		Mission mission = missionLogica.consultarPorId(entity.getMission().getIdMission());
		if(mission == null) {
			throw new Exception("La mission es nulo");
		}
		Student student = studentLogica.consultarPorIdStudent(entity.getStudent().getIdStudent());
		if(student == null) {
			throw new Exception("El student es nulo");
		}
		
		studentMissionDAO.modificarStudentMission(entity);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void eliminarStudentMission(StudentMission entity) throws Exception {
		if(entity == null) {
			throw new Exception("El studentMission es nulo");
		}
		if(entity.getIdStudentMission()==0) {
			throw new Exception("El id es nulo");
		}
		
		studentMissionDAO.eliminarStudentMission(entity);
	}

	@Override
	@Transactional(readOnly=true)
	public StudentMission consultarPorIdStudentMission(Integer id) throws Exception {
		if(id ==0) {
			throw new Exception("El id es nulo");
		}
		return studentMissionDAO.consultarPorIdStudentMission(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<StudentMission> consultarTodoLosStudentMission() throws Exception {
		return studentMissionDAO.consultarTodosLosStudentMission();
	}

	
	
}
