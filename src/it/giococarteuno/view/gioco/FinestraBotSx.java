package it.giococarteuno.view.gioco;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;

public class FinestraBotSx extends JPanel {

	private static JPanel panel;
	
	/**
	 * Create the panel.
	 */
	public FinestraBotSx() {

		initialize();
	}

	public Component initialize() {
		//Border blackline = BorderFactory.createLineBorder(Color.black);
		//setLayout(null);
		panel = new JPanel();
		panel.setBounds(10, 44, 146, 594);
		//panel.setBorder(blackline);
        
		add(panel);
		
		return panel;
	}
	
	
	public static JPanel getPanel() {
		return panel;
	}

	public static  void setPanel(JPanel panel) {
		FinestraBotSx.panel = panel;
	}
}
