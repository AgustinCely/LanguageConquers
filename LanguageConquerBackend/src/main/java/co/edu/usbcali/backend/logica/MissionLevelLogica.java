package co.edu.usbcali.backend.logica;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.backend.dao.IMissionLevelDAO;
import co.edu.usbcali.backend.modelo.MissionLevel;


@Scope("singleton")
@Service("missionLevelLogica")
public class MissionLevelLogica implements IMissionLevelLogica{

	@Autowired
	private IMissionLevelDAO missionLevelDAO;
	
	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void crearMissionLevel(MissionLevel entity) throws Exception {
		if(entity == null) {
			throw new Exception("El missionlevel es nulo");
		}
		if(entity.getNameMissionLevel()==null || entity.getNameMissionLevel().trim().equals("")==true) {
			throw new Exception("El nombre de la missionlevel es nulo");
		}
		if(entity.getImgMissionLevel()==null || entity.getImgMissionLevel().trim().equals("")== true) {
			throw new Exception("La ruta de imagen de missionlevel es nulo");
		}
		if(entity.getScoreMissionLevel()==0) {
			throw new Exception("El puntaje de la missionlevel no debe de ser cero");
		}
		
		missionLevelDAO.crearMissionLevel(entity);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void modificarMissionLevel(MissionLevel entity) throws Exception {
		if(entity == null) {
			throw new Exception("El missionlevel es nulo");
		}
		if(entity.getNameMissionLevel()==null || entity.getNameMissionLevel().trim().equals("")==true) {
			throw new Exception("El nombre de la missionlevel es nulo");
		}
		if(entity.getImgMissionLevel()==null || entity.getImgMissionLevel().trim().equals("")== true) {
			throw new Exception("La ruta de imagen de missionlevel es nulo");
		}
		if(entity.getScoreMissionLevel()==0) {
			throw new Exception("El puntaje de la missionlevel no debe de ser cero");
		}
		
		missionLevelDAO.modificarMissionLevel(entity);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void eliminarMissionLevel(MissionLevel entity) throws Exception {
		if(entity == null) {
			throw new Exception("El missionlevel es nulo");
		}
		if(entity.getIdMissionLevel()==0) {
			throw new Exception("El id es nulo");
		}
		
		missionLevelDAO.eliminarMissionLevel(entity);
	}

	@Override
	@Transactional(readOnly=true)
	public MissionLevel consultarPorIdMissionLevel(Integer id) throws Exception {
		if(id==0) {
			throw new Exception("El missionlevel es nulo");
		}
		return missionLevelDAO.consultarPorIdMissionLevel(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<MissionLevel> consultarTodosPorIdMissionLevel() throws Exception {
		return missionLevelDAO.consultarTodosLosMissionLevel();
	}

	
	
}
