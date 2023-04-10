package it.giococarteuno.controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.Timer;

import it.giococarteuno.view.FinestraGioco;
import it.giococarteuno.view.gioco.FinestraBotDx;
import it.giococarteuno.view.gioco.FinestraBotSu;
import it.giococarteuno.view.gioco.FinestraBotSx;
import it.giococarteuno.view.gioco.FinestraCarteMano;


/**
 *Questo controllore mi permette di gestire i turni dei vari  bot e anche il tempo di risposta di ogni bot alla
 *mossa successiva
 *il bot puo andare verso dx o sx in base alla variabile che controlla se il turno è in senso orario o antiorario
 */

public class TurnoController {
	
	public static int tempoDelay = 3000;
	//sempre in ascolto se non uso timer stop
	public void turnoBotSx() {
		System.out.println("dentro turno controller botSx");
		if(CartaController.clickUnoController == 1) {
			FinestraGioco.clickUnoButton.setVisible(true);
			CartaController.clickUnoController = 0;
			return;
		}
		//FinestraGioco.corniveAvatarGiocatore.setBorder(BorderFactory.createLineBorder((Color.black),2));
		FinestraGioco.corniveAvatarBotSx.setBorder(BorderFactory.createLineBorder((Color.red),2));
		
		Timer timer = new Timer(tempoDelay, new  ActionListener() {
			

			
			@Override
			public void actionPerformed(ActionEvent e) {
				//System.out.println("bot SX");
				if(CartaController.test == 1) {
					Boolean cartaTro = true; 
					//System.out.println("bot sx");
					//JButton cartaBotSx = new JButton();
					JButton cartaScar = FinestraGioco.getCartaScartata();
					//System.out.println(cartaScar);
					String[] cartaS = cartaScar.getIcon().toString().split("[_.\\\\]");
//					for (String string : cartaS) {
//						System.out.println(string);
//					}
					//String[] carta2 = cartaBotSx.getIcon().toString().split("[_.\\\\]");
					//System.out.println("inizo bot sx");
					for (Component com : FinestraBotDx.getPanel().getComponents()) {
						JButton but = new JButton();
						but = (JButton) com;
						//System.out.println(but);
						//System.out.println(but.getActionCommand());
					}
					//System.out.println("fine bot sx");
					for (Component com : FinestraBotSx.getPanel().getComponents()) {
						//System.out.println("dentro for bot sx");
						JButton but = new JButton();
						but = (JButton) com;
						//System.out.println(but);
						String[] cartaBut = but.getActionCommand().toString().split("[_.\\\\]");
						if(cartaS[1].equals(cartaBut[0]) || cartaS[2].equals(cartaBut[1]) || cartaBut[0].equals("CambioColore")
								|| cartaBut[0].equals("PiuQuattro")) {
							//System.out.println("for sx");
							but.setEnabled(true);
							but.doClick();
							cartaTro = false;
							break;
						}
						
					}
					if(cartaTro == true) {
						CartaController.contTur = 1;
						CartaController.addCartaBotSx();
						
						turnoBotSu();
					}
					
					
					CartaController.test++;
				}
				if(CartaController.test > 1) {
					FinestraGioco.corniveAvatarBotSx.setBorder(BorderFactory.createLineBorder((Color.black),2));
					Timer t = (Timer) e.getSource();
					t.stop();
				}
				
				
			}
			
		});
		timer.start();
		
	}
	
