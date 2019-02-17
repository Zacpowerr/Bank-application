package com.eduardo.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.eduardo.control.UsuarioControl;
import com.eduardo.dao.UsuarioDao;
import com.eduardo.model.Usuario;

public class GerenciarUsuario extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private Usuario usuario = null;
	private UsuarioDao usuarioDao = null;
	private UsuarioControl usuarioControl = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GerenciarUsuario frame = new GerenciarUsuario();
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
	public GerenciarUsuario() {
		setClosable(true);
		setTitle("Gerenciar Usuarios");
		setBounds(100, 100, 244, 181);
		getContentPane().setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(37, 35, 46, 14);
		getContentPane().add(lblNome);

		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setBounds(37, 77, 46, 14);
		getContentPane().add(lblCnpj);

		textField = new JTextField();
		textField.setBounds(78, 32, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(78, 74, 86, 20);
		getContentPane().add(textField_1);

		JButton btnCriar = new JButton("Criar");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				usuarioControl.cadastrar();

			}
		});
		btnCriar.setBounds(78, 120, 78, 20);
		getContentPane().add(btnCriar);
		usuarioControl = new UsuarioControl(usuario, usuarioDao, textField, textField_1);
	}
}
