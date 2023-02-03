package it.giococarteuno.view;

import java.awt.Component;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProfiloT extends JPanel {

	
	private static JPanel panel;
	
	/**
	 * Create the panel.
	 */
	public ProfiloT() {
		initialize();
	}
	
	public  Component  initialize() {
		
		panel = new JPanel();
		panel.setBounds(0, 0, 436, 263);
		panel.setLayout(new MigLayout("fillx", "[][][]", "[][][][][][][]"));
		
		JLabel lblNewLabel = new JLabel("Nickname: " + Testt.getStringaNickname().getNickname());
		panel.add(lblNewLabel, "cell 0 1,alignx center");
		
		JButton btnNewButton_1 = new JButton("Modifica");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Testt.addModificaProfilo();
				panel.setVisible(false);
				
			}
		});
		panel.add(btnNewButton_1, "cell 1 1");
		
		JLabel lblNewLabel_1 = new JLabel("Livello: " + Testt.getStringaNickname().getLivello());
		panel.add(lblNewLabel_1, "cell 0 2,alignx center");
		
		JLabel lblNewLabel_2 = new JLabel("Partite Vinte: " + Testt.getStringaNickname().getPartiteVinte());
		panel.add(lblNewLabel_2, "cell 0 3,alignx center");
		
		JLabel lblNewLabel_3 = new JLabel("Partite Perse: " + Testt.getStringaNickname().getPartitePerse());
		panel.add(lblNewLabel_3, "cell 0 4,alignx center");
		
		JLabel lblNewLabel_4 = new JLabel("Partite Giocate: " + Testt.getStringaNickname().getPartiteGiocate());
		panel.add(lblNewLabel_4, "cell 0 5,alignx center");
		
		JButton btnNewButton = new JButton("Indietro");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				
				panel.setVisible(false);
				Testt.addBenvenuto();
			}
		});
		panel.add(btnNewButton, "cell 1 6");
		
		
		
		return panel;
		
	}
	
	public static void showPro() {
		panel.setVisible(true);
	}

}
