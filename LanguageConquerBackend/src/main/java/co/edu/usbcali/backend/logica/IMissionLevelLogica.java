package co.edu.usbcali.backend.logica;

import java.util.List;

import co.edu.usbcali.backend.modelo.MissionLevel;

public interface IMissionLevelLogica {
	
	public void crearMissionLevel (MissionLevel entity) throws Exception;
	public void modificarMissionLevel(MissionLevel entity) throws Exception;
	public void eliminarMissionLevel(MissionLevel entity) throws Exception;
	public MissionLevel consultarPorIdMissionLevel (Integer id) throws Exception;
	public List<MissionLevel> consultarTodosPorIdMissionLevel() throws Exception;

}
