package co.edu.usbcali.backend.dao;

import java.util.List;

import co.edu.usbcali.backend.modelo.CourseMissionStudent;

public interface ICourseMissionStudentDAO {

	public void crearCourseMissionStudent(CourseMissionStudent entity);
	public void modificarCourseMissionStudent(CourseMissionStudent entity);
	public void eliminarCourseMissionStudent(CourseMissionStudent entity);
	public CourseMissionStudent consultarPorId(Integer id);
	public List<CourseMissionStudent> consultarTodosLosCourseMissionStudent() ;
}
