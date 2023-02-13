package it.giococarteuno.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.Timer;

import it.giococarteuno.view.gioco.FinestraBotDx;
import it.giococarteuno.view.gioco.FinestraBotSu;
import it.giococarteuno.view.gioco.FinestraBotSx;

public class TurnoController {

	
	//sempre in ascolto se non uso timer stop
	public void turnoBotSx() {
		Timer timer = new Timer(3000, new  ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(CartaController.test == 1) {
					JButton cartaBotSx = new JButton();
					cartaBotSx = (JButton) FinestraBotSx.getPanel().getComponents()[0];
					cartaBotSx.setEnabled(true);
					cartaBotSx.doClick();
				}
				CartaController.test++;
				
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
		Timer timer = new Timer(3000, new  ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(CartaController.contTur == 1) {
					JButton cartaBotSu = new JButton();
					cartaBotSu = (JButton) FinestraBotSu.getPanel().getComponents()[0];
					cartaBotSu.setEnabled(true);
					cartaBotSu.doClick();
				}
				CartaController.contTur++;
				
			}
			
		});
		timer.start();
	}
	
	public void turnoBotDx() {
		Timer timer = new Timer(3000, new  ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(CartaController.contTurnSu == 1) {
					JButton cartaBotDx = new JButton();
					cartaBotDx = (JButton) FinestraBotDx.getPanel().getComponents()[0];
					cartaBotDx.setEnabled(true);
					cartaBotDx.doClick();
				}
				CartaController.contTurnSu++;
				
			}
			
		});
		timer.start();
	}
}
