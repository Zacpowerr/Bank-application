package com.eduardo.view;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import com.eduardo.control.TransferenciaControl;
import com.eduardo.control.UsuarioControl;
import com.eduardo.dao.TransferenciaDao;
import com.eduardo.dao.UsuarioDao;
import com.eduardo.model.Transferencia;
import com.eduardo.model.Usuario;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Transferencias extends JInternalFrame {

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Transferencias frame = new Transferencias();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Transferencias() {

		setTitle("Transferencia");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		JLabel lblNomePagador = new JLabel("Nome pagador:");
		lblNomePagador.setBounds(10, 11, 90, 14);
		getContentPane().add(lblNomePagador);

		JLabel lblAgenciaPagador = new JLabel("Agencia pagador:");
		lblAgenciaPagador.setBounds(10, 36, 90, 14);
		getContentPane().add(lblAgenciaPagador);

		JLabel lblContaPagador = new JLabel("Conta pagador:");
		lblContaPagador.setBounds(219, 11, 90, 14);
		getContentPane().add(lblContaPagador);

		JLabel lblNomeBeneficiario = new JLabel("Nome beneficiario:");
		lblNomeBeneficiario.setBounds(10, 80, 105, 14);
		getContentPane().add(lblNomeBeneficiario);

		JLabel lblAgenciaBeneficiario = new JLabel("Agencia beneficiario:");
		lblAgenciaBeneficiario.setBounds(10, 105, 114, 14);
		getContentPane().add(lblAgenciaBeneficiario);

		JLabel lblContaBeneficiario = new JLabel("Conta beneficiario:");
		lblContaBeneficiario.setBounds(219, 80, 114, 14);
		getContentPane().add(lblContaBeneficiario);

		JLabel lblBancoBeneficiario = new JLabel("Banco beneficiario:");
		lblBancoBeneficiario.setBounds(219, 105, 114, 14);
		getContentPane().add(lblBancoBeneficiario);

		JLabel lblValor = new JLabel("Valor :");
		lblValor.setBounds(219, 36, 46, 14);
		getContentPane().add(lblValor);

		tfnomep = new JTextField();
		tfnomep.setBounds(100, 11, 109, 14);
		getContentPane().add(tfnomep);
		tfnomep.setColumns(10);

		tfcontap = new JTextField();
		tfcontap.setColumns(10);
		tfcontap.setBounds(297, 11, 109, 14);
		getContentPane().add(tfcontap);

		tfvalor = new JTextField();
		tfvalor.setColumns(10);
		tfvalor.setBounds(259, 36, 147, 14);
		getContentPane().add(tfvalor);

		tfagenciap = new JTextField();
		tfagenciap.setColumns(10);
		tfagenciap.setBounds(100, 36, 109, 14);
		getContentPane().add(tfagenciap);

		tfnomeb = new JTextField();
		tfnomeb.setColumns(10);
		tfnomeb.setBounds(123, 80, 86, 14);
		getContentPane().add(tfnomeb);

		tfagenciab = new JTextField();
		tfagenciab.setColumns(10);
		tfagenciab.setBounds(123, 105, 86, 14);
		getContentPane().add(tfagenciab);

		tfcontab = new JTextField();
		tfcontab.setColumns(10);
		tfcontab.setBounds(320, 80, 86, 14);
		getContentPane().add(tfcontab);

		tfbancob = new JTextField();
		tfbancob.setColumns(10);
		tfbancob.setBounds(320, 105, 86, 14);
		getContentPane().add(tfbancob);

		JButton btnRealizarTransferencia = new JButton("Realizar Transferencia");
		btnRealizarTransferencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				transControl.realizarAction();

			}
		});
		btnRealizarTransferencia.setBounds(137, 205, 164, 23);
		getContentPane().add(btnRealizarTransferencia);
		usuarioControl = new UsuarioControl(null, null, tfnomep, tfcontap, tfvalor, tfagenciap, tfnomeb, tfagenciab, tfcontab, tfbancob, usuario, usuarioDao);
		transControl = new TransferenciaControl(trans, transDao, transControl, tfnomep, tfcontap, tfvalor, tfagenciap,
				tfnomeb, tfagenciab, tfcontab, tfbancob, usuarioControl, usuario, usuarioDao);
	}
}
