package co.edu.uniquindio.pr2.model;

public class Nota {

	private String codigo;
	private String fecha;
	private String comentarios;
	private CategoriaNota categoriaNota;
	
	public Nota() {
		
	}
	public Nota(String codigo, String fecha, String comentarios, CategoriaNota categoriaNota) {
		super();
		this.codigo = codigo;
		this.fecha = fecha;
		this.comentarios = comentarios;
		this.categoriaNota = categoriaNota;
	}
	@Override
	public String toString() {
		return "Nota [codigo=" + codigo + ", fecha=" + fecha + ", comentarios=" + comentarios + ", categoriaNota="
				+ categoriaNota + "]";
	}
	
}
