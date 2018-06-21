package co.edu.usbcali.backend.logica;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.backend.dao.IMissionStateDAO;
import co.edu.usbcali.backend.modelo.MissionState;

public class MissionStateLogica implements IMissionStateLogica{

	@Autowired
	private IMissionStateDAO missionStateDAO;
	
	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void crearMissionState(MissionState entity) throws Exception {
		if(entity==null) {
			throw new Exception("La missionState es nulo");
		}
		if(entity.getNameMissionState()==null || entity.getNameMissionState().trim().equals("")==true) {
			throw new Exception("El nombre de missionState es nulo");
		}
		
		missionStateDAO.crearMissionState(entity);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void modificarMissionState(MissionState entity) throws Exception {
		if(entity==null) {
			throw new Exception("La missionState es nulo");
		}
		if(entity.getNameMissionState()==null || entity.getNameMissionState().trim().equals("")==true) {
			throw new Exception("El nombre de missionState es nulo");
		}
		
		missionStateDAO.modificarMissionState(entity);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void eliminarMissionState(MissionState entity) throws Exception {
		if(entity==null) {
			throw new Exception("La missionState es nulo");
		}
		if(entity.getIdMissionState()==0) {
			throw new Exception("El id es nulo");
		}
		
		missionStateDAO.eliminarMissionState(entity);
	}

	@Override
	@Transactional(readOnly=true)
	public MissionState consultarPorIdMissionState(Integer id) throws Exception {
		if(id==0) {
			throw new Exception("El id es nulo");
		}
		return missionStateDAO.consultarPorIdMissionState(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<MissionState> consultarTodosLosMissionState() throws Exception {
		return missionStateDAO.consultarTodosLosMissionState();
	}

	
}
