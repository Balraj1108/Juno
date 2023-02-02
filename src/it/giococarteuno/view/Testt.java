package it.giococarteuno.view;

import java.awt.EventQueue;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import it.giococarteuno.FinestraPrincipaleMain;
import it.giococarteuno.dao.UtenteDAO;
import it.giococarteuno.model.Utente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComponent;
import net.miginfocom.swing.MigLayout;
import java.awt.BorderLayout;

public class Testt extends JFrame {

	private JFrame frame;
	private JTextField textField;
	private static  Utente stringaNickname;
	private static JPanel panel = new JPanel();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Testt window = new Testt();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public Testt() {
		
		initialize();
	}
	
	
	private void showError() {
        JOptionPane.showMessageDialog(this, "Nickname non esistente. Registrati", "Errore", JOptionPane.ERROR_MESSAGE);
    }
	
	public static  void showMain() {
		
		panel.setVisible(true);
		
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Junoo");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		//frame.getContentPane().setLayout(new MigLayout("", "[69px][96px][][]", "[19px][21px][][][]"));
		
		panel.setBounds(0, 0, 436, 263);
		panel.setLayout(new MigLayout("fillx", "[48px][96px][][57px][75px]", "[21px][][][][]"));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Nickname:");
		//frame.getContentPane().add(lblNewLabel, "cell 1 2,alignx center,aligny center");
		panel.add(lblNewLabel, "cell 1 2,alignx center,aligny center");
		
		textField = new JTextField();
		//frame.getContentPane().add(textField, "cell 2 2,alignx left,aligny top");
		textField.setColumns(10);
		panel.add(textField, "cell 2 2,growx,aligny top");
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				UtenteDAO utenteDAO = new UtenteDAO();
				String nicknameText = textField.getText();
				textField.setText("");
				System.out.println(nicknameText + " testo che inserisco io");
				System.out.println(utenteDAO.findByNickname(nicknameText));
				setStringaNickname(utenteDAO.findByNickname(nicknameText));
				
				if(stringaNickname == null) {
					showError();
					return;
					
				}
				
				System.out.println(stringaNickname + "variabile");
				
//				lblNewLabel.setVisible(false);
//				btnNewButton.setVisible(false);
//				textField.setVisible(false);
				
				
				ProvaBen p = new ProvaBen();
				
				frame.getContentPane().add(p.initialize());
				panel.setVisible(false);
				
				//iniziaBenvenuto();
				
				
			}
		});
		//frame.getContentPane().add(btnNewButton, "cell 1 3,growx,aligny top");
		panel.add(btnNewButton, "cell 2 3,growx,aligny top");
		
		JButton btnNewButton_1 = new JButton("Registrati");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FinRegistrazione finReg = new FinRegistrazione();
				
				frame.getContentPane().add(finReg.initialize());
				panel.setVisible(false);
				
			}
		});
		//frame.getContentPane().add(btnNewButton_1, "cell 2 4,growx");
		panel.add(btnNewButton_1, "cell 2 4,growx,aligny top");
		
		
//		frame.getContentPane().add(benvenuto);
//		benvenuto.setVisible(true);
		

		
		
	}
	
//	public void provaBen() {
//		JPanel panel = new JPanel();
//		panel.setBounds(0, 0, 436, 263);
//		JButton btnNewButton = new JButton("Gioca");
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//				//per chiudere la finestra corrente
//				JComponent comp = (JComponent) e.getSource();
//				Window win = SwingUtilities.getWindowAncestor(comp);
//				win.dispose();
//				
//				FinestraGioco fGioco = new FinestraGioco();
//				fGioco.getFrame().setVisible(true);
//				
//				
//			}
//		});
//		btnNewButton.setBounds(166, 94, 89, 23);
//		frame.getContentPane().add(btnNewButton);
//	}
	
//	public void iniziaBenvenuto() {
//		Benvenuto benvenuto = new Benvenuto();
//		frame.getContentPane().add(benvenuto);
//		benvenuto.setVisible(true);
//	}
	
	public static Utente getStringaNickname() {
		return stringaNickname;
	}

	public static void setStringaNickname(Utente stringaNickname) {
		Testt.stringaNickname = stringaNickname;
	}
	
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	
	
}
