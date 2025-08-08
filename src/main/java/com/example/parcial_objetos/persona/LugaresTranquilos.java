package com.example.parcial_objetos.persona;

import com.example.parcial_objetos.lugar.Lugar;

public class LugaresTranquilos implements PreferenciaVacaciones {

	@Override
	public boolean tienePreferencia(Persona persona, Lugar lugar) {
		return lugar.lugarTranquilo();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + getClass().hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		return getClass() == obj.getClass();
	}

}
