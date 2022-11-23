package practica;

public class Clinica_veterinaria {
	private String nombre,telefono;
	private double pEsterilizacion;
	
	public Clinica_veterinaria(String nombre, String telefono, double pEsterilizacion) {
		this.nombre=nombre;
		this.telefono=telefono;
		this.pEsterilizacion=pEsterilizacion;
	}
	public String getNombre() {
		return nombre;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public double getP_esterilizacion() {
		return pEsterilizacion;
	}

	public String toString() {
		return "Clinica_veterinaria [nombre=" + nombre + ", telefono=" + telefono + ", p_esterilizacion=" + pEsterilizacion
			+ "]";
	}

}
