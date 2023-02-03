package com.plambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
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
		System.out.println("paso 1: " + paso1(casas));
				
		//Paso2 Conseguir los m2 totales de las casas del listado 
		//que tengan un nombre de menos de 4 caracteres
		System.out.println("paso 2: " + paso2(casas));
		
		//Paso3 Conseguir un listado de las casa que tengan un salon de m�s de 20 m2
		System.out.println("paso 3: ");
		paso3(casas).forEach(System.out::println);
		
		//Paso4 Conseguir un listado de Salones con las casas de m�s de una habitaci�n
		System.out.println("paso 4: ");
		paso4(casas).forEach(System.out::println);
		
				
		//Paso5 Conseguir los m2 de todos los salones de las casas
		System.out.println("paso 5: " + paso5(casas));
		
		
		
		//Paso6 Imprimir todas las casas
		System.out.println("paso 6: ");
		casas.forEach(System.out::println);
	
		
		//Paso7 Conseguir el numero total de habitaciones de las casas de mas de 1 habitaci�n,
		//      imprimiendo las casas que se han seleccionado.
		System.out.println("paso 7 total de habitaciones: " + paso7(casas));
		
		
		
	}
	
	private static Integer paso1(List<Casa> casa) {
		return casa.stream().mapToInt(i -> i.getM2()).sum();
	}
	
	private static Integer paso2(List<Casa> casa) {
		return casa.stream()
				.filter(i-> i.getNombre().length() < 4)
				.mapToInt(i -> i.getM2())
				.sum();
	}
	
	private static List<Casa> paso3(List<Casa> casa) {
		return casa.stream()
				.filter(i-> i.getSalon().getM2() > 20)
				.collect(Collectors.toList());
	}
	
	private static List<Salon> paso4(List<Casa> casa) {
		return casa.stream()
		.filter( i -> i.getNumHabitaciones() > 1)
		.map(i -> i.getSalon())
		.collect(Collectors.toList());
	}
	
	private static Integer paso5(List<Casa> casa) {
		return casa.stream()
				.mapToInt(i -> i.getSalon().getM2())
				.sum();
	}
	
	private static Integer paso7(List<Casa> casa) {
		System.out.println("paso 7 casas selecionadas: ");
		casa.stream()
		.filter(i -> i.getNumHabitaciones() > 1)
		.forEach(System.out::println);
		
		return casa.stream()
				.filter(i -> i.getNumHabitaciones() > 1)
				.mapToInt(i -> i.getNumHabitaciones())
				.sum();
	}

}
