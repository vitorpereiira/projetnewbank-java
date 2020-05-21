package model.entities;

import model.exceptions.DomainException;

public class Conta {
	
	
	private String nome;
	private int numero;
	private double saldo;
	private double limsaque;
	
	public Conta(String nome, int numero, double saldo, double limsaque) {
		this.nome = nome;
		this.numero = numero;
		this.saldo = saldo;
		this.limsaque = limsaque;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public double getLimsaque() {
		return limsaque;
	}
	
	public void setLimsaque(Double limSaque) {
		this.limsaque = limSaque;
	}

	public void deposito(double montante) {
		saldo += montante;
	}
	
	public void saque(double montante) {
		if (montante > limsaque) {
			throw new DomainException("O valor excede o limite de saque.");
		}
		if (montante > saldo) {
			throw new DomainException("Saldo insuficiente.");
		}
		saldo -= montante;
		
	}
	
	public String toString() {
		return "Conta: "
				
					+ numero
					+ ", Nome: "
					+ nome
					+ ", Saldo: R$"
					+ String.format("%.2f", saldo);
	}
	

}
