package co.edu.usbcali.backend.logica;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.backend.dao.IStudentDAO;
import co.edu.usbcali.backend.modelo.Avatar;
import co.edu.usbcali.backend.modelo.Course;
import co.edu.usbcali.backend.modelo.Student;

@Scope("singleton")
@Service("studentLogica")
public class StudentLogica implements IStudenLogica{
	
	@Autowired
	private IStudentDAO studenDAO;
	
	@Autowired
	private ICourseLogica courseLogica;
	
	@Autowired
	private IAvatarLogica avatarLogica;
	

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void crearStudent(Student entity) throws Exception {
		if(entity == null) {
			throw new Exception("El estudiante es nulo");
		}
		if(entity.getNameStudent()== null || entity.getNameStudent().trim().equals("")== true) {
			throw new Exception("El nombre del estudiante es nulo");
		}
		if(entity.getLastnameStudent()== null || entity.getLastnameStudent().trim().equals("")== true) {
			throw new Exception("El apellido del estudiante es nulo");
		}
		if(entity.getNicknameStudent()==null || entity.getNicknameStudent().trim().equals("")==true) {
			throw new Exception("El nickname del estudiante es nulo");
		}
		if(entity.getGenderStudent()==null || entity.getGenderStudent().toString().equals("")== true) {
			throw new Exception("El sexo del estudiante es nulo");
		}
		if(entity.getEmailStudent()==null || entity.getEmailStudent().trim().equals("")== true) {
			throw new Exception("El email del estudiante es nulo");
		}
		if(entity.getSemestreStudent()==0 && entity.getSemestreStudent()<=10) {
			throw new Exception("El semestre del estudiante debe de ser mayor a cero");
		}
		if(entity.getScoreStudent()==0) {
			throw new Exception("El puntaje del estudiante es nulo");
		}
		if(entity.getBirthdateStudent()==null || entity.getBirthdateStudent().toString().equals("")==true) {
			throw new Exception("La fecha de nacimiento del estudiante es nulo");
		}
		
		Avatar avatar = avatarLogica.consultarPorIdAvatar(entity.getAvatar().getIdAvatar());
		if(avatar==null) {
			throw new Exception("El avatar es nulo");
		}
		
		Course course = courseLogica.consultarPorId(entity.getCourse().getIdCourse());
		if(course==null) {
			throw new Exception("El course es nulo");
		}
		
		studenDAO.crearStudent(entity);
		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void modificarStudent(Student entity) throws Exception {
		if(entity == null) {
			throw new Exception("El estudiante es nulo");
		}
		if(entity.getNameStudent()== null || entity.getNameStudent().trim().equals("")== true) {
			throw new Exception("El nombre del estudiante es nulo");
		}
		if(entity.getLastnameStudent()== null || entity.getLastnameStudent().trim().equals("")== true) {
			throw new Exception("El apellido del estudiante es nulo");
		}
		if(entity.getNicknameStudent()==null || entity.getNicknameStudent().trim().equals("")==true) {
			throw new Exception("El nickname del estudiante es nulo");
		}
		if(entity.getGenderStudent()==null || entity.getGenderStudent().toString().equals("")== true) {
			throw new Exception("El sexo del estudiante es nulo");
		}
		if(entity.getEmailStudent()==null || entity.getEmailStudent().trim().equals("")== true) {
			throw new Exception("El email del estudiante es nulo");
		}
		if(entity.getSemestreStudent()==0 && entity.getSemestreStudent()<=10) {
			throw new Exception("El semestre del estudiante debe de ser mayor a cero");
		}
		if(entity.getScoreStudent()==0) {
			throw new Exception("El puntaje del estudiante es nulo");
		}
		if(entity.getBirthdateStudent()==null || entity.getBirthdateStudent().toString().equals("")==true) {
			throw new Exception("La fecha de nacimiento del estudiante es nulo");
		}
		
		studenDAO.modificarStudent(entity);
		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void eliminarStudent(Student entity) throws Exception {
		if(entity == null) {
			throw new Exception("El estudiante es nulo");
		}
		if(entity.getIdStudent()==0) {
			throw new Exception("El id del estudiante es nulo");
		}
		
		studenDAO.borrarStudent(entity);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Student consultarPorIdStudent(Integer id) throws Exception {
		if(id==0) {
			throw new Exception("El id es nulo");
		}
		return studenDAO.consultarPorIdStudent(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Student> consultarTodosLosStudent() throws Exception {
		return studenDAO.consultarTodosLosStudent();
	}

}
