package beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente {
    private String email;
    private String senha;
    private List<Solicitacao> solicitacoes;
    private int numeroPedidos;
    private List<Veiculo> veiculos;
    private VeiculoDAO veiculoDAO; 

    
    public Cliente(String email, String senha, VeiculoDAO veiculoDAO) {
        this.email = email;
        this.senha = senha;
        this.solicitacoes = new ArrayList<>();
        this.veiculos = new ArrayList<>();
        this.veiculoDAO = veiculoDAO; 
    }

    public List<Solicitacao> getSolicitacoes() {
        return solicitacoes;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void incrementarNumeroPedidos() {
        this.numeroPedidos++;
    }

    public int getNumeroPedidos() {
        return numeroPedidos;
    }

    public void exibirMenuPrincipal(Scanner scanner) {
        int opcao;
        do {
            System.out.println("===== Menu Principal =====");
            System.out.println("1. Minhas solicitações");
            System.out.println("2. Solicitar guincho");
            System.out.println("3. Suporte ao cliente");
            System.out.println("4. Cadastrar veículo");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    exibirMinhasSolicitacoes();
                    break;
                case 2:
                    solicitarGuincho(scanner);
                    break;
                case 3:
                    exibirSuporteAoCliente(scanner);
                    break;
                case 4:
                    cadastrarVeiculo(scanner);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void exibirMinhasSolicitacoes() {
        System.out.println("===== Minhas Solicitações =====");
        if (solicitacoes.isEmpty()) {
            System.out.println("Nenhuma solicitação encontrada.");
        } else {
            for (Solicitacao solicitacao : solicitacoes) {
                System.out.println("Motorista: " + solicitacao.getNomeMotorista());
                System.out.println("Valor: R$ " + String.format("%.2f", solicitacao.getValor()));
                System.out.println("Distância: " + solicitacao.getDistancia() + " km");
                System.out.println("==========");
            }
        }
    }

    private void solicitarGuincho(Scanner scanner) {

        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado. Cadastre um veículo primeiro.");
            return;
        }

        System.out.println("Veículos disponíveis:");
        List<Veiculo> veiculosDisponiveis = listarVeiculos();
        for (int i = 0; i < veiculosDisponiveis.size(); i++) {
            System.out.println((i + 1) + ". " + veiculosDisponiveis.get(i).getMarca() + " " + veiculosDisponiveis.get(i).getModelo());
        }

        System.out.print("Escolha um veículo (número): ");
        int escolhaVeiculo = scanner.nextInt();
        scanner.nextLine();

        if (escolhaVeiculo < 1 || escolhaVeiculo > veiculosDisponiveis.size()) {
            System.out.println("Escolha de veículo inválida.");
            return;
        }

        Veiculo veiculoSelecionado = veiculosDisponiveis.get(escolhaVeiculo - 1);

        System.out.println("===== Solicitar Guincho =====");
        System.out.print("Foto Frontal [A, B, C, D, E, F ou G]: ");
        String fotoFrontal = scanner.nextLine();

        System.out.print("Foto Traseira [A, B, C, D, E, F ou G]: ");
        String fotoLateral = scanner.nextLine();

        Algoritmo algoritmo = new Algoritmo();
        String melhorGuincho = algoritmo.escolherMelhorGuincho(fotoFrontal, fotoLateral);

        if (!melhorGuincho.equals("Nenhum guincho disponível")) {
            System.out.println("Seu veículo é: " + melhorGuincho);

            Pagamento pagamento = new Pagamento();
            double valor = pagamento.getValor();
            System.out.println("Valor: R$ " + String.format("%.2f", valor));

            System.out.print("Deseja pagar com cartão? (S/N): ");
            String opcaoPagamento = scanner.nextLine();

            if (opcaoPagamento.equalsIgnoreCase("S")) {
                System.out.println("Você selecionou o método de pagamento: Cartão");
            } else {
                System.out.println("Você selecionou o método de pagamento: Dinheiro");
            }

            System.out.print("Deseja solicitar guincho? (S/N): ");
            String opcaoSolicitarGuincho = scanner.nextLine();

            if (opcaoSolicitarGuincho.equalsIgnoreCase("S")) {
                System.out.println("Guincho solicitado com sucesso!");

                System.out.println("Encontrando o melhor motorista para você...");
                esperar(5000);

                String motoristaAleatorio = Motorista.obterMotoristaAleatorio();
                System.out.println(motoristaAleatorio + " está a caminho.");
                esperar(5000);

                int distancia = Motorista.gerarDistancia();
                int tempoEspera = Motorista.gerarTempoEspera();
                System.out.println("Distância: " + distancia + " km");
                System.out.println("Tempo de espera: " + tempoEspera + " minutos");
                esperar(5000);

                System.out.println(motoristaAleatorio + " chegou.");

                System.out.print("Avalie o serviço (1 a 5 estrelas): ");
                int avaliacao = scanner.nextInt();
                scanner.nextLine();

                Solicitacao solicitacao = new Solicitacao(motoristaAleatorio, valor, distancia);
                solicitacoes.add(solicitacao);

                incrementarNumeroPedidos();

                System.out.println("Obrigado por utilizar a AutoHelp!");
            }
        } else {
            System.out.println("Não há guinchos disponíveis para o seu veículo.");
        }
    }

    private void exibirSuporteAoCliente(Scanner scanner) {
        System.out.println("===== Suporte ao Cliente =====");
        System.out.print("Digite sua reclamação: ");
        String reclamacao = scanner.nextLine();

        Suporte suporte = new Suporte(this, reclamacao);
        suporte.registrarReclamacao();
    }

    
    private void cadastrarVeiculo(Scanner scanner) {
        System.out.println("===== Cadastrar Veículo =====");

        System.out.print("Marca do veículo: ");
        String marca = scanner.nextLine();

        System.out.print("Modelo do veículo: ");
        String modelo = scanner.nextLine();

        System.out.print("Tipo do veículo: ");
        String tipo = scanner.nextLine();

        System.out.print("Carga do veículo: ");
        String carga = scanner.nextLine();

        System.out.print("Ano do veículo: ");
        String ano = scanner.nextLine();

        Veiculo novoVeiculo = new Veiculo();
        novoVeiculo.setMarca(marca);
        novoVeiculo.setModelo(modelo);
        novoVeiculo.setTipo(tipo);
        novoVeiculo.setCarga(carga);
        novoVeiculo.setAno(ano);

       
        veiculoDAO.adiciona(novoVeiculo);

     
        veiculos.add(novoVeiculo);

        System.out.println("Veículo cadastrado com sucesso!");
    }

    private void esperar(int milissegundos) {
        try {
            Thread.sleep(milissegundos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

   
    public List<Veiculo> listarVeiculos() {
        return veiculos;
    }
}
