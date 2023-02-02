package it.giococarteuno.view;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import it.giococarteuno.FinestraPrincipaleMain;

import javax.swing.JLabel;

import java.awt.Component;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import net.miginfocom.swing.MigLayout;

public class ProvaBen extends JPanel {
	
	public ProvaBen() {
		
		initialize();
	}

	/**
	 * Create the panel.
	 */
	
	
	public  Component  initialize() {
		
		
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 436, 263);
		panel.setLayout(new MigLayout("fillx, debug", "[][][][][]", "[50][][][][]"));
		
		JButton btnNewButton = new JButton("Gioca");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//per chiudere la finestra corrente
				JComponent comp = (JComponent) e.getSource();
				Window win = SwingUtilities.getWindowAncestor(comp);
				win.dispose();
				
				FinestraGioco fGioco = new FinestraGioco();
				fGioco.getFrame().setVisible(true);
				
				
			}
		});
		
		JLabel lblNewLabel = new JLabel("Bentornato: " + Testt.getStringaNickname().getNickname());
		panel.add(lblNewLabel, "cell 2 0");
		
		panel.add(btnNewButton,"cell 2 1,growx");
		
		
		
		JButton btnNewButton_1 = new JButton("Profilo");
		panel.add(btnNewButton_1,"cell 2 2,growx");
		
		JButton btnNewButton_1_1 = new JButton("Esci");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Testt.showMain();
				panel.setVisible(false);
			}
		});
		panel.add(btnNewButton_1_1, "cell 2 3,growx");
		
		
		return panel;
		
	}

}
