package co.edu.usbcali.backend.logica;

import java.util.List;

import co.edu.usbcali.backend.modelo.Avatar;

public interface IAvatarLogica {
	
	public void crearAvatar(Avatar entity) throws Exception;
	public void modificarAvatar(Avatar entity) throws Exception;
	public void eliminarAvatar(Avatar entity) throws Exception;
	public Avatar consultarPorIdAvatar(Integer id) throws Exception;
	public List<Avatar> consultarTodosLosAvatar() throws Exception;
	
}
