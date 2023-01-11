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
		
		// Contiene la mejor combinación
		Mochila m_optimizada = new Mochila(5, articulos.length);

		llenarMochila(m_prueba, m_optimizada, articulos, false);

		System.out.println("~~~~~~~~~~~~~~~ PROBLEMA DEL VIAJERO Y LA MOCHILA ~~~~~~~~~~~~~~~\n");
		System.out.println(m_optimizada);

	}
	
	
	// *************************************************************************
	// MÉTODO 1: ALGORITMO DE BACKTRACKING PARA EL LLENADO ÓPTIMO DE LA MOCHILA
	public static void llenarMochila(Mochila m_prueba,  Mochila m_optimizada, Articulo[] articulos, boolean llena) {
		
		// CASO BASE: LA MOCHILA ESTÁ LLENA
		if (llena) {
			// Comprueba si la mochila actual tiene más valor
			if (m_prueba.getValor() > m_optimizada.getValor()) {

				// Copiamos los artículos de la mochila de prueba
				Articulo[] articulosMochPrueba = m_prueba.getArticulos();
				// Limpiamos la mochila con el supuesto mayor valor
				m_optimizada.limpiar();

				// Agregamos los elementos 
				for (Articulo a : articulosMochPrueba) {
					// La mejor solución puede incluir espacios vacíos
					if (a != null)
						m_optimizada.agregar(a);;
				}

			}

		// CASO RECURSIVO: LA MOCHILA AÚN NO ESTÁ LLENA
		} else {
			
			// Recorre los elementos
			for (int i = 0; i < articulos.length; i++) {
				// Si el elemento aún no está puesto en la mochila
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
