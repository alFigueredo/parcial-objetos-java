package com.example.parcial_objetos;

import java.time.LocalDate;
import java.util.ArrayList;

import com.example.parcial_objetos.lugar.Lugar;
import com.example.parcial_objetos.persona.Persona;

public class Tour {

	private final LocalDate fechaSalida;
	private final int cantPersonasRequeridas;
	private final Lugar[] listaLugares;
	private final int montoAPagarPorPersona;
	private final ArrayList<Persona> personas;

	public Tour(LocalDate fechaSalida, int cantPersonasRequeridas, Lugar[] listaLugares, int montoAPagarPorPersona,
			ArrayList<Persona> personas) {
		this.fechaSalida = fechaSalida;
		this.cantPersonasRequeridas = cantPersonasRequeridas;
		this.listaLugares = listaLugares;
		this.montoAPagarPorPersona = montoAPagarPorPersona;
		this.personas = personas;
	}

	public void agregarPersona(Persona persona) {
		this.validarPersonaAdecuada(persona);
		this.incorporarPersona(persona);
	}

	private void incorporarPersona(Persona persona) {
		this.validarTourNoConfirmado();
		personas.add(persona);
	}

	private void validarPersonaAdecuada(Persona persona) {
		assert persona.puedePagarElTour(montoAPagarPorPersona) : "La persona no posee el presupuesto suficiente";
		assert persona.lugaresAdecuados(listaLugares) : "No todos los lugares son adecuados para la persona";
	}

	private void validarTourNoConfirmado() {
		assert !this.tourConfirmado() : "El tour ya se encuentra confirmado, no se puede incorporar más gente";
	}

	public boolean tourConfirmado() {
		return personas.size() == cantPersonasRequeridas;
	}

	public void desvincularPersona(Persona persona) {
		personas.remove(persona);
	}

	public boolean saleEsteAnio() {
		return fechaSalida.getYear() == LocalDate.now().getYear();
	}

	public int montoTour() {
		return montoAPagarPorPersona * personas.size();
	}

}
