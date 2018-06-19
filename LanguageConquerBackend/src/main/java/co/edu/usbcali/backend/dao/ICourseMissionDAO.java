package co.edu.usbcali.backend.dao;

import java.util.List;

import co.edu.usbcali.backend.modelo.CourseMission;

public interface ICourseMissionDAO {
	
	public void crearCourseMission(CourseMission entity);
	public void modificarCourseMission(CourseMission entity);
	public void eliminarCourseMission(CourseMission entity);
	public CourseMission consultarPorIdCourseMission(Integer id);
	public List<CourseMission> consultarTodosLosCourseMission();

}
