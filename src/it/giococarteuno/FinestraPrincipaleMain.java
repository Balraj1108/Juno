package it.giococarteuno;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import it.giococarteuno.dao.UtenteDAO;
import it.giococarteuno.model.Utente;
import it.giococarteuno.view.Benvenuto;
import it.giococarteuno.view.FinestraBenvenuto;
import it.giococarteuno.view.Registrazione;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class FinestraPrincipaleMain extends JFrame {

	private JFrame frame;
	private JTextField textField;
	private JButton btnNewButton_1;
	private static  Utente stringaNickname;
	private JLabel lblNewLabel;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinestraPrincipaleMain window = new FinestraPrincipaleMain();
					Benvenuto benvenuto = new Benvenuto();
					//frame.getContentPane().add(benvenuto);
					benvenuto.setVisible(true);
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
	public FinestraPrincipaleMain() {
		initialize();
	}
	
	/**
	 * metodo per passare la stringa nickname
	 */
	
//	private void passString() {
//		UtenteDAO utenteDAO = new UtenteDAO();
//		String nicknameText = textField.getText();
//		utenteDAO.findByNickname(nicknameText);
//		stringaNickname = nicknameText;
//    }
	
	private void showError() {
        JOptionPane.showMessageDialog(this, "Nickname non esistente. Registrati", "Errore", JOptionPane.ERROR_MESSAGE);
    }

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("JUNO");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(109, 21, 261, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				UtenteDAO utenteDAO = new UtenteDAO();
				String nicknameText = textField.getText();
				System.out.println(nicknameText + " testo che inserisco io");
				System.out.println(utenteDAO.findByNickname(nicknameText));
				setStringaNickname(utenteDAO.findByNickname(nicknameText));
				
				if(stringaNickname == null) {
					showError();
					return;
					
				}
				
				System.out.println(stringaNickname + "variabile");
				
				
				FinestraBenvenuto fBenvenuto = new FinestraBenvenuto();
				fBenvenuto.getFrame().setVisible(true);
				frame.dispose();
				
				
				

				
			}
		});
		
		
		
		btnNewButton.setBounds(190, 52, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("Registrati");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registrazione fRegistrazione = new Registrazione();
				fRegistrazione.getFrame().setVisible(true);
				frame.dispose();
				
			}
		});
		btnNewButton_1.setBounds(190, 91, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		lblNewLabel = new JLabel("Nickname:");
		lblNewLabel.setBounds(32, 24, 67, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(37, 136, 333, 88);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registrazione fRegistrazione = new Registrazione();
				fRegistrazione.getFrame().setVisible(true);
				frame.dispose();
				
			}
		});
		btnNewButton_2.setBounds(23, 10, 85, 21);
		panel.add(btnNewButton_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(168, 11, 96, 19);
		panel.add(textField_1);
		textField_1.setColumns(10);
		panel.setVisible(false);
		
//		Benvenuto benvenuto = new Benvenuto();
//		frame.getContentPane().add(benvenuto);
		
//		benvenuto.setVisible(true);
		
		
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public static Utente getStringaNickname() {
		return stringaNickname;
	}

	public static void setStringaNickname(Utente stringaNickname) {
		FinestraPrincipaleMain.stringaNickname = stringaNickname;
	}
}
