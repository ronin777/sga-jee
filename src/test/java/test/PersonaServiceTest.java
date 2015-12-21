package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.ejb.embeddable.EJBContainer;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import mx.com.sga.domain.Persona;
import mx.com.sga.servicio.PersonaService;

public class PersonaServiceTest {

	private PersonaService  personaService;
	
	@Before
	public void setUp()throws Exception{
		EJBContainer contenedor = EJBContainer.createEJBContainer();
		personaService = (PersonaService) contenedor.getContext().lookup("java:global/classes/PersonaServiceImpl!mx.com.sga.servicio.PersonaService");
	}
	
	@Test
	@Ignore
	public void testEJBPersonaService(){
		
		System.out.println("Iniciando test EJB PersonaService");
		assertTrue(personaService != null);
		
		assertEquals(2, personaService.listarPersonas().size());
		
		System.out.println("El no, de Personas es igual a "+ personaService.listarPersonas().size());
		
		this.desplegarPersonas(personaService.listarPersonas());
		
		System.out.println("\nFinalizando prueba test");
	}
	
	@Test
	public void testRegistro(){
		
		System.out.println("Iniciando test EJB PersonaService");
		Persona p = new Persona();
		p.setNombre("Algredo");
		p.setApePaterno("Arm");
		p.setApeMaterno("Arm");
		p.setTelefono("S/T");
		p.setEmail("otroCorreo@hotmail.com");
		personaService.registrarPersona(p);
		
		assertEquals(3, personaService.listarPersonas().size());
		
		System.out.println("El no, de Personas es igual a "+ personaService.listarPersonas().size());
		
		this.desplegarPersonas(personaService.listarPersonas());
		
		System.out.println("\nFinalizando prueba test");
	}
	
	private void desplegarPersonas(List<Persona> listaPersonas){
		for (Persona persona : listaPersonas) {
			System.out.println(persona);
		}
	}
}
