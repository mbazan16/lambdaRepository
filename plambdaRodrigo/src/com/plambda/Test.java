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
//		int m2 = casas.stream().mapToInt(t -> t.getM2()).sum();
		int m2 = casas.stream().mapToInt(Casa::getM2).sum();
		System.out.println("M2 totales: " + m2);
				
		//Paso2 Conseguir los m2 totales de las casas del listado 
		//que tengan un nombre de menos de 4 caracteres
//		m2 = casas.stream().
//				filter(t -> t.getNombre().length() < 4).
//				mapToInt(Casa::getM2).sum();
		m2 = casas.stream()
				.mapToInt(t -> t.getNombre().length() < 4 
							? t.getM2()
							: 0).sum();
		System.out.println("M2 casas <4 caracteres de nombre: " + m2);
		
		//Paso3 Conseguir un listado de las casa que tengan un salon de m�s de 20 m2
		System.out.println("Listado casas  salon > 20m");
//		casas.stream().filter(t -> t.getSalon().getM2() > 20).forEach(t -> System.out.println(t.getNombre()));
		List<Casa> listCasas = casas.stream().filter(t -> t.getSalon().getM2() > 20).collect(Collectors.toList());
		listCasas.forEach(t -> System.out.println(t.getNombre()));
		
		//Paso4 Conseguir un listado de Salones con las casas de m�s de una habitaci�n
		System.out.println("Listado casas  habitaciones > 1");
//		casas.stream().filter(t -> t.getNumHabitaciones() > 1).
//			forEach(t -> System.out.println(t.getNombre()));
		List<String> listSalones = casas.stream().filter(t -> t.getNumHabitaciones() > 1).
				map(t -> t.getNombre()).collect(Collectors.toList());
		List<Salon> listSalon = casas.stream()
				.filter(t -> t.getSalon().getM2() > 20)
				.map(Casa::getSalon)
				.collect(Collectors.toList());
		listSalones.forEach(System.out::println);
		
				
		//Paso5 Conseguir los m2 de todos los salones de las casas
		m2 = casas.stream().mapToInt(t -> t.getSalon().getM2()).sum();
		System.out.println("M2 totales salones: " + m2);
		
		
		//Paso6 Imprimir todas las casas
		System.out.println("Todas las casas");
		casas.forEach(System.out::println);
	
		
		//Paso7 Conseguir el numero total de habitaciones de las casas de mas de 1 habitaci�n,
		//      imprimiendo las casas que se han seleccionado.
		System.out.println("Todas las casas con >1 hab y #totalHab");
//		casas.stream().filter(t -> t.getNumHabitaciones() > 1).forEach(t -> System.out.println(t.getNombre()));
		System.out.println("#hab " + casas.stream().
				filter(t -> t.getNumHabitaciones() > 1).
				mapToInt(t -> {
					System.out.println(t.getNombre()); 
					return t.getNumHabitaciones();
				}).sum());
		
		
		
	}

}
