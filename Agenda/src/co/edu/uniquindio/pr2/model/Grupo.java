package co.edu.uniquindio.pr2.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

import co.edu.uniquindio.pr2.exceptions.GrupoException;

public class Grupo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private Contacto listaContactos[];
	private CategoriaGrupos categoria;
	
	
	public Grupo(String nombre, int numListaContactos, CategoriaGrupos categoria) {
		super();
		this.nombre = nombre;
		this.listaContactos = new Contacto[numListaContactos];
		this.categoria = categoria;
	}
	
	public Grupo() {
		
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Contacto[] getListaContactos() {
		return listaContactos;
	}


	public void setListaContactos(Contacto[] listaContactos) {
		this.listaContactos = listaContactos;
	}


	public CategoriaGrupos getCategoria() {
		return categoria;
	}


	public void setCategoria(CategoriaGrupos categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Grupo [nombre=" + nombre + ", listaContactos=" + Arrays.toString(listaContactos) + ", categoria="
				+ categoria + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(listaContactos);
		result = prime * result + Objects.hash(categoria, nombre);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grupo other = (Grupo) obj;
		return categoria == other.categoria && Arrays.equals(listaContactos, other.listaContactos)
				&& Objects.equals(nombre, other.nombre);
	}
	
	public int verificarPosicionDisponible() {
		for (int i = 0; i < listaContactos.length; i++) {
			if(listaContactos[i] == null) {
				return i;
			}
		}
		return -1;
	}
	
	public void aniadirContactoGrupo(Contacto nuevoContacto) throws GrupoException {
		for (Contacto contacto : listaContactos) {
			if(contacto.equals(nuevoContacto)) {
				throw new GrupoException("El contacto ya está en el grupo");
			}
		}
		listaContactos[verificarPosicionDisponible()] = nuevoContacto;
	}
	
	public boolean verificarCategoria(CategoriaGrupos nuevoCategoria) {
		if(categoria.equals(nuevoCategoria)) {
			return true;
		}
		return false;
	}
	
	public boolean verificarDireccion(String nuevaDireccion) {
		for (Contacto contacto : listaContactos) {
			contacto.verificarDireccion(nuevaDireccion);
		}
		return false;
	}
}
