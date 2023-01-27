package it.giococarteuno.view;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Benvenuto extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public Benvenuto() {
		initialize();
	}
	
	public void initialize() {
		
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 436, 263);
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(93, 159, 85, 21);
		add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(200, 160, 96, 19);
		add(textField);
		textField.setColumns(10);
		
		setLayout(null);
		panel.setVisible(true);
		
	}

}
