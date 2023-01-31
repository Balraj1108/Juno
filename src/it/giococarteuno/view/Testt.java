package it.giococarteuno.view;

import java.awt.EventQueue;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import it.giococarteuno.FinestraPrincipaleMain;
import it.giococarteuno.dao.UtenteDAO;
import it.giococarteuno.model.Utente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComponent;

public class Testt extends JFrame {

	private JFrame frame;
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
					Testt window = new Testt();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void showError() {
        JOptionPane.showMessageDialog(this, "Nickname non esistente. Registrati", "Errore", JOptionPane.ERROR_MESSAGE);
    }

	/**
	 * Create the application.
	 */
	public Testt() {
		
		initialize();
		ProvaBen p = new ProvaBen();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Junoo");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(195, 41, 96, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nickname:");
		lblNewLabel.setBounds(98, 44, 69, 13);
		frame.getContentPane().add(lblNewLabel);
		
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
				
				
				
				frame.getContentPane().add(ProvaBen.initialize());
				
				//iniziaBenvenuto();
				
				
			}
		});
		btnNewButton.setBounds(195, 70, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		
		
//		frame.getContentPane().add(benvenuto);
//		benvenuto.setVisible(true);
		

		
		
	}
	
//	public void provaBen() {
//		JPanel panel = new JPanel();
//		panel.setBounds(0, 0, 436, 263);
//		JButton btnNewButton = new JButton("Gioca");
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//				//per chiudere la finestra corrente
//				JComponent comp = (JComponent) e.getSource();
//				Window win = SwingUtilities.getWindowAncestor(comp);
//				win.dispose();
//				
//				FinestraGioco fGioco = new FinestraGioco();
//				fGioco.getFrame().setVisible(true);
//				
//				
//			}
//		});
//		btnNewButton.setBounds(166, 94, 89, 23);
//		frame.getContentPane().add(btnNewButton);
//	}
	
	public void iniziaBenvenuto() {
		Benvenuto benvenuto = new Benvenuto();
		frame.getContentPane().add(benvenuto);
		benvenuto.setVisible(true);
	}
	
	public static Utente getStringaNickname() {
		return stringaNickname;
	}

	public static void setStringaNickname(Utente stringaNickname) {
		Testt.stringaNickname = stringaNickname;
	}
	
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}