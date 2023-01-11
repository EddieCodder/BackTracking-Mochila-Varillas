package Ejercicio_Varillas;

import java.util.ArrayList;

// CLASE PARA LAS VARILLAS
public class Varillas {
	
	
	private int dimension;
	private int cantidad;
	private ArrayList<Boolean> varillas = new ArrayList<>();
	
	// ***********************************************************
	// CONSTRUCTOR
	public Varillas(int dimension, int cantidad) {
		this.dimension = dimension;
		this.cantidad = cantidad;
	}
	
	// ***********************************************************
	// GETTERS
	public int getDimension() {
		return dimension;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public ArrayList<Boolean> getVarillas() {
		return varillas;
	}
	
	// *************************************************************************
	// MÉTODO 1: CORTA UNA VARILLA Y SE AÑADE AL INVENTARIO
	public void agregar() {
		varillas.add(true);
	}
	
	// *************************************************************************
	// MÉTODO 2: INDICA SI EL SET ESTÁ FULL
	public boolean lleno() {
		if(varillas.size() == this.cantidad)
			return true;
		return false;
	}
	
	// *************************************************************************
	// MÉTODO : MUESTRA TODAS LAS VARILLAS
	public String toString() {
		int cont = 1;
		String c = "VARILLAS ("+ this.dimension +"m)  -> Cantidad: "+ this.varillas.size()+ "\n";
		for(boolean v: varillas) {
			c += cont + ")" + v + "\n"; 
			cont++;
		}
		return c;
		
	}
}