	public void turnoBotSu() {
		System.out.println("dentro turno controller botSu");
		if(CartaController.clickUnoController == 1) {
			FinestraGioco.clickUnoButton.setVisible(true);
			CartaController.clickUnoController = 0;
			return;
		}
		//FinestraGioco.corniveAvatarGiocatore.setBorder(BorderFactory.createLineBorder((Color.black),2));
		FinestraGioco.corniveAvatarBotSu.setBorder(BorderFactory.createLineBorder((Color.red),2));
		
		Timer timer = new Timer(tempoDelay, new  ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//System.out.println("bot Su");
				
				if(CartaController.contTur == 1) {
					Boolean cartaTro = true;
					JButton cartaScar = FinestraGioco.getCartaScartata();
					String[] cartaS = cartaScar.getIcon().toString().split("[_.\\\\]");
					for (Component com : FinestraBotDx.getPanel().getComponents()) {
						JButton but = new JButton();
						but = (JButton) com;
						//System.out.println(but);
						//System.out.println(but.getActionCommand());
					}
					//System.out.println("fine bot su");
					for (Component com : FinestraBotSu.getPanel().getComponents()) {
						JButton but = new JButton();
						but = (JButton) com;
						//System.out.println(but);
						String[] cartaBut = but.getActionCommand().toString().split("[_.\\\\]");
						
						if(cartaS[1].equals(cartaBut[0]) || cartaS[2].equals(cartaBut[1]) || cartaBut[0].equals("CambioColore")
								|| cartaBut[0].equals("PiuQuattro")) {
							but.setEnabled(true);
							but.doClick();
							cartaTro = false;
							break;
						}
						
					}
					if(cartaTro == true) {
						CartaController.contTurnSu = 1;
						CartaController.addCartaBotSu();
						turnoBotDx();
					}
					
					CartaController.contTur++;
				}
				if(CartaController.contTur > 1) {
					FinestraGioco.corniveAvatarBotSu.setBorder(BorderFactory.createLineBorder((Color.black),2));
					Timer t = (Timer) e.getSource();
					t.stop();
				}
				
				
				
			}
			
		});
		timer.start();
		
	}
	
	public void turnoBotDx() {
		
		System.out.println("dentro turno controller botDx");
		
		
		FinestraGioco.corniveAvatarBotDx.setBorder(BorderFactory.createLineBorder((Color.red),2));
		
		Timer timer = new Timer(tempoDelay, new  ActionListener() {
			
			

			@Override
			public void actionPerformed(ActionEvent e) {
				//System.out.println("bot DX");
				
				if(CartaController.contTurnSu == 1) {
					Boolean cartaTro = true;
					JButton cartaScar = FinestraGioco.getCartaScartata();
					//System.out.println(cartaScar);
					String[] cartaS = cartaScar.getIcon().toString().split("[_.\\\\]");
					for (Component com : FinestraBotDx.getPanel().getComponents()) {
						JButton but = new JButton();
						but = (JButton) com;
						//System.out.println(but);
						//System.out.println(but.getActionCommand());
					}
					//System.out.println("fine bot dx");
					for (Component com : FinestraBotDx.getPanel().getComponents()) {
						//System.out.println("dentro for bot dx");
						JButton but = new JButton();
						but = (JButton) com;
						//System.out.println(but);
						//System.out.println(but.getActionCommand());
						String[] cartaBut = but.getActionCommand().toString().split("[_.\\\\]");
						if(cartaS[1].equals(cartaBut[0]) || cartaS[2].equals(cartaBut[1]) || cartaBut[0].equals("CambioColore")
								|| cartaBut[0].equals("PiuQuattro")) {
							//System.out.println("dentro 3 bot if");
							//System.out.println(but.getIcon() + " icon");
							//System.out.println(but.getActionCommand() + " action");
							but.setEnabled(true);
							but.doClick();
							cartaTro = false;
							break;
						}
						
					}
					if(cartaTro == true) {
						//System.out.println("dentro 3 bot secondo if sotto");
						CartaController.test = 1;
						CartaController.addCartaBotDx();
						for (Component c : FinestraCarteMano.getPanel().getComponents()) {
							c.setEnabled(true);
						}
						FinestraGioco.btnNewButton_1_1.setEnabled(true);
						FinestraCarteMano.getPanel().repaint();
						FinestraCarteMano.getPanel().validate();
					}
					
					CartaController.contTurnSu++;
				}
				if(CartaController.contTurnSu > 1) {
					FinestraGioco.corniveAvatarBotDx.setBorder(BorderFactory.createLineBorder((Color.black),2));
					Timer t = (Timer) e.getSource();
					t.stop();
				}
				
				
			}
			
		});
		timer.start();
		
	}
	
	public void turnoBotDxCambioGiro() {
		
		System.out.println("dentro turno controller botDx CAMBIO GIRO");
		
		if(CartaController.clickUnoController == 1) {
			FinestraGioco.clickUnoButton.setVisible(true);
			CartaController.clickUnoController = 0;
			return;
		}
		FinestraGioco.corniveAvatarBotDx.setBorder(BorderFactory.createLineBorder((Color.red),2));
		
		Timer timer = new Timer(tempoDelay, new  ActionListener() {
			

			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(CartaController.testCambioGiro == 1) {
					Boolean cartaTro = true; 
					//System.out.println("bot sx");
					//JButton cartaBotSx = new JButton();
					JButton cartaScar = FinestraGioco.getCartaScartata();
					//System.out.println(cartaScar);
					String[] cartaS = cartaScar.getIcon().toString().split("[_.\\\\]");
					for (Component com : FinestraBotDx.getPanel().getComponents()) {
						//System.out.println("dentro for bot sx");
						JButton but = new JButton();
						but = (JButton) com;
						//System.out.println(but);
						String[] cartaBut = but.getActionCommand().toString().split("[_.\\\\]");
						if(cartaS[1].equals(cartaBut[0]) || cartaS[2].equals(cartaBut[1]) || cartaBut[0].equals("CambioColore")
								|| cartaBut[0].equals("PiuQuattro")) {
							//System.out.println("for sx");
							but.setEnabled(true);
							but.doClick();
							cartaTro = false;
							break;
						}
						
					}
					if(cartaTro == true) {
						CartaController.contTurCambioGiro = 1;
						CartaController.addCartaBotSx();
						
						turnoBotSuCambioGiro();
					}
					
					
					CartaController.testCambioGiro++;
				}
				if(CartaController.testCambioGiro > 1) {
					FinestraGioco.corniveAvatarBotDx.setBorder(BorderFactory.createLineBorder((Color.black),2));
					Timer t = (Timer) e.getSource();
					t.stop();
				}
				
				
			}
			
		});
		timer.start();
	}
	
	public void turnoBotSuCambioGiro() {
		
		System.out.println("dentro turno controller botSu CAMBIO GIRO");
		if(CartaController.clickUnoController == 1) {
			FinestraGioco.clickUnoButton.setVisible(true);
			CartaController.clickUnoController = 0;
			return;
		}
		
		FinestraGioco.corniveAvatarBotSu.setBorder(BorderFactory.createLineBorder((Color.red),2));
		
		Timer timer = new Timer(tempoDelay, new  ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(CartaController.contTurCambioGiro == 1) {
					Boolean cartaTro = true;
					JButton cartaScar = FinestraGioco.getCartaScartata();
					String[] cartaS = cartaScar.getIcon().toString().split("[_.\\\\]");
					
					for (Component com : FinestraBotSu.getPanel().getComponents()) {
						JButton but = new JButton();
						but = (JButton) com;
						//System.out.println(but);
						String[] cartaBut = but.getActionCommand().toString().split("[_.\\\\]");
						
						if(cartaS[1].equals(cartaBut[0]) || cartaS[2].equals(cartaBut[1]) || cartaBut[0].equals("CambioColore")
								|| cartaBut[0].equals("PiuQuattro")) {
							but.setEnabled(true);
							but.doClick();
							cartaTro = false;
							break;
						}
						
					}
					if(cartaTro == true) {
						CartaController.contTurnSuCambioGiro = 1;
						CartaController.addCartaBotSu();
						turnoBotSxCambioGiro();
					}
					
					CartaController.contTurCambioGiro++;
				}
				if(CartaController.contTurCambioGiro > 1) {
					FinestraGioco.corniveAvatarBotSu.setBorder(BorderFactory.createLineBorder((Color.black),2));
					Timer t = (Timer) e.getSource();
					t.stop();
				}
				
				
				
			}
			
		});
		timer.start();
		
	}
	
	public void turnoBotSxCambioGiro() {
		
		System.out.println("dentro turno controller botsx CAMBIO GIRO");
		
		FinestraGioco.corniveAvatarBotSx.setBorder(BorderFactory.createLineBorder((Color.red),2));
		
		Timer timer = new Timer(tempoDelay, new  ActionListener() {
			
			

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(CartaController.contTurnSuCambioGiro == 1) {
					Boolean cartaTro = true;
					JButton cartaScar = FinestraGioco.getCartaScartata();
					//System.out.println(cartaScar);
					String[] cartaS = cartaScar.getIcon().toString().split("[_.\\\\]");
					
					for (Component com : FinestraBotSx.getPanel().getComponents()) {
						//System.out.println("dentro for bot dx");
						JButton but = new JButton();
						but = (JButton) com;
						//System.out.println(but);
						//System.out.println(but.getActionCommand());
						String[] cartaBut = but.getActionCommand().toString().split("[_.\\\\]");
						if(cartaS[1].equals(cartaBut[0]) || cartaS[2].equals(cartaBut[1]) || cartaBut[0].equals("CambioColore")
								|| cartaBut[0].equals("PiuQuattro")) {
							
							but.setEnabled(true);
							but.doClick();
							cartaTro = false;
							break;
						}
						
					}
					if(cartaTro == true) {
						//System.out.println("dentro 3 bot secondo if sotto");
						//CartaController.testCambioGiro = 1;
						CartaController.addCartaBotSx();
						for (Component c : FinestraCarteMano.getPanel().getComponents()) {
							c.setEnabled(true);
						}
						FinestraGioco.btnNewButton_1_1.setEnabled(true);
						FinestraCarteMano.getPanel().repaint();
						FinestraCarteMano.getPanel().validate();
					}
					
					CartaController.contTurnSuCambioGiro++;
				}
				if(CartaController.contTurnSuCambioGiro > 1) {
					FinestraGioco.corniveAvatarBotSx.setBorder(BorderFactory.createLineBorder((Color.black),2));
					Timer t = (Timer) e.getSource();
					t.stop();
				}
				
				
			}
			
		});
		timer.start();
		
	}
	
	/**
	 * metodo che colora di rosso il bordo del giocatore quando è il suo turno
	 */
	
	public void checkBorderGiocatore() {
		
		Timer timer = new Timer(0, new  ActionListener() {
			
			

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(FinestraGioco.btnNewButton_1_1.isEnabled()) {
					
					FinestraGioco.corniveAvatarGiocatore.setBorder(BorderFactory.createLineBorder((Color.red),2));
				}
				else {
					FinestraGioco.corniveAvatarGiocatore.setBorder(BorderFactory.createLineBorder((Color.black),2));
				}
				
				if(FinestraGioco.varCambioGiro) {
					BufferedImage picture2;
					try {
						picture2 = ImageIO.read(new File("backgroundImage\\cambioGiroOrario.png"));
						Image dimg = picture2.getScaledInstance(FinestraGioco.corniceGiro.getWidth(), FinestraGioco.corniceGiro.getHeight(),
				                Image.SCALE_SMOOTH);
						FinestraGioco.corniceGiro.setIcon(new ImageIcon(dimg));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					BufferedImage picture3;
					try {
						picture3 = ImageIO.read(new File("backgroundImage\\cambioGiroAntiorario.png"));
						Image dimg = picture3.getScaledInstance(FinestraGioco.corniceGiro.getWidth(), FinestraGioco.corniceGiro.getHeight(),
				                Image.SCALE_SMOOTH);
						FinestraGioco.corniceGiro.setIcon(new ImageIcon(dimg));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			
		});
		timer.start();
		
	}
	
	/**
	 * controlla se il giocatore ha "detto"(cliccato) uno quando gli rimane solo una carta, altrimenti pesca 2 carte
	 */
	public void checkClickUnoGiocatore() {
		
		Timer timer = new Timer(5000, new  ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(FinestraGioco.checkBtnclick == 0) {
					CartaController.pescaCarta();
					CartaController.pescaCarta();
					if(FinestraGioco.varCambioGiro == true) {
						CartaController.test = 1;
						TurnoController turnoCtrl = new TurnoController();
						turnoCtrl.turnoBotSx();
						
					}
					else {
						CartaController.testCambioGiro = 1;
						TurnoController turnoCtrl = new TurnoController();
						turnoCtrl.turnoBotDxCambioGiro();
					}
					FinestraGioco.clickUnoButton.setVisible(false);
				}
				FinestraGioco.checkBtnclick = 0;
				Timer t = (Timer) e.getSource();
				t.stop();
			}
			
		});
		timer.start();
		
	}
	
	
}
