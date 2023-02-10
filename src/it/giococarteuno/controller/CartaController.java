package it.giococarteuno.controller;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
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
import it.giococarteuno.view.gioco.FinestraBotDx;
import it.giococarteuno.view.gioco.FinestraBotSu;
import it.giococarteuno.view.gioco.FinestraBotSx;
import it.giococarteuno.view.gioco.FinestraCarteMano;

public class CartaController {
	
	public static int var = 0;
	public static int pos = 0;
	public static int meno = 10;
	public static int cont = 0;
	public static Carta carta;
	
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
	
	public static boolean isMouseWithinComponent(JButton c)
	{
	    Point mousePos = MouseInfo.getPointerInfo().getLocation();
	    Rectangle bounds = c.getBounds();
	    bounds.setLocation(c.getLocationOnScreen());
	    return bounds.contains(mousePos);
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
				if(cartaScar.getIcon().toString().equals("")) {
					
					//System.out.println("dentro primo if");
					cartaScar.setIcon(btnNewButton.getIcon());
					FinestraCarteMano.getPanel().remove(btnNewButton);
					//FinestraCarteMano.getPanel().repaint();
					//FinestraCarteMano.getPanel().validate();
				}
				
				
				//Arrays.asList(null);
				
				String[] carta1 = cartaScar.getIcon().toString().split("[_.'\']");
				String[] carta2 = btnNewButton.getIcon().toString().split("[_.'\']");
				if(carta1[1].equals(carta2[1]) || carta1[2].equals(carta2[2]))  {
					cartaScar.setIcon(btnNewButton.getIcon());
					FinestraCarteMano.getPanel().remove(btnNewButton);
					//FinestraCarteMano.getPanel().repaint();
					//FinestraCarteMano.getPanel().validate();
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
		//System.out.println(FinestraCarteMano.getPanel().getComponents().length);
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
		btnNewButton.setIcon(new ImageIcon("assets\\backSx.png"));
		Carta carta = generaCarta();
		btnNewButton.setActionCommand(carta.getValore() +"_"+ carta.getColore());
		//System.out.println(btnNewButton.getActionCommand());
		
		
		Dimension d = new Dimension();
		d.width = 111;
		d.height = 74;
		btnNewButton.setPreferredSize(d);
		
		int var = 0;
		
		int carteMano = FinestraBotSx.getPanel().getComponents().length;
		
		if(carteMano >= 5 && var < 111 ) {
			pos -= 5;
		}
		
		FinestraBotSx.getPanel().setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		
		FinestraBotSx.getPanel().add(btnNewButton);
		FinestraBotSx.getPanel().repaint();
		FinestraBotSx.getPanel().validate();
		var = FinestraBotSx.getPanel().getComponents()[0].getY();
		
		System.out.println(var);
		
	}
	
	public void addCartaBotSu() {
		
		JButton btnNewButton = new JButton();
		btnNewButton.setIcon(new ImageIcon("assets\\backSu.png"));
		Carta carta = generaCarta();
		btnNewButton.setActionCommand(carta.getValore() +"_"+ carta.getColore());
		//System.out.println(btnNewButton.getActionCommand());
		
		
		Dimension d = new Dimension();
		d.width = 74;
		d.height = 111;
		btnNewButton.setPreferredSize(d);
		
		FinestraBotSu.getPanel().add(btnNewButton);
		FinestraBotSu.getPanel().repaint();
		FinestraBotSu.getPanel().validate();
	}
	
	public void addCartaBotDx() {
		
		JButton btnNewButton = new JButton();
		btnNewButton.setIcon(new ImageIcon("assets\\backDx.png"));
		Carta carta = generaCarta();
		btnNewButton.setActionCommand(carta.getValore() +"_"+ carta.getColore());
		//System.out.println(btnNewButton.getActionCommand());
		
		
		Dimension d = new Dimension();
		d.width = 111;
		d.height = 74;
		btnNewButton.setPreferredSize(d);
		
		FinestraBotDx.getPanel().add(btnNewButton);
		FinestraBotDx.getPanel().repaint();
		FinestraBotDx.getPanel().validate();
	}

	public int getNumCarteMano() {
		return var;
	}

	public void setNumCarteMano(int var) {
		this.var = var;
	}
	
	

}
