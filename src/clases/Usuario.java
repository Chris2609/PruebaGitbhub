package clases;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

 
public class Usuario {

		private int id;
		private String nombre;
		private String apellido;
		private String nombreUsuario;
		private String contrasenia;
		private boolean activo;
		
		public Usuario(int id, String nombre, String apellido, String nombreUsuario, String contrasenia, boolean activo) {
			this.id = id;
			this.nombre = nombre;
			this.apellido = apellido;
			this.nombreUsuario = nombreUsuario;
			this.contrasenia = contrasenia;
			this.activo = activo;
		}
		
		public Usuario() {
			
		}
		
		public static ArrayList<Usuario> cargarUsuarios (String nombreFichero) throws FileNotFoundException{
			//importante esto es importante importantisimo
			ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
			
			File fichero = new File(nombreFichero);
			Scanner scan = new Scanner(fichero);
			
			//String[] linea;
			String linea;
			String[] partes;
			Usuario usuario;
			
			while(scan.hasNextLine()) {
				linea = scan.nextLine();
				partes = linea.split(":");
				
				usuario = new Usuario();
				usuario.setId(Integer.parseInt(partes[0]));
				usuario.setNombre(partes[1]);
				usuario.setApellido(partes[2]);
				usuario.setNombreUsuario(partes[3]);
				usuario.setContrasenia(partes[4]);
				boolean activo;
				if(partes[5].equals("0")) {
					activo = false;
				}else {
					activo = true;
				}
				usuario.setActivo(activo);
				
				usuarios.add(usuario);
				
				//linea = scan.nextLine().split(":");
				
				//usuario = new Usuario(Integer.parseInt(linea[0]), linea[1], linea[2], linea[3], linea[4], Boolean.parseBoolean(linea[5]));
				//usuarios.add(usuario);
				
			}
			
			return usuarios;
		}

		
		public static void  guardarUsuarios(String  nombreFichero, ArrayList<Usuario> usuarios) throws FileNotFoundException {
			
			PrintWriter writer = new PrintWriter(nombreFichero);
			for (Usuario usuario : usuarios) {
				writer.println(usuario.enFormatoFichero());
			}
			writer.close();
		}
		
		private String enFormatoFichero() {
			String archivoString="";
			if(activo == false) {
			archivoString = this.id + ":" + this.nombre + ":" + this.apellido + ":" + this.nombreUsuario + ":" + this.contrasenia + ":" + "0";
			}else {
			archivoString = this.id + ":" + this.nombre + ":" + this.apellido + ":" + this.nombreUsuario + ":" + this.contrasenia + ":" + "1";
			}
		
			return archivoString;
		}
		
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getApellido() {
			return apellido;
		}
		public void setApellido(String apellido) {
			this.apellido = apellido;
		}
		public String getnombreUsuario() {
			return nombreUsuario;
		}
		public void setNombreUsuario(String nombreUsuario) {
			this.nombreUsuario = nombreUsuario;
		}
		public String getContrasenia() {
			return contrasenia;
		}
		public void setContrasenia(String contrasenia) {
			this.contrasenia = contrasenia;
		}
		public boolean isActivo() {
			return activo;
		}
		public void setActivo(boolean activo) {
			this.activo = activo;
		}
		
		public String mostrar(ArrayList<Usuario> usuarios) {
			String lista;
			lista=this.id + " - " + this.nombre + " - " + this.apellido + " - " + this.nombreUsuario + " - " + this.contrasenia + " - " + this.activo + "\n";
			return lista;
		}
}
