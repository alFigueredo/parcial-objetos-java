package com.example.parcial_objetos.persona;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.example.parcial_objetos.lugar.Ciudad;
import com.example.parcial_objetos.lugar.Pueblo;

public class LugaresDivertidosTest {

	final Persona persona = new Persona(new LugaresDivertidos(), 1000000);

	@Test
	public void elLugarNoEsDivertido() {
		final Ciudad lugar = new Ciudad("Impar", 200000, new String[] { "Fuente", "Plaza", "Obelisco", "Rosedal" }, 20);
		assertFalse(persona.tienePreferencia(lugar));
	}

	@Test
	public void elPuebloNoEsDivertido() {
		final Pueblo pueblo = new Pueblo("Nombre par", 100, 1850, "Rio Negro");
		assertFalse(persona.tienePreferencia(pueblo));
	}

	@Test
	public void laCiudadEsDivertida() {
		final Ciudad ciudad = new Ciudad("Nombre par", 200000,
				new String[] { "Fuente", "Plaza", "Obelisco", "Rosedal" }, 20);
		assertTrue(persona.tienePreferencia(ciudad));
	}
}
