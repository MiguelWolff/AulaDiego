package br.com.unicuritiba.Investimento.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Invest {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nome;
	private int meses;
	private double aplicInicial;
	private double rentabilidade;
	private double saldo;
	@ManyToOne
	@JoinColumn(name = "id_user")
	private User user;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getMeses() {
		return meses;
	}
	public void setMeses(int meses) {
		this.meses = meses;
	}
	public double getAplicInicial() {
		return aplicInicial;
	}
	public void setAplicInicial(double aplicInicial) {
		this.aplicInicial = aplicInicial;
	}
	public double getRentabilidade() {
		return rentabilidade;
	}
	public void setRentabilidade(double rentabilidade) {
		this.rentabilidade = rentabilidade;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
}
