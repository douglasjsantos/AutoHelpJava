package main;
import java.util.Scanner;
import beans.Cliente;
import beans.ConnectionFactory;


public class AutoHelp {
    public static void main(String[] args) {
    	
    	ConnectionFactory c1 = new ConnectionFactory();
    	
    	c1.criaConexao();
    	
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu email: ");
        String email = scanner.nextLine();

        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();

        Cliente cliente = new Cliente(email, senha);
        cliente.exibirMenuPrincipal(scanner);

        scanner.close();
        
        
        
    }
}
