package co.edu.usbcali.backend.dao;

import java.util.List;

import co.edu.usbcali.backend.modelo.MissionType;

public interface IMissionTypeDAO {

	public void crearMissionType(MissionType entity);
	public void modificarMissionType(MissionType entity);
	public void eliminarMissionType(MissionType entity);
	public MissionType consultarPorIdMissionType(Integer id);
	public List<MissionType> consultarTodosLosMissionType();
	
}
