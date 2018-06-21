package co.edu.usbcali.backend.logica;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.backend.dao.IStudentProgrammingLevelDAO;
import co.edu.usbcali.backend.modelo.ProgrammingLevel;
import co.edu.usbcali.backend.modelo.Student;
import co.edu.usbcali.backend.modelo.StudentProgrammingLevel;


@Scope("singleton")
@Service("studentProgrammingLevelLogica")
public class StudentProgrammingLevelLogica implements IStudentProgrammingLevelLogica{

	@Autowired
	private IProgrammingLevelLogica programmingLevelLogica;
	
	@Autowired
	private IStudenLogica studentLogica;
	
	@Autowired
	private IStudentProgrammingLevelDAO studentProgrammingLevelDAO;
	
	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void crearStudentProgrammingLevel(StudentProgrammingLevel entity) throws Exception {
		if(entity == null) {
			throw new Exception("El StudentProgrammingLevel es nulo");
		}
		Student student = studentLogica.consultarPorIdStudent(entity.getStudent().getIdStudent());
		if(student == null) {
			throw new Exception("El Student es nulo");
		}
		ProgrammingLevel programmingLevel = programmingLevelLogica.consultarPorIdProgrammingLevel(entity.getProgrammingLevel().getIdProgrammingLevel());
		if(programmingLevel == null) {
			throw new Exception("El ProgrammingLevel es nulo");
		}
		
		studentProgrammingLevelDAO.crearStudentProgrammingLevel(entity);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void modificarStudentProgrammingLevel(StudentProgrammingLevel entity) throws Exception {
		if(entity == null) {
			throw new Exception("El StudentProgrammingLevel es nulo");
		}
		Student student = studentLogica.consultarPorIdStudent(entity.getStudent().getIdStudent());
		if(student == null) {
			throw new Exception("El Student es nulo");
		}
		ProgrammingLevel programmingLevel = programmingLevelLogica.consultarPorIdProgrammingLevel(entity.getProgrammingLevel().getIdProgrammingLevel());
		if(programmingLevel == null) {
			throw new Exception("El ProgrammingLevel es nulo");
		}
		
		studentProgrammingLevelDAO.modificarStudentProgrammingLevel(entity);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void eliminarStudentProgrammingLevel(StudentProgrammingLevel entity) throws Exception {
		if(entity == null) {
			throw new Exception("El StudentProgrammingLevel es nulo");
		}
		if(entity.getIdStudentProgrammingLevel()== 0) {
			throw new Exception("El id es nulo");
		}
		
		studentProgrammingLevelDAO.eliminarStudentProgrammingLevel(entity);
	}

	@Override
	@Transactional(readOnly=true)
	public StudentProgrammingLevel consultarPorIdStudentProgrammingLevel(Integer id) throws Exception {
		if(id ==0) {
			throw new Exception("El id es nulo");
		}
		return studentProgrammingLevelDAO.consultarPorIdStudentProgrammingLevel(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<StudentProgrammingLevel> consultarTodoLosStudentProgrammingLevel() throws Exception {
		return studentProgrammingLevelDAO.consultarTodosLosStudentProgrammingLevel();
	}
	
	
	
}
