package co.edu.usbcali.backend.dao;

import java.util.List;

import co.edu.usbcali.backend.modelo.Course;

public interface ICourseDAO {

	public void crearCourse(Course entity);
	public void modificarCourse(Course entity);
	public void eliminarCourse(Course entity);
	public Course consultarPorIdCourse(Integer id);
	public List<Course> consultarTodosLosCourse();
	
}
