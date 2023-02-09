package it.giococarteuno.view.gioco;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import it.giococarteuno.controller.CartaController;
import net.miginfocom.swing.MigLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.OverlayLayout;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JLabel;
import javax.swing.JScrollBar;

public class FinestraCarteMano extends JPanel {
	
	private static JPanel panel;
	/**
	 * Create the panel.
	 */
	public FinestraCarteMano() {
		
		
		initialize();
		
		
		
		
	}
	
	public Component initialize() {
		setLayout(null);
		
		//CartaController controller = new CartaController();
		panel = new JPanel();
		panel.setBounds(292, 524, 740, 146);
		add(panel);
		
//		System.out.println("dentro cartemano");
//		jPane = new JScrollPane(panel);
//		add(jPane);
//		JScrollPane jPane = new JScrollPane(this, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
//			    JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//		panel.add(jPane);
//		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		//panel.add(jPane);
		//add(jPane);
		//panel.add(jPane);
		//OverlayLayout overlay = new OverlayLayout(panel);
		//panel.setLayout(overlay);
		//panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 35));
		//panel.setLayout(null);
		
		
//		JButton btnNewButton = new JButton(new ImageIcon("assets\\"+ controller.generaCarta() + ".png"));
//		btnNewButton.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				Point p = btnNewButton.getLocation();
//				p.y -= 25;
//				btnNewButton.setLocation(p);
//			}
//			
//			@Override
//			public void mouseExited(MouseEvent e) {
//				Point p = btnNewButton.getLocation();
//				p.y += 25;
//				btnNewButton.setLocation(p);
//          }
//		});
//
//		
//		Dimension d = getPreferredSize();
//		d.width = 74;
//		d.height = 111;
//		btnNewButton.setPreferredSize(d);
//		panel.add(btnNewButton);
//		JButton btnNewButton_2 = new JButton(new ImageIcon("assets\\"+ controller.generaCarta() + ".png"));
//		btnNewButton_2.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				Point p = btnNewButton_2.getLocation();
//				p.y -= 25;
//				btnNewButton_2.setLocation(p);
//			}
//			
//			@Override
//			public void mouseExited(MouseEvent e) {
//				Point p = btnNewButton_2.getLocation();
//				p.y += 25;
//				btnNewButton_2.setLocation(p);
//          }
//		});
//		btnNewButton_2.setOpaque(false);
//		btnNewButton_2.setBorderPainted(false);
//		btnNewButton_2.setContentAreaFilled(false);
//		panel.add(btnNewButton_2);
//		JButton btnNewButton_3 = new JButton(new ImageIcon("assets\\"+ controller.generaCarta() + ".png"));
//		panel.add(btnNewButton_3);
//		JButton btnNewButton_4 = new JButton(new ImageIcon("assets\\"+ controller.generaCarta() + ".png"));
//		panel.add(btnNewButton_4);
//		JButton btnNewButton_5 = new JButton(new ImageIcon("assets\\"+ controller.generaCarta() + ".png"));
//		panel.add(btnNewButton_5);
//		JButton btnNewButton_6 = new JButton(new ImageIcon("assets\\"+ controller.generaCarta() + ".png"));
//		panel.add(btnNewButton_6);
//		JButton btnNewButton_7 = new JButton(new ImageIcon("assets\\"+ controller.generaCarta() + ".png"));
//		panel.add(btnNewButton_7);
//		JButton btnNewButton_8 = new JButton(new ImageIcon("assets\\"+ controller.generaCarta() + ".png"));
//		panel.add(btnNewButton_8);
//		JButton btnNewButton_9 = new JButton(new ImageIcon("assets\\"+ controller.generaCarta() + ".png"));
//		panel.add(btnNewButton_9);
//		JButton btnNewButton_10 = new JButton(new ImageIcon("assets\\"+ controller.generaCarta() + ".png"));
//		panel.add(btnNewButton_10);
		
		
		
		//panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 50));
		
		
//		
//		JButton btnNewButton_6 = new JButton(new ImageIcon("assets\\"+ controller.generaCarta() + ".png"));
//		btnNewButton_6.setSize(74, 111);
//		panel.add(btnNewButton_6);
//		
//		JButton btnNewButton_7 = new JButton(new ImageIcon("assets\\"+ controller.generaCarta() + ".png"));
//		panel.add(btnNewButton_7);
//		
//		JButton btnNewButton_5 = new JButton(new ImageIcon("assets\\"+ controller.generaCarta() + ".png"));
//		panel.add(btnNewButton_5);
//		
//		JButton btnNewButton_4 = new JButton(new ImageIcon("assets\\"+ controller.generaCarta() + ".png"));
//		panel.add(btnNewButton_4);
//		
//		JButton btnNewButton_3 = new JButton(new ImageIcon("assets\\"+ controller.generaCarta() + ".png"));
//		panel.add(btnNewButton_3);
		
		
//		CartaController controller = new CartaController();
//		
//		JButton btnNewButton = new JButton(new ImageIcon("assets\\"+ controller.generaCarta() + ".png"));
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
//		btnNewButton.setBounds(297, 35, 74, 111);
//		panel.add(btnNewButton);
//		
//		JButton btnNewButton_1 = new JButton(new ImageIcon("assets\\"+ controller.generaCarta() + ".png"));
//		btnNewButton_1.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				Point p = btnNewButton_1.getLocation();
//				p.y -= 25;
//				btnNewButton_1.setLocation(p);
//			}
//			
//            @Override
//            public void mouseExited(MouseEvent e) {
//            	Point p = btnNewButton_1.getLocation();
//				p.y += 25;
//				btnNewButton_1.setLocation(p);
//            }
//            
//		});
//		btnNewButton_1.setBounds(343, 35, 74, 111);
//		panel.add(btnNewButton_1);
//		
//		JButton btnNewButton_1_1 = new JButton(new ImageIcon("assets\\"+ controller.generaCarta() + ".png"));
//		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				Point p = btnNewButton_1_1.getLocation();
//				p.y -= 25;
//				btnNewButton_1_1.setLocation(p);
//			}
//			
//            @Override
//            public void mouseExited(MouseEvent e) {
//            	Point p = btnNewButton_1_1.getLocation();
//				p.y += 25;
//				btnNewButton_1_1.setLocation(p);
//            }
//            
//		});
//		btnNewButton_1_1.setBounds(381, 35, 74, 111);
//		panel.add(btnNewButton_1_1);
//		
//		JButton btnNewButton_2 = new JButton(new ImageIcon("assets\\"+ controller.generaCarta() + ".png"));
//		btnNewButton_2.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				Point p = btnNewButton_2.getLocation();
//				p.y -= 25;
//				btnNewButton_2.setLocation(p);
//			}
//			
//            @Override
//            public void mouseExited(MouseEvent e) {
//            	Point p = btnNewButton_2.getLocation();
//				p.y += 25;
//				btnNewButton_2.setLocation(p);
//            }
//            
//		});
//		btnNewButton_2.setBounds(415, 35, 74, 111);
//		panel.add(btnNewButton_2);
//		
//		JButton btnNewButton_3 = new JButton(new ImageIcon("assets\\"+ controller.generaCarta() + ".png"));
//		btnNewButton_3.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				Point p = btnNewButton_3.getLocation();
//				p.y -= 25;
//				btnNewButton_3.setLocation(p);
//			}
//			
//            @Override
//            public void mouseExited(MouseEvent e) {
//            	Point p = btnNewButton_3.getLocation();
//				p.y += 25;
//				btnNewButton_3.setLocation(p);
//            }
//            
//		});
//		btnNewButton_3.setBounds(442, 35, 74, 111);
//		panel.add(btnNewButton_3);
		
//		JButton btnNewButton = new JButton("New button");
//		
//		panel.add(btnNewButton, "cell 0 1,aligny bottom");
//		
//		JButton btnNewButton_1 = new JButton("New button");
//		panel.add(btnNewButton_1, "cell 1 1");
//		
//		JButton btnNewButton_2 = new JButton("New button");
//		panel.add(btnNewButton_2, "cell 2 1");
		
		
		
		
		
		
		return panel;
		
		
		
	}
	
	public static JPanel getPanel() {
		return panel;
	}

	public static  void setPanel(JPanel panel) {
		FinestraCarteMano.panel = panel;
	}
}
