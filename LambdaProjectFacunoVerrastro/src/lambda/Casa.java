package lambda;


public class Casa {
	
	private int numHabitaciones;
	private int m2;
	private String nombre;
	private Salon salon;
	
	public Casa() {
		super();
	}

	public Casa(int numHabitaciones, int m2, String nombre, Salon salon) {
		super();
		this.numHabitaciones = numHabitaciones;
		this.m2 = m2;
		this.nombre = nombre;
		this.salon = salon;
	}

	public int getNumHabitaciones() {
		return numHabitaciones;
	}

	public void setNumHabitaciones(int numHabitaciones) {
		this.numHabitaciones = numHabitaciones;
	}

	public int getM2() {
		return m2;
	}

	public void setM2(int m2) {
		this.m2 = m2;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Salon getSalon() {
		return salon;
	}

	public void setSalon(Salon salon) {
		this.salon = salon;
	}

	@Override
	public String toString() {
		return "Casa [numHabitaciones=" + numHabitaciones + ", m2=" + m2 + ", nombre=" + nombre + ", salon=" + salon
				+ "]";
	}
	
	

}
