package lojasnews;

public class LojasNewsPrincipal {

	public static void main(String[] args) {
		System.out.println("Olá mundo");

		Produto p1 = new Produto("caneta", 1.5, 25);
		Produto p2 = new Produto("lapis", 1.0, 25);
		
		System.out.println(p1.getCodigo() +" - "+ p1.getNome());
		System.out.println(p2.getCodigo() +" - "+ p2.getNome());
	}

}
