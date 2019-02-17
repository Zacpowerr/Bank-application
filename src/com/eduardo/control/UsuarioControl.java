package com.eduardo.control;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.eduardo.dao.UsuarioDao;
import com.eduardo.model.Usuario;

public class UsuarioControl {
	private JTextField tfNomel;
	private JTextField tfCNPJl;
	private JTextField tfnomep;
	private JTextField tfcontap;
	private JTextField tfvalor;
	private JTextField tfagenciap;
	private JTextField tfnomeb;
	private JTextField tfagenciab;
	private JTextField tfcontab;
	private JTextField tfbancob;
	private JTextField textField;
	private JTextField textField_1;

	private Usuario usuario = null;
	private UsuarioDao usuarioDao = null;

	private String nome;
	private String cnpj;

	public UsuarioControl(JTextField tfNomel, JTextField tfCNPJl, JTextField tfnomep, JTextField tfcontap,
			JTextField tfvalor, JTextField tfagenciap, JTextField tfnomeb, JTextField tfagenciab, JTextField tfcontab,
			JTextField tfbancob, Usuario usuario, UsuarioDao usuarioDao) {
		super();
		this.tfNomel = tfNomel;
		this.tfCNPJl = tfCNPJl;
		this.tfnomep = tfnomep;
		this.tfcontap = tfcontap;
		this.tfvalor = tfvalor;
		this.tfagenciap = tfagenciap;
		this.tfnomeb = tfnomeb;
		this.tfagenciab = tfagenciab;
		this.tfcontab = tfcontab;
		this.tfbancob = tfbancob;
		this.usuario = new Usuario();
		this.usuarioDao = new UsuarioDao();
	}

	public UsuarioControl(Usuario usuario, UsuarioDao usuarioDao, JTextField tfNomel, JTextField tfCNPJl) {
		this.tfNomel = tfNomel;
		this.tfCNPJl = tfCNPJl;
		this.usuario = new Usuario();
		this.usuarioDao = new UsuarioDao();
	}
	
	public UsuarioControl(JTextField textField, JTextField textField_1, Usuario usuario, UsuarioDao usuarioDao) {
		super();
		this.textField = textField;
		this.textField_1 = textField_1;
		this.usuario = usuario;
		this.usuarioDao = usuarioDao;
	}

	public boolean Verificar() {
		nome = tfNomel.getText();
		cnpj = tfCNPJl.getText();

		boolean res = usuarioDao.verifica(nome, cnpj);
		if (res) {
			return true;
		} else {
			return false;
		}

	}

	public void cadastrar() {
		usuario.setNome(textField.getText());
		usuario.setCnpj(textField_1.getText());
		boolean res = usuarioDao.cadastrar(usuario);
		if (res) {
			JOptionPane.showMessageDialog(null, "Cadastro efetuado");
		}
	}

	public Usuario VerificarU() {
		nome = tfnomep.getText();
		return usuario = usuarioDao.verifica(nome);

	}

}
