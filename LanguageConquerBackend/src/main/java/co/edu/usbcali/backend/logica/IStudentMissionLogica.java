package co.edu.usbcali.backend.logica;

import java.util.List;

import co.edu.usbcali.backend.modelo.StudentMission;

public interface IStudentMissionLogica {

	public void crearStudentMission(StudentMission entity) throws Exception;
	public void modificarStudentMission(StudentMission entity) throws Exception;
	public void eliminarStudentMission(StudentMission entity) throws Exception;
	public StudentMission consultarPorIdStudentMission(Integer id) throws Exception;
	public List<StudentMission> consultarTodoLosStudentMission() throws Exception;
}
