package lambda;


public class Salon {

	private int m2;

	public Salon() {
		super();
	}
	
	public Salon(int m2) {
		super();
		this.m2 = m2;
	}

	public int getM2() {
		return m2;
	}

	public void setM2(int m2) {
		this.m2 = m2;
	}

	@Override
	public String toString() {
		return "Salon [m2=" + m2 + "]";
	}	
	
	
}
