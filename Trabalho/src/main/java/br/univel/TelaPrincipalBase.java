package br.univel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTabbedPane;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class TelaPrincipalBase extends JFrame {

	protected JPanel contentPane;
	protected JButton btnOrcamento;
	protected JButton btnCliente;
	protected JTabbedPane tabbedPane;

	public TelaPrincipalBase() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		btnOrcamento = new JButton("Ocamento");
		GridBagConstraints gbc_btnOrcamento = new GridBagConstraints();
		gbc_btnOrcamento.anchor = GridBagConstraints.EAST;
		gbc_btnOrcamento.insets = new Insets(0, 0, 5, 5);
		gbc_btnOrcamento.gridx = 0;
		gbc_btnOrcamento.gridy = 0;
		contentPane.add(btnOrcamento, gbc_btnOrcamento);
		
		btnCliente = new JButton("Cliente");
		GridBagConstraints gbc_btnCliente = new GridBagConstraints();
		gbc_btnCliente.anchor = GridBagConstraints.WEST;
		gbc_btnCliente.insets = new Insets(0, 0, 5, 0);
		gbc_btnCliente.gridx = 1;
		gbc_btnCliente.gridy = 0;
		contentPane.add(btnCliente, gbc_btnCliente);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.gridwidth = 2;
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 1;
		contentPane.add(tabbedPane, gbc_tabbedPane);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
