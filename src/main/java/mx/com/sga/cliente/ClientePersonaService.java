package mx.com.sga.cliente;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import mx.com.sga.domain.Persona;
import mx.com.sga.servicio.PersonaServiceRemote;

public class ClientePersonaService {

	public static void main(String[] args) {
		System.out.println("Iniciando llamada al EJB desde el cliente...\n");
		try {
			Context jndi = new InitialContext();
			PersonaServiceRemote personaService = (PersonaServiceRemote) 
					jndi.lookup("java:global/sga-jee/PersonaServiceImpl!mx.com.sga.servicio.PersonaServiceRemote");
			
			List<Persona> personas = personaService.listarPersonas();
			
			for (Persona persona : personas) {
				System.out.println(persona);
			}
			
			System.out.println("\nFinalizando llamada al EJB desde el cliente...");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
