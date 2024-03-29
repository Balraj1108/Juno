package it.giococarteuno.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Window;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import it.giococarteuno.JUno;
import it.giococarteuno.controller.CartaController;
import it.giococarteuno.controller.TurnoController;
import it.giococarteuno.dao.UtenteDAO;
import it.giococarteuno.model.Carta;
import it.giococarteuno.model.Colore;
import it.giococarteuno.model.Utente;
import it.giococarteuno.model.Valore;
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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;
import java.awt.GridLayout;
import java.awt.Image;


/**
 *Finestra di gioco, qua l'utente può giocare ad Uno contro 3 bot 
 *ognuno ha un'immagine di profilo e questa appare con i bordi rossi quando tocca al giocatore o al bot
 *vi è anche un'immagine che mostra in che senso sta andando il turno
 *pila degli scarti dove vi è sempra l'ultima carta messa sul tavolo e mazzo da cui pescare
 *bottone esci per uscire dalla partita corrente
 *
 */
public class FinestraGioco {

	private static JFrame frame;
	private static JButton cartaScartata;
	public static JButton btnNewButton_1_1;
	private static  Utente utenteLog;
	public static JButton btnNewButton;
	public static Carta cartaS;
	public static JPanel panelScegliColore;
	public static JPanel panelScegliColorePiuQuattro;
	public static Boolean varCambioGiro;
	
	public static JLabel corniveAvatarGiocatore;
	public static JLabel corniveAvatarBotDx;
	public static JLabel corniveAvatarBotSu;
	public static JLabel corniveAvatarBotSx;
	public static JLabel corniceGiro;
	
	public static JButton clickUnoButton;
	
	public static int checkBtnclick = 0;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		
//	
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FinestraGioco window = new FinestraGioco();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public FinestraGioco() {
		initialize();
		TurnoController turnoCtrl = new TurnoController();
		turnoCtrl.checkBorderGiocatore();
		//turnoCtrl.checkCarteGiocatore();
	}
	
