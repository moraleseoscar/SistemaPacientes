import java.io.BufferedReader;
import java.io.FileReader;
import java.util.PriorityQueue;

/**
 * @author Oscar Estrada 20565
 *
 */

public class Controlador {
	
	PriorityQueue<Paciente> pacientes = new PriorityQueue();
	
	public Controlador() {}
	
	public void readPatientList() {
		// TODO Auto-generated method stub

		String texto = new String();

		try {
			FileReader fr = new FileReader("./docs/pacientes.txt");
			BufferedReader entrada = new BufferedReader(fr); 
			String s;

			while((s = entrada.readLine()) != null) {
				String[] temp = s.split(", ");
				
			}
		}
		catch(java.io.FileNotFoundException fnfex) {
			System.out.println("Archivo no encontrado: " + fnfex);}
		catch(java.io.IOException ioex) {}
	}
	
//	public int convertirLetraNumero(String letra) {
//		switch(letra) {
//		case "A":
//			return 1;
//		case "B":
//			return 2;
//		case "C":
//			return 3;
//		case "D":
//			return 4;
//		default:
//			return 5;
//		}
//	}
//	
//	public String convertirNumeroLetra(int num) {
//		switch(num) {
//		case 1:
//			return "A";
//		case 2:
//			return "B";
//		case 3:
//			return "C";
//		case 4:
//			return "D";
//		default:
//			return "E";
//		}
//	}
}
