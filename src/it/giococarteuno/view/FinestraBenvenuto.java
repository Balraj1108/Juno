package it.giococarteuno.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

public class FinestraBenvenuto {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinestraBenvenuto window = new FinestraBenvenuto();
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
	public FinestraBenvenuto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Benvenuto");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Gioca");
		btnNewButton.setBounds(166, 26, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Profilo");
		btnNewButton_1.setBounds(166, 92, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Esci");
		btnNewButton_2.setBounds(166, 165, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
	}

}
