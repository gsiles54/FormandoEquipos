package com.unlam.escritura;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.unlam.equipo.Equipo;

public class Escritura {
	File f;
	Equipo ganador;
	public Escritura(File f,Equipo equipo) {
		this.f=f;
		ganador=equipo;
	}
	
	public void escribirResultado() {
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(f);
			bw = new BufferedWriter(fw);
			String afinidad = new String(ganador.getAfinidad().toString());
			bw.append(afinidad);
			bw.newLine();
			bw.append(ganador.getCad());
			bw.flush();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
		
				try {	
					if(fw!=null)
					fw.close();
					if(bw!=null)
			bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
	}
}
