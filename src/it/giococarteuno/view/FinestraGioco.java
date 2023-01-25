package it.giococarteuno.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.JButton;

public class FinestraGioco {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinestraGioco window = new FinestraGioco();
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
	public FinestraGioco() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("FGioco");
		
		//frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setLocationRelativeTo(null);
		
		//frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		//myFrame.setExtendedState(myFrame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().setPreferredSize(new Dimension(1350, 680));
		frame.pack();
		frame.setVisible(true);
		//per aprire la finestra in grande
		//frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		//frame.getContentPane().setBackground(Color.blue);
		
		//frame.getContentPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.RED));
		
		//carico quello che voglio io
		ImageIcon image = new ImageIcon("assets\\0.png");
		ImageIcon image1 = new ImageIcon("assets\\3giallo.png");
		ImageIcon image2 = new ImageIcon("assets\\1rosso.png");
		
		
		JLabel lblNewLabel = new JLabel(image);
		lblNewLabel.setBounds(675, 534, 73, 136);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(image1);
		lblNewLabel_1.setBounds(786, 534, 73, 136);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel(image2);
		lblNewLabel_1_1.setBounds(581, 534, 73, 136);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton(image);
		btnNewButton.setBounds(439, 534, 85, 136);
		frame.getContentPane().add(btnNewButton);
		
		
		
		
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
