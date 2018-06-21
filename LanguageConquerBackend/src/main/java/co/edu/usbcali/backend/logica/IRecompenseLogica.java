package co.edu.usbcali.backend.logica;

import java.util.List;

import co.edu.usbcali.backend.modelo.Recompense;

public interface IRecompenseLogica {

	public void crearRecompense(Recompense entity) throws Exception;
	public void modificarRecompense(Recompense entity) throws Exception;
	public void eliminarRecompense(Recompense entity) throws Exception;
	public Recompense consultarPorIdRecompense(Integer id) throws Exception;
	public List<Recompense> consultarTodosLosRecompense() throws Exception;
	
}
