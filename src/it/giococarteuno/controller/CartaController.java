package it.giococarteuno.controller;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import it.giococarteuno.MainFinestraIniziale;
import it.giococarteuno.model.Carta;
import it.giococarteuno.model.Colore;
import it.giococarteuno.model.Mazzo;
import it.giococarteuno.model.Valore;
import it.giococarteuno.view.FinestraGioco;
import it.giococarteuno.view.gioco.ButtonLayout;
import it.giococarteuno.view.gioco.FinestraBotDx;
import it.giococarteuno.view.gioco.FinestraBotSu;
import it.giococarteuno.view.gioco.FinestraBotSx;
import it.giococarteuno.view.gioco.FinestraCarteMano;


public class CartaController {
	
	TurnoController turnCtrl = new TurnoController();
	
	
	public static int var = 0;
	public static int var1 = 0;
	public static int var2 = 0;
	public static int var3 = 0;
	
	public static int pos = 0;
	public static int pos1 = 0;
	public static int pos2 = 0;
	public static int pos3 = 0;
	
	public static int contTur = 0;
	public static int contTurnSu = 0;
	
	public static int meno = 10;
	public static int cont = 0;
	public static Carta carta;
	
	public static int test = 0;
	
	public void iniziaMano() {
		for(int i=0; i < 7; i++) {
			MainFinestraIniziale.getStringaNickname().getCarteMano().add(generaCarta());
		}
	}
	
	//usaCartaDallaMAno
//	Random rand = new Random();
//	int randomNum = rand.nextInt(4);
	
	public Carta generaCarta() {
		//System.out.println(cont);
		cont++;
		Random rand = new Random();
		int randomNum = rand.nextInt(4);
		//System.out.println(randomNum);
		return generaMazzo().getMazzo().get(randomNum);
		
	}

	
	public Mazzo generaMazzo() {
		Mazzo mazzo = new Mazzo();
		mazzo.getMazzo().add(new Carta(Colore.Blu, Valore.Zero));
		mazzo.getMazzo().add(new Carta(Colore.Giallo, Valore.Zero));
		mazzo.getMazzo().add(new Carta(Colore.Verde, Valore.Zero));
		mazzo.getMazzo().add(new Carta(Colore.Rosso, Valore.Zero));
//		for() {
//			
//		}
//		
//		for(int i = 0; i < 12; i++) {
//			
//			if(i%12 == 0) {
//				
//			mazzo.getMazzo().add(new Carta(Colore.Blu, Valore.Zero));}
//		}
		return mazzo;
	}
	
	
	
	
	
	public void addCartaMano() {
		
		JButton btnNewButton = new JButton();
		carta = generaCarta();
		btnNewButton.setIcon(new ImageIcon("assets\\"+ carta.getValore() + "_" + carta.getColore()  + ".png"));
		
		
		
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			
			
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				Point p = btnNewButton.getLocation();
				p.y -= 27;
				btnNewButton.setLocation(p);
				//System.out.println(btnNewButton.getLocation());
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				
				Point p = btnNewButton.getLocation();
				p.y += 27;
				btnNewButton.setLocation(p);
				if(btnNewButton.getY() > 35) {
					p.y = 35;
					btnNewButton.setLocation(p);
				}
				//System.out.println(btnNewButton.getLocation());
			}
				
          
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println("dentro bottone carta");
				
				JButton cartaScar = FinestraGioco.getCartaScartata();
				//System.out.println(cartaScar.getIcon());
				//System.out.println(btnNewButton.getIcon());
				String[] carta1 = cartaScar.getIcon().toString().split("[_.\\\\]");
				String[] carta2 = btnNewButton.getIcon().toString().split("[_.\\\\]");
				System.out.println(test + " fuori click mio");
				if(cartaScar.getIcon().toString().equals("")) {
					test = 1;
					//System.out.println("dentro primo if");
					cartaScar.setIcon(btnNewButton.getIcon());
					FinestraCarteMano.getPanel().remove(btnNewButton);
					TurnoController turnoCtrl = new TurnoController();
					turnoCtrl.turnoBotSx();
					System.out.println(test + " dentro click mio");
					//FinestraCarteMano.getPanel().repaint();
					//FinestraCarteMano.getPanel().validate();
				}
				
				
				//Arrays.asList(null);
				
//				String[] carta1 = cartaScar.getIcon().toString().split("[_.\\\\]");
//				String[] carta2 = btnNewButton.getIcon().toString().split("[_.\\\\]");
				
				
				
