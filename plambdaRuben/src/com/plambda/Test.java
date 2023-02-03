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
		
		
		int suma = 0;		
		//Paso1 Conseguir los m2 totales de las casas del listado
		System.out.print("Metros cuadrados totales: ");
//		suma = casas.stream().mapToInt(c -> c.getM2()).sum();
		suma = casas.stream()
				.mapToInt(Casa::getM2).sum();
		System.out.println(suma);
				
		//Paso2 Conseguir los m2 totales de las casas del listado 
		//que tengan un nombre de menos de 4 caracteres
		System.out.print("Metros cuadrados totales de casas de menos de 4 caracteres: ");
		suma = casas.stream()
				.filter(c -> c.getNombre().length() < 4)
				.mapToInt(c -> c.getM2()).sum();
//		suma = casas.stream().mapToInt(c -> (c.getNombre().length() < 4)? c.getM2() : 0).sum();
		System.out.println(suma);
		
		//Paso3 Conseguir un listado de las casa que tengan un salon de m�s de 20 m2
		System.out.println("Casas con salon de mas de 20 m2:");
		List<Casa> listaCasa = casas.stream()
				.filter(c -> c.getSalon().getM2() > 20)
				.collect(Collectors.toList());
		listaCasa.forEach(c -> System.out.println(c.toString()));
//		casas.stream().filter(c -> c.getSalon().getM2() > 20).
//			forEach(c -> System.out.println(c.getNombre()));
		
		//Paso4 Conseguir un listado de Salones con las casas de m�s de una habitaci�n
		System.out.println("Casas con mas de 1 habitacion:");
		listaCasa = casas.stream()
		.filter(c -> c.getNumHabitaciones() > 1)
		.collect(Collectors.toList());
		listaCasa.forEach(c -> System.out.println(c.toString()));
				
		//Paso5 Conseguir los m2 de todos los salones de las casas
		System.out.print("Metros cuadrados de los salones: ");
		suma = casas.stream()
				.mapToInt(c -> c.getSalon().getM2()).sum();
		System.out.println(suma);
		
		
		//Paso6 Imprimir todas las casas
		System.out.println("Casas:");
		casas.stream()
		.forEach(c -> System.out.println(c.toString()));
	
		
		//Paso7 Conseguir el numero total de habitaciones de las casas de mas de 1 habitaci�n,
		//      imprimiendo las casas que se han seleccionado.
		
		System.out.println("Casas con > 1 habitacion y #hab:");
		System.out.println("#hab: " + 
		casas.stream()
		.filter(c -> c.getNumHabitaciones() > 1)
		.mapToInt(t -> {
			System.out.println(t.toString());
			return t.getNumHabitaciones();
		}).sum());
		
	}

}
