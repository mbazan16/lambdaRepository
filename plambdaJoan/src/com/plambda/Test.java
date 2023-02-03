package com.plambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.plambda.beans.Casa;
import com.plambda.beans.Salon;

public class Test {

	public static void main(String[] args) {
		Casa casa1 = new Casa(3, 90, "una", new Salon(25));
		Casa casa2 = new Casa(2, 50, "dos", new Salon(15));
		Casa casa3 = new Casa(1, 50, "tres", new Salon(20));

		List<Casa> casas = new ArrayList<Casa>();
		casas.add(casa1);
		casas.add(casa2);
		casas.add(casa3);
		
		//Paso1 Conseguir los m2 totales de las casas del listado
		int totalM2 = casas.stream().
							mapToInt(a -> a.getM2()).
							sum();
		System.out.println("Total de M2 = " + totalM2);
		System.out.println("----------------------");
				
		//Paso2 Conseguir los m2 totales de las casas del listado 
		//que tengan un nombre de menos de 4 caracteres
		int totalM2MenosCaracteres = casas.stream().
				filter(a -> (a.getNombre().length()<4) ? true : false).
				mapToInt(a -> a.getM2()).
				sum();
		System.out.println("Total de M2 de las cass con nombre de menos de 4 caracteres = " + totalM2MenosCaracteres);
		System.out.println("----------------------");
		
		//Paso3 Conseguir un listado de las casa que tengan un salon de m�s de 20 m2
		List<Casa> lista = casas.stream().filter(a -> (a.getSalon().getM2()>20)).collect(Collectors.toList());
		casas.stream().filter(a -> a.getSalon().getM2()>20 ? true : false).forEach(System.out::println);
		System.out.println("----------------------");
		
		//Paso4 Conseguir un listado de Salones con las casas de m�s de una habitaci�n
		casas.stream().filter(a -> a.getNumHabitaciones()>1 ? true : false).map(a -> a.getSalon()).forEach(System.out::println);
		System.out.println("----------------------");
				
		//Paso5 Conseguir los m2 de todos los salones de las casas
		int totalM2Salones = casas.stream().mapToInt(a -> a.getSalon().getM2()).sum();
		System.out.println("Total de M2 de los salones = " + totalM2Salones);
		System.out.println("----------------------");
		
		
		
		//Paso6 Imprimir todas las casas
		casas.stream().forEach(System.out::println);
		System.out.println("----------------------");
		
		//Paso7 Conseguir el numero total de habitaciones de las casas de mas de 1 habitaci�n,
		//      imprimiendo las casas que se han seleccionado.
		casas.stream().filter(a -> (a.getNumHabitaciones()>1)).forEach(System.out::println);
		
		
	}

}
