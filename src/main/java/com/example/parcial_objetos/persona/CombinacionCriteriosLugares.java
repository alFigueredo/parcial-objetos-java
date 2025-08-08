package com.example.parcial_objetos.persona;

import java.util.Arrays;

import com.example.parcial_objetos.lugar.Lugar;

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
