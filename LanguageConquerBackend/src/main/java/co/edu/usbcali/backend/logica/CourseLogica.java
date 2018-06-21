package co.edu.usbcali.backend.logica;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.backend.dao.ICourseDAO;
import co.edu.usbcali.backend.modelo.Course;
import co.edu.usbcali.backend.modelo.Teacher;

@Scope("singleton")
@Service("courseLogica")
public class CourseLogica implements ICourseLogica{
	
	@Autowired
	private ICourseDAO courseDAO;
	
	@Autowired
	private ITeacherLogica teacherLogica;

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void crearCourse(Course entity) throws Exception {
		if(entity==null) {
			throw new Exception("El curso es nulo");
		}
		if(entity.getNameCourse()==null || entity.getNameCourse().trim().equals("")==true) {
			throw new Exception("El nombre del curso es nulo");
		}
		if(entity.getPasswordCourse()==null || entity.getPasswordCourse().trim().equals("")==true) {
			throw new Exception("La contraseña del curso es nulo");
		}
		if(entity.getNumberStudent()==0) {
			throw new Exception("El número de estudiantes debe ser mayor que cero");
		}
		if(entity.getQuantityLanguage()==0) {
			throw new Exception("El número de lenaguajes de programación debe ser mayor que cero");
		}
		if(entity.getStartCourse()==null || entity.getStartCourse().toString().equals("")==true) {
			throw new Exception("La fecha de inicio del curso es nulo");
		}
		if(entity.getEndCourse()==null || entity.getEndCourse().toString().equals("")==true) {
			throw new Exception("La fecha de terminacion del curso es nulo");
		}
		
		Teacher teacher=teacherLogica.consultarPorIdTeacher(entity.getTeacher().getIdTeacher());
		if(teacher==null) {
			throw new Exception("El docente no existe");
		}
		
		courseDAO.crearCourse(entity);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void modificarCourse(Course entity) throws Exception {
		if(entity==null) {
			throw new Exception("El curso es nulo");
		}
		if(entity.getNameCourse()==null || entity.getNameCourse().trim().equals("")==true) {
			throw new Exception("El nombre del curso es nulo");
		}
		if(entity.getPasswordCourse()==null || entity.getPasswordCourse().trim().equals("")==true) {
			throw new Exception("La contraseña del curso es nulo");
		}
		if(entity.getNumberStudent()==0) {
			throw new Exception("El número de estudiantes debe ser mayor que cero");
		}
		if(entity.getQuantityLanguage()==0) {
			throw new Exception("El número de lenaguajes de programación debe ser mayor que cero");
		}
		if(entity.getStartCourse()==null || entity.getStartCourse().toString().equals("")==true) {
			throw new Exception("La fecha de inicio del curso es nulo");
		}
		if(entity.getEndCourse()==null || entity.getEndCourse().toString().equals("")==true) {
			throw new Exception("La fecha de terminacion del curso es nulo");
		}
		
		courseDAO.modificarCourse(entity);
		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void eliminarCourse(Course entity) throws Exception {
		if(entity == null) {
			throw new Exception("El curso es nulo");
		}
		if(entity.getIdCourse()==0) {
			throw new Exception("El id es nulo");
		}
		
		courseDAO.eliminarCourse(entity);
	}

	@Override
	@Transactional(readOnly=true)
	public Course consultarPorId(Integer id) throws Exception {
		if(id==0) {
			throw new Exception("El id es nulo");
		}
		return courseDAO.consultarPorIdCourse(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Course> consultarTodosLosCourse() throws Exception {
		return courseDAO.consultarTodosLosCourse();
	}

}
