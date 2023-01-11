// CLASE PARA CADA ARTÍCULO
package Ejercicio_Mochila;

public class Articulo {
	private static int numArticuloGeneral = 0; // Variable de la clase
	private int peso;
	private int valor;
	private int numArticulo;

	// **************************************************************
	// CONSTRUCTOR
	public Articulo(int peso, int valor) {
		this.peso = peso;
		this.valor = valor;
		// Cada artículo cuenta con indentificador
		this.numArticulo = ++numArticuloGeneral;
	}

	// **************************************************************
	// GETTERS
	public int getPeso() {
		return peso;
	}

	public int getValor() {
		return valor;
	}

	// **************************************************************
	// TO STRING
	public String toString() {
		return "ARTÍCULO " + numArticulo + ": [Peso:" + peso + "]\t" + "[Valor:" + valor + "]";
	}
}
