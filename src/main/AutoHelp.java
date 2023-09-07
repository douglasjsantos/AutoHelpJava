package main;

import java.util.Scanner;
import beans.Cliente;
import beans.ConnectionFactory;
import beans.VeiculoDAO;

public class AutoHelp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu email: ");
        String email = scanner.nextLine();

        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();
       
        ConnectionFactory conexaoFactory = new ConnectionFactory();

        VeiculoDAO veiculoDAO = new VeiculoDAO(conexaoFactory.criaConexao());

        Cliente cliente = new Cliente(email, senha, veiculoDAO);

        cliente.exibirMenuPrincipal(scanner);

        scanner.close();
    }
}
