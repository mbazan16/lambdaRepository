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
		
//		int m2 = 0;
//		int m2Salones = 0;
//		
		//Paso 1 Conseguir los m2 totales de las casas del listado
		int m2 = casas.stream().mapToInt(a -> a.getM2()).sum();
		System.out.println("Los metros cuadrados totales son: " + m2);
				
		//Paso 2 Conseguir los m2 totales de las casas del listado 
		//que tengan un nombre de menos de 4 caracteres
//		casas.stream().map(a -> a.getNombre());
		int m2List = casas.stream()	.filter(c -> c.getNombre().length() < 4)
									.mapToInt(c ->c.getM2()).sum();
		System.out.println("Los metros cuadrados de las casas con un nombre de menos de 4 caracteres:" + m2List);
		
		//Paso 3 Conseguir un listado de las casa que tengan un salon de m�s de 20 m2
		List<Casa> m2ListSal = casas.stream()	.filter(c -> c.getSalon().getM2() > 20)
												.collect(Collectors.toCollection(ArrayList::new));
//		List<Casa> m2ListSal = casas.stream()	.filter(c -> c.getSalon().getM2() > 20)
//				.collect(Collectors.toList());
		System.out.println("Las casas con un salon de más de 20 metros: " + m2ListSal);
		
		//Paso 4 Conseguir un listado de Salones con las casas de m�s de una habitaci�n
		List<Salon> m2ListHab = casas.stream()	.filter(c -> c.getNumHabitaciones() > 1)
												.map(c->c.getSalon()).collect(Collectors.toCollection(ArrayList::new));
		System.out.println("Las casas con salones y más de una habitación " + m2ListHab);
		
		//Paso 5 Conseguir los m2 de todos los salones de las casas
		int m2Salones = casas.stream().
							mapToInt(a -> a.getSalon().getM2()).sum();
		System.out.println("Los metros cuadrados totales de los salones son: " + m2Salones);
				
		//Paso 6 Imprimir todas las casas
		casas.stream().map(a->a.toString()).forEach(System.out::println);
		
		//Paso 7 Conseguir el numero total de habitaciones de las casas de mas de 1 habitaci�n,
		//      imprimiendo las casas que se han seleccionado.
		int numHab = casas.stream().filter(c->c.getNumHabitaciones() > 1).mapToInt(c->c.getNumHabitaciones()).sum();
		System.out.println("El numero total de habitaciones son: " + numHab);
		
	}

}
