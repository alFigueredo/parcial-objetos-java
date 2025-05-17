package com.example.parcial_objetos;

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
		return montoAPagar <= this.presupuestoMaximo;
	}

	public boolean lugaresAdecuados(Lugar[] lugares) {
		for (Lugar lugar : lugares) {
			if (!this.tienePreferencia(lugar))
				return false;
		}
		return true;
	}

}
