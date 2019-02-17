package com.eduardo.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;

public class BancoNix extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BancoNix frame = new BancoNix();
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
	public BancoNix() {
		setBounds(100, 100, 294, 182);
		getContentPane().setLayout(null);
		
		JLabel lblBemVindoAo = new JLabel("Bem vindo ao Banco Nix");
		lblBemVindoAo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblBemVindoAo.setBounds(39, 59, 205, 14);
		getContentPane().add(lblBemVindoAo);

	}
}
