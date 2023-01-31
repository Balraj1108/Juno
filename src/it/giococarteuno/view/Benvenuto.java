package it.giococarteuno.view;

import javax.swing.JPanel;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import it.giococarteuno.FinestraPrincipaleMain;

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
//		JButton btnNewButton = new JButton("New button");
//		btnNewButton.setBounds(93, 159, 85, 21);
//		add(btnNewButton);
		
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
		btnNewButton.setBounds(166, 94, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Profilo");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Profilo fProfilo = new Profilo();
				fProfilo.getFrame().setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(166, 153, 89, 23);
		add(btnNewButton_1);
		
		
		
//		JLabel lblNewLabel = new JLabel("Bentornato " + FinestraPrincipaleMain.getStringaNickname().getNickname());
//		lblNewLabel.setBounds(166, 34, 187, 13);
//		add(lblNewLabel);
		
//		textField = new JTextField();
//		textField.setBounds(200, 160, 96, 19);
//		add(textField);
//		textField.setColumns(10);
		
		setLayout(null);
		panel.setVisible(true);
		
	}

}
