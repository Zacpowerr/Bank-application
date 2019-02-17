package com.eduardo.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import com.eduardo.control.TransferenciaControl;
import com.eduardo.dao.TransferenciaDao;

import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GerenciarTransferencias extends JInternalFrame {
	private JTable table;
	private Transferencias trans;
	private TransferenciaControl transControl;
	private TransferenciaDao transDao;
	private int statusp = 0;
	private int statusb = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GerenciarTransferencias frame = new GerenciarTransferencias();
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
	public GerenciarTransferencias() {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameOpened(InternalFrameEvent arg0) {
				transControl.listarAction();
			}
		});
		setTitle("Gerenciamento de Transferencias");
		setBounds(100, 100, 1199, 400);
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 81, 1163, 278);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID pagador", "Nome pagador", "Banco pagador", "Agencia pagador", "Conta pagador",
						"Nome beneficiario", "Banco beneficiario", "Agencia beneficiario", "Conta beneficiario", "Tipo",
						"Status", "Valor" }));
		scrollPane.setViewportView(table);
		transControl = new TransferenciaControl(table);
		JRadioButton rdbtnBeneficiarios = new JRadioButton("Beneficiarios");
		JRadioButton rdbtnPagadores = new JRadioButton("Pagadores");
		rdbtnPagadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				statusp++;
				if(statusp ==1 ) {
					rdbtnBeneficiarios.setEnabled(false);
					transControl.filtropAction();
				}else {
					transControl.listarAction();
					statusp = 0;
					rdbtnBeneficiarios.setEnabled(true);
				}
				
			}
		});
		rdbtnPagadores.setBounds(157, 28, 109, 23);
		getContentPane().add(rdbtnPagadores);
		
		
		rdbtnBeneficiarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				statusb++;
				if(statusb ==1) {
					rdbtnPagadores.setEnabled(false);
					transControl.filtrobAction();	
				}else {
					transControl.listarAction();
					statusb = 0;
					rdbtnPagadores.setEnabled(true);
				}
				
			}
		});
		rdbtnBeneficiarios.setBounds(268, 28, 109, 23);
		getContentPane().add(rdbtnBeneficiarios);
		
		JLabel lblFiltros = new JLabel("Filtros:");
		lblFiltros.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblFiltros.setBounds(34, 30, 73, 14);
		getContentPane().add(lblFiltros);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				transControl.excluirAction();
			}
		});
		btnExcluir.setBounds(652, 28, 89, 23);
		getContentPane().add(btnExcluir);
	}
}
