package co.edu.usbcali.backend.dao;

import java.util.List;

import co.edu.usbcali.backend.modelo.RolStudent;

public interface IRolStudentDAO {

	public void crearRolStudent(RolStudent entity);
	public void modificarRolStudent(RolStudent entity);
	public void eliminarRolStudent(RolStudent entity);
	public RolStudent consultarPorIdRolStudent(Integer id);
	public List<RolStudent> consultarTodosLosRolStudent();
	
}
