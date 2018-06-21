package co.edu.usbcali.backend.logica;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.backend.dao.ICourseLanguageDAO;
import co.edu.usbcali.backend.modelo.Course;
import co.edu.usbcali.backend.modelo.CourseLanguage;
import co.edu.usbcali.backend.modelo.Language;


@Scope("singleton")
@Service("courseLanguageLogica")
public class CourseLanguageLogica implements ICourseLanguageLogica {

	@Autowired
	private ICourseLanguageDAO courseLanguageDAO;
	
	@Autowired
	private ICourseLogica courseLogica;
	
	@Autowired
	private ILanguageLogica languageLogica;
	
	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void crearCourseLanguage(CourseLanguage entity) throws Exception {
		if(entity == null) {
			throw new Exception("El CourseLanguage es nulo");
		}
		if(entity.getProgressbarCourseLanguage() == 0) {
			throw new Exception("La barra de progreso CourseLanguage es nulo");
		}
		
		Course course=courseLogica.consultarPorId(entity.getCourse().getIdCourse());
		if(course==null) {
			throw new Exception("El course es nulo");
		}
		
		Language language = languageLogica.consultarPorIdLanguage(entity.getLanguage().getIdLanguage());
		if(language == null) {
			throw new Exception("El language es nulo");
		}
		
		courseLanguageDAO.crearCourseLanguage(entity);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void modificarCourseLanguage(CourseLanguage entity) throws Exception {
		if(entity == null) {
			throw new Exception("El CourseLanguage es nulo");
		}
		if(entity.getProgressbarCourseLanguage() == 0) {
			throw new Exception("La barra de progreso CourseLanguage es nulo");
		}
		if(entity.getImgCourseLanguage() == null || entity.getImgCourseLanguage().trim().equals("")==true) {
			throw new Exception("la ruta de la image de CourseLanguage es nulo");
		}
		
		Course course=courseLogica.consultarPorId(entity.getCourse().getIdCourse());
		if(course==null) {
			throw new Exception("El course es nulo");
		}
		
		Language language = languageLogica.consultarPorIdLanguage(entity.getLanguage().getIdLanguage());
		if(language == null) {
			throw new Exception("El language es nulo");
		}
		
		courseLanguageDAO.modificarCourseLanguage(entity);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void eliminarCourseLanguage(CourseLanguage entity) throws Exception {
		if(entity == null) {
			throw new Exception("El CourseLanguage es nulo");
		}
		if(entity.getIdCoruseLanguage()==0) {
			throw new Exception("El id es nulo");
		}
		
		courseLanguageDAO.eliminarCourseLanguage(entity);
	}

	@Override
	@Transactional(readOnly=true)
	public CourseLanguage consultarPorIdCourseLanguage(Integer id) throws Exception {
		if(id == 0) {
			throw new Exception("El id es nulo");
		}
		return courseLanguageDAO.consultarPorIdCourseLanguage(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<CourseLanguage> consultarTodoLosCourseLanguage() throws Exception {
		return courseLanguageDAO.consultarTodosLosCourseLanguage();
	}

	
	
}
