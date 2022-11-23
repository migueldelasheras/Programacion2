package practica;

public class Ayuntamiento {

	private String telefono;
	private double subvencion; //lo que dona el ayuntamiento por animal
	
	public Ayuntamiento(String telefono, double subvencion) {
		this.telefono=telefono;
		this.subvencion=subvencion;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public double getSubvencion() {
		return subvencion;
	}
	
	public String toString() {
		return "Ayuntamiento [telefono=" + telefono + ", subvencion=" + subvencion + "]";
	}
	
}
