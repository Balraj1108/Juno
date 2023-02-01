package it.giococarteuno.view;

import javax.swing.JPanel;
import javax.swing.JButton;

public class ProvaB extends JPanel {

	/**
	 * Create the panel.
	 */
	public ProvaB() {
		initialize();
	}
	
	public void initialize() {
		
		setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(152, 199, 85, 21);
		add(btnNewButton);
	}
}
