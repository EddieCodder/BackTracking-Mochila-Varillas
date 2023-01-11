package Ejercicio_Varillas;

import java.util.ArrayList;

public class Principal {
	
	static int dimGeneral = 12;	// Dimensión de la varilla originaria
	
	// Almacena los residuos que ya no pueden ser utilizados
	static ArrayList<Integer> residuos = new ArrayList<>();
	
	public static void main(String[] args) {
		
		// VARILLAS por cortar	
		Varillas[] set_varillas = {
				new Varillas(3,100), // 3 metros - 100 unidades
				new Varillas(5,150), // 5 metros - 150 unidades
				new Varillas(7,200), // 7 metros - 200 unidades
				new Varillas(8,85)   // 8 metros - 200 unidades
		};
		
		// Se deben ordenar los conjuntos de varillas
		// De mayor a menor
		ordenarPorInsercion(set_varillas);
		cortarVarillas(12, set_varillas);
		
	
		// MUESTRA TODAS LAS VARILLAS
		for(int i=0;i<set_varillas.length;i++) {
			System.out.println(set_varillas[i]);
		}
		
		// MUESTRA LOS RESIDUOS MÍNIMOS QUE YA NO SON UTILIZABLES
		System.out.println("\nRESIDUOS");
		int cont = 1;
		int total = 0;
		for(Integer i: residuos) {
			System.out.println(cont + ") " +i);
			total += i;
			cont++;
		}
		System.out.println("Suma de todos los residuos inutilizables: " + total);
		
	}
	
	// ************************************************************************************************
	// MÉTODO 1: ALGORITMO PARA CORTAR LAS VARILLAS CON DESPERDICIO MÍNIMO
	public static void cortarVarillas(int dim_var, Varillas[] set_varillas) {

		// Para cada conjunto de varilla (Empezando por las de mayor dimensión)
		for(int i=0;i<set_varillas.length;i++) {
			
			while(!set_varillas[i].lleno()) {
				for(int j = 0; j < set_varillas.length; j++) {
					if(set_varillas[j].getDimension() <= dim_var && !set_varillas[j].lleno()) {
						System.out.println("DIMENSION VARILLA : " + dim_var);
						
						// SIMULAMOS EL CORTE RESTANDO
						// Restando dimensión a la varilla originaria
						dim_var -= set_varillas[j].getDimension();
						// Agregamos ese corte al conjunto de varillas que corresponde
						set_varillas[j].agregar(); 
						
						// Se muestran los datos
						System.out.println("CORTE VARILLA(" + set_varillas[j].getDimension()+
										   "m) -> Cantidad: "+ set_varillas[j].getVarillas().size());
						System.out.println("RESIDUO : " + dim_var + "\n");
					}
				}
				
				// Agregamos los residuos
				residuos.add(dim_var);
				System.out.println("RESIDUO INUTILIZABLE  -> " + dim_var + "\n");
				System.out.println("****************************************");
				System.out.println("\n\tRENOVANDO VARILLA ORIGINARIA\n");


				
				// Actualizamos la dimensión de la varilla originaria
				dim_var = dimGeneral;
			}
		}
			
	}
	
	// ******************************************************************************************************
	// MÉTODO 2: ORDENAMIENTO POR INSERCIÓN (de mayor a menor)
	public static void ordenarPorInsercion(Varillas a[]) {
		Varillas aux;
		int pos;
		for (int i = 1; i < a.length; i++) {
			pos = i;
			aux = a[i];
			// si existe un elemento mayor al que se está evaluando (pos=i)
			while ((pos > 0) && (a[pos - 1].getDimension() < aux.getDimension())) {
				a[pos] = a[pos - 1];
				pos--;
			}
			a[pos] = aux;
		}
	}
}