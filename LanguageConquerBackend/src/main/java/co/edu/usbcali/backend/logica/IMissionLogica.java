package co.edu.usbcali.backend.logica;

import java.util.List;

import co.edu.usbcali.backend.modelo.Mission;

public interface IMissionLogica {
	
	public void crearMission(Mission entity) throws Exception;
	public void modificarMission(Mission entity) throws Exception;
	public void eliminarMission (Mission entity) throws Exception;
	public Mission consultarPorId(Integer id) throws Exception;
	public List<Mission> consultarTodosLosMission() throws Exception;
}
