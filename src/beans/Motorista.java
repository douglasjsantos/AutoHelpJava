package beans;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Motorista {
    private static final List<String> nomes = Arrays.asList(
            "Fábio Pimenta",
            "João Victor",
            "Junior Matias",
            "Patrick Paixão",
            "Hiago Guimarães"
        );

        public static String obterMotoristaAleatorio() {
            Random random = new Random();
            int indice = random.nextInt(nomes.size());
            return nomes.get(indice);
        }

        public static int gerarDistancia() {
            Random random = new Random();
            return random.nextInt(31) + 10;
        }

        public static int gerarTempoEspera() {
            Random random = new Random();
            return random.nextInt(36) + 20;
        }
}