	public static  void addFinCarteMano() {
		
		FinestraCarteMano p = new FinestraCarteMano();
		frame.getContentPane().add(p.initialize());
		//System.out.println("addPanelCartaManoAlFrame");
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("FGioco");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().setPreferredSize(new Dimension(1350, 680));
		frame.pack();
		frame.setVisible(true);
		//per aprire la finestra in grande
		//frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		
		try {
			frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("backgroundImage\\backgroundLegno.png")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
		frame.setResizable(false);
		
		varCambioGiro = true;
		CartaController.generaMazzo();
		cartaS = CartaController.generaCarta();
		
	    while (cartaS.getValore() == Valore.Blocca || cartaS.getValore() == Valore.PiuQuattro 
	    		|| cartaS.getValore() == Valore.CambioColore || cartaS.getValore() == Valore.CambioGiro
	    		|| cartaS.getValore() == Valore.PiuDue) { // Controlla se il valore della carta è 5 o 6
	        System.out.println("dentro  VALORE CARTA INIZIO"); // Stampa un messaggio informativo
	    	cartaS = CartaController.generaCarta(); // Genera una nuova carta
	    }
		
		
		cartaScartata = new JButton(new ImageIcon("assets\\"+ cartaS.getValore() + "_" + cartaS.getColore()  + ".png"));
		cartaScartata.setBounds(547, 322, 74, 111);
		
		
		cartaScartata.setBorder(BorderFactory.createLineBorder(CartaController.coloreCornice(cartaS.getColore()+""),4));
		frame.getContentPane().add(cartaScartata);
		
		
		FinestraCarteMano p = new FinestraCarteMano();
		frame.getContentPane().add(p.initialize());
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
				if(varCambioGiro == true) {
					CartaController.pescaCarta();
					for (Component c : FinestraCarteMano.getPanel().getComponents()) {
							c.setEnabled(false);
					}
					btnNewButton_1_1.setEnabled(false);
					CartaController.test = 1;
					TurnoController turnoCtrl = new TurnoController();
					turnoCtrl.turnoBotSx();
				}
				else {
					CartaController.pescaCarta();
					for (Component c : FinestraCarteMano.getPanel().getComponents()) {
						c.setEnabled(false);
				}
				btnNewButton_1_1.setEnabled(false);
				CartaController.testCambioGiro = 1;
				TurnoController turnoCtrl = new TurnoController();
				turnoCtrl.turnoBotDxCambioGiro();
				}
			}
		});
		btnNewButton_1_1.setBounds(692, 322, 74, 111);
		frame.getContentPane().add(btnNewButton_1_1);
		
		
		btnNewButton = new JButton("Esci");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				JComponent comp = (JComponent) e.getSource();
				Window win = SwingUtilities.getWindowAncestor(comp);
				win.dispose();
				

				JUno.getFrame().setVisible(true);
				FinestraBenvenuto.getPanel().setVisible(true);
				UtenteDAO utenteDAO = new UtenteDAO();
				
				JUno.setStringaNickname(utenteDAO.findByNickname(utenteLog.getNickname()));
				utenteLog = utenteDAO.findByNickname(utenteLog.getNickname());
				
				
				
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
				cartaScartata.setIcon(new ImageIcon("assets\\CambioColore_Blu.png"));
				cartaScartata.setBorder(BorderFactory.createLineBorder((Color.blue),4));
				panelScegliColore.setVisible(false);
				if(varCambioGiro == true) {
					CartaController.test = 1;
					TurnoController turnoCtrl = new TurnoController();
					turnoCtrl.turnoBotSx();
				}
				else {
					CartaController.testCambioGiro = 1;
					TurnoController turnoCtrl = new TurnoController();
					turnoCtrl.turnoBotDxCambioGiro();
				}
			}
		});
		panelScegliColore.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("Rosso");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cartaScartata.setIcon(new ImageIcon("assets\\CambioColore_Rosso.png"));
				cartaScartata.setBorder(BorderFactory.createLineBorder((Color.red),4));
				panelScegliColore.setVisible(false);
				if(varCambioGiro == true) {
					CartaController.test = 1;
					TurnoController turnoCtrl = new TurnoController();
					turnoCtrl.turnoBotSx();
				}
				else {
					CartaController.testCambioGiro = 1;
					TurnoController turnoCtrl = new TurnoController();
					turnoCtrl.turnoBotDxCambioGiro();
				}
				
			}
		});
		panelScegliColore.add(btnNewButton_3);
		
		JButton btnNewButton_2 = new JButton("Verde");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cartaScartata.setIcon(new ImageIcon("assets\\CambioColore_Verde.png"));
				cartaScartata.setBorder(BorderFactory.createLineBorder((Color.green),4));
				panelScegliColore.setVisible(false);
				if(varCambioGiro == true) {
					CartaController.test = 1;
					TurnoController turnoCtrl = new TurnoController();
					turnoCtrl.turnoBotSx();
				}
				else {
					CartaController.testCambioGiro = 1;
					TurnoController turnoCtrl = new TurnoController();
					turnoCtrl.turnoBotDxCambioGiro();
				}
				
			}
		});
		panelScegliColore.add(btnNewButton_2);
		
		JButton btnNewButton_4 = new JButton("Giallo");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cartaScartata.setIcon(new ImageIcon("assets\\CambioColore_Giallo.png"));
				cartaScartata.setBorder(BorderFactory.createLineBorder((Color.yellow),4));
				panelScegliColore.setVisible(false);
				if(varCambioGiro == true) {
					CartaController.test = 1;
					TurnoController turnoCtrl = new TurnoController();
					turnoCtrl.turnoBotSx();
				}
				else {
					CartaController.testCambioGiro = 1;
					TurnoController turnoCtrl = new TurnoController();
					turnoCtrl.turnoBotDxCambioGiro();
				}
			}
		});
		panelScegliColore.add(btnNewButton_4);
		
		panelScegliColore.setVisible(false);
		
		
		//panel per il piu quattro
		panelScegliColorePiuQuattro = new JPanel();
		panelScegliColorePiuQuattro.setBounds(812, 244, 150, 150);
		frame.getContentPane().add(panelScegliColorePiuQuattro);
		panelScegliColorePiuQuattro.setLayout(new GridLayout(2, 2, 0, 0));
		
		JButton btnNewButton_11 = new JButton("Blu");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cartaScartata.setIcon(new ImageIcon("assets\\PiuQuattro_Blu.png"));
				cartaScartata.setBorder(BorderFactory.createLineBorder((Color.blue),4));
				panelScegliColorePiuQuattro.setVisible(false);
				if(varCambioGiro == true) {
					CartaController.contTur = 1;
					TurnoController turnoCtrl = new TurnoController();
					turnoCtrl.turnoBotSu();
				}
				else {
					CartaController.contTurCambioGiro = 1;
					TurnoController turnoCtrl = new TurnoController();
					turnoCtrl.turnoBotSuCambioGiro();
				}
			}
		});
		panelScegliColorePiuQuattro.add(btnNewButton_11);
		
		JButton btnNewButton_31 = new JButton("Rosso");
		btnNewButton_31.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cartaScartata.setIcon(new ImageIcon("assets\\PiuQuattro_Rosso.png"));
				cartaScartata.setBorder(BorderFactory.createLineBorder((Color.red),4));
				panelScegliColorePiuQuattro.setVisible(false);
				
				if(varCambioGiro == true) {
					CartaController.contTur = 1;
					TurnoController turnoCtrl = new TurnoController();
					turnoCtrl.turnoBotSu();
				}
				else {
					CartaController.contTurCambioGiro = 1;
					TurnoController turnoCtrl = new TurnoController();
					turnoCtrl.turnoBotSuCambioGiro();
				}
				
			}
		});
		panelScegliColorePiuQuattro.add(btnNewButton_31);
		
		JButton btnNewButton_21 = new JButton("Verde");
		btnNewButton_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cartaScartata.setIcon(new ImageIcon("assets\\PiuQuattro_Verde.png"));
				cartaScartata.setBorder(BorderFactory.createLineBorder((Color.green),4));
				panelScegliColorePiuQuattro.setVisible(false);
				
				if(varCambioGiro == true) {
					CartaController.contTur = 1;
					TurnoController turnoCtrl = new TurnoController();
					turnoCtrl.turnoBotSu();
				}
				else {
					CartaController.contTurCambioGiro = 1;
					TurnoController turnoCtrl = new TurnoController();
					turnoCtrl.turnoBotSuCambioGiro();
				}
				
			}
		});
		panelScegliColorePiuQuattro.add(btnNewButton_21);
		
		JButton btnNewButton_41 = new JButton("Giallo");
		btnNewButton_41.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cartaScartata.setIcon(new ImageIcon("assets\\PiuQuattro_Giallo.png"));
				cartaScartata.setBorder(BorderFactory.createLineBorder((Color.yellow),4));
				panelScegliColorePiuQuattro.setVisible(false);
				
				if(varCambioGiro == true) {
					CartaController.contTur = 1;
					TurnoController turnoCtrl = new TurnoController();
					turnoCtrl.turnoBotSu();
				}
				else {
					CartaController.contTurCambioGiro = 1;
					TurnoController turnoCtrl = new TurnoController();
					turnoCtrl.turnoBotSuCambioGiro();
				}
			}
		});
		panelScegliColorePiuQuattro.add(btnNewButton_41);
		
		panelScegliColorePiuQuattro.setVisible(false);
		
		//giocatore
		corniveAvatarGiocatore = new JLabel();
		corniveAvatarGiocatore.setBounds(632, 466, 50, 50);
		frame.getContentPane().add(corniveAvatarGiocatore);
		corniveAvatarGiocatore.setBorder(BorderFactory.createLineBorder((Color.black),2));
		
		BufferedImage picture;
		try {
			picture = ImageIO.read(new File("profileImage\\userImg.png"));
			Image dimg = picture.getScaledInstance(corniveAvatarGiocatore.getWidth(), corniveAvatarGiocatore.getHeight(),
	                Image.SCALE_SMOOTH);
			corniveAvatarGiocatore.setIcon(new ImageIcon(dimg));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//bot sx
		corniveAvatarBotSx = new JLabel();
		corniveAvatarBotSx.setBorder(BorderFactory.createLineBorder((Color.black),2));
		corniveAvatarBotSx.setBounds(182, 344, 50, 50);
		corniveAvatarBotSx.setOpaque(true);
		corniveAvatarBotSx.setBackground(Color.blue);
		frame.getContentPane().add(corniveAvatarBotSx);
		
		//bot su
		corniveAvatarBotSu = new JLabel();
		corniveAvatarBotSu.setBorder(BorderFactory.createLineBorder((Color.black),2));
		corniveAvatarBotSu.setBounds(632, 167, 50, 50);
		corniveAvatarBotSu.setOpaque(true);
		corniveAvatarBotSu.setBackground(Color.yellow);
		frame.getContentPane().add(corniveAvatarBotSu);
		
		//bot dx
		corniveAvatarBotDx = new JLabel();
		corniveAvatarBotDx.setBorder(BorderFactory.createLineBorder((Color.black),2));
		corniveAvatarBotDx.setBounds(1126, 344, 50, 50);
		corniveAvatarBotDx.setOpaque(true);
		corniveAvatarBotDx.setBackground(Color.green);
		frame.getContentPane().add(corniveAvatarBotDx);
		
		//click uno
		clickUnoButton = new JButton("UNOOO");
		clickUnoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(varCambioGiro == true) {
					checkBtnclick++;
					CartaController.test = 1;
					TurnoController turnoCtrl = new TurnoController();
					turnoCtrl.turnoBotSx();
					
				}
				else {
					checkBtnclick++;
					CartaController.testCambioGiro = 1;
					TurnoController turnoCtrl = new TurnoController();
					turnoCtrl.turnoBotDxCambioGiro();
				}
				clickUnoButton.setVisible(false);
			}
		});
		clickUnoButton.setBounds(326, 442, 121, 59);
		frame.getContentPane().add(clickUnoButton);
		clickUnoButton.setVisible(false);
		
		corniceGiro = new JLabel();
		corniceGiro.setBounds(195, 120, 100, 100);
		
		frame.getContentPane().add(corniceGiro);
		
		
		JUno.setStringaNickname(utenteLog);
		
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
