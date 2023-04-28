package co.edu.uniquindio.pr2.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

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

	/**
	 * verificar si una fecha de una reunion esta en el intervalo necesario
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
