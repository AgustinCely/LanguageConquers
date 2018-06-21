package co.edu.usbcali.backend.logica;

import java.util.List;

import co.edu.usbcali.backend.modelo.RolStudent;

public interface IRolStudentLogica {
	
	public void crearRolStudent(RolStudent entity) throws Exception;
	public void modificarRolStudent(RolStudent entity) throws Exception;
	public void eliminarRolStudent(RolStudent entity) throws Exception;
	public RolStudent consultarPorIdRolStudent(Integer id) throws Exception;
	public List<RolStudent> consultarTodoslosRolStudent() throws Exception;
}
