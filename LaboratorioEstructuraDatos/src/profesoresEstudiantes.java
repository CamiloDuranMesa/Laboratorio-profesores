import java.util.ArrayList;

import javax.swing.JOptionPane;

public class profesoresEstudiantes {
	

		ArrayList<String> listaProfesores;
		ArrayList<String> listaEstudiantes;
		ArrayList<ArrayList<String>> listaGeneralEstudiantes;
		
		
		
		public profesoresEstudiantes() {
			listaProfesores = new ArrayList<>();
			listaGeneralEstudiantes=new ArrayList<>();
		}
		
		public void iniciar() {
			
			

            System.out.print("Selecciona una opción: ");
			int selección = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su elección del menú:"
					+ "\n1. Registrar profesores"
					+ "\n2. Registrar estudiantes"
					+ "\n3. Consultar lista de profesores y lista de estudiantes"
					+ "\n4. Consultar profesores por nombre"
					+ "\n5. Consultar cantidad de estudiante por profesor"
					+ "\n6. Consultar estudiantes"
					+ "\n7. Salir"));;
			do {
				switch(selección) {
				case 1:
					registrarProfesores();
				break;
				case 2:
					registrarEstudiantes();
				break;
				case 3:
					consultarListaProfesoresYEstudiantes();
				break;
				case 4:
					consultarProfesoresPorNombre();
				break;
				case 5:
					consultarCantidadEstudiantesPorProfesor();
				break;
				case 6:
					consultarEstudiantes();
				break;
				case 7:
					System.out.println("\nEsta saliendo de la pagina.");
				break;
				default:
					System.out.println("\nLa opción seleccionada no esta disponible");
				break;
				
				}
	
			}while(selección != 7);
			

		}
		
		public void registrarProfesores() {
			System.out.println("\n<Registro profesores>");
			int cant=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de profesores"));
			
			for (int i = 0; i < cant; i++) {
				String nombreProfesor=JOptionPane.showInputDialog("nombre profesor "+ (i+1));
				listaProfesores.add(nombreProfesor);
			}
			System.out.println("Registro de profesores Exitoso!\n");
			iniciar();
		}
		
		public void registrarEstudiantes() {
			System.out.println("\n <Registro estudiantes>");
			for (int i = 0; i < listaProfesores.size(); i++) {
				JOptionPane.showInputDialog("Ingrese los estudiantes para el profesor"+listaProfesores.get(i));
				
				listaEstudiantes=new ArrayList<String>();
				
				int cant=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de estudiantes"));
				
				for (int j = 0; j < cant; j++) {
					String nombreEst = JOptionPane.showInputDialog("nombre estudiante "+(j+1));
					listaEstudiantes.add(nombreEst);
				}
				listaGeneralEstudiantes.add(listaEstudiantes);
			}
			System.out.println("Registro de estudiantes Exitoso!\n");
			iniciar();
		}
		
		public void consultarListaProfesoresYEstudiantes() {
			System.out.println("\n<Lista de profesores y Estudiantes>");
			
			for (int i = 0; i < listaGeneralEstudiantes.size(); i++) {
				
				System.out.println("Profesor: "+listaProfesores.get(i)+" = ");
				System.out.println("[");
				for (int j = 0; j < listaGeneralEstudiantes.size(); j++) {
					System.out.println(listaGeneralEstudiantes.get(j));
					if(j<listaGeneralEstudiantes.size()) {
						System.out.println(",");
					}
				}
				System.out.println("]\n");
				iniciar();
			}
		}
		
		public void consultarProfesoresPorNombre() {
			System.out.println("\n<Consulta de profesores>\n");
			String nombre = JOptionPane.showInputDialog("Ingrese el nombre del profesor");
			
			if(listaProfesores.contains(nombre)) {
				int posicion = listaProfesores.indexOf(nombre);
				ArrayList<String> listaTemporal = listaGeneralEstudiantes.get(posicion);
				
				System.out.println("Profesor: "+nombre+" = ");
				System.out.println("[");
				for (int i = 0; i < listaTemporal.size(); i++) {
					System.out.println(listaTemporal.get(i));
					if(i<listaTemporal.size()-1) {
						System.out.println(",");
					}
				}
				System.out.println("]\n");
				iniciar();
			}else {
				System.out.println("No se encuentra el profesor "+nombre+"\n");
				iniciar();
			}
			
		}
		
		public void consultarCantidadEstudiantesPorProfesor() {
		System.out.println("\n<Consulta cantidad de estudiantes de Profesores> \n");
		String nombre = JOptionPane.showInputDialog("Ingrese el nombre del profesor para saber la cantidad de estudiantes asociados");
		
		if(listaProfesores.contains(nombre)) {
			int posicion=listaProfesores.indexOf(nombre);
			ArrayList <String> listaTemp = listaGeneralEstudiantes.get(posicion);
			System.out.println("La cantidad de estudiantes asociados al profesor "+nombre+""
					+ " es "+listaTemp.size()+"\n");
			iniciar();
		}else {
			System.out.println("No se encuentra el profesor "+nombre+"\n");
			iniciar();
		}
		}
		
		public void consultarEstudiantes() {
			
			System.out.println("\n<Consulta de estudiantes");
			ArrayList<String> listaTemp;
			
			String nombre= JOptionPane.showInputDialog("Ingrese el nombre del estudiantes");
			
			for (int i = 0; i < listaGeneralEstudiantes.size(); i++) {
				listaTemp = listaGeneralEstudiantes.get(i);
				
				if(listaTemp.contains(nombre)) {
					for (int j = 0; j < listaTemp.size(); j++) {
						if(listaTemp.get(j).equalsIgnoreCase(nombre)) {
						System.out.println("Encuentra al nombre: "+nombre+"pertenece al"
								+ "grupo de "+listaProfesores.get(i)+"\n");	
							iniciar();
						}
						
					}
				}else {
					System.out.println("No se encuentra el nombre en el grupo de "+listaProfesores.get(i)+"\n");
					iniciar();
					
				}
			}
		}
		
}
