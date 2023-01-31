package it.giococarteuno.view;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;

import java.awt.Component;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;

public class ProvaBen extends JPanel {
	
	public ProvaBen() {
		setLayout(null);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(62, 217, 85, 21);
		add(btnNewButton_1);
	}

	/**
	 * Create the panel.
	 */
	
	
	public static Component initialize() {
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 436, 263);
		JButton btnNewButton = new JButton("Gioca");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//per chiudere la finestra corrente
				JComponent comp = (JComponent) e.getSource();
				Window win = SwingUtilities.getWindowAncestor(comp);
				win.dispose();
				
				FinestraGioco fGioco = new FinestraGioco();
				fGioco.getFrame().setVisible(true);
				
				
			}
		});
		btnNewButton.setBounds(160, 94, 89, 23);
		return btnNewButton;
	}

}
