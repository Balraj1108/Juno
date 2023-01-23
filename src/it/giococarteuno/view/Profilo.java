package it.giococarteuno.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import it.giococarteuno.FinestraPrincipaleMain;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class Profilo {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Profilo window = new Profilo();
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
	public Profilo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Profilo Utente");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nickname: " + FinestraPrincipaleMain.getStringaNickname().getNickname());
		lblNewLabel.setBounds(45, 43, 223, 28);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Livello: " + FinestraPrincipaleMain.getStringaNickname().getLivello());
		lblNewLabel_1.setBounds(45, 70, 310, 28);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Partite Vinte: " + FinestraPrincipaleMain.getStringaNickname().getPartiteVinte());
		lblNewLabel_2.setBounds(45, 108, 310, 28);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Partite Perse: " + FinestraPrincipaleMain.getStringaNickname().getPartitePerse());
		lblNewLabel_3.setBounds(45, 146, 310, 28);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Partite Giocate: " + FinestraPrincipaleMain.getStringaNickname().getPartiteGiocate());
		lblNewLabel_4.setBounds(45, 184, 310, 28);
		frame.getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Indietro");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FinestraBenvenuto fBenvenuto = new FinestraBenvenuto();
				fBenvenuto.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(305, 222, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Modifica");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificaProfilo fModificaProfilo = new ModificaProfilo();
				fModificaProfilo.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(273, 47, 117, 21);
		frame.getContentPane().add(btnNewButton_1);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
