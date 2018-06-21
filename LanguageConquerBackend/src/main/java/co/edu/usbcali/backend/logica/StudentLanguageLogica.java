package co.edu.usbcali.backend.logica;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.backend.dao.IStudentLanguageDAO;
import co.edu.usbcali.backend.modelo.Language;
import co.edu.usbcali.backend.modelo.Student;
import co.edu.usbcali.backend.modelo.StudentLanguage;


@Scope("singleton")
@Service("studentLanguageLogica")
public class StudentLanguageLogica implements IStudentLanguageLogica{
	
	@Autowired
	private ILanguageLogica languageLogica;
	
	@Autowired
	private IStudenLogica studentLogica;
	
	@Autowired
	private IStudentLanguageDAO studentLanguageDAO;
	
	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void crearStudentLanguage(StudentLanguage entity) throws Exception {
		if(entity == null) {
			throw new Exception("El studentLanguage es nulo");
		}
		Language language = languageLogica.consultarPorIdLanguage(entity.getLanguage().getIdLanguage());
		if(language == null) {
			throw new Exception("El language es nulo");
		}
		Student student = studentLogica.consultarPorIdStudent(entity.getStudent().getIdStudent());
		if(student == null) {
			throw new Exception("El student es nulo");
		}
		
		studentLanguageDAO.crearStudentLanguage(entity);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void modificarStudentLanguage(StudentLanguage entity) throws Exception {
		if(entity == null) {
			throw new Exception("El studentLanguage es nulo");
		}
		Language language = languageLogica.consultarPorIdLanguage(entity.getLanguage().getIdLanguage());
		if(language == null) {
			throw new Exception("El language es nulo");
		}
		Student student = studentLogica.consultarPorIdStudent(entity.getStudent().getIdStudent());
		if(student == null) {
			throw new Exception("El student es nulo");
		}
		
		studentLanguageDAO.modificarStudentLanguage(entity);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void eliminarStudentLanguage(StudentLanguage entity) throws Exception {
		if(entity == null) {
			throw new Exception("El studentLanguage es nulo");
		}
		if(entity.getIdStudentLanguage()==0) {
			throw new Exception("El id es nulo");
		}
		
		studentLanguageDAO.eliminarStudentLanguage(entity);
	}

	@Override
	@Transactional(readOnly=true)
	public StudentLanguage consultarPorIdStudentLanguage(Integer id) throws Exception {
		if(id == 0) {
			throw new Exception("El id es nulo");
		}
		return studentLanguageDAO.consultarPorIdStudentLanguage(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<StudentLanguage> consultarTodosLosStudentLanguage() throws Exception {
		return studentLanguageDAO.consultarTodosLosStudentLanguage();
	}

	
}
