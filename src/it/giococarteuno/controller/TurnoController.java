package it.giococarteuno.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.Timer;

import it.giococarteuno.view.FinestraGioco;
import it.giococarteuno.view.gioco.FinestraBotDx;
import it.giococarteuno.view.gioco.FinestraBotSu;
import it.giococarteuno.view.gioco.FinestraBotSx;
import it.giococarteuno.view.gioco.FinestraCarteMano;

public class TurnoController {

	
	//sempre in ascolto se non uso timer stop
	public void turnoBotSx() {
		
		Timer timer = new Timer(2000, new  ActionListener() {

			
			@Override
			public void actionPerformed(ActionEvent e) {
				
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
					for (Component com : FinestraBotSx.getPanel().getComponents()) {
						//System.out.println("dentro for bot sx");
						JButton but = new JButton();
						but = (JButton) com;
						//System.out.println(but);
						String[] cartaBut = but.getActionCommand().toString().split("[_.\\\\]");
//						for (String string : cartaBut) {
//							System.out.println(string);
//						}
						if(cartaS[1].equals(cartaBut[0]) || cartaS[2].equals(cartaBut[1])) {
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
		
		Timer timer = new Timer(2000, new  ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(CartaController.contTur == 1) {
					Boolean cartaTro = true;
					JButton cartaScar = FinestraGioco.getCartaScartata();
					String[] cartaS = cartaScar.getIcon().toString().split("[_.\\\\]");
//					for (String string : cartaS) {
//						System.out.println(string);
//					}
					//String[] carta2 = cartaBotSx.getIcon().toString().split("[_.\\\\]");
					for (Component com : FinestraBotSu.getPanel().getComponents()) {
						JButton but = new JButton();
						but = (JButton) com;
						//System.out.println(but);
						String[] cartaBut = but.getActionCommand().toString().split("[_.\\\\]");
						
						if(cartaS[1].equals(cartaBut[0]) || cartaS[2].equals(cartaBut[1])) {
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
					Timer t = (Timer) e.getSource();
					t.stop();
				}
				
				
				
			}
			
		});
		timer.start();
		
	}
	
	public void turnoBotDx() {
		
		Timer timer = new Timer(2000, new  ActionListener() {
			
			

			@Override
			public void actionPerformed(ActionEvent e) {
				//System.out.println("bot DX");
				if(CartaController.contTurnSu == 1) {
					Boolean cartaTro = true;
					JButton cartaScar = FinestraGioco.getCartaScartata();
					//System.out.println(cartaScar);
					String[] cartaS = cartaScar.getIcon().toString().split("[_.\\\\]");
//					for (String string : cartaS) {
//						System.out.println(string);
//					}
					//String[] carta2 = cartaBotSx.getIcon().toString().split("[_.\\\\]");
					for (Component com : FinestraBotDx.getPanel().getComponents()) {
						//System.out.println("dentro for bot dx");
						JButton but = new JButton();
						but = (JButton) com;
						//System.out.println(but);
						String[] cartaBut = but.getActionCommand().toString().split("[_.\\\\]");
//						for (String string : cartaBut) {
//							System.out.println(string);
//						}
						if(cartaS[1].equals(cartaBut[0]) || cartaS[2].equals(cartaBut[1])) {
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
						CartaController.test = 1;
						CartaController.addCartaBotDx();
					}
					
					for (Component c : FinestraCarteMano.getPanel().getComponents()) {
						c.setEnabled(true);
					}
					FinestraGioco.btnNewButton_1_1.setEnabled(true);
					CartaController.contTurnSu++;
				}
				if(CartaController.contTurnSu > 1) {
					Timer t = (Timer) e.getSource();
					t.stop();
				}
				
				
			}
			
		});
		timer.start();
		
	}
}