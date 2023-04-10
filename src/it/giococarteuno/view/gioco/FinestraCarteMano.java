package it.giococarteuno.view.gioco;

import java.awt.Color;
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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;

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
		
		panel = new JPanel();
		panel.setBounds(292, 524, 740, 146);
		panel.setOpaque(false);
		
		add(panel);
		
		return panel;
		
		
		
	}
	
	public static JPanel getPanel() {
		return panel;
	}

	public static  void setPanel(JPanel panel) {
		FinestraCarteMano.panel = panel;
	}
}
