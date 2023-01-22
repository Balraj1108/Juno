package it.giococarteuno.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JTextField;

import it.giococarteuno.FinestraPrincipaleMain;
import it.giococarteuno.dao.UtenteDAO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registrazione extends JFrame {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registrazione window = new Registrazione();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Registrazione() {
		initialize();
	}
	
	private void showError() {
        JOptionPane.showMessageDialog(this, "Nickname già esistente", "Errore", JOptionPane.ERROR_MESSAGE);
    }
	
	private void showSuccess() {
        JOptionPane.showMessageDialog(this, "Registrazione avvenuta con successo", "Successo", JOptionPane.CLOSED_OPTION);
    }

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame("Form Registrazione"));
		getFrame().setBounds(100, 100, 450, 300);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("    Nickname");
		lblNewLabel.setBounds(175, 11, 86, 29);
		getFrame().getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(175, 34, 86, 20);
		getFrame().getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Conferma");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UtenteDAO utenteDAO = new UtenteDAO();
				String nicknameText = textField.getText();
				
				
				
				if(utenteDAO.findByNickname(nicknameText) != null 
						|| nicknameText.equals("")) {
					showError();
				}
				else {
					utenteDAO.insert(nicknameText);
					FinestraPrincipaleMain fPrincipale = new FinestraPrincipaleMain();
					fPrincipale.getFrame().setVisible(true);
					getFrame().dispose();
					showSuccess();
					
				}
				
			}
		});
		btnNewButton.setBounds(119, 65, 101, 23);
		getFrame().getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Annulla");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FinestraPrincipaleMain fPrincipale = new FinestraPrincipaleMain();
				fPrincipale.getFrame().setVisible(true);
				getFrame().dispose();
			}
		});
		btnNewButton_1.setBounds(230, 65, 101, 23);
		getFrame().getContentPane().add(btnNewButton_1);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
