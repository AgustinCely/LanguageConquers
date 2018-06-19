package co.edu.usbcali.backend.dao;

import java.util.List;

import co.edu.usbcali.backend.modelo.CourseLanguage;

public interface ICourseLanguageDAO {
	
	public void crearCourseLanguage(CourseLanguage entity);
	public void modificarCourseLanguage(CourseLanguage entity);
	public void eliminarCourseLanguage(CourseLanguage entity);
	public CourseLanguage consultarPorIdCourseLanguage(Integer id);
	public List<CourseLanguage> consultarTodosLosCourseLanguage();
}
