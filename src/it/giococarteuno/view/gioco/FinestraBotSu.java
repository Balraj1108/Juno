package it.giococarteuno.view.gioco;

import java.awt.Component;

import javax.swing.JPanel;

public class FinestraBotSu extends JPanel {
	
	private static JPanel panel;

	/**
	 * Create the panel.
	 */
	public FinestraBotSu() {
		initialize();
	}
	
	public Component initialize() {
		setLayout(null);
		panel = new JPanel();
		panel.setBounds(298, 10, 740, 146);
		add(panel);
		
		return panel;
	}
	
	public static JPanel getPanel() {
		return panel;
	}

	public static  void setPanel(JPanel panel) {
		FinestraBotSu.panel = panel;
	}

}
