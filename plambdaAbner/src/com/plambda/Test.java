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

		// Paso1 Conseguir los m2 totales de las casas del listado
		int sum = casas.stream()
				.mapToInt(i -> i.getM2())
				.sum();
		System.out.println(sum);

		// Paso2 Conseguir los m2 totales de las casas del listado
		// que tengan un nombre de menos de 4 caracteres

		int sum2 = casas.stream()
					.filter(n -> n.getNombre().length() < 4)
					.mapToInt(i -> i.getM2())
					.sum();
		
		System.out.println(sum2);
		
		
		// Paso3 Conseguir un listado de las casa que tengan un salon de m�s de 20 m2

		List<Casa> newList = casas.stream()
						.filter(n -> n.getSalon().getM2() > 20)
						.collect(Collectors.toList());
		
		System.out.println(newList);

		// Paso4 Conseguir un listado de Salones con las casas de m�s de una habitaci�n

		List<Salon> newList2 = casas.stream()
				.filter(n -> n.getNumHabitaciones() > 1)
				.map(n -> n.getSalon())
				.collect(Collectors.toList());
		
		System.out.println(newList2);

		// Paso5 Conseguir los m2 de todos los salones de las casas

		int sum3 = casas.stream()
				.mapToInt(i -> i.getSalon().getM2())
				.sum();
		
		System.out.println(sum);

		// Paso6 Imprimir todas las casas

		casas.forEach(item -> {
			System.out.println(item.getNombre());
		});

		// Paso7 Conseguir el numero total de habitaciones de las casas de mas de 1
		// habitaci�n,
		// imprimiendo las casas que se han seleccionado.
		int sum4 = casas.stream()
					.filter(i -> i.getNumHabitaciones() > 1)
					.mapToInt(i -> i.getNumHabitaciones())
					.sum();
		System.out.println(sum4);
		
		casas.forEach(item -> {
			if (item.getNumHabitaciones() > 1) {
				System.out.println(item.getNombre());
			}
		});

	}

}
