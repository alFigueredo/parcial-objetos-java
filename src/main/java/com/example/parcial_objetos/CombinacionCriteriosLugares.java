package com.example.parcial_objetos;

public class CombinacionCriteriosLugares implements PreferenciaVacaciones {

	private final PreferenciaVacaciones[] criterios;

	public CombinacionCriteriosLugares(PreferenciaVacaciones[] criterios) {
		this.criterios = criterios;
	}

	@Override
	public boolean tienePreferencia(Persona persona, Lugar lugar) {
		for (PreferenciaVacaciones criterio : criterios) {
			if (criterio.tienePreferencia(persona, lugar))
				return true;
		}
		return false;
	}

}
