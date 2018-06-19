package co.edu.usbcali.backend.dao;

import java.util.List;

import co.edu.usbcali.backend.modelo.Recompense;

public interface IRecompenseDAO {
	
	public void crearRecompense(Recompense entity);
	public void modificarRecompense(Recompense entity);
	public void eliminarRecompense(Recompense entity);
	public Recompense consultarPorIdRecompense(Integer id);
	public List<Recompense> consultarTodosLosRecompense();
	
}
