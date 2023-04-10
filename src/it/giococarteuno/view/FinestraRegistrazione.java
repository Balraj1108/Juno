package it.giococarteuno.view;

import java.awt.Component;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import it.giococarteuno.JUno;
import it.giococarteuno.dao.UtenteDAO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/**
 * 
 *Permette la registrazione di un nuovo utente
 */
public class FinestraRegistrazione extends JPanel {
	private JTextField textField;
	

	/**
	 * Create the panel.
	 */
	public FinestraRegistrazione() {
		initialize();
	}
	
	
	private void showError() {
        JOptionPane.showMessageDialog(this,"Nickname già esistente", "Errore", JOptionPane.ERROR_MESSAGE);
       
    }
	
	private void showSuccess() {
        JOptionPane.showMessageDialog(this, "Registrazione avvenuta con successo", "Successo", JOptionPane.CLOSED_OPTION);
        
    }
	
	
	public Component initialize() {
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 436, 263);
		
		panel.setLayout(new MigLayout("fillx", "[][][][grow][][][][]", "[][][][]"));
		panel.setOpaque(false);
		
		JLabel lblNewLabel = new JLabel("Nickname");
		panel.add(lblNewLabel, "cell 3 1,alignx center");
		
		textField = new JTextField();
		panel.add(textField, "cell 3 2,growx");
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Conferma");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UtenteDAO utenteDAO = new UtenteDAO();
				String nicknameText = textField.getText();
				
				
				
				if(utenteDAO.findByNickname(nicknameText) != null 
						|| nicknameText.equals("")) {
					panel.repaint();
					showError();
					panel.repaint();
					
				}
				else {
					utenteDAO.insert(nicknameText);
					
					JUno.showMain();
					panel.setVisible(false);
					
					showSuccess();
					
				}
			}
		});
		panel.add(btnNewButton, "flowx,cell 3 3");
		
		JButton btnNewButton_1 = new JButton("Annulla");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JUno.showMain();
				panel.setVisible(false);
				
			}
		});
		panel.add(btnNewButton_1, "cell 3 3,alignx right");
		
		
		
		
		
		return panel;
		
	}

}
