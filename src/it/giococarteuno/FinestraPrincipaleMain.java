package it.giococarteuno;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import it.giococarteuno.dao.UtenteDAO;
import it.giococarteuno.view.FinestraBenvenuto;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FinestraPrincipaleMain {

	private JFrame frame;
	private JTextField textField;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinestraPrincipaleMain window = new FinestraPrincipaleMain();
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
				System.out.println(utenteDAO.findByNickname(nicknameText));
				FinestraBenvenuto fBenvenuto = new FinestraBenvenuto();
				fBenvenuto.frame.setVisible(true);
				frame.dispose();
				

				
			}
		});
		btnNewButton.setBounds(190, 52, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("Registrati");
		btnNewButton_1.setBounds(190, 91, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
	}
}
