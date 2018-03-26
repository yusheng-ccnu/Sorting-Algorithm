package execise;

public class Crow extends Bird implements Fly{
	
	public  Crow() {
		
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		
		System.out.println(name);
		
	}

	@Override
	void intro() {
		// TODO Auto-generated method stub
		System.out.println(super.age);
		
	}

}
