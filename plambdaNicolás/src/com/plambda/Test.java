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
		int m2Totales = casas.stream().mapToInt(c -> c.getM2()).sum();
		System.out.println("1. m2 totales: " + m2Totales);

		// Paso2 Conseguir los m2 totales de las casas del listado
		// que tengan un nombre de menos de 4 caracteres
		int m2TotalesNombreCorto = casas.stream().filter(c -> c.getNombre().length() < 4).mapToInt(c -> c.getM2())
				.sum();
		System.out.println(
				"\n2. m2 totales de las casas con un nombre de menos de 4 caracteres: " + m2TotalesNombreCorto);

		// Paso3 Conseguir un listado de las casa que tengan un salon de m�s de 20 m2
		// List<Casa> casasConSalonGrande = new ArrayList<>(casas.stream().filter(c ->
		List<Casa> casasConSalonGrande = casas.stream().filter(c -> c.getSalon().getM2() > 20)
				.collect(Collectors.toCollection(ArrayList::new));
		System.out.println("\n3. Casas que tienen un salon de mas de 20 m2: " + casasConSalonGrande);

		// Paso4 Conseguir un listado de Salones con las casas de m�s de una habitaci�n
		List<Salon> salonesDeCasasGrandes = casas.stream().filter(c -> c.getNumHabitaciones() > 1)
				.map(c -> c.getSalon()).collect(Collectors.toCollection(ArrayList::new));
		System.out.println("\n4. Salones de las casas de mas de una habitacion: " + salonesDeCasasGrandes);

		// Paso5 Conseguir los m2 de todos los salones de las casas
		int m2SalonesTotales = casas.stream().mapToInt(c -> c.getSalon().getM2()).sum();
		System.out.println("\n5. m2 de todos los salones: " + m2SalonesTotales);

		// Paso6 Imprimir todas las casas
		System.out.println("\n6. Todas las casas: " + casas);

		// Paso7 Conseguir el numero total de habitaciones de las casas de mas de 1
		// habitaci�n, imprimiendo las casas que se han seleccionado.
		List<Casa> casasGrandes = casas.stream().filter(c -> c.getNumHabitaciones() > 1)
				.collect(Collectors.toCollection(ArrayList::new));
		int habitacionesTotales = casasGrandes.stream().mapToInt(c -> c.getNumHabitaciones()).sum();
		System.out.println("\n7. Habitaciones totales de las casas de mas de 1 habitacion: " + habitacionesTotales
				+ "\n Casas con más de 1 habitacion: " + casasGrandes);

	}

}
