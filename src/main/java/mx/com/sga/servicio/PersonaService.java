package mx.com.sga.servicio;

import java.util.List;

import javax.ejb.Local;

import mx.com.sga.domain.Persona;

@Local
public interface PersonaService {

	public List<Persona> listarPersonas();

	public void registrarPersona(Persona persona);

	public Persona encontrarPersonaPorID(Persona persona);

	public void modificarPersona(Persona persona);

	public void eliminarPersona(Persona persona);

	public Persona encontrarPersonaPorEmail(Persona persona);
}
