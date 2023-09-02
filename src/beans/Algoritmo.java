package beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Algoritmo {
    public String escolherMelhorGuincho(String fotoFrontal, String fotoLateral) {
        List<String> opcoesValidas = new ArrayList<>();
        opcoesValidas.add("A");
        opcoesValidas.add("B");
        opcoesValidas.add("C");
        opcoesValidas.add("D");
        opcoesValidas.add("E");
        opcoesValidas.add("F");
        opcoesValidas.add("G");

        String foto1 = fotoFrontal.toUpperCase();
        String foto2 = fotoLateral.toUpperCase();

        if (!opcoesValidas.contains(foto1) || !opcoesValidas.contains(foto2)) {
            return "Nenhum guincho disponível";
        }

        List<String> opcoesSelecionadas = new ArrayList<>();
        opcoesSelecionadas.add(foto1);
        opcoesSelecionadas.add(foto2);

        Random random = new Random();
        int indiceSelecionado = random.nextInt(opcoesSelecionadas.size());
        return opcoesSelecionadas.get(indiceSelecionado);
    }
}
