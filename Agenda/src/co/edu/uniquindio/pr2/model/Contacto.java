package co.edu.uniquindio.pr2.model;

import java.util.Arrays;
import java.util.Objects;

public class Contacto {

	private String nombre;
	private String alias;
	private String direccion;
	private String telefono;
	
	private Grupo listaGrupos[];
	private Reunion listaReuniones[];
	
	
	public Contacto() {
		// TODO Auto-generated constructor stub
	}
	
	public Contacto(String nombre, String alias, String direccion, String telefono, int numListaGrupos,
			int numListaReuniones) {
		super();
		this.nombre = nombre;
		this.alias = alias;
		this.direccion = direccion;
		this.telefono = telefono;
		this.listaGrupos = new Grupo[numListaGrupos];
		this.listaReuniones = new Reunion[numListaReuniones];
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getAlias() {
		return alias;
	}


	public void setAlias(String alias) {
		this.alias = alias;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public Grupo[] getListaGrupos() {
		return listaGrupos;
	}


	public void setListaGrupos(Grupo[] listaGrupos) {
		this.listaGrupos = listaGrupos;
	}


	public Reunion[] getListaReuniones() {
		return listaReuniones;
	}


	public void setListaReuniones(Reunion[] listaReuniones) {
		this.listaReuniones = listaReuniones;
	}


	@Override
	public String toString() {
		return "Contacto [nombre=" + nombre + ", alias=" + alias + ", direccion=" + direccion + ", telefono=" + telefono
				+ ", listaGrupos=" + Arrays.toString(listaGrupos) + ", listaReuniones="
				+ Arrays.toString(listaReuniones) + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(nombre, telefono);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contacto other = (Contacto) obj;
		return Objects.equals(nombre, other.nombre) && Objects.equals(telefono, other.telefono);
	}
	
	/**
	 * verificar si tiene las 5 vocales
	 * @return
	 */
	public boolean encontarContactoCincoVocales() {
		int A,E,I,O,U;
		A=0;
		E=0;
		I=0;
		O=0;
		U=0;
		for (int i = 0; i < nombre.length(); i++) {
			if(isVocalA(nombre.charAt(i))) {
				A++;
				continue;
			}
			if(isVocalE(nombre.charAt(i))) {
				I++;
				continue;
			}
			if(isVocalI(nombre.charAt(i))) {
				E++;
				continue;
			}
			if(isVocalO(nombre.charAt(i))) {
				O++;
				continue;
			}
			if(isVocalU(nombre.charAt(i))) {
				U++;
				continue;
			}
		}
		if(A>0 && E>0 && I>0 && O>0 && U>0) {
			return true;
		}
		return false;
	}
	
	public boolean isVocalA(char charName) {
		if(charName == 'A' || charName == 'a'){
			return true;
		}
		return false;
	}
	
	public boolean isVocalE(char charName) {
		if(charName == 'E' || charName == 'e'){
			return true;
		}
		return false;
	}
	
	public boolean isVocalI(char charName) {
		if(charName == 'I' || charName == 'i'){
			return true;
		}
		return false;
	}
	
	public boolean isVocalO(char charName) {
		if(charName == 'O' || charName == 'o'){
			return true;
		}
		return false;
	}
	
	public boolean isVocalU(char charName) {
		if(charName == 'U' || charName == 'u'){
			return true;
		}
		return false;
	}
	
	/**
	 * verificar direccion
	 * @param nuevaDireccion
	 * @return
	 */
	
	public boolean verificarDireccion(String nuevaDireccion) {
		if(direccion.equals(nuevaDireccion)) {
			return true;
		}
		return false;
	}
}
