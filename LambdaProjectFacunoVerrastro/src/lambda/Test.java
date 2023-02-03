package lambda;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lambda.Casa;
import lambda.Salon;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Casa casa1 = new Casa(3, 90, "una", new Salon(25));
		Casa casa2 = new Casa(2, 50, "dos", new Salon(15));
		Casa casa3 = new Casa(1, 50, "tres", new Salon(20));

		List<Casa> casas = new ArrayList<Casa>();
		casas.add(casa1);
		casas.add(casa2);
		casas.add(casa3);
		
		//Paso1 Conseguir los m2 totales de las casas del listado
		int totales1=casas.stream().mapToInt( c -> c.getM2()).sum();
		int totales2=casas.stream().mapToInt(Casa::getM2).sum();
				
		//Paso2 Conseguir los m2 totales de las casas del listado 
		//que tengan un nombre de menos de 4 caracteres
		int menosDe4Caracteres = casas.stream().filter(a->a.getNombre().length()<4).mapToInt( c -> c.getM2()).sum();
		System.out.println(menosDe4Caracteres);
		
		//Paso3 Conseguir un listado de las casa que tengan un salon de m�s de 20 m2
		List<Casa> casasMas20M2 = casas.stream().filter(c->c.getM2()>20).collect(Collectors.toList());
		System.out.println(casasMas20M2);
		
		//Paso4 Conseguir un listado de Salones con las casas de m�s de una habitaci�n
//		List<Salon> salones = casas.stream()
//				.filter(null)
		
				
		//Paso5 Conseguir los m2 de todos los salones de las casas
		
		
		
		
		//Paso6 Imprimir todas las casas
		
	
		
		//Paso7 Conseguir el numero total de habitaciones de las casas de mas de 1 habitaci�n,
		//      imprimiendo las casas que se han seleccionado.
		
		
	}

}
