/**
 * @author Oscar Estrada 20565
 *
 */
public class Paciente implements Comparable<Paciente>{
	private String nombre;
	private String descripcion;
	private String prioridad;
	
	/**
	 * @param nombre
	 * @param descripcion
	 * @param prioridad
	 */
	public Paciente(String nombre, String descripcion, String prioridad) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.prioridad = prioridad;
	}
	
	
	/** 
	 * Devuelve la prioridad de un paciente
	 * @return String
	 */
	public String getPrioridad() {
		return this.prioridad;
	}

	
	/** 
	 * Sistema para comparacion y revisar quien va primero con respecto a su letra de prioridad
	 * @param o
	 * @return int
	 */
	@Override
	public int compareTo(Paciente o) {
		// TODO Auto-generated method stub
		int compare = this.prioridad.compareTo(o.prioridad); //Este compareTo no es de recursividad, es de la libreria String.
		if (compare == 0){
            return 0;
        }else if (compare > 0){
            return 1;
        }else{
            return -1;
        }
	}

	
	/** 
	 * To String para imprimir a los pacientes
	 * @return String
	 */
	@Override
	public String toString() {
		return "Paciente: " + nombre + " | Descripcion: " + descripcion + " | Prioridad: " + prioridad;
	}
}
