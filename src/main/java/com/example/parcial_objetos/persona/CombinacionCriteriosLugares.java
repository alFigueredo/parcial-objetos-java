package com.example.parcial_objetos.persona;

import java.util.HashSet;

import com.example.parcial_objetos.lugar.Lugar;

public class CombinacionCriteriosLugares implements PreferenciaVacaciones {

	private final HashSet<PreferenciaVacaciones> criterios;

	public CombinacionCriteriosLugares(HashSet<PreferenciaVacaciones> criterios) {
		this.criterios = criterios;
	}

	@Override
	public boolean tienePreferencia(Persona persona, Lugar lugar) {
		return criterios.stream().anyMatch((criterio) -> criterio.tienePreferencia(persona, lugar));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((criterios == null) ? 0 : criterios.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CombinacionCriteriosLugares other = (CombinacionCriteriosLugares) obj;
		if (criterios == null) {
			if (other.criterios != null)
				return false;
		} else if (!criterios.equals(other.criterios))
			return false;
		return true;
	}

}
