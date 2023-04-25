package co.edu.uniquindio.pr2.exceptions;

public class GrupoException extends Exception {

	public GrupoException() {
		this("Error al crear el grupo");
	}
	
	public GrupoException(String cadena) {
		super(cadena);
	}
}
