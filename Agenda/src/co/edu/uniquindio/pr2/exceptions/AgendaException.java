package co.edu.uniquindio.pr2.exceptions;

public class AgendaException extends Exception {

	public AgendaException() {
		this("Información importante sobre la agenda");
	}
	
	public AgendaException(String cadena) {
		super(cadena);
	}
}
