package it.giococarteuno;

import java.awt.EventQueue;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import it.giococarteuno.dao.UtenteDAO;
import it.giococarteuno.model.Utente;
import it.giococarteuno.view.FinestraRegistrazione;
import it.giococarteuno.view.FinestraModificaProfilo;
import it.giococarteuno.view.FinestraProfilo;
import it.giococarteuno.view.FinestraBenvenuto;
import it.giococarteuno.view.FinestraGioco;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import net.miginfocom.swing.MigLayout;
import java.awt.BorderLayout;
import java.awt.Color;

public class JUno extends JFrame {

	private static JFrame frame;
	private JTextField textField;
	private static  Utente stringaNickname;
	private static JPanel panel = new JPanel();
	

	/**
	 * Launch the application.
	 * Main FinestraIniziale per far partire il gioco con il login.
	 * L'utente può scegliere se fare il login o la registrazione.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JUno window = new JUno();
					getFrame().setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public JUno() {
		initialize();
	}
	
	
	private void showError() {
        JOptionPane.showMessageDialog(this, "Nickname non esistente. Registrati", "Errore", JOptionPane.ERROR_MESSAGE);
    }
	
	public static  void showMain() {
		
		panel.setVisible(true);
		
	}
	
	public static  void closeMain() {
		
		panel.setVisible(false);
		
	}
	
	public static  void addProfilo() {
		
		FinestraProfilo pro = new FinestraProfilo();
		frame.getContentPane().add(pro.initialize());
		
	}
	
	public static  void addModificaProfilo() {
		
		FinestraModificaProfilo modPro = new FinestraModificaProfilo();
		frame.getContentPane().add(modPro.initialize());
		
	}
	
	public static  void addBenvenuto() {
		
		FinestraBenvenuto p = new FinestraBenvenuto();
		frame.getContentPane().add(p.initialize());
		
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame("Junoo");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		try {
			frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("backgroundImage\\backgroundLegnoGrigio.jpg")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		panel.setBounds(0, 0, 436, 263);
		panel.setLayout(new MigLayout("fillx", "[48px][96px][][57px][75px]", "[21px][][][][]"));
		panel.setOpaque(false);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Nickname:");
		panel.add(lblNewLabel, "cell 1 2,alignx center,aligny center");
		
		textField = new JTextField();
		textField.setColumns(10);
		panel.add(textField, "cell 2 2,growx,aligny top");
		
		/**
		 * bottone login
		 */
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				UtenteDAO utenteDAO = new UtenteDAO();
				String nicknameText = textField.getText();
				textField.setText("");
				setStringaNickname(utenteDAO.findByNickname(nicknameText));
				
				if(stringaNickname == null) {
					showError();
					return;
					
				}
				
				FinestraGioco.setUtenteLog(stringaNickname);
				
				
				
				addBenvenuto();
				panel.setVisible(false);
				
				
			}
		});
		
		panel.add(btnNewButton, "cell 2 3,growx,aligny top");
		
		/**
		 * bottone Registrati
		 */
		
		JButton btnNewButton_1 = new JButton("Registrati");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FinestraRegistrazione finReg = new FinestraRegistrazione();
				
				frame.getContentPane().add(finReg.initialize());
				textField.setText("");
				panel.setVisible(false);
				
			}
		});
		
		panel.add(btnNewButton_1, "cell 2 4,growx,aligny top");
		
		
		
	}
	
	
	public static Utente getStringaNickname() {
		return stringaNickname;
	}

	public static void setStringaNickname(Utente stringaNickname) {
		JUno.stringaNickname = stringaNickname;
	}
	
	public static JFrame getFrame() {
		return frame;
	}

	public static void setFrame(JFrame frame) {
		JUno.frame = frame;
	}

	public static JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		JUno.panel = panel;
	}
	
	
	
}
