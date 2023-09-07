package main;

import java.util.Scanner;
import beans.Cliente;
import beans.ConnectionFactory;
<<<<<<< HEAD
import beans.VeiculoDAO;

public class AutoHelp {
    public static void main(String[] args) {
=======


public class AutoHelp {
    public static void main(String[] args) {
    	
    	ConnectionFactory c1 = new ConnectionFactory();
    	
    	c1.criaConexao();
    	
>>>>>>> 353abf6b4f7b5876ea2536dae5ea869534795748
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
