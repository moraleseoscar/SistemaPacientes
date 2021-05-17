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
	
	public String getPrioridad() {
		return this.prioridad;
	}

	@Override
	public int compareTo(Paciente o) {
		// TODO Auto-generated method stub
		int compare = this.prioridad.compareTo(o.prioridad);
		if (compare == 0){
            return 0;
        }else if (compare > 0){
            return 1;
        }else{
            return -1;
        }
	}

	@Override
	public String toString() {
		return "Paciente [nombre=" + nombre + ", descripcion=" + descripcion + ", prioridad=" + prioridad + "]";
	}
}
