package com.example.parcial_objetos;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.example.parcial_objetos.lugar.Ciudad;
import com.example.parcial_objetos.lugar.Lugar;
import com.example.parcial_objetos.lugar.Pueblo;
import com.example.parcial_objetos.persona.CombinacionCriteriosLugares;
import com.example.parcial_objetos.persona.LugaresRaros;
import com.example.parcial_objetos.persona.LugaresTranquilos;
import com.example.parcial_objetos.persona.Persona;
import com.example.parcial_objetos.persona.PreferenciaVacaciones;

public class TourTest {

	private final PreferenciaVacaciones preferencia = new CombinacionCriteriosLugares(
			new PreferenciaVacaciones[] { new LugaresTranquilos(), new LugaresRaros() });

	private final Persona persona1 = new Persona(preferencia, 1000000);
	private final Persona persona2 = new Persona(preferencia, 1000000);

	private final Ciudad ciudad = new Ciudad("Nombre letras par", 200000,
			new String[] { "Fuente", "Plaza", "Obelisco", "Rosedal" }, 30);
	private final Pueblo pueblo = new Pueblo("Nombre par", 100, 1750, "La Pampa");

	@Test
	public void laPersonaNoPoseeSuficientePresupuesto() {
		final Tour tour = new Tour(LocalDate.of(2023, 1, 7), 3, new Lugar[] { ciudad, pueblo }, 800000,
				new ArrayList<Persona>(Arrays.asList(persona1, persona2)));
		final Persona persona = new Persona(preferencia, 700000);
		AssertionError error = assertThrows(AssertionError.class, () -> tour.agregarPersona(persona));
		assertEquals("La persona no posee el presupuesto suficiente", error.getMessage());
	}

	@Test
	public void laPersonaNoTienePreferenciaPorTodosLosLugares() {
		final Tour tour = new Tour(LocalDate.of(2023, 1, 7), 3, new Lugar[] { ciudad, pueblo }, 800000,
				new ArrayList<Persona>(Arrays.asList(persona1, persona2)));
		final Persona persona = new Persona(new LugaresTranquilos(), 1000000);
		AssertionError error = assertThrows(AssertionError.class, () -> tour.agregarPersona(persona));
		assertEquals("No todos los lugares son adecuados para la persona", error.getMessage());
	}

	@Test
	public void laPersonaPuedeSerAgregadaAlTour() {
		final Tour tour = new Tour(LocalDate.of(2023, 1, 7), 3, new Lugar[] { ciudad, pueblo }, 800000,
				new ArrayList<Persona>(Arrays.asList(persona1, persona2)));
		final Persona persona = new Persona(preferencia, 1000000);
		assertDoesNotThrow(() -> tour.agregarPersona(persona));
		assertTrue(tour.tourConfirmado());
	}

	@Test
	public void laPersonaNoPuedeSerAgregadaAUnTourConfirmado() {
		final Tour tour = new Tour(LocalDate.of(2023, 1, 7), 2, new Lugar[] { ciudad, pueblo }, 800000,
				new ArrayList<Persona>(Arrays.asList(persona1, persona2)));
		final Persona persona = new Persona(preferencia, 1000000);
		AssertionError error = assertThrows(AssertionError.class, () -> tour.agregarPersona(persona));
		assertEquals("El tour ya se encuentra confirmado, no se puede incorporar más gente", error.getMessage());
	}

	@Test
	public void unaPersonaPuedeSerDesvinculadaDelTour() {
		final Persona persona = new Persona(preferencia, 1000000);
		final Tour tour = new Tour(LocalDate.of(2023, 1, 7), 3, new Lugar[] { ciudad, pueblo }, 800000,
				new ArrayList<Persona>(Arrays.asList(persona1, persona2, persona)));
		assertDoesNotThrow(() -> tour.desvincularPersona(persona));
		assertFalse(tour.tourConfirmado());
	}
}
