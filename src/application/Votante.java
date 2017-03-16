package application;

import java.time.LocalDate;

public class Votante {
	private String cedula;
	private String nombre;
	private LocalDate FechaNacimiento;
	private String uriFoto;
	private boolean asignadoAMesa;
	private RecintoElectoral recinto;
	public Votante(String cedula, String nombre, LocalDate fechaNacimiento, String uriFoto, boolean asignadoAMesa,
			RecintoElectoral recinto) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		FechaNacimiento = fechaNacimiento;
		this.uriFoto = uriFoto;
		this.asignadoAMesa = asignadoAMesa;
		this.recinto = recinto;
	}
	
	
	public String getCedula() {
		return cedula;
	}


	public void setCedula(String cedula) {
		this.cedula = cedula;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public LocalDate getFechaNacimiento() {
		return FechaNacimiento;
	}


	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		FechaNacimiento = fechaNacimiento;
	}


	public String getUriFoto() {
		return uriFoto;
	}


	public void setUriFoto(String uriFoto) {
		this.uriFoto = uriFoto;
	}


	public boolean isAsignadoAMesa() {
		return asignadoAMesa;
	}


	public void setAsignadoAMesa(boolean asignadoAMesa) {
		this.asignadoAMesa = asignadoAMesa;
	}


	public RecintoElectoral getRecinto() {
		return recinto;
	}


	public void setRecinto(RecintoElectoral recinto) {
		this.recinto = recinto;
	}


	@Override
	public String toString() {
		return "Votante [cedula=" + cedula + ", nombre=" + nombre + ", FechaNacimiento=" + FechaNacimiento
				+ ", uriFoto=" + uriFoto + ", asignadoAMesa=" + asignadoAMesa + ", recinto=" + recinto + "]";
	}
	
	public String imprimirDomicilioElectoral()
	{
		String domiciolioElectoral = "Ud vota en la parroquia " + recinto.getParroquia() + " de la provincia " + recinto.getProvincia() + " en la direccion: " + recinto.getDireccion();
		return domiciolioElectoral;
	}
	
}
