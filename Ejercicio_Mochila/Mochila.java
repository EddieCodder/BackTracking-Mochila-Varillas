package Ejercicio_Mochila;

//CLASE PARA LA MOCHILA
public class Mochila {
	
	private int pesoMaximo;
	private Articulo[] articulos;

	// *************************************************************************
	// VALORES ACTUALES DE LA MOCHILA
	private int peso;
	private int valor;

	// *************************************************************************
	// CONSTRUCTOR
	public Mochila(int pesoMaximo, int numArticulos) {
		this.pesoMaximo = pesoMaximo;
		this.articulos = new Articulo[numArticulos];
		this.valor = 0;
		this.peso = 0;
	}
	
	// *************************************************************************
	// GETTERS
	public Articulo[] getArticulos() {
		return articulos;
	}

	public int getPeso() {
		return peso;
	}

	public int getValor() {
		return valor;
	}


	public int getPesoMaximo() {
		return pesoMaximo;
	}

	// *************************************************************************
	// MÉTODO 1: AÑADE UN ARTÍCULO A LA MOCHILA
	public void agregar(Articulo a) {

		for (int i = 0; i < this.articulos.length; i++) {
			// Agrega artículos en espacios vacíos
			if (this.articulos[i] == null) {
				this.articulos[i] = a;
				this.valor += a.getValor(); // Incrementa el valor actual
				this.peso += a.getPeso(); // Incrementa el peso actual
				break;
			}
		}

	}

	// *************************************************************************
	// MÉTODO 2: VACÍA LA MOCHILA
	public void limpiar() {
		this.peso = 0;
		this.valor = 0;
		for (int i = 0; i < this.articulos.length; i++) {
			this.articulos[i] = null;
		}
	}

	// *************************************************************************
	// MÉTODO 3: ELIMINA UN ARTÍCULO DE LA MOCHILA
	public void eliminar(Articulo e) {
		for (int i = 0; i < this.articulos.length; i++) {
			if (this.articulos[i].equals(e)) {
				this.articulos[i] = null;
				this.peso -= e.getPeso();
				this.valor -= e.getValor();
				break;
			}
		}
	}

	// *************************************************************************
	// MÉTODO 4: INIDCA SI EL ELEMENTO YA ESTÁ EN LA MOCHILA
	public boolean contiene(Articulo a) {
		for (int i = 0; i < this.articulos.length; i++) {
			if (this.articulos[i] != null && this.articulos[i].equals(a)) 
				return true;		
		}
		return false;
	}

	// *************************************************************************
	// MÉTODO 5: MUESTRA EL CONTENDIO DE LA MOCHILA (TO STRING)
	public String toString() {
		String c = "";
		for (int i = 0; i < this.articulos.length; i++) {
			if (this.articulos[i] != null) 
				c += articulos[i] + "\n";		
		}
		c += "PESO: " + getPeso() + "\n";
		c += "VALOR: " + getValor() + "\n";
		return c;
	}

}
