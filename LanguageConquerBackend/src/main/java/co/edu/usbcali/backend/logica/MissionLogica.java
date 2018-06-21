package co.edu.usbcali.backend.logica;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.backend.dao.IMissionDAO;
import co.edu.usbcali.backend.modelo.Mission;
import co.edu.usbcali.backend.modelo.MissionLevel;
import co.edu.usbcali.backend.modelo.MissionType;
import co.edu.usbcali.backend.modelo.Recompense;


@Scope("singleton")
@Service("missionLogica")
public class MissionLogica implements IMissionLogica{

	@Autowired
	private IMissionDAO missionDAO;
	
	@Autowired
	private IMissionLevelLogica missionLevelLogica;
	
	@Autowired
	private IMissionTypeLogica missionTypeLogica;
	
	@Autowired
	private IRecompenseLogica recompenseLogica;
	
	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void crearMission(Mission entity) throws Exception {
		if(entity == null) {
			throw new Exception("La mission es nulo");
		}
		if(entity.getTitleMission() == null || entity.getTitleMission().trim().equals("")==true) {
			throw new Exception("El titulo de la mission es nulo");
		}
		if(entity.getDescriptionMission() == null || entity.getDescriptionMission().trim().equals("")==true) {
			throw new Exception("La descripcion de la mission es nulo");
		}
		if(entity.getScoreMission() == 0) {
			throw new Exception("El puntaje de la mission es nulo");
		}
		if(entity.getDateLimit() == null || entity.getDateLimit().toString().trim().equals("")==true) {
			throw new Exception("La fecha limite de la mission es nulo");
		}
		if(entity.getStateMission()==null || entity.getStateMission().toString().trim().equals("")==true) {
			throw new Exception("El estado e la mission debe ser A o I");
		}
		if(entity.getSendMission()==null || entity.getSendMission().toString().trim().equals("")==true) {
			throw new Exception("El enviar la mission debe ser Y/N");
		}
		Recompense recompense=recompenseLogica.consultarPorIdRecompense(entity.getRecompense().getIdRecompense());
		if(recompense==null) {
			throw new Exception("La recompense es nulo");
		}
		MissionLevel missionLevel = missionLevelLogica.consultarPorIdMissionLevel(entity.getMissionLevel().getIdMissionLevel());
		if(missionLevel == null) {
			throw new Exception("La missionLevel es nulo");
		}
		MissionType missionType = missionTypeLogica.consultarPorIdMissionType(entity.getMissionType().getIdMissionType());
		if(missionType==null) {
			throw new Exception("La missionType es nulo");
		}
		
		missionDAO.crearMission(entity);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void modificarMission(Mission entity) throws Exception {
		if(entity ==null) {
			throw new Exception("La mission es nulo");
		}
		if(entity.getTitleMission() == null || entity.getTitleMission().trim().equals("")==true) {
			throw new Exception("El titulo de la mission es nulo");
		}
		if(entity.getDescriptionMission() == null || entity.getDescriptionMission().trim().equals("")==true) {
			throw new Exception("La descripcion de la mission es nulo");
		}
		if(entity.getScoreMission() == 0) {
			throw new Exception("El puntaje de la mission es nulo");
		}
		if(entity.getDateLimit() == null || entity.getDateLimit().toString().trim().equals("")==true) {
			throw new Exception("La fecha limite de la mission es nulo");
		}
		if(entity.getStateMission()==null || entity.getStateMission().toString().trim().equals("")==true) {
			throw new Exception("El estado e la mission debe ser A o I");
		}
		if(entity.getSendMission()==null || entity.getSendMission().toString().trim().equals("")==true) {
			throw new Exception("El enviar la mission debe ser Y/N");
		}
		Recompense recompense=recompenseLogica.consultarPorIdRecompense(entity.getRecompense().getIdRecompense());
		if(recompense==null) {
			throw new Exception("La recompense es nulo");
		}
		MissionLevel missionLevel = missionLevelLogica.consultarPorIdMissionLevel(entity.getMissionLevel().getIdMissionLevel());
		if(missionLevel == null) {
			throw new Exception("La missionLevel es nulo");
		}
		MissionType missionType = missionTypeLogica.consultarPorIdMissionType(entity.getMissionType().getIdMissionType());
		if(missionType==null) {
			throw new Exception("La missionType es nulo");
		}
		
		missionDAO.modificarMission(entity);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void eliminarMission(Mission entity) throws Exception {
		if(entity ==null) {
			throw new Exception("La mission es nulo");
		}
		if(entity.getIdMission()==0) {
			throw new Exception("El id es nulo");
		}
		
		missionDAO.eliminarMission(entity);
	}

	@Override
	@Transactional(readOnly=true)
	public Mission consultarPorId(Integer id) throws Exception {
		if(id==0) {
			throw new Exception("El id es nulo");
		}
		return missionDAO.consultarPorIdMission(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Mission> consultarTodosLosMission() throws Exception {
		return missionDAO.consultarTodosLosMission();
	}

	
	
}
