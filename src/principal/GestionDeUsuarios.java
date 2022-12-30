package principal;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.*;

import clases.Usuario;

/**
 * 
 * @author Christian Camarasa
 *
 */

public class GestionDeUsuarios {

	//funcion para contar las lineas del fichero automaticamente

	
	public static void main(String[] args) throws FileNotFoundException {
//		final String fichero = "datos/usuarios.txt";
//		ArrayList<Usuario> usuarios = Usuario.cargarUsuarios(fichero);
		
		final String NOMBRE_FICHERO = "datos/usuarios.txt";
		//cargar datos en un arraylist
		ArrayList<Usuario> usuarios = Usuario.cargarUsuarios(NOMBRE_FICHERO);
		
		//el programa principal
		final int mostrarU = 1;
		final int eliminarU = 2;
		final int crearU = 3;
		final int modificarU = 4;
		int opcion_menu;
		
		do {
			opcion_menu = Integer.parseInt(JOptionPane.showInputDialog(null,
					"------MENU-------\n" + mostrarU + ". Mostrar usuarios\n" + eliminarU + ". Eliminar usuario\n"
							+ crearU + ". Crear usuario\n" + modificarU + ". Modificar usuario\n"  + "0. Salir\n" ));
			
			
			switch (opcion_menu) {
			case mostrarU:	
				String mensaje="";
				for(int i = 0; i < usuarios.size(); i++) {
		            mensaje=mensaje + usuarios.get(i).getId() + " - " + usuarios.get(i).getNombre()+ " - " + usuarios.get(i).getApellido() + " - " + usuarios.get(i).getnombreUsuario() + " - " + usuarios.get(i).isActivo() +"\n";
				}
				JOptionPane.showMessageDialog(null, mensaje);
				break;
			case eliminarU:
				String usuarioEliminar = (JOptionPane.showInputDialog(null, "Introduce el usuario que quieres eliminar"));
				for (int i = 0; i < usuarios.size(); i++) {
					if(usuarioEliminar.equals(usuarios.get(i).getnombreUsuario())) {
						usuarios.remove(i);
					}
				}
				break;
			case crearU:
				
				int nuevoID = usuarios.size() + 1;
				String nuevoNombre = (JOptionPane.showInputDialog(null, "Introduce el nombre"));
				String nuevoApellido = (JOptionPane.showInputDialog(null, "Introduce el apellido"));
				String nuevoUsuario = (JOptionPane.showInputDialog(null, "Introduce el nombre de usuario"));
				String nuevaContraseña = (JOptionPane.showInputDialog(null, "Introduce la contraseña del usuario"));
				
				
				Usuario usuarioNuevo = new Usuario(nuevoID, nuevoNombre, nuevoApellido, nuevoUsuario, nuevaContraseña, true);
				
				usuarios.add(usuarioNuevo);
				
				
				break;
				
			case modificarU:
				boolean encontrado = false;
				
				String usuarioModificar = JOptionPane.showInputDialog(null, "Introduce el usuario que quieres modificar");

				for (int i = 0; i < usuarios.size(); i++) {

					if(usuarioModificar.equals(usuarios.get(i).getnombreUsuario())) {
						encontrado = true;
						String nuevonombre = JOptionPane.showInputDialog(null, "Introduce el nuevo nombre");
						String nuevoapellido = JOptionPane.showInputDialog(null, "Introduce el nuevo apellido");
						String nombreusuariomod = JOptionPane.showInputDialog(null, "Introduce el nuevo nombre de usuario");
						String nuevacontra = JOptionPane.showInputDialog(null, "Introduce la nueva contraseña");
						
					
					Usuario usuariomodificado= new Usuario (usuarios.get(i).getId(),nuevonombre,nuevoapellido,nombreusuariomod,nuevacontra, true);
					usuarios.set(i, usuariomodificado);
					 }
				}
				
				if(!encontrado) {
					JOptionPane.showMessageDialog(null, "El usuario no se ha encontrado");
					break;
				}
			
				break;
				
			case 0:
				JOptionPane.showMessageDialog(null, "Saliendo");
				break;
			}
	
		} while (opcion_menu != 0);
		
		
		
		//guardar datos del arraylist en el fichero
		Usuario.guardarUsuarios(NOMBRE_FICHERO, usuarios);
		

		
		
		
	}
}
