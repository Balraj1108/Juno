package it.giococarteuno.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import it.giococarteuno.FinestraPrincipaleMain;
import it.giococarteuno.dao.UtenteDAO;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificaProfilo extends JFrame {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificaProfilo window = new ModificaProfilo();
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
	public ModificaProfilo() {
		initialize();
	}
	
	private void showSuccess() {
        JOptionPane.showMessageDialog(this, "Cambio nickname avvenuto con successo", "Successo", JOptionPane.CLOSED_OPTION);
    }
	
	private void showError() {
        JOptionPane.showMessageDialog(this, "Nickname già esistente", "Errore", JOptionPane.ERROR_MESSAGE);
    }

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Modifica Profilo");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField(FinestraPrincipaleMain.getStringaNickname().getNickname());
		textField.setBounds(169, 25, 96, 19);
		frame.getContentPane().add(textField);
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
				
				else
				{
					utenteDAO.update(nicknameText, 
					FinestraPrincipaleMain.getStringaNickname().getId());
					FinestraPrincipaleMain.getStringaNickname().setNickname(nicknameText);
					Profilo fProfilo = new Profilo();
					fProfilo.getFrame().setVisible(true);
					frame.dispose();
					showSuccess();
				}
			}
		});
		btnNewButton.setBounds(120, 54, 112, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Annulla");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Profilo fProfilo = new Profilo();
				fProfilo.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(242, 54, 85, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Nickname: ");
		lblNewLabel.setBounds(89, 28, 70, 13);
		frame.getContentPane().add(lblNewLabel);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	

}
