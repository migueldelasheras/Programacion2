package practica;


public class Gato extends Animal implements Constantes{
	
	private boolean esterilizado;
	
	public Gato(String nombre, char sexo, int edad, boolean sociable, boolean apadrinado, boolean esterilizado) {
		super(nombre,sexo,edad,sociable, apadrinado);
		this.esterilizado=esterilizado;
	}
	
	public boolean isEsterilizado() {
		return esterilizado;
	}
	
	public double calcGastos() {
		int gastos=0;
		if (apadrinado) {
			return gastos=0;
		}else {
		if (!esterilizado&&sexo=='h') 
			gastos+=esterilizacion;
			return gastos;
		}
	}

	public String toString() {
		return "Gato[nombre=" + nombre +", sexo="+sexo+ ", esterilizado=" + esterilizado + ", edad=" + edad + 
				", sociable=" + sociable + ", apadrinado=" + apadrinado +  "]";
	}
}
