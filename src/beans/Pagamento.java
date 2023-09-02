package beans;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class Pagamento {
    private double valor;

    public Pagamento() {
        this.valor = gerarValorAleatorio(100, 1500);
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        return "Valor: R$ " + decimalFormat.format(valor);
    }

    private double gerarValorAleatorio(double min, double max) {
        Random random = new Random();
        return min + (max - min) * random.nextDouble();
    }
    
    public String escolherMetodoPagamento(Scanner scanner) {
        System.out.print("Deseja pagar com cartão? (S/N): ");
        String resposta = scanner.nextLine().toUpperCase();

        if (resposta.equals("S")) {
            return "Cartão";
        } else {
            return "Dinheiro";
        }
    }
}
