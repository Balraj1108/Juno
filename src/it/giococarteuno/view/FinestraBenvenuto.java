package it.giococarteuno.view;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import it.giococarteuno.JUno;
import it.giococarteuno.controller.CartaController;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import net.miginfocom.swing.MigLayout;


/**
 *Finestra di benvenuto che appare dopo il Login che mostra l'immagine di profilo corrente
 *permette di giocare, vedere il profilo o uscire dall'account
 *
 */
public class FinestraBenvenuto extends JPanel {
	
	
	private static JPanel panel;
	
	public FinestraBenvenuto() {
		
		initialize();
	}

	/**
	 * Create the panel.
	 */
	
	
	public  Component  initialize() {
		
		
		
		
		panel = new JPanel();
		panel.setBounds(0, 0, 436, 263);
		panel.setLayout(new MigLayout("fillx", "[][][][][]", "[50][][][][]"));
		panel.setOpaque(false);
		
		JButton btnNewButton = new JButton("Gioca");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CartaController.pos = 0;
				CartaController.pos1 = 0;
				CartaController.pos2 = 0;
				CartaController.pos3 = 0;
				
				//per chiudere la finestra corrente
				JComponent comp = (JComponent) e.getSource();
				Window win = SwingUtilities.getWindowAncestor(comp);
				win.dispose();
				
				FinestraGioco fGioco = new FinestraGioco();
				fGioco.getFrame().setVisible(true);
				
				
			}
		});
		
		JLabel lblNewLabel = new JLabel("Bentornato: " + JUno.getStringaNickname().getNickname());
		panel.add(lblNewLabel, "cell 2 0");
		
		JLabel lblNewLabel_1 = new JLabel();
		
		lblNewLabel_1.setSize(100 , 100);
		lblNewLabel_1.setBorder(BorderFactory.createLineBorder((Color.black),2));
		
		BufferedImage picture;
		try {
			picture = ImageIO.read(new File("profileImage\\userImg.png"));
			Image dimg = picture.getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(),
	                Image.SCALE_SMOOTH);
			lblNewLabel_1.setIcon(new ImageIcon(dimg));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		panel.add(lblNewLabel_1, "cell 0 1");
		
		panel.add(btnNewButton,"cell 2 1,growx");
		
		
		
		JButton btnNewButton_1 = new JButton("Profilo");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JUno.addProfilo();
//				pro.setEnabled(true);
//				System.out.println("prima false profilo");
				panel.setVisible(false);
				
				
			}
		});
		panel.add(btnNewButton_1,"cell 2 2,growx");
		
		JButton btnNewButton_1_1 = new JButton("Esci");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//MainFinestraIniziale.showMain();
				
				JUno.getPanel().setVisible(true);
				panel.setVisible(false);
			}
		});
		panel.add(btnNewButton_1_1, "cell 2 3,growx");
		
		
		return panel;
		
	}
	
	public static void showBen() {
		panel.setVisible(true);
	}

	public static JPanel getPanel() {
		return panel;
	}

	public static void setPanel(JPanel panel) {
		FinestraBenvenuto.panel = panel;
	}
	
	

}
