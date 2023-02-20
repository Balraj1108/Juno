package it.giococarteuno.controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.Timer;

import it.giococarteuno.view.FinestraGioco;
import it.giococarteuno.view.gioco.FinestraBotDx;
import it.giococarteuno.view.gioco.FinestraBotSu;
import it.giococarteuno.view.gioco.FinestraBotSx;
import it.giococarteuno.view.gioco.FinestraCarteMano;

public class TurnoController {

	public static int tempoDelay = 0;
	//sempre in ascolto se non uso timer stop
	public void turnoBotSx() {
		if(FinestraCarteMano.getPanel().getComponents().length == 1) {
			FinestraGioco.clickUnoButton.setVisible(true);
			tempoDelay = 100000;
		}
		//FinestraGioco.corniveAvatarGiocatore.setBorder(BorderFactory.createLineBorder((Color.black),2));
		FinestraGioco.corniveAvatarBotSx.setBorder(BorderFactory.createLineBorder((Color.red),2));
		
		Timer timer = new Timer(tempoDelay, new  ActionListener() {
			

			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("bot SX");
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
					System.out.println("inizo bot sx");
					for (Component com : FinestraBotDx.getPanel().getComponents()) {
						JButton but = new JButton();
						but = (JButton) com;
						//System.out.println(but);
						System.out.println(but.getActionCommand());
					}
					System.out.println("fine bot sx");
					for (Component com : FinestraBotSx.getPanel().getComponents()) {
						//System.out.println("dentro for bot sx");
						JButton but = new JButton();
						but = (JButton) com;
						//System.out.println(but);
						String[] cartaBut = but.getActionCommand().toString().split("[_.\\\\]");
//						for (String string : cartaBut) {
//							System.out.println(string);
//						}
						if(cartaS[1].equals(cartaBut[0]) || cartaS[2].equals(cartaBut[1]) || cartaBut[0].equals("CambioColore")
								|| cartaBut[0].equals("PiuQuattro") || cartaBut[0].equals("CambioGiro") ) {
							//System.out.println("for sx");
							but.setEnabled(true);
							but.doClick();
							cartaTro = false;
							break;
						}
//						else {
//							
//							CartaController.contTur = 1;
//							CartaController.addCartaBotSx();
//						}
						
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
		
//		if(CartaController.test == 1) {
//			timer.stop();
//		}
		
//		tim timer = new Timer();
//		timer.schedule(new TimerTask(){
//		a0verride
//		public void run()
//		System.out.println( "Wait is over!");
//		//timer.cancel();
//		, 10000;
	}
	
	public void turnoBotSu() {
		
		//FinestraGioco.corniveAvatarGiocatore.setBorder(BorderFactory.createLineBorder((Color.black),2));
		FinestraGioco.corniveAvatarBotSu.setBorder(BorderFactory.createLineBorder((Color.red),2));
		
		Timer timer = new Timer(tempoDelay, new  ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("bot Su");
				
				if(CartaController.contTur == 1) {
					Boolean cartaTro = true;
					JButton cartaScar = FinestraGioco.getCartaScartata();
					String[] cartaS = cartaScar.getIcon().toString().split("[_.\\\\]");
//					for (String string : cartaS) {
//						System.out.println(string);
//					}
					//String[] carta2 = cartaBotSx.getIcon().toString().split("[_.\\\\]");
					System.out.println("inizo bot su");
					for (Component com : FinestraBotDx.getPanel().getComponents()) {
						JButton but = new JButton();
						but = (JButton) com;
						//System.out.println(but);
						System.out.println(but.getActionCommand());
					}
					System.out.println("fine bot su");
					for (Component com : FinestraBotSu.getPanel().getComponents()) {
						JButton but = new JButton();
						but = (JButton) com;
						//System.out.println(but);
						String[] cartaBut = but.getActionCommand().toString().split("[_.\\\\]");
						
						if(cartaS[1].equals(cartaBut[0]) || cartaS[2].equals(cartaBut[1]) || cartaBut[0].equals("CambioColore")
								|| cartaBut[0].equals("PiuQuattro") || cartaBut[0].equals("CambioGiro") ) {
							but.setEnabled(true);
							but.doClick();
							cartaTro = false;
							break;
						}
//						else {
//							
//							CartaController.contTurnSu = 1;
//							CartaController.addCartaBotSu();
//						}
						
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
		
		FinestraGioco.corniveAvatarBotDx.setBorder(BorderFactory.createLineBorder((Color.red),2));
		
		Timer timer = new Timer(tempoDelay, new  ActionListener() {
			
			

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("bot DX");
				
				if(CartaController.contTurnSu == 1) {
					Boolean cartaTro = true;
					JButton cartaScar = FinestraGioco.getCartaScartata();
					//System.out.println(cartaScar);
					String[] cartaS = cartaScar.getIcon().toString().split("[_.\\\\]");
//					for (String string : cartaS) {
//						System.out.println(string);
//					}
					//String[] carta2 = cartaBotSx.getIcon().toString().split("[_.\\\\]");
					System.out.println("inizo bot dx");
					for (Component com : FinestraBotDx.getPanel().getComponents()) {
						JButton but = new JButton();
						but = (JButton) com;
						//System.out.println(but);
						System.out.println(but.getActionCommand());
					}
					System.out.println("fine bot dx");
					for (Component com : FinestraBotDx.getPanel().getComponents()) {
						//System.out.println("dentro for bot dx");
						JButton but = new JButton();
						but = (JButton) com;
						//System.out.println(but);
						//System.out.println(but.getActionCommand());
						String[] cartaBut = but.getActionCommand().toString().split("[_.\\\\]");
//						for (String string : cartaBut) {
//							System.out.println(string);
//						}
						if(cartaS[1].equals(cartaBut[0]) || cartaS[2].equals(cartaBut[1]) || cartaBut[0].equals("CambioColore")
								|| cartaBut[0].equals("PiuQuattro") || cartaBut[0].equals("CambioGiro")) {
							System.out.println("dentro 3 bot if");
							System.out.println(but.getIcon() + " icon");
							System.out.println(but.getActionCommand() + " action");
							but.setEnabled(true);
							but.doClick();
							cartaTro = false;
							break;
						}
//						else {
//							
//							CartaController.test = 1;
//							CartaController.addCartaBotDx();
//						}
						
					}
					if(cartaTro == true) {
						System.out.println("dentro 3 bot secondo if sotto");
						CartaController.test = 1;
						CartaController.addCartaBotDx();
						for (Component c : FinestraCarteMano.getPanel().getComponents()) {
							c.setEnabled(true);
						}
						FinestraGioco.btnNewButton_1_1.setEnabled(true);
					}
					
//					for (Component c : FinestraCarteMano.getPanel().getComponents()) {
//						c.setEnabled(true);
//					}
//					FinestraGioco.btnNewButton_1_1.setEnabled(true);
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
		if(FinestraCarteMano.getPanel().getComponents().length == 1) {
			FinestraGioco.clickUnoButton.setVisible(true);
			tempoDelay = 100000;
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
//					for (String string : cartaS) {
//						System.out.println(string);
//					}
					//String[] carta2 = cartaBotSx.getIcon().toString().split("[_.\\\\]");
					for (Component com : FinestraBotDx.getPanel().getComponents()) {
						//System.out.println("dentro for bot sx");
						JButton but = new JButton();
						but = (JButton) com;
						//System.out.println(but);
						String[] cartaBut = but.getActionCommand().toString().split("[_.\\\\]");
//						for (String string : cartaBut) {
//							System.out.println(string);
//						}
						if(cartaS[1].equals(cartaBut[0]) || cartaS[2].equals(cartaBut[1]) || cartaBut[0].equals("CambioColore")
								|| cartaBut[0].equals("PiuQuattro") || cartaBut[0].equals("CambioGiro")) {
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
		
		FinestraGioco.corniveAvatarBotSu.setBorder(BorderFactory.createLineBorder((Color.red),2));
		
		Timer timer = new Timer(tempoDelay, new  ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(CartaController.contTurCambioGiro == 1) {
					Boolean cartaTro = true;
					JButton cartaScar = FinestraGioco.getCartaScartata();
					String[] cartaS = cartaScar.getIcon().toString().split("[_.\\\\]");
//					for (String string : cartaS) {
//						System.out.println(string);
//					}
					//String[] carta2 = cartaBotSx.getIcon().toString().split("[_.\\\\]");
					System.out.println("fine bot su");
					for (Component com : FinestraBotSu.getPanel().getComponents()) {
						JButton but = new JButton();
						but = (JButton) com;
						//System.out.println(but);
						String[] cartaBut = but.getActionCommand().toString().split("[_.\\\\]");
						
						if(cartaS[1].equals(cartaBut[0]) || cartaS[2].equals(cartaBut[1]) || cartaBut[0].equals("CambioColore")
								|| cartaBut[0].equals("PiuQuattro") || cartaBut[0].equals("CambioGiro")) {
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
		
		FinestraGioco.corniveAvatarBotSx.setBorder(BorderFactory.createLineBorder((Color.red),2));
		
		Timer timer = new Timer(tempoDelay, new  ActionListener() {
			
			

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(CartaController.contTurnSuCambioGiro == 1) {
					Boolean cartaTro = true;
					JButton cartaScar = FinestraGioco.getCartaScartata();
					//System.out.println(cartaScar);
					String[] cartaS = cartaScar.getIcon().toString().split("[_.\\\\]");
//					for (String string : cartaS) {
//						System.out.println(string);
//					}
					//String[] carta2 = cartaBotSx.getIcon().toString().split("[_.\\\\]");
					
					for (Component com : FinestraBotSx.getPanel().getComponents()) {
						//System.out.println("dentro for bot dx");
						JButton but = new JButton();
						but = (JButton) com;
						//System.out.println(but);
						//System.out.println(but.getActionCommand());
						String[] cartaBut = but.getActionCommand().toString().split("[_.\\\\]");
//						for (String string : cartaBut) {
//							System.out.println(string);
//						}
						if(cartaS[1].equals(cartaBut[0]) || cartaS[2].equals(cartaBut[1]) || cartaBut[0].equals("CambioColore")
								|| cartaBut[0].equals("PiuQuattro") || cartaBut[0].equals("CambioGiro")) {
							
							but.setEnabled(true);
							but.doClick();
							cartaTro = false;
							break;
						}
						
					}
					if(cartaTro == true) {
						System.out.println("dentro 3 bot secondo if sotto");
						CartaController.testCambioGiro = 1;
						CartaController.addCartaBotSx();
						for (Component c : FinestraCarteMano.getPanel().getComponents()) {
							c.setEnabled(true);
						}
						FinestraGioco.btnNewButton_1_1.setEnabled(true);
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
				
				
				
			}
			
		});
		timer.start();
		
	}
	
	
}
