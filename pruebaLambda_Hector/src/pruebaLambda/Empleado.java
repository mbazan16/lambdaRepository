package pruebaLambda;

public class Empleado implements IVer<Empleado>{
	
	@Override
	public void ver(Empleado element) {
		// TODO Auto-generated method stub
		System.out.println("Elemento:" + element);
	}
}
