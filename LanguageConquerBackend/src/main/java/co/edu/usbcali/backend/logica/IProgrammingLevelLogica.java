package co.edu.usbcali.backend.logica;

import java.util.List;

import co.edu.usbcali.backend.modelo.ProgrammingLevel;

public interface IProgrammingLevelLogica {

	public void crearProgrammingLevel(ProgrammingLevel entity) throws Exception;
	public void modificarProgrammingLevel(ProgrammingLevel entity) throws Exception;
	public void eliminarProgrammingLevel(ProgrammingLevel entity) throws Exception;
	public ProgrammingLevel consultarPorIdProgrammingLevel(Integer id) throws Exception;
	public List<ProgrammingLevel> consultarTodosLosProgrammingLevel() throws Exception ;
}
