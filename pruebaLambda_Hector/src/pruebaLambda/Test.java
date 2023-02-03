package pruebaLambda;


import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<Casa> lista = new ArrayList<Casa>();
		
		Casa c1 = new Casa(2);
		Casa c2 = new Casa(4);
		Casa c3 = new Casa(7);
		
		lista.add(c1);
		lista.add(c2);
		lista.add(c3);
		
		int habTotal = 0;
		
		for (Casa c : lista) {
			System.out.println(c.getNumHab());
			habTotal += c.getNumHab();
		}
		
		lista.stream().mapToInt(a -> a.getNumHab()).forEach(System.out::println);
		habTotal = lista.stream().mapToInt(a -> a.getNumHab()).sum();
		System.out.println("" + habTotal);
		lista.forEach(a -> System.out.println(a.getNumHab()));
		lista.forEach(null);
	}
}
