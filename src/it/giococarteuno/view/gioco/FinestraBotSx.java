package it.giococarteuno.view.gioco;

import java.awt.Component;

import javax.swing.JPanel;

public class FinestraBotSx extends JPanel {

	private static JPanel panel;
	
	/**
	 * Create the panel.
	 */
	public FinestraBotSx() {

		initialize();
	}

	public Component initialize() {
		setLayout(null);
		panel = new JPanel();
		panel.setBounds(10, 44, 146, 592);
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
