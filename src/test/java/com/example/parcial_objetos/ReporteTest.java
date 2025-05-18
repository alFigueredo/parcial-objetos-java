package com.example.parcial_objetos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class ReporteTest {

	private final PreferenciaVacaciones preferencia = new CombinacionCriteriosLugares(
			new PreferenciaVacaciones[] { new LugaresTranquilos(), new LugaresRaros() });

	private final Persona persona1 = new Persona(preferencia, 1000000);
	private final Persona persona2 = new Persona(preferencia, 1000000);
	private final Persona persona3 = new Persona(preferencia, 1000000);

	private final Ciudad ciudad = new Ciudad("Nombre letras par", 200000,
			new String[] { "Fuente", "Plaza", "Obelisco", "Rosedal" }, 30);
	private final Pueblo pueblo = new Pueblo("Nombre par", 100, 1750, "La Pampa");

	private final Tour tour1 = new Tour(LocalDate.of(LocalDate.now().getYear(), 1, 7), 3,
			new Lugar[] { ciudad, pueblo },
			800000, new ArrayList<Persona>(Arrays.asList(persona1, persona2)));
	private final Tour tour2 = new Tour(LocalDate.of(LocalDate.now().minusYears(1).getYear(), 1, 7), 2,
			new Lugar[] { ciudad, pueblo },
			700000, new ArrayList<Persona>(Arrays.asList(persona1, persona2)));
	private final Tour tour3 = new Tour(LocalDate.of(LocalDate.now().getYear(), 1, 7), 3,
			new Lugar[] { ciudad, pueblo },
			600000, new ArrayList<Persona>(Arrays.asList(persona1, persona2, persona3)));

	private final Reporte reporte = new Reporte(new Tour[] { tour1, tour2, tour3 });

	@Test
	public void toursPendientesDeConfirmacion() {
		final Tour[] tours = reporte.toursPendientesDeConfirmacion();
		assertEquals(1, tours.length);
	}

	@Test
	public void montoTotalToursQueSalenEsteAnio() {
		assertEquals(3400000, reporte.montoTotalToursEsteAnio());
	}

}
