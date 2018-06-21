package co.edu.usbcali.backend.logica;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.backend.dao.IRecompenseDAO;
import co.edu.usbcali.backend.modelo.Recompense;


@Scope("singleton")
@Service("recompenseLogica")
public class RecompenseLogica implements IRecompenseLogica {

	@Autowired
	private IRecompenseDAO recompenseDAO;
	
	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void crearRecompense(Recompense entity) throws Exception {
		if(entity==null) {
			throw new Exception("La recompense es nulo");
		}
		if(entity.getTitleRecompense()==null || entity.getTitleRecompense().trim().equals("")==true) {
			throw new Exception("El titulo de la recompense es nulo");
		}
		if(entity.getImgRecompense()==null || entity.getImgRecompense().trim().equals("")==true) {
			throw new Exception("La ruta de la imagen recompense es nulo");
		}
		if(entity.getScoreMin()==0) {
			throw new Exception("El puntaje minimo de la recompense debe ser mayor que cero");
		}
		
		recompenseDAO.crearRecompense(entity);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void modificarRecompense(Recompense entity) throws Exception {
		if(entity==null) {
			throw new Exception("La recompense es nulo");
		}
		if(entity.getTitleRecompense()==null || entity.getTitleRecompense().trim().equals("")==true) {
			throw new Exception("El titulo de la recompense es nulo");
		}
		if(entity.getImgRecompense()==null || entity.getImgRecompense().trim().equals("")==true) {
			throw new Exception("La ruta de la imagen recompense es nulo");
		}
		if(entity.getScoreMin()==0) {
			throw new Exception("El puntaje minimo de la recompense debe ser mayor que cero");
		}
		
		recompenseDAO.modificarRecompense(entity);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void eliminarRecompense(Recompense entity) throws Exception {
		if(entity==null) {
			throw new Exception("La recompense es nulo");
		}
		if(entity.getIdRecompense()==0) {
			throw new Exception("El id es nulo");
		}
		
		recompenseDAO.eliminarRecompense(entity);
	}

	@Override
	@Transactional(readOnly=true)
	public Recompense consultarPorIdRecompense(Integer id) throws Exception {
		if(id==0) {
			throw new Exception("El id es nulo");
		}
		return recompenseDAO.consultarPorIdRecompense(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Recompense> consultarTodosLosRecompense() throws Exception {
		return recompenseDAO.consultarTodosLosRecompense();
	}

	
	
}
