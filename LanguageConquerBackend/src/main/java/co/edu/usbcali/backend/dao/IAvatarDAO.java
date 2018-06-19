package co.edu.usbcali.backend.dao;

import java.util.List;

import co.edu.usbcali.backend.modelo.Avatar;

public interface IAvatarDAO {

	public void crearAvatar(Avatar entity);
	public void modificarAvatar(Avatar entity);
	public void borrarAvatar(Avatar entity);
	public Avatar consultarPorIdAvatar(Integer id);
	public List<Avatar> consultarTodosLosAvatar();
}
