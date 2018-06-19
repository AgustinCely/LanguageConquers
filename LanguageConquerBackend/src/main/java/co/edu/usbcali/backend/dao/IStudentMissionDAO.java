package co.edu.usbcali.backend.dao;

import java.util.List;

import co.edu.usbcali.backend.modelo.StudentMission;

public interface IStudentMissionDAO {

	public void crearStudentMission(StudentMission entity);
	public void modificarStudentMission(StudentMission entity);
	public void eliminarStudentMission(StudentMission entity);
	public StudentMission consultarPorIdStudentMission(Integer id);
	public List<StudentMission> consultarTodosLosStudentMission();
	
}
