import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author Oscar Estrada 20565
 *
 */
public class SistemaPacientes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Controlador con = new Controlador();
		Scanner sc = new Scanner(System.in);
		
		PriorityQueue<Paciente> pacientePri = new PriorityQueue<>();
		VectorHeap<Paciente> pacienteVec = new VectorHeap<Paciente>();
		
		boolean menu = true;
		
        while(menu) {
        	System.out.println("");
        	System.out.println("+---------------------------------------------+");
            System.out.println("|          Seleccion de PriorityQueue         |");
            System.out.println("+---------------------------------------------+");
            System.out.println("");
            System.out.println("1. ADT PriorityQueue.");
            System.out.println("2. VectorHeap.");
            System.out.println("0. Salir.");
            System.out.println("");
            System.out.print("Escriba el numero de su seleccion: ");
            int sel = sc.nextInt();
            sc.nextLine();
            while(sel < 0 || sel > 2) {
            	System.out.print("Seleccion fuera de rango. Intente de nuevo:");
                sel = sc.nextInt();
                sc.nextLine();
    		}
            
            if(sel == 1) {
            	con.readPatientList(1);
            	pacientePri = con.getPacientesPri();
            	int turno = 1;
            	while(!pacientePri.isEmpty()) {
            		System.out.println("Turno "+turno+" >>>"+ pacientePri.remove());
            		turno += 1;
            	}
            }else if(sel == 2) {
            	con.readPatientList(2);
            	pacienteVec = con.getPacientesVec();
            	int turno = 1;
            	while(!pacienteVec.isEmpty()) {
            		System.out.println("Turno "+turno+" >>>"+ pacienteVec.remove());
            		turno += 1;
            	}
            }else {
            	System.out.println("Cerrando programa...");
            	menu = false;
            }
        }
		
		
		
	}

}
