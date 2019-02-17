package com.eduardo.view;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;

public class TelaPrincipal {

	private JFrame frame;
	private BancoNix bemvindo = null;
	private Transferencias trans = null;
	private GerenciarTransferencias view = null;
	private GerenciarUsuario usuario = null;
	private static JDesktopPane desktopPane;
	private JScrollPane scrollPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				bemvindo = new BancoNix();
				desktopPane.add(bemvindo);
				bemvindo.setBounds(0, 0, desktopPane.getWidth(), desktopPane.getHeight());
				bemvindo.show();

			}
		});
		frame.setBounds(100, 100, 330, 264);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnTransferencias = new JMenu("Transferencias");
		menuBar.add(mnTransferencias);

		JMenuItem mntmVisualizar = new JMenuItem("Visualizar");
		mntmVisualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				desktopPane.removeAll();
				frame.setBounds(0, 0, 1250, 500);
				desktopPane.setBounds(10, 10, 1200, 400);
				scrollPane.setBounds(10, 10, 1200, 400);
				view = new GerenciarTransferencias();
				desktopPane.add(view);
				view.setBounds(0, 0, view.getWidth(), view.getHeight());
				view.show();
			}
		});
		mnTransferencias.add(mntmVisualizar);

		JMenuItem mntmRealizar = new JMenuItem("Realizar");
		mntmRealizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				desktopPane.removeAll();
				frame.setBounds(0, 0, 550, 450);
				desktopPane.setBounds(10, 10, 450, 310);
				scrollPane.setBounds(10, 10, 450, 310);
				trans = new Transferencias();
				desktopPane.add(trans);
				trans.setBounds(0, 0, desktopPane.getWidth(), desktopPane.getHeight());
				trans.show();

			}
		});
		mnTransferencias.add(mntmRealizar);
		
		JMenu mnUsuario = new JMenu("Usuario");
		menuBar.add(mnUsuario);
		
		JMenuItem mntmCriar = new JMenuItem("Criar");
		mntmCriar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				desktopPane.removeAll();
				frame.setBounds(0, 0, 550, 450);
				desktopPane.setBounds(10, 10, 450, 310);
				scrollPane.setBounds(10, 10, 450, 310);
				usuario = new GerenciarUsuario();
				desktopPane.add(usuario);
				usuario.setBounds(0, 0, desktopPane.getWidth(), desktopPane.getHeight());
				usuario.show();
			}
		});
		mnUsuario.add(mntmCriar);
		frame.getContentPane().setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 294, 182);
		frame.getContentPane().add(scrollPane);

		desktopPane = new JDesktopPane();
		scrollPane.setViewportView(desktopPane);
	}

	public JDesktopPane getDesktopPane() {
		return desktopPane;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}
};
