package it.giococarteuno.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import it.giococarteuno.MainFinestraIniziale;
import it.giococarteuno.controller.CartaController;
import it.giococarteuno.view.gioco.FinestraBotDx;
import it.giococarteuno.view.gioco.FinestraBotSu;
import it.giococarteuno.view.gioco.FinestraBotSx;
import it.giococarteuno.view.gioco.FinestraCarteMano;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FinestraGioco {

	private static JFrame frame;
	private static JButton cartaScartata;

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
	
	public static  void addFinCarteMano() {
		
		FinestraCarteMano p = new FinestraCarteMano();
		frame.getContentPane().add(p.initialize());
		System.out.println("addPanelCartaManoAlFrame");
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
		CartaController controller = new CartaController();
		//carico quello che voglio io
//		ImageIcon image = new ImageIcon("assets\\"+ controller.generaCarta() + ".png");
//		ImageIcon image1 = new ImageIcon("assets\\3giallo.png");
//		ImageIcon image2 = new ImageIcon("assets\\1rosso.png");
		
		
		
		cartaScartata = new JButton(new ImageIcon(""));
		cartaScartata.setBounds(547, 322, 74, 111);
		frame.getContentPane().add(cartaScartata);
		
//		JPanel panel = new JPanel();
//		panel.setBounds(298, 524, 740, 146);
//		frame.getContentPane().add(panel);
		
		FinestraCarteMano p = new FinestraCarteMano();
		frame.getContentPane().add(p.initialize());
		//System.out.println("dentroFinestraGioco");
		CartaController ctrl = new CartaController();
		for(int i = 0; i < 7; i++) {
			ctrl.pescaCarta();
		}
		
		
		FinestraBotSx finBotSx = new FinestraBotSx();
		frame.getContentPane().add(finBotSx.initialize());
		for(int i = 0; i < 7; i++) {
			ctrl.addCartaBotSx();
		}
		
		FinestraBotSu finBotSu = new FinestraBotSu();
		frame.getContentPane().add(finBotSu.initialize());
		for(int i = 0; i < 7; i++) {
			ctrl.addCartaBotSu();
		}
		
		FinestraBotDx finBotDx = new FinestraBotDx();
		frame.getContentPane().add(finBotDx.initialize());
		for(int i = 0; i < 7; i++) {
			
			ctrl.addCartaBotDx();
		}
		
		
		
		
		//mazzo da cui pescare
		JButton btnNewButton_1_1 = new JButton(new ImageIcon("assets\\backMazzo.png"));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CartaController ctrl = new CartaController();
				ctrl.pescaCarta();
			}
		});
		btnNewButton_1_1.setBounds(692, 322, 74, 111);
		frame.getContentPane().add(btnNewButton_1_1);
		
		
		
		
	}

	
	public static JFrame getFrame() {
		return frame;
	}

	public static void setFrame(JFrame frame) {
		FinestraGioco.frame = frame;
	}
	
	public static JButton getCartaScartata() {
		return cartaScartata;
	}

	public static void setCartaScartata(JButton cartaScartata) {
		FinestraGioco.cartaScartata = cartaScartata;
	}
}
