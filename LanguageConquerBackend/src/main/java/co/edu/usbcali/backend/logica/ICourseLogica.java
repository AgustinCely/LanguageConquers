package co.edu.usbcali.backend.logica;

import java.util.List;

import co.edu.usbcali.backend.modelo.Course;

public interface ICourseLogica {

	public void crearCourse(Course entity) throws Exception;
	public void modificarCourse(Course entity) throws Exception;
	public void eliminarCourse(Course entity) throws Exception;
	public Course consultarPorId(Integer id) throws Exception;
	public List<Course> consultarTodosLosCourse() throws Exception;
	
	
}
