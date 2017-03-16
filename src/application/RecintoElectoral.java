package application;

public class RecintoElectoral {

	private int idRecinto;
	private String nombre;
	private int numeroMesas;
	private Provincia provincia;
	private String parroquia;
	private String direccion;
	public int getIdRecinto() {
		return idRecinto;
	}
	public void setIdRecinto(int idRecinto) {
		this.idRecinto = idRecinto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNumeroMesas() {
		return numeroMesas;
	}
	public void setNumeroMesas(int numeroMesas) {
		this.numeroMesas = numeroMesas;
	}
	public Provincia getProvincia() {
		return provincia;
	}
	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
	public String getParroquia() {
		return parroquia;
	}
	public void setParroquia(String parroquia) {
		this.parroquia = parroquia;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public RecintoElectoral(int idRecinto, String nombre, int numeroMesas, Provincia provincia, String parroquia,
			String direccion) {
		super();
		this.idRecinto = idRecinto;
		this.nombre = nombre;
		this.numeroMesas = numeroMesas;
		this.provincia = provincia;
		this.parroquia = parroquia;
		this.direccion = direccion;
	}
	@Override
	public String toString() {
		return "RecintoElectoral [idRecinto=" + idRecinto + ", nombre=" + nombre + ", numeroMesas=" + numeroMesas
				+ ", provincia=" + provincia + ", parroquia=" + parroquia + ", direccion=" + direccion + "]";
	}
	
	
}
