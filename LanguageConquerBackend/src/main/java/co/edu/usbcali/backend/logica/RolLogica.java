package co.edu.usbcali.backend.logica;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.backend.dao.IRolDAO;
import co.edu.usbcali.backend.modelo.Rol;


@Scope("singleton")
@Service("rolLogica")
public class RolLogica implements IRolLogica {

	@Autowired
	private IRolDAO rolDAO;
	
	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void crearRol(Rol entity) throws Exception {
		if(entity == null) {
			throw new Exception("El rol es nulo");
		}
		if(entity.getNameRol()==null || entity.getNameRol().trim().equals("")==true) {
			throw new Exception("El nombre rol es nulo");
		}
		rolDAO.crearRol(entity);
		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void modificarRol(Rol entity) throws Exception {
		if(entity == null) {
			throw new Exception("El rol es nulo");
		}
		if(entity.getNameRol()==null || entity.getNameRol().trim().equals("")==true) {
			throw new Exception("El nombre rol es nulo");
		}
		if(entity.getImgRol()==null || entity.getImgRol().trim().equals("")==true) {
			throw new Exception("La ruta de la imagen es nulo");
		}
		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void eliminarRol(Rol entity) throws Exception {
		if(entity == null) {
			throw new Exception("El rol es nulo");
		}
		if(entity.getIdRol()==0) {
			throw new Exception("El rol es nulo");
		}
		
		rolDAO.eliminarRol(entity);
	}

	@Override
	@Transactional(readOnly=true)
	public Rol consultarPorIdRol(Integer id) throws Exception {
		if(id==0) {
			throw new Exception("El id es nulo");
		}
		return rolDAO.consultarPorIdRol(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Rol> consultarTodosLorRol() throws Exception {
		return rolDAO.consultarTodosLosRol();
	}

	
	
}
