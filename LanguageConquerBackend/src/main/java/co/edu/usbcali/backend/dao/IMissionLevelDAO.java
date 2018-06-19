package co.edu.usbcali.backend.dao;

import java.util.List;

import co.edu.usbcali.backend.modelo.MissionLevel;

public interface IMissionLevelDAO {

	public void crearMissionLevel(MissionLevel entity);
	public void modificarMissionLevel(MissionLevel entity);
	public void eliminarMissionLevel(MissionLevel entity);
	public MissionLevel consultarPorIdMissionLevel(Integer id);
	public List<MissionLevel> consultarTodosLosMissionLevel();
}
