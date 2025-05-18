package com.example.parcial_objetos;

import java.util.Arrays;

public class CombinacionCriteriosLugares implements PreferenciaVacaciones {

	private final PreferenciaVacaciones[] criterios;

	public CombinacionCriteriosLugares(PreferenciaVacaciones[] criterios) {
		this.criterios = criterios;
	}

	@Override
	public boolean tienePreferencia(Persona persona, Lugar lugar) {
		return Arrays.stream(criterios).anyMatch((criterio) -> criterio.tienePreferencia(persona, lugar));
	}

}
