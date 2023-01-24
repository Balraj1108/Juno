package it.giococarteuno.view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import it.giococarteuno.FinestraPrincipaleMain;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class FinestraBenvenuto {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinestraBenvenuto window = new FinestraBenvenuto();
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
	public FinestraBenvenuto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame("Benvenuto"));
		getFrame().setBounds(100, 100, 450, 300);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Gioca");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FinestraGioco fGioco = new FinestraGioco();
				fGioco.getFrame().setVisible(true);
				getFrame().dispose();
			}
		});
		btnNewButton.setBounds(166, 94, 89, 23);
		getFrame().getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Profilo");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Profilo fProfilo = new Profilo();
				fProfilo.getFrame().setVisible(true);
				getFrame().dispose();
			}
		});
		btnNewButton_1.setBounds(166, 153, 89, 23);
		getFrame().getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Esci");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FinestraPrincipaleMain fPrincipale = new FinestraPrincipaleMain();
				fPrincipale.getFrame().setVisible(true);
				getFrame().dispose();
			}
		});
		
		btnNewButton_2.setBounds(166, 206, 89, 23);
		getFrame().getContentPane().add(btnNewButton_2);
		
		

		System.out.println(FinestraPrincipaleMain.getStringaNickname().getNickname());
		JLabel lblNewLabel = new JLabel("Bentornato " + FinestraPrincipaleMain.getStringaNickname().getNickname());
		lblNewLabel.setBounds(166, 34, 187, 13);
		getFrame().getContentPane().add(lblNewLabel);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}
