package Ejercicio_Mochila;

public class Principal {

	public static void main(String[] args) {
		Articulo[] articulos = {
				new Articulo(2, 3), 
				new Articulo(3, 4), 
				new Articulo(4, 5), 
				new Articulo(5, 6),
		};
		
		// Para probar todas las combinaciones
		Mochila m_prueba = new Mochila(5, articulos.length); 
		
		// Contiene la mejor combinaci�n
		Mochila m_optimizada = new Mochila(5, articulos.length);

		llenarMochila(m_prueba, m_optimizada, articulos, false);

		System.out.println("~~~~~~~~~~~~~~~ PROBLEMA DEL VIAJERO Y LA MOCHILA ~~~~~~~~~~~~~~~\n");
		System.out.println(m_optimizada);

	}
	
	
	// *************************************************************************
	// M�TODO 1: ALGORITMO DE BACKTRACKING PARA EL LLENADO �PTIMO DE LA MOCHILA
	public static void llenarMochila(Mochila m_prueba,  Mochila m_optimizada, Articulo[] articulos, boolean llena) {
		
		// CASO BASE: LA MOCHILA EST� LLENA
		if (llena) {
			// Comprueba si la mochila actual tiene m�s valor
			if (m_prueba.getValor() > m_optimizada.getValor()) {

				// Copiamos los art�culos de la mochila de prueba
				Articulo[] articulosMochPrueba = m_prueba.getArticulos();
				// Limpiamos la mochila con el supuesto mayor valor
				m_optimizada.limpiar();

				// Agregamos los elementos 
				for (Articulo a : articulosMochPrueba) {
					// La mejor soluci�n puede incluir espacios vac�os
					if (a != null)
						m_optimizada.agregar(a);;
				}

			}

		// CASO RECURSIVO: LA MOCHILA A�N NO EST� LLENA
		} else {
			
			// Recorre los elementos
			for (int i = 0; i < articulos.length; i++) {
				// Si el elemento a�n no est� puesto en la mochila
				if (!m_prueba.contiene(articulos[i])) {
					
					// Si el peso de la mochila se supera, indicamos que esta llena
					if (m_prueba.getPesoMaximo() >= m_prueba.getPeso() + articulos[i].getPeso()) {
						m_prueba.agregar(articulos[i]);
						// Llamada recursiva para probar todas las combinaciones
						llenarMochila(m_prueba, m_optimizada, articulos, false);
						m_prueba.eliminar(articulos[i]);
					} else {
						llenarMochila(m_prueba, m_optimizada, articulos, true);
					}

				}
			}
		}

	}

}
