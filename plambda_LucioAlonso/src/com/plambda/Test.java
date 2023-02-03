package com.plambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.function.Function;   
import java.util.function.Supplier;   
import java.util.stream.Stream;

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
		System.out.println("[Paso 1] M2 totales: " + 
				casas.stream()
				.mapToInt(a -> a.getM2()).sum());
				
		//Paso2 Conseguir los m2 totales de las casas del listado 
		//que tengan un nombre de menos de 4 caracteres
		System.out.println("\n[Paso 2] M2 totales con menos de 4 caracteres: " + 
				casas.stream()
				.mapToInt(a -> (a.getNombre().length() < 4) ? a.getM2() : 0)
				.sum());
		

		//Paso3 Conseguir un listado de las casa que tengan un salon de m�s de 20 m2
		/*
		casas.stream()
			.filter(a -> (a.getSalon().getM2() > 20))
			.forEach(System.out::println);
		*/
		//otra forma
		System.out.println("\n[Paso 3] Listado de casas con un salon de mas de 20m2: ");
		List<Casa> casas20M2 = casas.stream()
				.filter(a -> (a.getSalon().getM2() > 20))
				.collect(Collectors.toList());
		casas20M2.stream().forEach(System.out::println);
		
		
		
		//Paso4 Conseguir un listado de Salones con las casas de m�s de una habitaci�n
		System.out.println("\n[Paso 4] Conseguir un listado de Salones con las casas de mas de una habitacion: ");
		List<Casa> paso4 = casas.stream()
			.filter(a -> (a.getNumHabitaciones() > 1))
			.collect(Collectors.toList());
		paso4.stream().forEach(System.out::println);
		
		
				
		//Paso5 Conseguir los m2 de todos los salones de las casas
		/*
		casas.stream()
			.forEach(b -> System.out.println(b.getSalon().getM2()));
		*/
		System.out.println("\n[Paso 5] Los m2 de todos los salones de las casas: ");
		List<Salon> paso5 = casas.stream()
				.map(a -> a.getSalon())
				.collect(Collectors.toList());
		paso5.stream().forEach(System.out::println);
		
		
		
		//Paso6 Imprimir todas las casas
		System.out.println("\n[Paso 6] Imprimir todas las casas: ");
		casas.stream()
			.forEach(System.out::println);
		
		//Paso7 Conseguir el numero total de habitaciones de las casas de mas de 1 habitaci�n,
		//      imprimiendo las casas que se han seleccionado.
		/*
		System.out.println("\nNumero total de habitaciones de las casas de mas de 1 habitacion imprimiendo las casas que se han seleccionado: ");
		casas.stream()
			.filter(a -> (a.getNumHabitaciones() > 1))
			.forEach(System.out::println);
			*/
		//otra forma
		
		int contador = casas.stream()
			.filter(a -> (a.getNumHabitaciones() > 1))
			.mapToInt(a -> {
				System.out.println(a);
				return a.getM2();
			})
			.sum();

		
	}

}
