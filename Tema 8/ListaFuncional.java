import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.stream.Collectors;

public class ListaFuncional {
    public static void main(String[] args) {
        // Creamos una lista a la que añadiremos los números aleatorios
        ArrayList<Integer> numeros = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            numeros.add(random.nextInt(100) + 1);
        }
        System.out.println("===Lista inicial===");
        System.out.println(numeros);
        System.out.println("===Lista ordenada===");
        System.out.println(numeros.stream().sorted().collect(Collectors.toList()));
        System.out.println("===Lista ordenada de los números impares===");
        System.out.println(numeros.stream().sorted().filter(x -> x % 2 != 0).collect(Collectors.toList()));
        System.out.print("==Máximo: "+numeros.stream().max(Comparator.naturalOrder()).orElse(0)+"\n");
        System.out.print("==Mínimo: "+numeros.stream().min(Comparator.naturalOrder()).orElse(0)+"\n");
    }
}