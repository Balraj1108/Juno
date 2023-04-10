package it.giococarteuno.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;

import javax.swing.JPanel;

import it.giococarteuno.JUno;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class FinestraProfilo extends JPanel {

	
	private static JPanel panel;
	
	/**
	 * Create the panel.
	 */
	public FinestraProfilo() {
		initialize();
		
	}
	
	
	public  Component  initialize() {
		
		panel = new JPanel();
		panel.setBounds(0, 0, 436, 263);
		panel.setLayout(new MigLayout("fillx", "[][][]", "[][][][][][][][][][][][][][][][][]"));
		panel.setOpaque(false);
		
		JLabel lblNewLabel = new JLabel("Nickname: " + JUno.getStringaNickname().getNickname());
		panel.add(lblNewLabel, "cell 0 1,alignx center");
		
		JButton btnNewButton_1 = new JButton("Modifica Nickname");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JUno.addModificaProfilo();
				panel.setVisible(false);
				
				
			}
		});
		panel.add(btnNewButton_1, "cell 1 1");
		
		JLabel lblNewLabel_1 = new JLabel("Livello: " + JUno.getStringaNickname().getLivello());
		panel.add(lblNewLabel_1, "cell 0 2,alignx center");
		
		JLabel lblNewLabel_2 = new JLabel("Partite Vinte: " + JUno.getStringaNickname().getPartiteVinte());
		panel.add(lblNewLabel_2, "cell 0 3,alignx center");
		
		JLabel lblNewLabel_3 = new JLabel("Partite Perse: " + JUno.getStringaNickname().getPartitePerse());
		panel.add(lblNewLabel_3, "cell 0 4,alignx center");
		
		JLabel lblNewLabel_4 = new JLabel("Partite Giocate: " + JUno.getStringaNickname().getPartiteGiocate());
		panel.add(lblNewLabel_4, "cell 0 5,alignx center");
		
		JButton btnNewButton = new JButton("Indietro");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				
				panel.setVisible(false);
				JUno.addBenvenuto();
			}
		});
		panel.add(btnNewButton, "cell 1 6");
		
		JLabel lblNewLabel_5 = new JLabel();
		//lblNewLabel_5.setBounds(350, 50, 150, 150);
		lblNewLabel_5.setSize(100 , 100);
		lblNewLabel_5.setBorder(BorderFactory.createLineBorder((Color.black),2));
		
		BufferedImage picture;
		try {
			picture = ImageIO.read(new File("profileImage\\userImg.png"));
			Image dimg = picture.getScaledInstance(lblNewLabel_5.getWidth(), lblNewLabel_5.getHeight(),
	                Image.SCALE_SMOOTH);
	        lblNewLabel_5.setIcon(new ImageIcon(dimg));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
		
		panel.add(lblNewLabel_5, "cell 0 8,alignx center");
		
		JButton btnNewButton_2 = new JButton("Modifica Img");
		
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnNewButton_2) {
		            JFileChooser fileChooser = new JFileChooser();
		            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		            int result = fileChooser.showOpenDialog(getParent());
		            if (result == JFileChooser.APPROVE_OPTION) {
		                try {
		                    File file = fileChooser.getSelectedFile();
		                    BufferedImage picture = ImageIO.read(file);
		                    Image dimg = picture.getScaledInstance(lblNewLabel_5.getWidth(), lblNewLabel_5.getHeight(),
		                            Image.SCALE_SMOOTH);
		                    

		                    lblNewLabel_5.setIcon(new ImageIcon(dimg));
		                    
		                    
		                    ImageIO.write(picture, "png", new File("profileImage\\" + "userImg.png"));
		                    
		                    
		                    
		                } catch (IOException ioe) {
		                    ioe.printStackTrace();
		                    JOptionPane.showMessageDialog(null, "ERROR");
		                }
		            }
		        }
				
			}
		});

			
		panel.add(btnNewButton_2, "cell 1 8");
		
		return panel;
		
	}
	
	public static void showPro() {
		panel.setVisible(true);
	}

}
