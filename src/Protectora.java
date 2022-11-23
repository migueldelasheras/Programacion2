package practica;

import java.util.Arrays;

public class Protectora implements Constantes{

private int nAnimales;
private Animal[]animales;


public Protectora( ) {
	
	nAnimales=animalesin;
	animales=new Animal[animalesmax];
}

public int getN_animales() {
	return nAnimales;
}

public void setN_animales(int n_animales) {
	this.nAnimales = n_animales;
}

public double calcSubvencion(Ayuntamiento ayto) {
	return (nAnimales*ayto.getSubvencion())+subvencion;
}

public double campEsterilizacion(Clinica_veterinaria clinica) {
	double dinero=0;
	for (int i = 0; i < nAnimales; i++) {
		if (animales[i] instanceof Gato && animales[i].getSexo()=='h'&&!((Gato)animales[i]).isEsterilizado()) {
			dinero+=clinica.getP_esterilizacion();
		}
	}
	return dinero;
}

public boolean existencia(String animal) {
	
	boolean existe=false;
	for (int i = 0; i < nAnimales; i++) {
		if (animales[i].getNombre().equalsIgnoreCase(animal)) {
			existe=true;
		}
	}
	return existe;
}

public String addSol(String animal, int tipo, String telefono) throws ExceptionIntervalo{
	String cadena="";
	for (int i = 0; i < nAnimales; i++) {
		if (animales[i].getNombre().equalsIgnoreCase(animal)) {
			animales[i].addsolicitud(tipo,telefono);
			cadena="Solicitud añadida";
		}
	}
	return cadena;
	
	
}

public void addAnimales(Animal animal) {
	if (nAnimales<animalesmax) {
		animales[nAnimales]=animal;
		nAnimales++;
	}
}

public String mostrarAnimales() {
	String cadena="";
	for (int i = 0; i < nAnimales; i++) 
		cadena=cadena+(i+1)+". " + animales[i]+"\n";
	return cadena;
}

public String mostrarsol(String animal) {
	String cadena= "";
	for (int i = 0; i < nAnimales; i++) {
		if (animales[i].getNombre().equalsIgnoreCase(animal)) {
			cadena= cadena + animales[i].getNombre() +": "+ animales[i].mostrarSolicitudes() + "\n";
		}
	}
	return cadena;
}

public double calcGastos() {
	double gastos=0;
	for (int i = 0; i < nAnimales; i++) {
		gastos+=animales[i].calcGastos();
	}
	return gastos;
}

public double calcPienso() {
	double cantidad=0;
	for (int i = 0; i < nAnimales; i++) {
		if (animales[i] instanceof Perro&&animales[i].getEdad()>edadminima) {
			cantidad+=((Perro)animales[i]).calcpienso();
		}else {
			cantidad+=0; //si la cantidad es 0 es porque tiene menos de 18 meses
		}
	}
	return cantidad;
}

public String toString() {
	return "Protectora [nAnimales=" + nAnimales + ", animales="
			+ Arrays.toString(animales) + "]";
}

}