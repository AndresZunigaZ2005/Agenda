package co.edu.uniquindio.pr2.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Reunion {

	private String descripcion;
	private String fecha;
	private String hora;
	private Contacto listaContactos[];
	private Nota listaNotas[];
	
	public Reunion() {
		// TODO Auto-generated constructor stub
	}

	public Reunion(String descripcion, String fecha, String hora, int numListaContactos, int nota) {
		super();
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.hora = hora;
		this.listaContactos = new Contacto[numListaContactos];
		this.listaNotas = new Nota[nota];
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Contacto[] getListaContactos() {
		return listaContactos;
	}

	public void setListaContactos(Contacto[] listaContactos) {
		this.listaContactos = listaContactos;
	}
		
	public Nota[] getListaNotas() {
		return listaNotas;
	}

	public void setListaNotas(Nota[] listaNotas) {
		this.listaNotas = listaNotas;
	}
	
	@Override
	public String toString() {
		return "Reunion [descripcion=" + descripcion + ", fecha=" + fecha + ", hora=" + hora + ", listaContactos="
				+ Arrays.toString(listaContactos) + ", listaNotas=" + Arrays.toString(listaNotas) + "]";
	}
	//-----------------------------------------------------------------------------
	/**
	 * PARCIAL II
	 */

	/**
	 * punto 1.B. 
	 * el metodo encontrarPalabrasCondicionada recorre la lista de notas de la reunion, buscando aquellas palabras que cumplen la 
	 * condicion, gracias a la invocacion del metodo encontrarPalabrasCondicionada de la clase Nota, el metodo retorna un arrayList 
	 * con las palabras
	 * @param caracterInicial
	 * @return
	 */
	
	public List<String>encontrarPalabrasCondicionada(char caracterInicial){
		List<String>listaPalabras = new ArrayList<>();
		for ( Nota nota : listaNotas) {
			listaPalabras.add(nota.encontrarPalabrasCondicionadas(caracterInicial).toString());
		}
		return listaPalabras;
	}

	/**
	 * verificar si una fecha de una reunion esta en el intervalo necesario PREGUNTA 3
	 * @throws ParseException 
	 */
	public boolean verificarFecha(String limiteMayor, String limiteMenor) throws ParseException {
		SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
		Date fechaLimiteMayor = date.parse(limiteMayor);
		Date fechaLimiteMenor = date.parse(limiteMenor);
		Date fechaReunion = date.parse(getFecha());
		if(fechaReunion.after(fechaLimiteMenor) && fechaReunion.before(fechaLimiteMayor)) {
			return true;
		}
		return false;
	}
}
