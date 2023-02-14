package it.giococarteuno.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import it.giococarteuno.MainFinestraIniziale;
import it.giococarteuno.controller.CartaController;
import it.giococarteuno.controller.TurnoController;
import it.giococarteuno.model.Carta;
import it.giococarteuno.model.Colore;
import it.giococarteuno.model.Utente;
import it.giococarteuno.view.gioco.FinestraBotDx;
import it.giococarteuno.view.gioco.FinestraBotSu;
import it.giococarteuno.view.gioco.FinestraBotSx;
import it.giococarteuno.view.gioco.FinestraCarteMano;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;
import java.awt.GridLayout;

public class FinestraGioco {

	private static JFrame frame;
	private static JButton cartaScartata;
	public static JButton btnNewButton_1_1;
	private static  Utente utenteLog;
	public static JButton btnNewButton;
	public static Carta cartaS;
	public static JPanel panelScegliColore;

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
		//CartaController controller = new CartaController();
		//carico quello che voglio io
//		ImageIcon image = new ImageIcon("assets\\"+ controller.generaCarta() + ".png");
//		ImageIcon image1 = new ImageIcon("assets\\3giallo.png");
//		ImageIcon image2 = new ImageIcon("assets\\1rosso.png");
		CartaController.generaMazzo();
		cartaS = CartaController.generaCarta();
		
		cartaScartata = new JButton(new ImageIcon("assets\\"+ cartaS.getValore() + "_" + cartaS.getColore()  + ".png"));
		cartaScartata.setBounds(547, 322, 74, 111);
		
		
		cartaScartata.setBorder(BorderFactory.createLineBorder(CartaController.coloreCornice(cartaS.getColore()+""),4));
		frame.getContentPane().add(cartaScartata);
		
//		JPanel panel = new JPanel();
//		panel.setBounds(298, 524, 740, 146);
//		frame.getContentPane().add(panel);
		
		FinestraCarteMano p = new FinestraCarteMano();
		frame.getContentPane().add(p.initialize());
		//System.out.println("dentroFinestraGioco");
		//CartaController ctrl = new CartaController();
		//CartaController.generaMazzo();
		for(int i = 0; i < 7; i++) {
			CartaController.pescaCarta();
		}
		
		
		FinestraBotSx finBotSx = new FinestraBotSx();
		frame.getContentPane().add(finBotSx.initialize());
		for(int i = 0; i < 7; i++) {
			CartaController.addCartaBotSx();
		}
		
		FinestraBotSu finBotSu = new FinestraBotSu();
		frame.getContentPane().add(finBotSu.initialize());
		for(int i = 0; i < 7; i++) {
			CartaController.addCartaBotSu();
		}
		
		FinestraBotDx finBotDx = new FinestraBotDx();
		frame.getContentPane().add(finBotDx.initialize());
		for(int i = 0; i < 7; i++) {
			
			CartaController.addCartaBotDx();
		}
		
		
		
		
		//mazzo da cui pescare
		btnNewButton_1_1 = new JButton(new ImageIcon("assets\\backMazzo.png"));
		//btnNewButton_1_1.setEnabled(false);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//CartaController ctrl = new CartaController();
				CartaController.pescaCarta();
				for (Component c : FinestraCarteMano.getPanel().getComponents()) {
						c.setEnabled(false);
				}
				btnNewButton_1_1.setEnabled(false);
				CartaController.test = 1;
				TurnoController turnoCtrl = new TurnoController();
				turnoCtrl.turnoBotSx();
			}
		});
		btnNewButton_1_1.setBounds(692, 322, 74, 111);
		frame.getContentPane().add(btnNewButton_1_1);
		
		System.out.println(MainFinestraIniziale.getStringaNickname());
		
		btnNewButton = new JButton("Esci");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CartaController.ranInt = 96;
				JComponent comp = (JComponent) e.getSource();
				Window win = SwingUtilities.getWindowAncestor(comp);
				win.dispose();
				
				MainFinestraIniziale window = new MainFinestraIniziale();
				window.getFrame().setVisible(true);
				
				MainFinestraIniziale.addBenvenuto();
				
				//FinestraBenvenuto fBen = new FinestraBenvenuto();
				//fBen.getPanel().setVisible(true);
				//frame.getContentPane().add(p.initialize());
				//window.getContentPane().add(fBen);
				//MainFinestraIniziale.getPanel().setVisible(true);
				
				
			}
		});
		btnNewButton.setBounds(610, 277, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		
		
		panelScegliColore = new JPanel();
		panelScegliColore.setBounds(812, 244, 150, 150);
		frame.getContentPane().add(panelScegliColore);
		panelScegliColore.setLayout(new GridLayout(2, 2, 0, 0));
		
		JButton btnNewButton_1 = new JButton("Blu");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				synchronized (btnNewButton_1) {
					btnNewButton_1.notify();
				}
				cartaScartata.setIcon(new ImageIcon("assets\\CambioColore_Blu.png"));
				cartaScartata.setBorder(BorderFactory.createLineBorder((Color.blue),4));
				panelScegliColore.setVisible(false);
			}
		});
		panelScegliColore.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("Rosso");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cartaScartata.setIcon(new ImageIcon("assets\\CambioColore_Rosso.png"));
				cartaScartata.setBorder(BorderFactory.createLineBorder((Color.red),4));
				panelScegliColore.setVisible(false);
				
			}
		});
		panelScegliColore.add(btnNewButton_3);
		
		JButton btnNewButton_2 = new JButton("Verde");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cartaScartata.setIcon(new ImageIcon("assets\\CambioColore_Verde.png"));
				cartaScartata.setBorder(BorderFactory.createLineBorder((Color.green),4));
				panelScegliColore.setVisible(false);
				
			}
		});
		panelScegliColore.add(btnNewButton_2);
		
		JButton btnNewButton_4 = new JButton("Giallo");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cartaScartata.setIcon(new ImageIcon("assets\\CambioColore_Giallo.png"));
				cartaScartata.setBorder(BorderFactory.createLineBorder((Color.yellow),4));
				panelScegliColore.setVisible(false);
			}
		});
		panelScegliColore.add(btnNewButton_4);
		
		panelScegliColore.setVisible(false);
		
		
		
		
		MainFinestraIniziale.setStringaNickname(utenteLog);
		
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
	
	public static Utente getUtenteLog() {
		return utenteLog;
	}

	public static void setUtenteLog(Utente utenteLog) {
		FinestraGioco.utenteLog = utenteLog;
	}
}
