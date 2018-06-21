package co.edu.usbcali.backend.logica;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.backend.dao.IMissionTypeDAO;
import co.edu.usbcali.backend.modelo.MissionType;


@Scope("singleton")
@Service("missionTypeLogica")
public class MissionTypeLogica implements IMissionTypeLogica{

	@Autowired
	private IMissionTypeDAO missionTypeDAO;
	
	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void crearMissionType(MissionType entity) throws Exception {
		if(entity==null) {
			throw new Exception("La missionType es nulo");
		}
		if(entity.getDescriptionMissionType()==null || entity.getDescriptionMissionType().trim().equals("")==true) {
			throw new Exception("La descripcion de missionType es nulo");
		}
		
		missionTypeDAO.crearMissionType(entity);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void modificarMissionType(MissionType entity) throws Exception {
		if(entity==null) {
			throw new Exception("La missionType es nulo");
		}
		if(entity.getDescriptionMissionType()==null || entity.getDescriptionMissionType().trim().equals("")==true) {
			throw new Exception("La descripcion de missionType es nulo");
		}
		
		missionTypeDAO.modificarMissionType(entity);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void eliminarMissionType(MissionType entity) throws Exception {
		if(entity==null) {
			throw new Exception("La missionType es nulo");
		}
		if(entity.getIdMissionType()==0) {
			throw new Exception("El id es nulo");
		}
		
		missionTypeDAO.eliminarMissionType(entity);
	}

	@Override
	@Transactional(readOnly=true)
	public MissionType consultarPorIdMissionType(Integer id) throws Exception {
		if(id==0) {
			throw new Exception("El id es nulo");
		}
		return missionTypeDAO.consultarPorIdMissionType(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<MissionType> consutarTodosLosMissionType() throws Exception {
		return missionTypeDAO.consultarTodosLosMissionType();
	}

	
	
}
