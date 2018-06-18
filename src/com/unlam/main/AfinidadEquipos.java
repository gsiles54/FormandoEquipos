package com.unlam.main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.unlam.equipo.Equipo;
import com.unlam.escritura.Escritura;
import com.unlam.lectura.Lectura;

public class AfinidadEquipos {

	List<String> respuestas;
	Integer cantPreguntas;
	Integer cantColaboradores;
	List<Equipo> listaEquipos;
	
	public AfinidadEquipos(List<String> respuestas,Integer cantPreguntas,Integer cantColaboradores) {
		this.respuestas=respuestas;
		this.cantColaboradores=cantColaboradores;
		this.cantPreguntas=cantPreguntas;
		listaEquipos = new ArrayList<>();
	}
	
	
	public void resolverEjercicio() {
		
		/*for(int i = 0 ; i<cantColaboradores ; i++) {
			String valorActual = respuestas.get(i).substring(0, 1);
			for(int j = i+1; j<cantColaboradores ; j++) {
				String valorSig = respuestas.get(j).substring(0,1);
				if(valorActual.equals(valorSig)) {
					if(listaEquipos.isEmpty()) {
						Equipo eq = new Equipo(valorActual);
						eq.agregarFila(i);
						eq.agregarFila(j);
						listaEquipos.add(eq);
					}else {
						
						agregarFilaEnEquipo(valorActual,j);
							
					}
					
				}
			}
		}*/
		for(int k = 0 ; k<cantPreguntas ; k++) {
			for(int i = 0; i<cantColaboradores ; i++) {
				String valorActual = respuestas.get(i).substring(0, k+1);
				
				for(int j = i +1 ;j<cantColaboradores ;j++) {
					String valorSig = respuestas.get(j).substring(0,k+1);
					if(valorActual.equals(valorSig)) {
						if(listaEquipos.isEmpty()||!existeValorDeEquipo(valorActual)) {
							Equipo eq = new Equipo(valorActual);
							eq.agregarFila(i);
							eq.agregarFila(j);
							listaEquipos.add(eq);
						}else {
							
							agregarFilaEnEquipo(valorActual,j);
								
						}
						
					}
				}
			}
		}
		
		for(Equipo e: listaEquipos) {
			System.out.println(e.getCad() + "  " + e.getAfinidad());
		}
		System.out.println("------------------------------------");
	}
	public Equipo reclamar4() {
		Integer afinMax;
		if(listaEquipos.isEmpty()) {
			return null;
		}
		afinMax=listaEquipos.get(0).getAfinidad();
		Equipo ganador=null;
		for(Equipo e: listaEquipos) {
			if(e.getAfinidad()>=afinMax) {
				afinMax=e.getAfinidad();
				ganador = e;
			}
		}
		
		return ganador;
	}
	private boolean existeValorDeEquipo(String valor) {
		
		for(Equipo e : listaEquipos) {
			if(e.getCad().equals(valor)) {
				return true;
			}
		}
		return false;
	}
	private void agregarFilaEnEquipo(String valor,Integer j) {
		for(Equipo e : listaEquipos) {
			if(e.getCad().equals(valor)) {
				if(!e.getFilas().contains(j)) {
					e.agregarFila(j);
				}
			}		
		}
	}
	public static void main(String[]args ) {
		File f = new File("entrada.in");
		Lectura lectura = new Lectura(f);
		lectura.leerEntrada();
		AfinidadEquipos afinidad = new AfinidadEquipos(lectura.getRespuestas(),lectura.getCantPreguntas(), lectura.getCantColaboradores());
		afinidad.resolverEjercicio();
		Equipo ganador = afinidad.reclamar4();
		if(ganador==null) {
			System.out.println("No hay equipos");
		}else {
			System.out.println("gana el equipo con afinidad:" +ganador.getAfinidad());
			System.out.println("con la cadena:" +ganador.getCad());
		}
		File salida = new File("salida.out");
		Escritura esc = new Escritura (salida, ganador);
		esc.escribirResultado();
	}
}
