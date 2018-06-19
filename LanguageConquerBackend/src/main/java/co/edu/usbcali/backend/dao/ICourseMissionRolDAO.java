package co.edu.usbcali.backend.dao;

import java.util.List;

import co.edu.usbcali.backend.modelo.CourseMissionRol;

public interface ICourseMissionRolDAO {

	public void crearCourseMissionRol(CourseMissionRol entity);
	public void modificarCourseMissionRol(CourseMissionRol entity);
	public void eliminarCourseMissionRol(CourseMissionRol entity);
	public CourseMissionRol consultarPorIdCourseMissionRol(Integer id);
	public List<CourseMissionRol> consultarTodosLosCourseMissionRol();
	
}
