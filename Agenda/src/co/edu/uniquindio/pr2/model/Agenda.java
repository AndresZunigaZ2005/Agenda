package co.edu.uniquindio.pr2.model;

import java.text.ParseException;
import java.util.ArrayList;
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
	
	//Para probar en el test
	public Agenda(String nombre, Contacto[] listaContactos, Grupo[] listaGrupos, Reunion[] listaReuniones) {
		super();
		this.nombre = nombre;
		this.listaContactos = listaContactos;
		this.listaGrupos = listaGrupos;
		this.listaReuniones = listaReuniones;
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
		for (Contacto contacto : asList) {
			if(contacto.equals(newContacto)) {
				return true;
			}
		}
		return false;
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
	public void crearGrupo(Grupo nuevoGrupo) throws GrupoException{
		List <Grupo> asList = Arrays.asList(listaGrupos);
		if(asList.stream().anyMatch(g -> g.equals(nuevoGrupo))) {
			throw new GrupoException("El grupo ya existe");
		}
		int posiblePosicion = buscarEspacioLibreGrupo();
		if(posiblePosicion == -1) {
			throw new GrupoException("No hay espacio en la agenda");
		}
		listaGrupos[posiblePosicion] = nuevoGrupo;
	}
	
	private boolean existeGrupo(Grupo buscarGrupo) {
		List<Grupo> asList = Arrays.asList(listaGrupos);
		return asList.stream().anyMatch(x -> x.equals(buscarGrupo));
	}
	
	private Grupo buscarGrupo(Grupo buscarGrupo) throws GrupoException{
		if(!existeGrupo(buscarGrupo)) {
			throw new GrupoException("El grupo no existe");
		}
		return buscarGrupo;
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
	
	/**
	 * contar si tiene las 5 vocales
	 * @return
	 */
	
	public Contacto[] eliminarContactosCincoVocales() {
		List<Contacto> asList =Arrays.asList(listaContactos);
		Stream<Contacto> contactos = asList.stream().filter(x -> x.encontarContactoCincoVocales());
		return listaContactos = (Contacto[]) contactos.toArray();
	}
	
	/**
	 * retornar lista de grupos con requerimentos de direccion y categoria de grupos
	 */
	
	public List<Grupo> devolverContactosDireccionCategoria(){
		List<Grupo> asList = Arrays.asList(listaGrupos);
		Stream<Grupo> grupos = asList.stream().filter(x -> x.verificarCategoria(CategoriaGrupos.OFICINA)
				&& x.verificarDireccion("calle 2 numero 18-00"));
		return asList=grupos.toList();
	}
	
	/**
	 * Retornar lista telefonos capicuas
	 */
	public String[] hallarListaTelefonoCapicua() {
		List <Contacto> asList = Arrays.asList(listaContactos);
		Stream <Contacto> ContTel = asList.stream().filter(x -> x.isCapicua());
		return (String[]) ContTel.toArray();
	}
	
	//-------------------------------------------------------------------------------
	/**
	 * PARCIAL II
	 */
	
	/**
	 * Pregunta 1.B.
	 * en el metodo encontrarPalabrasCondicionadas, retorna una lista de palabras que cumplen la condicon de iniciar
	 * por un caracter en especifico, son las palabaras encontradas en todas las reuniones de todas las notas de cada reunion,
	 * para el cual se invoca el metodo encontrarPalabrasCondicionada de la clase reunion
	 * @param caracterInicial
	 * @return
	 */
	public List<String>encontrarPalabrasCondicionada(char caracterInicial){
		List<String>listaPalabras = new ArrayList<>();
		for (Reunion reunion : listaReuniones) {
			listaPalabras.add(reunion.encontrarPalabrasCondicionada(caracterInicial).toString());
		}
		return listaPalabras;

	}
	
	/**
	 * Pregunta 2 Crea una lista de grupos que pertenecen a un grupo que se mandó por 
	 * parametro
	 * @param nuevoGrupo
	 * @return
	 * @throws GrupoException
	 */
	public Contacto[] filtrarContactos(Grupo nuevoGrupo) throws GrupoException{
		if(!existeGrupo(nuevoGrupo)) {
			throw new GrupoException("No se ha encontrado el grupo");
		}
		List <Contacto> asList = Arrays.asList(buscarGrupo(nuevoGrupo).getListaContactos());
		return (Contacto[]) asList.toArray();
	}
	
	/**
	 * Matriz de las fechas de las reuniones Pregunta 3
	 * @throws ParseException 
	 */
	public String[][] llenarMatrizFecha() throws ParseException{
		List <Reunion> lineaUno = new ArrayList<>();
		List <Reunion> lineaDos = new ArrayList<>();
		List <Reunion> lineaTres = new ArrayList<>();
		for (int i = 0; i < listaReuniones.length; i++) {
			if(listaReuniones[i].verificarFecha("30-11-2022", "01-11-2022")){
				lineaUno.add(listaReuniones[i]);
				continue;
			} else 	if(listaReuniones[i].verificarFecha("31-12-2022", "01-12-2022")){
				lineaUno.add(listaReuniones[i]);				
				continue;
			}else if(listaReuniones[i].verificarFecha("30-12-2022", "01-01-2022")){
				lineaUno.add(listaReuniones[i]);				
				continue;
			}
		}
		String [][] matriz = {(String[]) lineaUno.toArray(), 
				(String[]) lineaDos.toArray(), (String[]) lineaTres.toArray()};
		return matriz;
	}
	
	/**
	 * punto 4
	 * el metodo encontrarGrupos, recorre la lista de grupos, y llena un arrayList con grupos, cada grupo se crea a partir
	 * de los contactos que cumplen la condicion del prefijo de cada Grupo existenete en la listaGrupos, mediante la invocación
	 * del metodo crearGrupoCondicionado y la iteracion del foreach sobre la listaGrupos
	 * @param prefijo
	 * @return
	 */

	public List<Grupo>encontrarGrupos(String prefijo){
		List<Grupo>listaGruposCondicionado = new ArrayList<>();
		for (Grupo grupo : listaGrupos) {
			listaGruposCondicionado.add(crearGrupoCondicionado(prefijo, grupo));
		}
		return listaGruposCondicionado;
	}

	/**
	 * Punto 4
	 * el metodo crearGrupoCondicionado retorna un Grupo, que el mismo crea, donde solo existen los contactos
	 * que cumplen con la condicion del perfijo en su numero de telefono, invocando al metodo encontrarContactosCondicionado
	 * @param prefijo
	 * @param grupo1
	 * @return
	 */

	public Grupo crearGrupoCondicionado(String prefijo, Grupo grupo1){
		Grupo grupo= new Grupo(null, grupo1.encontrarContactosCondicionado(prefijo), null);
		return grupo;
	}
}
