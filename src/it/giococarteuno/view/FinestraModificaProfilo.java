package it.giococarteuno.view;

import java.awt.Component;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import it.giococarteuno.MainFinestraIniziale;
import it.giococarteuno.dao.UtenteDAO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FinestraModificaProfilo extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public FinestraModificaProfilo() {
		initialize();
	}
	
	private void showSuccess() {
        JOptionPane.showMessageDialog(this, "Cambio nickname avvenuto con successo", "Successo", JOptionPane.CLOSED_OPTION);
    }
	
	private void showError() {
        JOptionPane.showMessageDialog(this, "Nickname già esistente", "Errore", JOptionPane.ERROR_MESSAGE);
    }
	
	public  Component  initialize() {
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 436, 263);
		panel.setLayout(new MigLayout("fillx", "[][grow][][]", "[][][]"));
		panel.setOpaque(false);
		
		JLabel lblNewLabel = new JLabel("Nickname:");
		panel.add(lblNewLabel, "flowx,cell 1 1,alignx center");
		
		textField = new JTextField(MainFinestraIniziale.getStringaNickname().getNickname());
		panel.add(textField, "cell 1 1,alignx center");
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Conferma");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UtenteDAO utenteDAO = new UtenteDAO();
				String nicknameText = textField.getText();
				
				
				if(utenteDAO.findByNickname(nicknameText) != null 
						|| nicknameText.equals("")) {
					
					panel.repaint();
					showError();
					panel.repaint();
				}
				
				else
				{
					utenteDAO.update(nicknameText, 
					MainFinestraIniziale.getStringaNickname().getId());
					
					MainFinestraIniziale.getStringaNickname().setNickname(nicknameText);
					
					FinestraGioco.getUtenteLog().setNickname(nicknameText);
					
					
					panel.setVisible(false);
					MainFinestraIniziale.addProfilo();
					showSuccess();
				}
			}
		});
		panel.add(btnNewButton, "flowx,cell 1 2,alignx center");
		
		JButton btnNewButton_1 = new JButton("Annulla");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FinestraProfilo.showPro();
				panel.setVisible(false);
			}
		});
		panel.add(btnNewButton_1, "cell 1 2");
		
		
		
		return panel;
	}

}
