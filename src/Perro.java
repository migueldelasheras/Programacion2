package practica;


public class Perro extends Animal implements Constantes{
	private String raza;
	private int tamano;
	private boolean ppp,leishmania;
	
	
	public Perro(String nombre,char sexo, int edad, boolean sociable, boolean apadrinado, String raza,int tamano,
			boolean ppp, boolean leishmania) {
		super(nombre, sexo, edad, sociable,apadrinado);
		this.raza=raza;
		this.tamano=tamano;
		this.ppp=ppp;
		this.leishmania=leishmania;
		}

	public String getRaza() {
		return raza;
	}

	public int getTamano() {
		return tamano;
	}

	public boolean isPpp() {
		return ppp;
	}

	public boolean isLeishmania() {
		return leishmania;
	}
	
	public double calcGastos() { 
		double gastos=0;
		if (apadrinado) {
			return gastos=0;
		}else {
		if (leishmania) 
			gastos+=gleishmania;
		
		if (ppp&&!sociable) 
			gastos+=pppysociable;
		
		gastos+=rabia;
		return gastos;
		}
	}
	public double calcpienso() {
		double pienso=0;
		
		if (tamano<=tamanoa) pienso=piensoa;
		if (tamano>tamanoa&&tamano<tamanob) pienso=piensob;
		if (tamano>tamanob) pienso= piensoc*(tamano*kg);
		
		return (pienso*diasemana)/kg;
		
	}

	public String toString() {
		return  "Perro[nombre=" + nombre + ", raza=" + raza + ", tamano=" + tamano + ", ppp=" + ppp + ", leishmania=" + leishmania + ", edad="
				+ edad + ", sexo=" + sexo +", sociable=" + sociable + ", apadrinado="
				+ apadrinado  + "]";
	}
}

