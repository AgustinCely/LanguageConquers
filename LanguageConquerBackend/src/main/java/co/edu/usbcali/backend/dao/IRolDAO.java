package co.edu.usbcali.backend.dao;

import java.util.List;

import co.edu.usbcali.backend.modelo.Rol;

public interface IRolDAO {

	public void crearRol(Rol entity);
	public void modificarRol(Rol entity);
	public void eliminarRol(Rol entity);
	public Rol consultarPorIdRol(Integer id);
	public List<Rol> consultarTodosLosRol();
}
