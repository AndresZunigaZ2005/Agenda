package co.edu.uniquindio.pr2.model;

import java.util.Arrays;

public class Reunion {

	private String descripcion;
	private String fecha;
	private String hora;
	private Contacto listaContactos[];
	private Nota nota;
	
	public Reunion() {
		// TODO Auto-generated constructor stub
	}

	public Reunion(String descripcion, String fecha, String hora, int numListaContactos, Nota nota) {
		super();
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.hora = hora;
		this.listaContactos = new Contacto[numListaContactos];
		this.nota = nota;
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

	public Nota getNota() {
		return nota;
	}

	public void setNota(Nota nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "Reunion [descripcion=" + descripcion + ", fecha=" + fecha + ", hora=" + hora + ", listaContactos="
				+ Arrays.toString(listaContactos) + ", nota=" + nota + "]";
	}

}
