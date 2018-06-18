package com.unlam.equipo;

import java.util.ArrayList;
import java.util.List;

public class Equipo {
	private List<Integer> filas;
	private String cad;
	private Integer afinidad;
	
	public Equipo(String cad) {
		this.cad=cad;
		filas = new ArrayList<>();
		
	}
	public void agregarFila(Integer fila) {
		filas.add(fila);
		afinidad=(int) (Math.pow(cad.length(), 2)*filas.size());
	}
	public List<Integer> getFilas() {
		return filas;
	}
	public void setFilas(List<Integer> filas) {
		this.filas = filas;
	}
	public String getCad() {
		return cad;
	}
	public void setCad(String cad) {
		this.cad = cad;
	}
	public Integer getAfinidad() {
		return afinidad;
	}
}
