package co.edu.usbcali.backend.dao;

import java.util.List;

import co.edu.usbcali.backend.modelo.Mission;

public interface IMissionDAO {
	
	public void crearMission(Mission entity);
	public void modificarMission(Mission entity);
	public void eliminarMission(Mission entity);
	public Mission consultarPorIdMission(Integer id);
	public List<Mission> consultarTodosLosMission();

}
