package com.plambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
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
		
		
		int m2Totales = 
				casas
				.stream()
				.mapToInt(e -> e.getM2())
				.sum();
		
		System.out.println(m2Totales);
				
		//Paso2 Conseguir los m2 totales de las casas del listado 
		//que tengan un nombre de menos de 4 caracteres
		
		int m2TotalesF = 
				casas
				.stream()
				.filter(e -> e.getNombre().length() < 4)
				.mapToInt(x -> x.getM2())
				.sum();
		
		System.out.println(m2TotalesF);
		
		//Paso3 Conseguir un listado de las casa que tengan un salon de m�s de 20 m2
		
		List<Casa> casasSM20 = casas.
				stream().
				filter(e -> e.getSalon().getM2() > 20).collect(Collectors.toList());
		
		//Paso4 Conseguir un listado de Salones con las casas de m�s de una habitaci�n
		
		List<Casa> casasM1H = casas.stream().filter(e -> e.getNumHabitaciones() > 1).
				collect(Collectors.toList());
		
		//Paso5 Conseguir los m2 de todos los salones de las casas
		
		casas.stream()
		.map(e -> e.getSalon())
		.map(x -> x.getM2())
		.forEach(y -> System.out.println("Los m2 de todos los salones: " + y));
		
		//Paso6 Imprimir todas las casas
		
		casas.stream().forEach(e -> System.out.println(e.getNombre()));
		
		//Paso7 Conseguir el numero total de habitaciones de las casas de mas de 1 habitaci�n,
		//      imprimiendo las casas que se han seleccionado.
	
		casas.stream()
		.filter(e -> e.getNumHabitaciones() > 1)
		.forEach(y -> System.out.println(y));
		
	}

}
