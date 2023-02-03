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
		int metros = casas.stream()
				.mapToInt(a -> a.getM2())
				.sum();
		casas.stream()
			.mapToInt(Casa::getM2)
			.sum();
		 System.out.println("Metros totales: " + metros);
				
		//Paso2 Conseguir los m2 totales de las casas del listado 
		//que tengan un nombre de menos de 4 caracteres
		 metros = casas.stream()
				 .filter(a -> a.getNombre().length() < 4)
				 .mapToInt(a -> a.getM2())
				 .sum();
		 casas.stream()
		 		.filter(a -> a.getNombre().length() < 4)
		 		.mapToInt(Casa::getM2)
		 		.sum();
		 casas.stream()
		 		.mapToInt(a -> (a.getNombre().length() < 4) ? a.getM2() : 0)
		 		.sum(); // NO GUSTA EL TERNARIO
		 System.out.println("Metros totales: " + metros);
		 
		//Paso3 Conseguir un listado de las casa que tengan un salon de m�s de 20 m2
		 casas.stream()
		 		.filter(a -> a.getSalon().getM2() > 20)
		 		.map(a -> a.getNombre())
		 		.forEach(System.out::println); //SE QUERÍA USAR COLLECTION
		 
		 List<Casa> listaCasas = casas.stream()
				 .filter(a -> a.getSalon().getM2() > 20)
				 .collect(Collectors.toList());

		 List<Casa> listaCasas2 = casas.stream()
				 .filter(a -> a.getSalon().getM2() > 20)
				 .collect(Collectors.toCollection(ArrayList::new));
		
		//Paso4 Conseguir un listado de Salones con las casas de m�s de una habitaci�n
		 casas.stream()
		 		.filter(a -> a.getNumHabitaciones() > 1)
		 		.map(a -> a.getNombre())
		 		.forEach(System.out::println);
				
		//Paso5 Conseguir los m2 de todos los salones de las casas
		 metros = casas.stream()
				 .mapToInt(a -> a.getSalon().getM2())
				 .sum();
		 System.out.println("Metros totales: " + metros);

		//Paso6 Imprimir todas las casas
		 casas.stream().map(a -> a.toString()).forEach(System.out::println);
			
		//Paso7 Conseguir el numero total de habitaciones de las casas de mas de 1 habitaci�n,
		//      imprimiendo las casas que se han seleccionado.
		 int habTotal = casas.stream().filter(a -> a.getNumHabitaciones() > 1).mapToInt(a -> {
			 System.out.println(a.toString());
			 return a.getNumHabitaciones();
		 }).sum();
		 System.out.println("Habitaciones totales: " + habTotal);
	}

}
