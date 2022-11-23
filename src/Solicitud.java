package practica;

public class Solicitud {
	private int tipo;
	private String telefono;
	
	public Solicitud(int tipo, String telefono) {
		this.tipo = tipo;
		this.telefono = telefono;
	}
	
	public int getTipo() {
		return tipo;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public String toString() {
		String tipoa;
		if (tipo==1) {
			tipoa="adopcion";
		}else {
			tipoa="acogida";
		}
		return "solicitud [tipo=" + tipoa+ ", telefono=" + telefono + "]";
	}
	
}
