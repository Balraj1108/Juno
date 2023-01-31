package it.giococarteuno.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import it.giococarteuno.dao.UtenteDAO;
import it.giococarteuno.model.Utente;

public class test extends JFrame {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JTextField textField;
	private static  Utente stringaNickname;
	private Benvenuto benvenuto = new Benvenuto();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test window = new test();
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
	public test() {
		initialize();
	}
	
	private void showError() {
        JOptionPane.showMessageDialog(this, "Nickname non esistente. Registrati", "Errore", JOptionPane.ERROR_MESSAGE);
    }

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Juno");
		
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(48, 87, 45, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		//frame.setLocationRelativeTo(null);//per centrare il frame
		
		
		
		
		lblNewLabel = new JLabel("Nickname:");
		lblNewLabel.setBounds(0, 0, 436, 263);
		frame.getContentPane().add(lblNewLabel);
		getContentPane().setLayout(null);
		
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
				
				lblNewLabel.setVisible(false);
				btnNewButton.setVisible(false);
				textField.setVisible(false);
				
//				Benvenuto benvenuto = new Benvenuto();
//				frame.getContentPane().add(benvenuto);
				benvenuto.setVisible(true);
				
				
			}
		});
		
		
		
		btnNewButton.setBounds(190, 52, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		
		
//		frame.getContentPane().add(benvenuto);
//		benvenuto.setVisible(false);
		
//		setLayout(null);
		//panel.setVisible(true);
		
		
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
		test.stringaNickname = stringaNickname;
	}

}