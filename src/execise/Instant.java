package execise;

public class Instant {
	public static void main(String[] args) {
		Crow c = new Crow();
		SonOfCrow sc = new SonOfCrow();
		System.out.println(c instanceof Crow);
		System.out.println(sc instanceof Crow);
		System.out.println(c instanceof Fly);
	}

}
