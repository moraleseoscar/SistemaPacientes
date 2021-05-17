import java.io.BufferedReader;
import java.io.FileReader;
import java.util.PriorityQueue;

/**
 * @author Oscar Estrada 20565
 *
 */

public class Controlador {
	
	PriorityQueue<Paciente> pacientesPri = new PriorityQueue<>();
	VectorHeap<Paciente> pacientesVec = new VectorHeap<Paciente>();
	
	public Controlador() {
	}
	
	
	/** 
	 * Solicita el tipo para saber que PriorityQueue llenar
	 * @param typeQueue
	 */
	public void readPatientList(int typeQueue) {
		// TODO Auto-generated method stub

		String texto = new String();

		try {
			FileReader fr = new FileReader("./docs/pacientes.txt");
			BufferedReader entrada = new BufferedReader(fr); 
			String s;

			while((s = entrada.readLine()) != null) {
				String[] temp = s.split(", ");
				Paciente pac = new Paciente(temp[0], temp[1], temp[2]);
				if(typeQueue == 1) {
					pacientesPri.add(pac);
				}else {
					pacientesVec.add(pac);
				}
			}
		}
		catch(java.io.FileNotFoundException fnfex) {
			System.out.println("Archivo no encontrado: " + fnfex);}
		catch(java.io.IOException ioex) {}
	}
	
	
	/** 
	 * Devuelve la lista por medio de PriorityQueue
	 * @return PriorityQueue<Paciente>
	 */
	public PriorityQueue<Paciente> getPacientesPri(){
		return pacientesPri;
	}
	
	
	/** 
	 * Devuelve la lista por medio del VectorHeap.
	 * @return VectorHeap<Paciente>
	 */
	public VectorHeap<Paciente> getPacientesVec(){
		return pacientesVec;
	}
}
