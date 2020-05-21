package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Conta;
import model.exceptions.DomainException;

public class Program {

	

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner leia = new Scanner(System.in);
		

		System.out.println("Dados para cadastro da conta.");
		System.out.print("Digite o numero da conta ->");
		int numero = leia.nextInt();
		System.out.print("Digite o nome do cliente ->");
		leia.nextLine();
		String nome = leia.nextLine();
		System.out.print("Saldo inicial: ");
		Double saldo = leia.nextDouble();
		System.out.print("Limite de saque :");
		double limsaque = leia.nextDouble();
				
		Conta conta = new Conta(nome, numero, saldo, limsaque);
		
		System.out.println();
		System.out.print("Digite o valor de saque: ");
		double montante = leia.nextDouble();
		try {
			conta.saque(montante);
			System.out.println("Novo saldo: " + String.format("%.2f", conta.getSaldo()));
			
		}
		catch (DomainException e) {
			System.out.println("Erro de saque: " + e.getMessage());
		}
		
		
		leia.close();
		
		

}
}
