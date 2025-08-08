package com.example.parcial_objetos.persona;

import java.util.Arrays;

import com.example.parcial_objetos.lugar.Lugar;

public class Persona {

	private PreferenciaVacaciones preferenciaVacaciones;
	private int presupuestoMaximo;

	public Persona(PreferenciaVacaciones preferenciaVacaciones, int presupuestoMaximo) {
		this.preferenciaVacaciones = preferenciaVacaciones;
		this.presupuestoMaximo = presupuestoMaximo;
	}

	public PreferenciaVacaciones getPreferenciaVacaciones() {
		return preferenciaVacaciones;
	}

	public void setPreferenciaVacaciones(PreferenciaVacaciones preferenciaVacaciones) {
		this.preferenciaVacaciones = preferenciaVacaciones;
	}

	public int getPresupuestoMaximo() {
		return presupuestoMaximo;
	}

	public void setPresupuestoMaximo(int presupuestoMaximo) {
		this.presupuestoMaximo = presupuestoMaximo;
	}

	public boolean tienePreferencia(Lugar lugar) {
		return preferenciaVacaciones.tienePreferencia(this, lugar);
	}

	public boolean puedePagarElTour(int montoAPagar) {
		return montoAPagar <= presupuestoMaximo;
	}

	public boolean lugaresAdecuados(Lugar[] lugares) {
		return Arrays.stream(lugares).allMatch((lugar) -> this.tienePreferencia(lugar));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((preferenciaVacaciones == null) ? 0 : preferenciaVacaciones.hashCode());
		result = prime * result + presupuestoMaximo;
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
		Persona other = (Persona) obj;
		if (preferenciaVacaciones == null) {
			if (other.preferenciaVacaciones != null)
				return false;
		} else if (!preferenciaVacaciones.equals(other.preferenciaVacaciones))
			return false;
		if (presupuestoMaximo != other.presupuestoMaximo)
			return false;
		return true;
	}

}
