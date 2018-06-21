package co.edu.usbcali.backend.logica;

import java.util.List;

import co.edu.usbcali.backend.modelo.MissionType;

public interface IMissionTypeLogica {
	
	public void crearMissionType(MissionType entity) throws Exception;
	public void modificarMissionType(MissionType entity) throws Exception;
	public void eliminarMissionType(MissionType entity) throws Exception;
	public MissionType consultarPorIdMissionType(Integer id) throws Exception;
	public List<MissionType> consutarTodosLosMissionType() throws Exception;
	
}