				else if(carta1[1].equals(carta2[1]) || carta1[2].equals(carta2[2]))  {
					test = 1;
					cartaScar.setIcon(btnNewButton.getIcon());
					FinestraCarteMano.getPanel().remove(btnNewButton);
					TurnoController turnoCtrl = new TurnoController();
					turnoCtrl.turnoBotSx();
					System.out.println(test + " dentro click mio 2if");
					//FinestraCarteMano.getPanel().repaint();
					//FinestraCarteMano.getPanel().validate();
				}
				
				int carteMano = FinestraCarteMano.getPanel().getComponents().length;
				
				
				if(carteMano >= 9 && var > 90 && pos < 0 ) {
					pos += 5;
				}
				if(carteMano <=9) {
					pos = 0;
				}
				FinestraCarteMano.getPanel().setLayout(new FlowLayout(FlowLayout.CENTER, pos, 35));
				if (carteMano >=9) {
					var = FinestraCarteMano.getPanel().getComponents()[0].getX();
				}
				
				
				FinestraCarteMano.getPanel().repaint();
				FinestraCarteMano.getPanel().validate();
				
//				else if(Arrays.asList(cartaScar.getIcon().toString().split("[_.'\']")).equals("")) {
//					System.out.println("dentro secondo if");
//					cartaScar.setIcon(btnNewButton.getIcon());
//				}
			}
			
		});
		//System.out.println(btnNewButton.getIcon());

		
		Dimension d = new Dimension();
		d.width = 74;
		d.height = 111;
		btnNewButton.setPreferredSize(d);
		
		//System.out.println(finCarteMano.getComponents().length);
		//FinestraGioco.addFinCarteMano();
		//System.out.println(FinestraCarteMano.getPanel().getComponents().length + " carte mano");
		int carteMano = FinestraCarteMano.getPanel().getComponents().length;
		
		
		
		if(carteMano >= 9 && var < 74 ) {
			pos -= 5;
		}
		
		
		FinestraCarteMano.getPanel().setLayout(new FlowLayout(FlowLayout.CENTER, pos, 35));
		
		//System.out.println(FinestraCarteMano.getPanel().getLayout().toString());
		FinestraCarteMano.getPanel().add(btnNewButton);
		
		
		FinestraCarteMano.getPanel().repaint();
		FinestraCarteMano.getPanel().validate();
		var = FinestraCarteMano.getPanel().getComponents()[0].getX();

		
	}
	
	
	public void pescaCarta() {
		
			addCartaMano();
	}
	
	public void addCartaBotSx() {
		
		JButton btnNewButton = new JButton();
		btnNewButton.setIcon(new ImageIcon("assets\\backSx.png"));
		btnNewButton.setDisabledIcon(new ImageIcon("assets\\backSx.png"));
		Carta carta = generaCarta();
		btnNewButton.setActionCommand(carta.getValore() +"_"+ carta.getColore());
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JButton cartaScar = FinestraGioco.getCartaScartata();
				String[] carta1 = cartaScar.getIcon().toString().split("[_.\\\\]");
				String[] carta2 = btnNewButton.getActionCommand().split("[_.\\\\]");
				
				if(cartaScar.getIcon().toString().equals("")) {
					contTur = 1;
					
					cartaScar.setIcon(new ImageIcon("assets\\"+ btnNewButton.getActionCommand() +".png"));
					FinestraBotSx.getPanel().remove(btnNewButton);
				}
				
				
				
				
				else if(carta1[1].equals(carta2[0]) || carta1[2].equals(carta2[1]))  {
					contTur = 1;
					cartaScar.setIcon(new ImageIcon("assets\\"+ btnNewButton.getActionCommand() +".png"));
					FinestraBotSx.getPanel().remove(btnNewButton);
					
				}
				
				int carteMano = FinestraBotSx.getPanel().getComponents().length;
				
				if(carteMano >= 7 && var1 > 90 && pos1 < 0 ) {
					pos1 += 9;
				}
				if(carteMano <=7) {
					pos1 = 0;
				}
				FinestraBotSx.getPanel().setLayout(new ButtonLayout(ButtonLayout.Alignment.VERTICAL, ButtonLayout.Anchor.CENTER, pos1));
				if (carteMano >=7) {
					var1 = FinestraBotSx.getPanel().getComponents()[0].getY();
				}
				
				FinestraBotSx.getPanel().repaint();
				FinestraBotSx.getPanel().validate();
				

			}
			
		});
		
		
		Dimension d = new Dimension();
		d.width = 111;
		d.height = 74;
		btnNewButton.setPreferredSize(d);
		

		int carteMano = FinestraBotSx.getPanel().getComponents().length;
		
		
		if(var1 < 74 ) {
			pos1 -= 5;
		}
		
		
		
		if(carteMano > 7) {
			
			FinestraBotSx.getPanel().setLayout(new ButtonLayout(ButtonLayout.Alignment.VERTICAL, ButtonLayout.Anchor.CENTER, pos1));
		}
		
		if(carteMano <= 7) {

			FinestraBotSx.getPanel().setLayout(new ButtonLayout(ButtonLayout.Alignment.VERTICAL, ButtonLayout.Anchor.CENTER, 0));

		}
		
		btnNewButton.setEnabled(false);
		
		FinestraBotSx.getPanel().add(btnNewButton);
		
		//btnNewButton.setEnabled(false);
		
		FinestraBotSx.getPanel().repaint();
		FinestraBotSx.getPanel().validate();
		
		
		var1 = FinestraBotSx.getPanel().getComponents()[0].getY();
		
		
	}
	
	public void addCartaBotSu() {
		
		JButton btnNewButton = new JButton();
		btnNewButton.setIcon(new ImageIcon("assets\\backSu.png"));
		btnNewButton.setDisabledIcon(new ImageIcon("assets\\backSu.png"));
		Carta carta = generaCarta();
		btnNewButton.setActionCommand(carta.getValore() +"_"+ carta.getColore());
		//System.out.println(btnNewButton.getActionCommand());
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JButton cartaScar = FinestraGioco.getCartaScartata();
				
				if(cartaScar.getIcon().toString().equals("")) {
					contTurnSu = 1;
					cartaScar.setIcon(new ImageIcon("assets\\"+ btnNewButton.getActionCommand() +".png"));
					FinestraBotSu.getPanel().remove(btnNewButton);
				}
				
				
				String[] carta1 = cartaScar.getIcon().toString().split("[_.\\\\]");
				String[] carta2 = btnNewButton.getActionCommand().split("[_.\\\\]");
				
				
				if(carta1[1].equals(carta2[0]) || carta1[2].equals(carta2[1]))  {
					contTurnSu = 1;
					cartaScar.setIcon(new ImageIcon("assets\\"+ btnNewButton.getActionCommand() +".png"));
					FinestraBotSu.getPanel().remove(btnNewButton);
					
				}
				
				int carteMano = FinestraBotSu.getPanel().getComponents().length;
				
				if(carteMano >= 9 && var2 > 90 && pos2 < 0 ) {
					pos2 += 5;
				}
				if(carteMano <=9) {
					pos2 = 0;
				}
				FinestraBotSu.getPanel().setLayout(new ButtonLayout(ButtonLayout.Alignment.HORIZONTAL, ButtonLayout.Anchor.CENTER, pos2));
				if (carteMano >=9) {
					var2 = FinestraBotSu.getPanel().getComponents()[0].getX();
				}
				
				FinestraBotSu.getPanel().repaint();
				FinestraBotSu.getPanel().validate();
				

			}
			
		});
		
		
		Dimension d = new Dimension();
		d.width = 74;
		d.height = 111;
		btnNewButton.setPreferredSize(d);
		
		int carteMano = FinestraBotSu.getPanel().getComponents().length;
		
		
		if(var2 < 74 ) {
			pos2 -= 5;
		}
		
		
		
		if(carteMano > 7) {
			
			FinestraBotSu.getPanel().setLayout(new ButtonLayout(ButtonLayout.Alignment.HORIZONTAL, ButtonLayout.Anchor.CENTER, pos2));
		}
		
		if(carteMano <= 7) {

			FinestraBotSu.getPanel().setLayout(new ButtonLayout(ButtonLayout.Alignment.HORIZONTAL, ButtonLayout.Anchor.CENTER, 0));

		}
		
		
		btnNewButton.setEnabled(false);
		
		FinestraBotSu.getPanel().add(btnNewButton);
		FinestraBotSu.getPanel().repaint();
		FinestraBotSu.getPanel().validate();
		
		var2 = FinestraBotSu.getPanel().getComponents()[0].getX();
	}
	
	public void addCartaBotDx() {
		
		JButton btnNewButton = new JButton();
		btnNewButton.setIcon(new ImageIcon("assets\\backDx.png"));
		btnNewButton.setDisabledIcon(new ImageIcon("assets\\backDx.png"));
		Carta carta = generaCarta();
		btnNewButton.setActionCommand(carta.getValore() +"_"+ carta.getColore());
		//System.out.println(btnNewButton.getActionCommand());
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JButton cartaScar = FinestraGioco.getCartaScartata();
				
				if(cartaScar.getIcon().toString().equals("")) {
					
					cartaScar.setIcon(new ImageIcon("assets\\"+ btnNewButton.getActionCommand() +".png"));
					FinestraBotDx.getPanel().remove(btnNewButton);
				}
				
				
				String[] carta1 = cartaScar.getIcon().toString().split("[_.\\\\]");
				String[] carta2 = btnNewButton.getActionCommand().split("[_.\\\\]");
				
				
				if(carta1[1].equals(carta2[0]) || carta1[2].equals(carta2[1]))  {
					
					cartaScar.setIcon(new ImageIcon("assets\\"+ btnNewButton.getActionCommand() +".png"));
					FinestraBotDx.getPanel().remove(btnNewButton);
					
				}
				
				int carteMano = FinestraBotDx.getPanel().getComponents().length;
				
				if(carteMano >= 7 && var3 > 90 && pos3 < 0 ) {
					pos3 += 9;
				}
				if(carteMano <=7) {
					pos3 = 0;
				}
				FinestraBotDx.getPanel().setLayout(new ButtonLayout(ButtonLayout.Alignment.VERTICAL, ButtonLayout.Anchor.CENTER, pos3));
				if (carteMano >=7) {
					var3 = FinestraBotDx.getPanel().getComponents()[0].getY();
				}
				
				FinestraBotDx.getPanel().repaint();
				FinestraBotDx.getPanel().validate();
				

			}
			
		});
		
		
		Dimension d = new Dimension();
		d.width = 111;
		d.height = 74;
		btnNewButton.setPreferredSize(d);
		
		int carteMano = FinestraBotDx.getPanel().getComponents().length;
		
		
		if(var3 < 74 ) {
			pos3 -= 5;
		}
		
		
		
		if(carteMano > 7) {
			
			FinestraBotDx.getPanel().setLayout(new ButtonLayout(ButtonLayout.Alignment.VERTICAL, ButtonLayout.Anchor.CENTER, pos3));
		}
		
		if(carteMano <= 7) {

			FinestraBotDx.getPanel().setLayout(new ButtonLayout(ButtonLayout.Alignment.VERTICAL, ButtonLayout.Anchor.CENTER, 0));

		}
		
		
		
		
		
		btnNewButton.setEnabled(false);
		
		
		FinestraBotDx.getPanel().add(btnNewButton);
		FinestraBotDx.getPanel().repaint();
		FinestraBotDx.getPanel().validate();
		
		var3 = FinestraBotDx.getPanel().getComponents()[0].getY();
	}
	
	
	

}
