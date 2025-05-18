package com.example.parcial_objetos;

import java.util.Arrays;

public class Reporte {

	private final Tour[] tours;

	public Reporte(Tour[] tours) {
		this.tours = tours;
	}

	public Tour[] toursPendientesDeConfirmacion() {
		return Arrays.stream(tours).filter((tour) -> !tour.tourConfirmado()).toArray(Tour[]::new);
	}

	public int montoTotalToursEsteAnio() {
		return this.montoTotal(this.toursQueSalenEsteAnio());
	}

	private Tour[] toursQueSalenEsteAnio() {
		return Arrays.stream(tours).filter((tour) -> tour.saleEsteAnio()).toArray(Tour[]::new);
	}

	private int montoTotal(Tour[] coleccionTours) {
		return Arrays.stream(coleccionTours).reduce(0, (monto, tour) -> monto + tour.montoTour(), Integer::sum);
	}

}
