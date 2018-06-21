package co.edu.usbcali.backend.logica;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.backend.dao.IAvatarDAO;
import co.edu.usbcali.backend.modelo.Avatar;


@Scope("singleton")
@Service("avatarLogica")
public class AvatarLogica implements IAvatarLogica{

	@Autowired
	private IAvatarDAO avatarDAO;
	
	
	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void crearAvatar(Avatar entity) throws Exception {
		if(entity == null) {
			throw new Exception("El avatar es nulo");
		}
		if(entity.getNameAvatar()==null || entity.getNameAvatar().trim().equals("")== true) {
			throw new Exception("El nombre del avatar es nulo");
		}
		
		avatarDAO.crearAvatar(entity);
		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void modificarAvatar(Avatar entity) throws Exception {
		if(entity == null) {
			throw new Exception("El avatar es nulo");
		}
		if(entity.getNameAvatar()==null || entity.getNameAvatar().trim().equals("")== true) {
			throw new Exception("El nombre del avatar es nulo");
		}
		if(entity.getImgAvatar()==null || entity.getImgAvatar().trim().equals("")==true) {
			throw new Exception("La ruta de la imagen es nulo");
		}
		avatarDAO.modificarAvatar(entity);
		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void eliminarAvatar(Avatar entity) throws Exception {
		if(entity == null) {
			throw new Exception("El avatar es nulo");
		}
		if(entity.getIdAvatar()==0) {
			throw new Exception("El id es nulo");
		}
		
		avatarDAO.borrarAvatar(entity);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Avatar consultarPorIdAvatar(Integer id) throws Exception {
		if(id==0) {
			throw new Exception("El id es nulo");
		}
		return avatarDAO.consultarPorIdAvatar(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Avatar> consultarTodosLosAvatar() throws Exception {
		return avatarDAO.consultarTodosLosAvatar();
	}

	
	
}
