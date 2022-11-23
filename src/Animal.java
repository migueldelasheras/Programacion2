package practica;

public abstract class Animal implements Constantes{
	
	protected int edad;
	protected char sexo;
	protected String nombre;
	protected boolean sociable,apadrinado;
	protected Solicitud[]solicitudes;
	protected int n_solicitudes;
	
	public Animal(String nombre, char sexo,int edad, boolean sociable, boolean apadrinado) {
		solicitudes = new Solicitud[solicitudes_maximas];
		this.edad = edad;
		this.sexo = sexo;
		this.nombre = nombre;
		this.sociable = sociable;
		this.apadrinado = apadrinado;
		n_solicitudes=sol_iniciales;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public char getSexo() {
		return sexo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public boolean isSociable() {
		return sociable;
	}
	
	public boolean isApadrinado() {
		return apadrinado;
	}
	
	
	public int getN_solicitudes() {
		return n_solicitudes;
	}

	public void addsolicitud(int tipo, String telefono) throws ExceptionIntervalo{
		Solicitud sol= new Solicitud(tipo,telefono);
		if(n_solicitudes>=solicitudes_maximas) {
			throw new ExceptionIntervalo("No hay mas espacio");
		}else{solicitudes[n_solicitudes]= sol;
			n_solicitudes++;
		}
	}
	public String mostrarSolicitudes() {
		String cadena="El animal tiene " + n_solicitudes + " solicitudes\n";
		for (int i = 0; i < n_solicitudes; i++) {
			if (solicitudes[i].getTipo()==1) {
				cadena+= solicitudes[i].toString()+"\n";
			}
			
		}
		
		return cadena;		
	}
	
	public abstract double calcGastos();
	
	

	
	public String toString() {
		return "Animal [edad=" + edad + ", sexo=" + sexo + ", nombre=" + nombre + ", sociable=" + sociable
				+ ", apadrinado=" + apadrinado +  "]";
	}
	
}
