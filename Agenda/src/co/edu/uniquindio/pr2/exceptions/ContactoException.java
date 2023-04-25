package co.edu.uniquindio.pr2.exceptions;

public class ContactoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ContactoException() {
		this("Error al encontrar el contacto");
	}
	
	public ContactoException(String cadena) {
		super(cadena);
	}

}
