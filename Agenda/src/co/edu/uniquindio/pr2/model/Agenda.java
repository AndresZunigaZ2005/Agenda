package co.edu.uniquindio.pr2.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

import co.edu.uniquindio.pr2.exceptions.AgendaException;
import co.edu.uniquindio.pr2.exceptions.ContactoException;
import co.edu.uniquindio.pr2.exceptions.GrupoException;

public class Agenda {

	private String nombre;
	private Contacto listaContactos[];
	private Grupo listaGrupos[];
	private Reunion listaReuniones[];
	
	public Agenda(String nombre, int numListaContactos, int numListaGrupos, int numListaReuniones) {
		super();
		this.nombre = nombre;
		this.listaContactos = new Contacto[numListaContactos];
		this.listaGrupos = new Grupo[numListaGrupos];
		this.listaReuniones = new Reunion[numListaReuniones];
	}
	
	public Agenda() {
		
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
		return "Agenda [nombre=" + nombre + ", listaContactos=" + Arrays.toString(listaContactos) + ", listaGrupos="
				+ Arrays.toString(listaGrupos) + ", listaReuniones=" + Arrays.toString(listaReuniones) + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agenda other = (Agenda) obj;
		return Objects.equals(nombre, other.nombre);
	}
	
	/*
	 * Metodos de agenda llena y huecos libres
	 */
	private void indicarAgendaLLena() throws AgendaException{
		for (int i = 0; i < listaContactos.length; i++) {
			if(listaContactos[i] != null) {
				throw new AgendaException("Todavía tiene espacio en la agenda");
			}
		}
		throw new AgendaException("La agenda esta llena");
	}
	
	private int cantidadHuecosLibres() throws AgendaException{
		int contador = 0;
		for (int i = 0; i < listaContactos.length; i++) {
			if(listaContactos[i] != null) {
				contador++;
			}
		}
		if(listaContactos.length-1 == contador) {
			throw new AgendaException("La agenda esta llena");
		}
		return contador;
	}	
	
	/*
	 * Metodos CRUD contacto
	 */
	public void agregarContacto(Contacto nuevoContacto) throws ContactoException{
		Contacto contactoEncontrado = buscarContacto(nuevoContacto);
		int posiblePosicion = 0;
		if (contactoEncontrado != null) {
			throw new ContactoException("El contacto ya existe");
		}
		posiblePosicion = obtenerPosicion();
		if(posiblePosicion == -1) {
			throw new ContactoException("Agenda llena");
		}
		listaContactos[posiblePosicion] = contactoEncontrado;
	}
	
	private int obtenerPosicion() {
		for (int i = 0; i < listaContactos.length; i++) {
			if(listaContactos[i] == null) {
				return i;
			}
		}
		return -1;
	}
	
	public void listarContactos() {
		List <Contacto> asList =Arrays.asList(listaContactos);
		asList.forEach(x -> System.out.println(x.toString()));
	}

	private Contacto buscarContacto(Contacto nuevoContacto) {
		
		List <Contacto> asList = Arrays.asList(listaContactos);
		
		Optional<Contacto> findfirst = asList.stream().filter(x -> x.equals(nuevoContacto)).findFirst();
		return findfirst.get();
	}
	
	private void eliminarContacto(String nombre, String telefono) {
		for (int i = 0; i < listaContactos.length; i++) {
			Contacto contacto = listaContactos[i];
			if(contacto.getNombre().equals(nombre) && contacto.getTelefono().equals(telefono)) {
				listaContactos[i] = null;
				break;
			}
		}
	}
	
	private boolean existeContacto(Contacto newContacto) {
		List <Contacto> asList = Arrays.asList(listaContactos);
		return asList.stream().anyMatch(x -> x.equals(newContacto));
	}
	
	public void eliminar(Contacto contacto) {
		
	}
	
	public Contacto[] obtenerContactoR() {
		
		Contacto resultado[] = new Contacto[obtenerTamanioFirstLetterContacts("R")];
		for (int i = 0; i < listaContactos.length; i++) {
			Contacto nuevoContacto = listaContactos[i];
			resultado[i] = obtenerContactoFirstLetterContacts("R", nuevoContacto);
		}
		return resultado;
	}
	
	private Contacto obtenerContactoFirstLetterContacts(String charVerify, Contacto contacto) {
		Contacto contactoLetraEncontrada = new Contacto();
		if(contacto.getNombre().startsWith(charVerify)) {
			contactoLetraEncontrada = contacto;
		}
		return contactoLetraEncontrada;
	}
	
	private int obtenerTamanioFirstLetterContacts(String charVerify) {
		List <Contacto> asList = Arrays.asList(listaContactos);
		int contador = 0;
		for (Contacto contacto : asList) {
			if(contacto.getNombre().startsWith(charVerify)); {
				contador++;
			}
		}
		return contador;
	}
	
	/*
	 * Metodos CRUD Grupo
	 */
	private void crearGrupo(Grupo nuevoGrupo) throws GrupoException{
		List <Grupo> asList = Arrays.asList(listaGrupos);
		if(asList.stream().anyMatch(x -> x.equals(nuevoGrupo))) {
			throw new GrupoException("El grupo ya existe");
		}
		int posiblePosicion = buscarEspacioLibreGrupo();
		if(posiblePosicion == -1) {
			throw new GrupoException("No hay espacio en la agenda");
		}
		listaGrupos[posiblePosicion] = nuevoGrupo;
	}
	
	private int buscarEspacioLibreGrupo() {
		for (int i = 0; i < listaGrupos.length; i++) {
			if(listaGrupos[i]!=null) {
				return i;
			}
		}
		return -1;
	}
	
	private void añadirContactoGrupo(Grupo grupo, Contacto nuevoContacto) throws GrupoException {
		grupo.aniadirContactoGrupo(nuevoContacto);
	}
	
	private void eliminarGrupo(Grupo grupoEliminado) {
		List <Grupo> asList = Arrays.asList(listaGrupos);
		asList.remove(grupoEliminado);
		listaGrupos = (Grupo[]) asList.toArray();
	}
}
