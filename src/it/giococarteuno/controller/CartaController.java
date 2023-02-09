package it.giococarteuno.controller;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import it.giococarteuno.MainFinestraIniziale;
import it.giococarteuno.model.Carta;
import it.giococarteuno.model.Colore;
import it.giococarteuno.model.Mazzo;
import it.giococarteuno.model.Valore;
import it.giococarteuno.view.FinestraGioco;
import it.giococarteuno.view.gioco.FinestraBotSx;
import it.giococarteuno.view.gioco.FinestraCarteMano;

public class CartaController {
	
	public static int var = 0;
	public static int pos = 0;
	public static int meno = 10;
	
	public void iniziaMano() {
		for(int i=0; i < 7; i++) {
			MainFinestraIniziale.getStringaNickname().getCarteMano().add(generaCarta());
		}
	}
	
	//usaCartaDallaMAno
//	Random rand = new Random();
//	int randomNum = rand.nextInt(4);
	
	public Carta generaCarta() {
		
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
		btnNewButton.setIcon(new ImageIcon("assets\\"+ generaCarta() + ".png"));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Point p = btnNewButton.getLocation();
				p.y -= 27;
				btnNewButton.setLocation(p);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				Point p = btnNewButton.getLocation();
				p.y += 27;
				btnNewButton.setLocation(p);
          }
		});

		
		Dimension d = new Dimension();
		d.width = 74;
		d.height = 111;
		btnNewButton.setPreferredSize(d);
//		btnNewButton.setAlignmentX(0.5f+pCarta);
//		btnNewButton.setAlignmentY(1f);
//		btnNewButton.setBounds(74*pCarta, 35, 74, 111);
		
//		JButton btnNewButton1 = new JButton(new ImageIcon("assets\\"+ generaCarta() + ".png"));
//		btnNewButton1.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				Point p = btnNewButton1.getLocation();
//				p.y -= 25;
//				btnNewButton1.setLocation(p);
//			}
//			
//			@Override
//			public void mouseExited(MouseEvent e) {
//				Point p = btnNewButton1.getLocation();
//				p.y += 25;
//				btnNewButton1.setLocation(p);
//          }
//		});
//
//		
//		Dimension d1 = new Dimension();
//		d1.width = 74;
//		d1.height = 111;
//		btnNewButton1.setPreferredSize(d1);
		
//		JButton btnNewButton = new JButton(new ImageIcon("assets\\"+ generaCarta() + ".png"));
//		btnNewButton.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				Point p = btnNewButton.getLocation();
//				p.y -= 25;
//				btnNewButton.setLocation(p);
//			}
//			
//            @Override
//            public void mouseExited(MouseEvent e) {
//            	Point p = btnNewButton.getLocation();
//				p.y += 25;
//				btnNewButton.setLocation(p);
//            }
//            
//		});
//		btnNewButton.setBounds(pCarta, 35, 74, 111);
		//FinestraGioco.addFinCarteMano();
		
		//btnNewButton.setBounds(pCarta, 35, 74, 111);
		
		//System.out.println(finCarteMano.getComponents().length);
		//FinestraGioco.addFinCarteMano();
		System.out.println(FinestraCarteMano.getPanel().getComponents().length);
		int carteMano = FinestraCarteMano.getPanel().getComponents().length;
		
		
		
		if(carteMano >= 5 && var < 74 ) {
			pos -= 5;
		}
		
		
		
		FinestraCarteMano.getPanel().setLayout(new FlowLayout(FlowLayout.CENTER, pos, 35));
		
		//System.out.println(FinestraCarteMano.getPanel().getLayout().toString());
		FinestraCarteMano.getPanel().add(btnNewButton);
		
		
//		FinestraCarteMano.getPanel().add(FinestraCarteMano.jPane);
//		JScrollPane jPane = new JScrollPane();
//		FinestraCarteMano.getPanel().add(jPane);
		//FinestraCarteMano.getPanel().add(btnNewButton1);
		//numCarteMano++;
		//FinestraGioco.getFrame().repaint();
		//FinestraCarteMano.getPanel().validate();
		//FinestraGioco.getFrame().repaint();
		//FinestraGioco.addFinCarteMano();
		//checkScroll();
		FinestraCarteMano.getPanel().repaint();
		FinestraCarteMano.getPanel().validate();
		var = FinestraCarteMano.getPanel().getComponents()[0].getX();
		//System.out.println(FinestraCarteMano.getPanel().getComponents()[0].getX());
//		FinestraCarteMano.getPanel().add(FinestraCarteMano.jPane);
//		JScrollPane jPane = new JScrollPane(FinestraCarteMano.getPanel());
//		jPane.getViewport().addChangeListener(new ChangeListener() {
//			@Override
//			public void stateChanged(ChangeEvent e) {
//				// TODO Auto-generated method stub
//				if(jPane.getHorizontalScrollBar().isShowing()) {
//					System.out.println("ciao");
//		        }
//			}
//
//		});
		//System.out.println(FinestraCarteMano.contaCarte());
		//System.out.println("ciao");
		//System.out.println(FinestraCarteMano.getPanel().getComponents().length);
		
	}
	
//	public void checkScroll() {
//		System.out.println("dentro check");
//		FinestraCarteMano.jPane.getViewport().addChangeListener(new ChangeListener() {
//			@Override
//			public void stateChanged(ChangeEvent e) {
//				// TODO Auto-generated method stub
//				if(FinestraCarteMano.jPane.getHorizontalScrollBar().isShowing()) {
//					System.out.println("ciao");
//		        }
//			}
//
//		});
//	}
	
	public void pescaCarta() {
//		System.out.println(numCarteMano);
		
			
			addCartaMano();
//		int pCarta = 74;
//		JButton btnNewButton = new JButton(new ImageIcon("assets\\"+ generaCarta() + ".png"));
//		btnNewButton.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				Point p = btnNewButton.getLocation();
//				p.y -= 25;
//				btnNewButton.setLocation(p);
//			}
//			
//            @Override
//            public void mouseExited(MouseEvent e) {
//            	Point p = btnNewButton.getLocation();
//				p.y += 25;
//				btnNewButton.setLocation(p);
//            }
//            
//		});
//		btnNewButton.setBounds(pCarta*5, 35, 74, 111);
//		//System.out.println(finCarteMano.getComponents().length);
//		FinestraGioco.addFinCarteMano();
//		FinestraCarteMano.getPanel().add(btnNewButton);
//		numCarteMano++;
//		FinestraCarteMano.getPanel().repaint();
//		//FinestraGioco.addFinCarteMano();
//		//System.out.println(FinestraCarteMano.contaCarte());
			
//		System.out.println(pos+"pos");
//		System.out.println(numCarteMano);
		//FinestraCarteMano.rep();
	}
	
	public void addCartaBotSx() {
		
		JButton btnNewButton = new JButton();
		btnNewButton.setIcon(new ImageIcon("assets\\"+ generaCarta() + ".png"));
		
		
		Dimension d = new Dimension();
		d.width = 111;
		d.height = 74;
		btnNewButton.setPreferredSize(d);
		
		FinestraBotSx.getPanel().add(btnNewButton);
		FinestraBotSx.getPanel().repaint();
		FinestraBotSx.getPanel().validate();
	}

	public int getNumCarteMano() {
		return var;
	}

	public void setNumCarteMano(int var) {
		this.var = var;
	}
	
	

}
