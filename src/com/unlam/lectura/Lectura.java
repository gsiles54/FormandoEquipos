package com.unlam.lectura;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Lectura {

	File f;
	Integer cantPreguntas;
	Integer cantColaboradores;
	List<String> respuestas;
	
	public Lectura(File f){
		this.f=f;
		respuestas= new ArrayList<>();
	}
	
	public void leerEntrada() {
		FileReader fr =null;
		BufferedReader br=null;
		
		
		try {
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			String linea;
			linea=br.readLine();
			cantPreguntas=Integer.valueOf(linea);
			cantColaboradores=Integer.valueOf(br.readLine());
			while((linea=br.readLine())!=null) {
				respuestas.add(linea);
			}
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}

	public Integer getCantPreguntas() {
		return cantPreguntas;
	}

	public Integer getCantColaboradores() {
		return cantColaboradores;
	}

	public List<String> getRespuestas() {
		return respuestas;
	}
}
