package com.eduardo.model;

public class Transferencia {
	private int id;
	private int usuario_id;
	private String pagador_nome;
	private String pagador_banco;
	private String pagador_agencia;
	private String pagador_conta;
	private String beneficiario_nome;
	private String beneficiario_banco;
	private String beneficiario_agencia;
	private String beneficiario_conta;
	private int valor;
	private String tipo;
	private String status;

	public Transferencia() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(int usuario_id) {
		this.usuario_id = usuario_id;
	}

	public String getPagador_nome() {
		return pagador_nome;
	}

	public void setPagador_nome(String pagador_nome) {
		this.pagador_nome = pagador_nome;
	}

	public String getPagador_banco() {
		return pagador_banco;
	}

	public void setPagador_banco(String pagador_banco) {
		this.pagador_banco = pagador_banco;
	}

	public String getPagador_agencia() {
		return pagador_agencia;
	}

	public void setPagador_agencia(String pagador_agencia) {
		this.pagador_agencia = pagador_agencia;
	}

	public String getPagador_conta() {
		return pagador_conta;
	}

	public void setPagador_conta(String pagador_conta) {
		this.pagador_conta = pagador_conta;
	}

	public String getBeneficiario_nome() {
		return beneficiario_nome;
	}

	public void setBeneficiario_nome(String beneficiario_nome) {
		this.beneficiario_nome = beneficiario_nome;
	}

	public String getBeneficiario_banco() {
		return beneficiario_banco;
	}

	public void setBeneficiario_banco(String beneficiario_banco) {
		this.beneficiario_banco = beneficiario_banco;
	}

	public String getBeneficiario_agencia() {
		return beneficiario_agencia;
	}

	public void setBeneficiario_agencia(String beneficiario_agencia) {
		this.beneficiario_agencia = beneficiario_agencia;
	}

	public String getBeneficiario_conta() {
		return beneficiario_conta;
	}

	public void setBeneficiario_conta(String beneficiario_conta) {
		this.beneficiario_conta = beneficiario_conta;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
