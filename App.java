import java.util.ArrayList;
import java.util.Random;

public class App {
    private static Random dado = new Random();

    public static double girarDado() {
        double valorDado = dado.nextDouble() * 10; // Gera um número entre 0 e 10
        System.out.println(valorDado); // Imprime o valor do dado (só pra teste)
        return valorDado;
    }
    public static void main(String[] args) {

        ArrayList<Castelo> listaDeCastelos = new ArrayList<>();

        listaDeCastelos.add(new Japones(2, 2, "C1", 15));
        listaDeCastelos.add(new Japones(2, 2, "C2", 15));
        listaDeCastelos.add(new Europeu(3, 2, "C3", 10));
        listaDeCastelos.add(new Europeu(3, 2, "C4", 10));

        girarDado();


    }
}
