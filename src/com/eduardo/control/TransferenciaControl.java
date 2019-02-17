package com.eduardo.control;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.eduardo.dao.TransferenciaDao;
import com.eduardo.dao.UsuarioDao;
import com.eduardo.model.Transferencia;
import com.eduardo.model.Usuario;

public class TransferenciaControl {

	private Transferencia trans;
	private TransferenciaDao transDao;
	private TransferenciaControl transControl;
	private JTextField tfnomep;
	private JTextField tfcontap;
	private JTextField tfvalor;
	private JTextField tfagenciap;
	private JTextField tfnomeb;
	private JTextField tfagenciab;
	private JTextField tfcontab;
	private JTextField tfbancob;

	private UsuarioControl usuarioControl;
	private Usuario usuario;
	private UsuarioDao usuarioDao;
	private List<Transferencia> listtrans = null;
	private JTable table;

	public TransferenciaControl(Transferencia trans, TransferenciaDao transDao, TransferenciaControl transControl,
			JTextField tfnomep, JTextField tfcontap, JTextField tfvalor, JTextField tfagenciap, JTextField tfnomeb,
			JTextField tfagenciab, JTextField tfcontab, JTextField tfbancob, UsuarioControl usuarioControl,
			Usuario usuario, UsuarioDao usuarioDao) {
		super();

		this.trans = new Transferencia();
		this.transDao = new TransferenciaDao();
		this.transControl = transControl;
		this.tfnomep = tfnomep;
		this.tfcontap = tfcontap;
		this.tfvalor = tfvalor;
		this.tfagenciap = tfagenciap;
		this.tfnomeb = tfnomeb;
		this.tfagenciab = tfagenciab;
		this.tfcontab = tfcontab;
		this.tfbancob = tfbancob;
		this.usuarioControl = usuarioControl;
		this.usuario = new Usuario();
		this.usuarioDao = new UsuarioDao();
	}

	public TransferenciaControl(JTable table) {
		super();
		this.table = table;
		this.trans = new Transferencia();
		this.transDao = new TransferenciaDao();
		this.usuario = new Usuario();
		this.usuarioDao = new UsuarioDao();
	}

	public void realizarAction() {
		usuario = usuarioControl.VerificarU();
		trans = new Transferencia();
		trans.setPagador_nome(tfnomep.getText());
		trans.setPagador_agencia(tfagenciap.getText());
		trans.setPagador_conta(tfcontap.getText());
		trans.setBeneficiario_agencia(tfagenciab.getText());
		trans.setValor(Integer.parseInt(tfvalor.getText()));
		trans.setBeneficiario_nome(tfnomeb.getText());
		trans.setBeneficiario_conta(tfcontab.getText());
		trans.setBeneficiario_banco(tfbancob.getText());
		trans.setUsuario_id(usuario.getId());
		trans.setPagador_banco("Nix");

		if (tfbancob.getText().equals("Nix")) {
			trans.setTipo("CC");
			if (Integer.parseInt(tfvalor.getText()) > 1000000) {
				trans.setStatus("ERRO");
			} else {
				trans.setStatus("OK");
			}
		} else if (Integer.parseInt(tfvalor.getText()) < 5000) {
			trans.setTipo("TED");
			trans.setStatus("OK");
		} else {
			trans.setTipo("DOC");
			if (Integer.parseInt(tfvalor.getText()) > 1000000) {
				trans.setStatus("ERRO");
			} else {
				trans.setStatus("OK");
			}

		}
		transDao.cadastrar(trans);

	}

	public void listarAction() {
		listtrans = transDao.listar();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setNumRows(0);
		for (Transferencia t : listtrans) {
			model.addRow(new Object[] { t.getUsuario_id(), t.getPagador_nome(), t.getPagador_banco(),
					t.getPagador_agencia(), t.getPagador_conta(), t.getBeneficiario_nome(), t.getBeneficiario_banco(),
					t.getBeneficiario_agencia(), t.getBeneficiario_conta(), t.getTipo(), t.getStatus(), t.getValor() });
		}

	}

	public void filtropAction() {
		listtrans = transDao.listarp();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setNumRows(0);
		for (Transferencia t : listtrans) {
			model.addRow(new Object[] { t.getUsuario_id(), t.getPagador_nome(), t.getPagador_banco(),
					t.getPagador_agencia(), t.getPagador_conta(), t.getBeneficiario_nome(), t.getBeneficiario_banco(),
					t.getBeneficiario_agencia(), t.getBeneficiario_conta(), t.getTipo(), t.getStatus(), t.getValor() });
		}
	}

	public void filtrobAction() {
		listtrans = transDao.listarb();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setNumRows(0);
		for (Transferencia t : listtrans) {
			model.addRow(new Object[] { t.getUsuario_id(), t.getPagador_nome(), t.getPagador_banco(),
					t.getPagador_agencia(), t.getPagador_conta(), t.getBeneficiario_nome(), t.getBeneficiario_banco(),
					t.getBeneficiario_agencia(), t.getBeneficiario_conta(), t.getTipo(), t.getStatus(), t.getValor() });
		}
	}

	private Transferencia getItemSelecionado() {
		int linha = table.getSelectedRow();
		if (linha >= 0) {
			trans = listtrans.get(linha);
		}
		return trans;
	}

	public void excluirAction() {
		trans = getItemSelecionado();
		boolean res = transDao.excluir(trans);
		if(res) {
			JOptionPane.showMessageDialog(null, "Excluído com sucesso");
			listarAction();
		}else {
			JOptionPane.showMessageDialog(null, "Falha ao excluir");
		}
		trans = null;
		
		

	}
}
