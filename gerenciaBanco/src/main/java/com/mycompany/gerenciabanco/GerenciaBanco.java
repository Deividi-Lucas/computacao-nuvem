/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gerenciabanco;
import java.util.Scanner;

/**
 *
 * @author Deividi
 */
public class GerenciaBanco {

    public static void main(String[] args) {
        // Coleta dados do usuário
        try (Scanner scanner = new Scanner(System.in)) {
            // Coleta dados do usuário
            System.out.println("Bem-vindo ao Gerenciador Bancario!");
            System.out.print("Informe seu nome: ");
            String nome = scanner.nextLine();
            System.out.print("Informe seu sobrenome: ");
            String sobrenome = scanner.nextLine();
            System.out.print("Informe seu CPF: ");
            String cpf = scanner.nextLine();
            
            ContaBancaria conta = new ContaBancaria(nome, sobrenome, cpf);
            
            int opcao;
            do {
                exibirMenu();
                opcao = scanner.nextInt();
                
                switch (opcao) {
                    case 1 -> System.out.println("Saldo atual: R$" + conta.getSaldo());
                    case 2 -> {
                        System.out.print("Valor do deposito: R$");
                        double valorDeposito = scanner.nextDouble();
                        conta.depositar(valorDeposito);
                    }
                    case 3 -> {
                        System.out.print("Valor do saque: R$");
                        double valorSaque = scanner.nextDouble();
                        conta.sacar(valorSaque);
                    }
                    case 4 -> System.out.println("Obrigado por utilizar o Gerenciador Bancario!");
                    default -> System.out.println("Opcao invalida.");
                }
            } while (opcao != 4);
        }
    }

    public static void exibirMenu() {
    System.out.println();
    System.out.println("======================================");
    System.out.println("         GERENCIADOR BANCARIO         ");
    System.out.println("======================================");
    System.out.println("1 - Consultar Saldo");
    System.out.println("2 - Realizar Deposito");
    System.out.println("3 - Realizar Saque");
    System.out.println("4 - Encerrar");
    System.out.println("--------------------------------------");
    System.out.print("Escolha uma opcao: ");
    }
}

// Classe para dados pessoais e operações bancárias
class ContaBancaria {
    private String nome;
    private String sobrenome;
    private String cpf;
    private double saldo;

    public ContaBancaria(String nome, String sobrenome, String cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome; 
       this.cpf = cpf;
        this.saldo = 0.0;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("\nDeposito realizado com sucesso!");
        } else {
            System.out.println("\nValor de depósito inválido.");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("\nSaque realizado com sucesso!");
        } else {
            System.out.println("\nValor de saque invalido ou saldo insuficiente.");
        }
    }
}
