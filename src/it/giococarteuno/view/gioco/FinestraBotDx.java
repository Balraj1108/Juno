package it.giococarteuno.view.gioco;

import java.awt.Component;

import javax.swing.JPanel;

public class FinestraBotDx extends JPanel {

	private static JPanel panel;
	
	/**
	 * Create the panel.
	 */
	public FinestraBotDx() {
		initialize();
	}
	
	public Component initialize() {
		setLayout(null);
		panel = new JPanel();
		panel.setBounds(1194, 44, 146, 592);
		panel.setOpaque(false);
		add(panel);
		
		return panel;
	}
	
	public static JPanel getPanel() {
		return panel;
	}

	public static  void setPanel(JPanel panel) {
		FinestraBotDx.panel = panel;
	}

}
