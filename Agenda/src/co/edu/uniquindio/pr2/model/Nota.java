package co.edu.uniquindio.pr2.model;

import java.util.Arrays;

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
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	public CategoriaNota getCategoriaNota() {
		return categoriaNota;
	}
	public void setCategoriaNota(CategoriaNota categoriaNota) {
		this.categoriaNota = categoriaNota;
	}
	@Override
	public String toString() {
		return "Nota [codigo=" + codigo + ", fecha=" + fecha + ", comentarios=" + comentarios + ", categoriaNota="
				+ categoriaNota + "]";
	}
	//-------------------------------------------------------------------------------------------
	/**
	 * PARCIAL II
	 */
	
	/**
	 * punto 1.B
	 * el metodo encontrarPalabrasCondicionadas retorna un arreglo con las palabras que cumplen la condicion, para ello
	 * se utiliza el metodo .split que separa el cadena que almacena los comentarios por palabras, almacenandose en un arreglo
	 * en la expresion lambda se condiciona si cada palabra inica con el caracter que se pide.
	 * @param caracterInicial
	 * @return
	 */
	
	public String[]encontrarPalabrasCondicionadas(char caracterInicial){
		
		String[]listaPalabrasNotas = comentarios.split(" ");
		return Arrays.stream(listaPalabrasNotas).filter(x->x.charAt(0)==caracterInicial).toArray(String[]::new);
	}
}
