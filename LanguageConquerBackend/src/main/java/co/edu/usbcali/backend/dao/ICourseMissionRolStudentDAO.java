package co.edu.usbcali.backend.dao;

import java.util.List;

import co.edu.usbcali.backend.modelo.CourseMissionRolStudent;

public interface ICourseMissionRolStudentDAO {
	
	public void crearCourseMissionRolStudent(CourseMissionRolStudent entity);
	public void modificarCourseMissionRolStudent(CourseMissionRolStudent entity);
	public void eliminarCourseMissionRolStudent(CourseMissionRolStudent entity);
	public CourseMissionRolStudent consultarPorIdCourseMissionRolStudent(Integer id);
	public List<CourseMissionRolStudent> consultarTodosLosCourseMissionRolStudent();
	
}
