package it.giococarteuno.controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import it.giococarteuno.JUno;
import it.giococarteuno.dao.UtenteDAO;
import it.giococarteuno.model.Carta;
import it.giococarteuno.model.Colore;
import it.giococarteuno.model.Mazzo;
import it.giococarteuno.model.Valore;
import it.giococarteuno.view.FinestraGioco;
import it.giococarteuno.view.gioco.ButtonLayout;
import it.giococarteuno.view.gioco.FinestraBotDx;
import it.giococarteuno.view.gioco.FinestraBotSu;
import it.giococarteuno.view.gioco.FinestraBotSx;
import it.giococarteuno.view.gioco.FinestraCarteMano;

/**
 * è il controller per le carte.
 * mi permette di generare il mazzo e generare una carta random dal mazzo
 * ogni carta ha delle caratteristiche in base a dove viene posizionata
 * in mano, al bot di sx al bot in alto o il bot di dx
 */

public class CartaController extends JPanel {

	public static int var = 0;
	public static int var1 = 0;
	public static int var2 = 0;
	public static int var3 = 0;

	public static int pos = 0;
	public static int pos1 = 0;
	public static int pos2 = 0;
	public static int pos3 = 0;

	public static int test = 0;
	public static int contTur = 0;
	public static int contTurnSu = 0;

	public static int testCambioGiro = 0;
	public static int contTurCambioGiro = 0;
	public static int contTurnSuCambioGiro = 0;

	public static int clickUnoController = 0;

	public static int meno = 10;
	public static int cont = 0;
	public static int ranInt = 96;
	public static Carta carta;
	public static Mazzo mazzo;
	public static Mazzo mazzoCarteScartate;
	

	public CartaController() {

	}

	public static Mazzo generaMazzo() {

		System.out.println("dentro gen");
		mazzo = new Mazzo();
		mazzoCarteScartate = new Mazzo();


		for(int j = 0; j < 2; j++) {
			for(int i = 1; i < Valore.values().length-2; i++) {
				for(int k = 0; k < Colore.values().length-1; k++) {
					mazzo.getMazzo().add(new Carta(Colore.values()[k], Valore.values()[i]));
				}
			}
		}
		
		mazzo.getMazzo().add(new Carta(Colore.Blu, Valore.Zero));
		mazzo.getMazzo().add(new Carta(Colore.Giallo, Valore.Zero));
		mazzo.getMazzo().add(new Carta(Colore.Verde, Valore.Zero));
		mazzo.getMazzo().add(new Carta(Colore.Rosso, Valore.Zero));
		
		mazzo.getMazzo().add(new Carta(Colore.QuattroColori, Valore.CambioColore));
		mazzo.getMazzo().add(new Carta(Colore.QuattroColori, Valore.CambioColore));
		mazzo.getMazzo().add(new Carta(Colore.QuattroColori, Valore.CambioColore));
		mazzo.getMazzo().add(new Carta(Colore.QuattroColori, Valore.CambioColore));
		
		mazzo.getMazzo().add(new Carta(Colore.QuattroColori, Valore.PiuQuattro));
		mazzo.getMazzo().add(new Carta(Colore.QuattroColori, Valore.PiuQuattro));
		mazzo.getMazzo().add(new Carta(Colore.QuattroColori, Valore.PiuQuattro));
		mazzo.getMazzo().add(new Carta(Colore.QuattroColori, Valore.PiuQuattro));
		
		System.out.println(mazzo.getMazzo().size());
		return mazzo;
	}

	public static Carta generaCarta() {
		Carta car = new Carta();
		cont++;
		Random rand = new Random();
		
		int sizeMazzo = mazzo.getMazzo().size();
		int randomNum = rand.nextInt(sizeMazzo);
		car = mazzo.getMazzo().get(randomNum);
		mazzo.getMazzo().remove(car);
		
		if (mazzo.getMazzo().size() == 0) {
			mazzoCarteScartate.getMazzo().stream().forEach(cart -> mazzo.getMazzo().add(cart));
			Collections.shuffle(mazzo.getMazzo());
			mazzoCarteScartate.getMazzo().clear();
		}
		return car;

	}

	private static void showSuccess() {
		JOptionPane.showMessageDialog(FinestraGioco.getFrame(), "Complimenti Hai Vinto!!!", "Successo",
				JOptionPane.CLOSED_OPTION);

	}

	private static void showError() {
		JOptionPane.showMessageDialog(FinestraGioco.getFrame(), "Hai Perso :(", "Perso", JOptionPane.ERROR_MESSAGE);

	}

	public static Color coloreCornice(String coloreCarta) {
		Color colScar = Color.black;

		switch (coloreCarta) {

		case "Blu":
			colScar = Color.blue;

			break;

		case "Giallo":
			colScar = Color.yellow;

			break;

		case "Rosso":
			colScar = Color.red;

			break;

		case "Verde":
			colScar = Color.GREEN;

			break;

		case "QuattroColori":
			colScar = Color.black;

			break;

		}
		return colScar;
	}

	public static void addCartaMano() {

		JButton btnNewButton = new JButton();
		carta = generaCarta();
		btnNewButton.setIcon(new ImageIcon("assets\\" + carta.getValore() + "_" + carta.getColore() + ".png"));
		btnNewButton.setDisabledIcon(new ImageIcon("assets\\" + carta.getValore() + "_" + carta.getColore() + ".png"));

		btnNewButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {

				Point p = btnNewButton.getLocation();
				p.y -= 27;
				btnNewButton.setLocation(p);

			}

			@Override
			public void mouseExited(MouseEvent e) {

				Point p = btnNewButton.getLocation();
				p.y += 27;
				btnNewButton.setLocation(p);
				if (btnNewButton.getY() > 35) {
					p.y = 35;
					btnNewButton.setLocation(p);
				}
			}

		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// System.out.println("dentro bottone carta");

				JButton cartaScar = FinestraGioco.getCartaScartata();
				// System.out.println(cartaScar.getIcon());
				// System.out.println(btnNewButton.getIcon());
				String[] carta1 = cartaScar.getIcon().toString().split("[_.\\\\]");
				String[] carta2 = btnNewButton.getIcon().toString().split("[_.\\\\]");
				// System.out.println(btnNewButton.getIcon());
				// System.out.println(test + " fuori click mio");
				// System.out.println(carta2[1]);
				if (cartaScar.getIcon().toString().equals("")) {
					FinestraGioco.btnNewButton_1_1.setEnabled(false);
					for (Component c : FinestraCarteMano.getPanel().getComponents()) {
						c.setEnabled(false);
					}
					if (FinestraGioco.varCambioGiro == true) {
						test = 1;
						// System.out.println("dentro primo if");
						cartaScar.setIcon(btnNewButton.getIcon());
						// System.out.println(carta2[1]);
						FinestraCarteMano.getPanel().remove(btnNewButton);
						TurnoController turnoCtrl = new TurnoController();
						turnoCtrl.turnoBotSx();
						// System.out.println(test + " dentro click mio");
						// FinestraCarteMano.getPanel().repaint();
						// FinestraCarteMano.getPanel().validate();
					} else {
						testCambioGiro = 1;

						cartaScar.setIcon(btnNewButton.getIcon());

						FinestraCarteMano.getPanel().remove(btnNewButton);
						TurnoController turnoCtrl = new TurnoController();
						turnoCtrl.turnoBotDxCambioGiro();

					}
				}


				else if (carta1[1].equals(carta2[1]) || carta1[2].equals(carta2[2]) || carta2[1].equals("CambioColore")
						|| carta2[1].equals("PiuQuattro")) {
					if (FinestraCarteMano.getPanel().getComponents().length == 2) {
						TurnoController turnoCtrl1 = new TurnoController();
						turnoCtrl1.checkClickUnoGiocatore();
						FinestraGioco.clickUnoButton.setVisible(true);
						clickUnoController++;
						// FinestraGioco.panelScegliColore.setVisible(true);

					}
					if (FinestraCarteMano.getPanel().getComponents().length == 1 && (carta2[1].equals("CambioColore")
							|| carta2[1].equals("PiuQuattro") || carta2[1].equals("PiuDue")
							|| carta2[1].equals("Blocca") || carta2[1].equals("CambioGiro"))) {
						return;
						// FinestraGioco.panelScegliColore.setVisible(true);

					}
					FinestraGioco.btnNewButton_1_1.setEnabled(false);
					for (Component c : FinestraCarteMano.getPanel().getComponents()) {
						c.setEnabled(false);
					}
					String strIcon = btnNewButton.getIcon() + "";
					if (strIcon.contains("PiuDue")) {
						if (FinestraGioco.varCambioGiro == true) {
							contTur = 1;
							CartaController.addCartaBotSx();
							CartaController.addCartaBotSx();
							TurnoController turnoCtrl = new TurnoController();
							turnoCtrl.turnoBotSu();
						} else {
							contTurCambioGiro = 1;
							CartaController.addCartaBotDx();
							CartaController.addCartaBotDx();
							TurnoController turnoCtrl = new TurnoController();
							turnoCtrl.turnoBotSuCambioGiro();

						}

					} else if (strIcon.contains("Blocca")) {
						if (FinestraGioco.varCambioGiro == true) {

							contTur = 1;
							TurnoController turnoCtrl = new TurnoController();
							turnoCtrl.turnoBotSu();
						} else {
							contTurCambioGiro = 1;
							TurnoController turnoCtrl = new TurnoController();
							turnoCtrl.turnoBotSuCambioGiro();
						}
					} else if (strIcon.contains("CambioColore")) {
						FinestraGioco.panelScegliColore.setVisible(true);
					} else if (strIcon.contains("PiuQuattro")) {
						if (FinestraGioco.varCambioGiro == true) {
							CartaController.addCartaBotSx();
							CartaController.addCartaBotSx();
							CartaController.addCartaBotSx();
							CartaController.addCartaBotSx();
						} else {
							CartaController.addCartaBotDx();
							CartaController.addCartaBotDx();
							CartaController.addCartaBotDx();
							CartaController.addCartaBotDx();
						}
						FinestraGioco.panelScegliColorePiuQuattro.setVisible(true);
					} else if (strIcon.contains("CambioGiro")) {
						if (FinestraGioco.varCambioGiro == true) {
							// System.out.println("entra cambio giro if");
							FinestraGioco.varCambioGiro = false;
							testCambioGiro = 1;
							TurnoController turnoCtrl = new TurnoController();
							turnoCtrl.turnoBotDxCambioGiro();
						} else {
							// System.out.println("entra cambio giro else ");
							FinestraGioco.varCambioGiro = true;
							test = 1;
							TurnoController turnoCtrl = new TurnoController();
							turnoCtrl.turnoBotSx();

						}
					}

					else {
						if (FinestraGioco.varCambioGiro == true) {
							test = 1;
							TurnoController turnoCtrl = new TurnoController();
							turnoCtrl.turnoBotSx();
						} else {
							testCambioGiro = 1;
							TurnoController turnoCtrl = new TurnoController();
							turnoCtrl.turnoBotDxCambioGiro();
						}
					}

					cartaScar.setIcon(btnNewButton.getIcon());
					cartaScar.setBorder(BorderFactory.createLineBorder(CartaController.coloreCornice(carta2[2]), 4));
					// System.out.println(carta2[2]);
					mazzoCarteScartate.getMazzo().add(carta);
					// System.out.println(mazzoCarteScartate.getMazzo().size());
					FinestraCarteMano.getPanel().remove(btnNewButton);
				}

				int carteMano = FinestraCarteMano.getPanel().getComponents().length;

				if (carteMano >= 9 && var > 90 && pos < 0) {
					pos += 5;
				}
				if (carteMano <= 9) {
					pos = 0;
				}
				FinestraCarteMano.getPanel().setLayout(new FlowLayout(FlowLayout.CENTER, pos, 35));
				if (carteMano >= 9) {
					var = FinestraCarteMano.getPanel().getComponents()[0].getX();
				}

				if (FinestraCarteMano.getPanel().getComponents().length == 0) {
					UtenteDAO utenteDAO = new UtenteDAO();
					utenteDAO.updateStatsWin(FinestraGioco.getUtenteLog().getId());
					FinestraGioco.btnNewButton.doClick();
					showSuccess();

				}

				FinestraCarteMano.getPanel().repaint();
				FinestraCarteMano.getPanel().validate();

			}

		});

		Dimension d = new Dimension();
		d.width = 74;
		d.height = 111;
		btnNewButton.setPreferredSize(d);

		// FinestraGioco.addFinCarteMano();
		int carteMano = FinestraCarteMano.getPanel().getComponents().length;
		// System.out.println(carteMano + " carte");

		if (carteMano >= 9 && var < 74) {
			pos -= 5;
		}

		FinestraCarteMano.getPanel().setLayout(new FlowLayout(FlowLayout.CENTER, pos, 35));
		// btnNewButton.setEnabled(false);
		// System.out.println(FinestraCarteMano.getPanel().getLayout().toString());
		FinestraCarteMano.getPanel().add(btnNewButton);

		FinestraCarteMano.getPanel().repaint();
		FinestraCarteMano.getPanel().validate();
		var = FinestraCarteMano.getPanel().getComponents()[0].getX();

	}

	public static void pescaCarta() {

		addCartaMano();
	}

	public static void addCartaBotSx() {

		JButton btnNewButton = new JButton();
		btnNewButton.setIcon(new ImageIcon("assets\\backSx.png"));
		btnNewButton.setDisabledIcon(new ImageIcon("assets\\backSx.png"));
		Carta carta = generaCarta();
		btnNewButton.setActionCommand(carta.getValore() + "_" + carta.getColore());

		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.out.println("dentro click bot sx cartaController");
				JButton cartaScar = FinestraGioco.getCartaScartata();
				String[] carta1 = cartaScar.getIcon().toString().split("[_.\\\\]");
				String[] carta2 = btnNewButton.getActionCommand().split("[_.\\\\]");

				if (cartaScar.getIcon().toString().equals("")) {
					contTur = 1;
					TurnoController turnoCtrl = new TurnoController();
					turnoCtrl.turnoBotSu();
					cartaScar.setIcon(new ImageIcon("assets\\" + btnNewButton.getActionCommand() + ".png"));
					FinestraBotSx.getPanel().remove(btnNewButton);
				}

				else if (carta1[1].equals(carta2[0]) || carta1[2].equals(carta2[1]) || carta2[0].equals("CambioColore")
						|| carta2[0].equals("PiuQuattro")) {
					// System.out.println("dentro bot");
					contTur = 1;
					Boolean camCol = false;
					String strIcon = btnNewButton.getActionCommand() + "";
					if (strIcon.contains("PiuDue")) {
						if (FinestraGioco.varCambioGiro == true) {
							contTurnSu = 1;
							CartaController.addCartaBotSu();
							CartaController.addCartaBotSu();
							TurnoController turnoCtrl = new TurnoController();
							turnoCtrl.turnoBotDx();
						} else {
							CartaController.addCartaMano();
							CartaController.addCartaMano();
							testCambioGiro = 1;
							TurnoController turnoCtrl = new TurnoController();
							turnoCtrl.turnoBotDxCambioGiro();
						}

					} else if (strIcon.contains("Blocca")) {
						if (FinestraGioco.varCambioGiro == true) {
							contTurnSu = 1;
							TurnoController turnoCtrl = new TurnoController();
							turnoCtrl.turnoBotDx();
						} else {
							testCambioGiro = 1;
							TurnoController turnoCtrl = new TurnoController();
							turnoCtrl.turnoBotDxCambioGiro();
						}
					}

					else if (strIcon.contains("CambioColore")) {
						// System.out.println("dentro bot else if");
						String[] coloriStringa = { "Blu", "Giallo", "Verde", "Rosso" };
						Color[] colori = { Color.blue, Color.yellow, Color.green, Color.red };
						Random rand = new Random();
						int randomNumCol = rand.nextInt(3);

						camCol = true;
						cartaScar
								.setIcon(new ImageIcon("assets\\CambioColore_" + coloriStringa[randomNumCol] + ".png"));
						cartaScar.setBorder(BorderFactory.createLineBorder(colori[randomNumCol], 4));
						if (FinestraGioco.varCambioGiro == true) {
							contTur = 1;
							TurnoController turnoCtrl = new TurnoController();
							turnoCtrl.turnoBotSu();
						} else {
							for (Component c : FinestraCarteMano.getPanel().getComponents()) {
								c.setEnabled(true);
							}
							FinestraGioco.btnNewButton_1_1.setEnabled(true);
							FinestraCarteMano.getPanel().repaint();
							FinestraCarteMano.getPanel().validate();
						}
					} else if (strIcon.contains("PiuQuattro")) {
						if (FinestraGioco.varCambioGiro == true) {
							CartaController.addCartaBotSu();
							CartaController.addCartaBotSu();
							CartaController.addCartaBotSu();
							CartaController.addCartaBotSu();
						} else {
							CartaController.addCartaMano();
							CartaController.addCartaMano();
							CartaController.addCartaMano();
							CartaController.addCartaMano();
						}
						// System.out.println("dentro bot else if");
						String[] coloriStringa = { "Blu", "Giallo", "Verde", "Rosso" };
						Color[] colori = { Color.blue, Color.yellow, Color.green, Color.red };
						Random rand = new Random();
						int randomNumCol = rand.nextInt(3);

						camCol = true;
						// FinestraGioco.panelScegliColore.setVisible(true);
						cartaScar.setIcon(new ImageIcon("assets\\PiuQuattro_" + coloriStringa[randomNumCol] + ".png"));
						cartaScar.setBorder(BorderFactory.createLineBorder(colori[randomNumCol], 4));
						// System.out.println(cartaScar.getIcon());
						if (FinestraGioco.varCambioGiro == true) {
							contTurnSu = 1;
							TurnoController turnoCtrl = new TurnoController();
							turnoCtrl.turnoBotDx();
						} else {
							testCambioGiro = 1;
							TurnoController turnoCtrl = new TurnoController();
							turnoCtrl.turnoBotDxCambioGiro();
						}
					} else if (strIcon.contains("CambioGiro")) {
						if (FinestraGioco.varCambioGiro == true) {

							FinestraGioco.varCambioGiro = false;
							for (Component c : FinestraCarteMano.getPanel().getComponents()) {
								c.setEnabled(true);
							}
							FinestraGioco.btnNewButton_1_1.setEnabled(true);
							FinestraCarteMano.getPanel().repaint();
							FinestraCarteMano.getPanel().validate();
						} else {

							FinestraGioco.varCambioGiro = true;
							contTur = 1;
							TurnoController turnoCtrl = new TurnoController();
							turnoCtrl.turnoBotSu();

						}
					} else {
						if (FinestraGioco.varCambioGiro == true) {
							contTur = 1;
							TurnoController turnoCtrl = new TurnoController();
							turnoCtrl.turnoBotSu();
						} else {
							for (Component c : FinestraCarteMano.getPanel().getComponents()) {
								c.setEnabled(true);
							}
							FinestraGioco.btnNewButton_1_1.setEnabled(true);
							FinestraCarteMano.getPanel().repaint();
							FinestraCarteMano.getPanel().validate();
						}

					}
					if (camCol == false) {
						cartaScar.setIcon(new ImageIcon("assets\\" + btnNewButton.getActionCommand() + ".png"));
						cartaScar
								.setBorder(BorderFactory.createLineBorder(CartaController.coloreCornice(carta2[1]), 4));
					}
					mazzoCarteScartate.getMazzo().add(carta);
					FinestraBotSx.getPanel().remove(btnNewButton);

				}

				int carteMano = FinestraBotSx.getPanel().getComponents().length;

				if (carteMano >= 7 && var1 > 90 && pos1 < 0) {
					pos1 += 9;
				}
				if (carteMano <= 7) {
					pos1 = 0;
				}
				FinestraBotSx.getPanel()
						.setLayout(new ButtonLayout(ButtonLayout.Alignment.VERTICAL, ButtonLayout.Anchor.CENTER, pos1));
				if (carteMano >= 7) {
					var1 = FinestraBotSx.getPanel().getComponents()[0].getY();
				}

				if (FinestraBotSx.getPanel().getComponents().length == 0) {
					// CartaController.ranInt = 96;
					UtenteDAO utenteDAO = new UtenteDAO();
					utenteDAO.updateStatsLose(FinestraGioco.getUtenteLog().getId());
					FinestraGioco.btnNewButton.doClick();
					showError();
					// CartaController.ranInt = 96;

				}

				FinestraBotSx.getPanel().repaint();
				FinestraBotSx.getPanel().validate();

			}

		});

		Dimension d = new Dimension();
		d.width = 111;
		d.height = 74;
		btnNewButton.setPreferredSize(d);

		int carteMano = FinestraBotSx.getPanel().getComponents().length;

		if (var1 < 74) {
			pos1 -= 5;
		}

		if (carteMano > 7) {

			FinestraBotSx.getPanel()
					.setLayout(new ButtonLayout(ButtonLayout.Alignment.VERTICAL, ButtonLayout.Anchor.CENTER, pos1));
		}

		if (carteMano <= 7) {

			FinestraBotSx.getPanel()
					.setLayout(new ButtonLayout(ButtonLayout.Alignment.VERTICAL, ButtonLayout.Anchor.CENTER, 0));

		}

		btnNewButton.setEnabled(false);

		FinestraBotSx.getPanel().add(btnNewButton);

		// btnNewButton.setEnabled(false);

		FinestraBotSx.getPanel().repaint();
		FinestraBotSx.getPanel().validate();

		var1 = FinestraBotSx.getPanel().getComponents()[0].getY();

	}

	public static void addCartaBotSu() {

		JButton btnNewButton = new JButton();
		btnNewButton.setIcon(new ImageIcon("assets\\backSu.png"));
		btnNewButton.setDisabledIcon(new ImageIcon("assets\\backSu.png"));
		Carta carta = generaCarta();
		btnNewButton.setActionCommand(carta.getValore() + "_" + carta.getColore());
		// System.out.println(btnNewButton.getActionCommand());

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("dentro click bot SU cartaController");
				JButton cartaScar = FinestraGioco.getCartaScartata();

				if (cartaScar.getIcon().toString().equals("")) {
					contTurnSu = 1;
					TurnoController turnoCtrl = new TurnoController();
					turnoCtrl.turnoBotDx();
					cartaScar.setIcon(new ImageIcon("assets\\" + btnNewButton.getActionCommand() + ".png"));
					FinestraBotSu.getPanel().remove(btnNewButton);
				}

				String[] carta1 = cartaScar.getIcon().toString().split("[_.\\\\]");
				String[] carta2 = btnNewButton.getActionCommand().split("[_.\\\\]");

				if (carta1[1].equals(carta2[0]) || carta1[2].equals(carta2[1]) || carta2[0].equals("CambioColore")
						|| carta2[0].equals("PiuQuattro")) {
					// contTurnSu = 1;
					Boolean camCol = false;
					String strIcon = btnNewButton.getActionCommand() + "";
					if (strIcon.contains("PiuDue")) {
						if (FinestraGioco.varCambioGiro == true) {
							CartaController.addCartaBotDx();
							CartaController.addCartaBotDx();
							for (Component c : FinestraCarteMano.getPanel().getComponents()) {
								c.setEnabled(true);
							}
							FinestraGioco.btnNewButton_1_1.setEnabled(true);
							FinestraCarteMano.getPanel().repaint();
							FinestraCarteMano.getPanel().validate();
						} else {
							CartaController.addCartaBotSx();
							CartaController.addCartaBotSx();
							for (Component c : FinestraCarteMano.getPanel().getComponents()) {
								c.setEnabled(true);
							}
							FinestraGioco.btnNewButton_1_1.setEnabled(true);
							FinestraCarteMano.getPanel().repaint();
							FinestraCarteMano.getPanel().validate();
						}

					} else if (strIcon.contains("Blocca")) {
						for (Component c : FinestraCarteMano.getPanel().getComponents()) {
							c.setEnabled(true);
						}
						FinestraGioco.btnNewButton_1_1.setEnabled(true);
						FinestraCarteMano.getPanel().repaint();
						FinestraCarteMano.getPanel().validate();
					} else if (strIcon.contains("CambioColore")) {
						// System.out.println("dentro bot else if");
						String[] coloriStringa = { "Blu", "Giallo", "Verde", "Rosso" };
						Color[] colori = { Color.blue, Color.yellow, Color.green, Color.red };
						Random rand = new Random();
						int randomNumCol = rand.nextInt(3);

						camCol = true;
						// FinestraGioco.panelScegliColore.setVisible(true);
						cartaScar
								.setIcon(new ImageIcon("assets\\CambioColore_" + coloriStringa[randomNumCol] + ".png"));
						cartaScar.setBorder(BorderFactory.createLineBorder(colori[randomNumCol], 4));
						// System.out.println(cartaScar.getIcon());
						if (FinestraGioco.varCambioGiro == true) {
							contTurnSu = 1;
							TurnoController turnoCtrl = new TurnoController();
							turnoCtrl.turnoBotDx();
						} else {
							contTurnSuCambioGiro = 1;
							TurnoController turnoCtrl = new TurnoController();
							turnoCtrl.turnoBotSxCambioGiro();
						}
					} else if (strIcon.contains("PiuQuattro")) {
						if (FinestraGioco.varCambioGiro == true) {
							CartaController.addCartaBotDx();
							CartaController.addCartaBotDx();
							CartaController.addCartaBotDx();
							CartaController.addCartaBotDx();
						} else {
							CartaController.addCartaBotSx();
							CartaController.addCartaBotSx();
							CartaController.addCartaBotSx();
							CartaController.addCartaBotSx();
						}
						// System.out.println("dentro bot else if");
						String[] coloriStringa = { "Blu", "Giallo", "Verde", "Rosso" };
						Color[] colori = { Color.blue, Color.yellow, Color.green, Color.red };
						Random rand = new Random();
						int randomNumCol = rand.nextInt(3);

						camCol = true;
						// FinestraGioco.panelScegliColore.setVisible(true);
						cartaScar.setIcon(new ImageIcon("assets\\PiuQuattro_" + coloriStringa[randomNumCol] + ".png"));
						cartaScar.setBorder(BorderFactory.createLineBorder(colori[randomNumCol], 4));
						// System.out.println(cartaScar.getIcon());
						for (Component c : FinestraCarteMano.getPanel().getComponents()) {
							c.setEnabled(true);
						}
						FinestraGioco.btnNewButton_1_1.setEnabled(true);
						FinestraCarteMano.getPanel().repaint();
						FinestraCarteMano.getPanel().validate();
					} else if (strIcon.contains("CambioGiro")) {
						if (FinestraGioco.varCambioGiro == true) {

							FinestraGioco.varCambioGiro = false;
							contTurnSuCambioGiro = 1;
							TurnoController turnoCtrl = new TurnoController();
							turnoCtrl.turnoBotSxCambioGiro();
						} else {

							FinestraGioco.varCambioGiro = true;
							contTurnSu = 1;
							TurnoController turnoCtrl = new TurnoController();
							turnoCtrl.turnoBotDx();

						}
					} else {
						if (FinestraGioco.varCambioGiro == true) {
							contTurnSu = 1;
							TurnoController turnoCtrl = new TurnoController();
							turnoCtrl.turnoBotDx();
						} else {
							contTurnSuCambioGiro = 1;
							TurnoController turnoCtrl = new TurnoController();
							turnoCtrl.turnoBotSxCambioGiro();
						}
					}
					if (camCol == false) {

						cartaScar.setIcon(new ImageIcon("assets\\" + btnNewButton.getActionCommand() + ".png"));
						cartaScar
								.setBorder(BorderFactory.createLineBorder(CartaController.coloreCornice(carta2[1]), 4));
					}
					mazzoCarteScartate.getMazzo().add(carta);
					FinestraBotSu.getPanel().remove(btnNewButton);

				}

				int carteMano = FinestraBotSu.getPanel().getComponents().length;

				if (carteMano >= 9 && var2 > 90 && pos2 < 0) {
					pos2 += 5;
				}
				if (carteMano <= 9) {
					pos2 = 0;
				}
				FinestraBotSu.getPanel().setLayout(
						new ButtonLayout(ButtonLayout.Alignment.HORIZONTAL, ButtonLayout.Anchor.CENTER, pos2));
				if (carteMano >= 9) {
					var2 = FinestraBotSu.getPanel().getComponents()[0].getX();
				}
				if (FinestraBotSu.getPanel().getComponents().length == 0) {
					// CartaController.ranInt = 96;
					UtenteDAO utenteDAO = new UtenteDAO();
					utenteDAO.updateStatsLose(FinestraGioco.getUtenteLog().getId());
					FinestraGioco.btnNewButton.doClick();
					showError();

				}

				FinestraBotSu.getPanel().repaint();
				FinestraBotSu.getPanel().validate();

			}

		});

		Dimension d = new Dimension();
		d.width = 74;
		d.height = 111;
		btnNewButton.setPreferredSize(d);

		int carteMano = FinestraBotSu.getPanel().getComponents().length;

		if (var2 < 74) {
			pos2 -= 5;
		}

		if (carteMano > 7) {

			FinestraBotSu.getPanel()
					.setLayout(new ButtonLayout(ButtonLayout.Alignment.HORIZONTAL, ButtonLayout.Anchor.CENTER, pos2));
		}

		if (carteMano <= 7) {

			FinestraBotSu.getPanel()
					.setLayout(new ButtonLayout(ButtonLayout.Alignment.HORIZONTAL, ButtonLayout.Anchor.CENTER, 0));

		}

		btnNewButton.setEnabled(false);

		FinestraBotSu.getPanel().add(btnNewButton);
		FinestraBotSu.getPanel().repaint();
		FinestraBotSu.getPanel().validate();

		var2 = FinestraBotSu.getPanel().getComponents()[0].getX();
	}

	public static void addCartaBotDx() {

		JButton btnNewButton = new JButton();
		btnNewButton.setIcon(new ImageIcon("assets\\backDx.png"));
		btnNewButton.setDisabledIcon(new ImageIcon("assets\\backDx.png"));
		Carta carta = generaCarta();
		btnNewButton.setActionCommand(carta.getValore() + "_" + carta.getColore());
		// System.out.println(btnNewButton.getActionCommand());

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("dentro click bot dx cartaController");
				JButton cartaScar = FinestraGioco.getCartaScartata();

				if (cartaScar.getIcon().toString().equals("")) {

					cartaScar.setIcon(new ImageIcon("assets\\" + btnNewButton.getActionCommand() + ".png"));
					FinestraBotDx.getPanel().remove(btnNewButton);

				}

				String[] carta1 = cartaScar.getIcon().toString().split("[_.\\\\]");
				String[] carta2 = btnNewButton.getActionCommand().split("[_.\\\\]");

				if (carta1[1].equals(carta2[0]) || carta1[2].equals(carta2[1]) || carta2[0].equals("CambioColore")
						|| carta2[0].equals("PiuQuattro")) {

					Boolean camCol = false;
					String strIcon = btnNewButton.getActionCommand() + "";

					if (strIcon.contains("PiuDue")) {
						if (FinestraGioco.varCambioGiro == true) {
							test = 1;
							TurnoController turnoCtrl = new TurnoController();
							turnoCtrl.turnoBotSx();
							CartaController.addCartaMano();
							CartaController.addCartaMano();
							FinestraGioco.btnNewButton_1_1.setEnabled(false);
							for (Component c : FinestraCarteMano.getPanel().getComponents()) {
								c.setEnabled(false);
							}
						} else {
							CartaController.addCartaBotSu();
							CartaController.addCartaBotSu();
							contTurnSuCambioGiro = 1;
							TurnoController turnoCtrl = new TurnoController();
							turnoCtrl.turnoBotSxCambioGiro();

						}

					} else if (strIcon.contains("Blocca")) {
						if (FinestraGioco.varCambioGiro == true) {
							test = 1;
							TurnoController turnoCtrl = new TurnoController();
							turnoCtrl.turnoBotSx();
							FinestraGioco.btnNewButton_1_1.setEnabled(false);
							for (Component c : FinestraCarteMano.getPanel().getComponents()) {
								c.setEnabled(false);
							}
						} else {
							contTurnSuCambioGiro = 1;
							TurnoController turnoCtrl = new TurnoController();
							turnoCtrl.turnoBotSxCambioGiro();

						}

					} else if (strIcon.contains("CambioColore")) {
						// System.out.println("dentro bot else if");
						String[] coloriStringa = { "Blu", "Giallo", "Verde", "Rosso" };
						Color[] colori = { Color.blue, Color.yellow, Color.green, Color.red };
						Random rand = new Random();
						int randomNumCol = rand.nextInt(3);

						camCol = true;
						// FinestraGioco.panelScegliColore.setVisible(true);
						cartaScar
								.setIcon(new ImageIcon("assets\\CambioColore_" + coloriStringa[randomNumCol] + ".png"));
						cartaScar.setBorder(BorderFactory.createLineBorder(colori[randomNumCol], 4));
						// System.out.println(cartaScar.getIcon());
						if (FinestraGioco.varCambioGiro == true) {
							FinestraGioco.btnNewButton_1_1.setEnabled(true);
							FinestraCarteMano.getPanel().repaint();
							FinestraCarteMano.getPanel().validate();
							for (Component c : FinestraCarteMano.getPanel().getComponents()) {
								c.setEnabled(true);
							}
						} else {
							contTurCambioGiro = 1;
							TurnoController turnoCtrl = new TurnoController();
							turnoCtrl.turnoBotSuCambioGiro();
						}
					} else if (strIcon.contains("PiuQuattro")) {
						if (FinestraGioco.varCambioGiro == true) {
							CartaController.addCartaMano();
							CartaController.addCartaMano();
							CartaController.addCartaMano();
							CartaController.addCartaMano();
						} else {
							CartaController.addCartaBotSu();
							CartaController.addCartaBotSu();
							CartaController.addCartaBotSu();
							CartaController.addCartaBotSu();
						}
						// System.out.println("dentro bot else if");
						String[] coloriStringa = { "Blu", "Giallo", "Verde", "Rosso" };
						Color[] colori = { Color.blue, Color.yellow, Color.green, Color.red };
						Random rand = new Random();
						int randomNumCol = rand.nextInt(3);

						camCol = true;
						// FinestraGioco.panelScegliColore.setVisible(true);
						cartaScar.setIcon(new ImageIcon("assets\\PiuQuattro_" + coloriStringa[randomNumCol] + ".png"));
						cartaScar.setBorder(BorderFactory.createLineBorder(colori[randomNumCol], 4));
						// System.out.println(cartaScar.getIcon());
						if (FinestraGioco.varCambioGiro == true) {
							test = 1;
							TurnoController turnoCtrl = new TurnoController();
							turnoCtrl.turnoBotSx();
							FinestraGioco.btnNewButton_1_1.setEnabled(false);
							for (Component c : FinestraCarteMano.getPanel().getComponents()) {
								c.setEnabled(false);
							}
						} else {
							contTurnSuCambioGiro = 1;
							TurnoController turnoCtrl = new TurnoController();
							turnoCtrl.turnoBotSxCambioGiro();
						}
					} else if (strIcon.contains("CambioGiro")) {
						if (FinestraGioco.varCambioGiro == true) {

							FinestraGioco.varCambioGiro = false;
							contTurCambioGiro = 1;
							TurnoController turnoCtrl = new TurnoController();
							turnoCtrl.turnoBotSuCambioGiro();
						} else {

							FinestraGioco.varCambioGiro = true;
							FinestraGioco.btnNewButton_1_1.setEnabled(true);
							FinestraCarteMano.getPanel().repaint();
							FinestraCarteMano.getPanel().validate();
							for (Component c : FinestraCarteMano.getPanel().getComponents()) {
								c.setEnabled(true);
							}

						}
					} else {
						if (FinestraGioco.varCambioGiro == true) {
							// System.out.println("dentro carta controller bot dx else");
							FinestraGioco.btnNewButton_1_1.setEnabled(true);
							FinestraCarteMano.getPanel().repaint();
							FinestraCarteMano.getPanel().validate();
							for (Component c : FinestraCarteMano.getPanel().getComponents()) {
								c.setEnabled(true);
							}
						} else {
							contTurCambioGiro = 1;
							TurnoController turnoCtrl = new TurnoController();
							turnoCtrl.turnoBotSuCambioGiro();
						}
					}
					if (camCol == false) {
						cartaScar.setIcon(new ImageIcon("assets\\" + btnNewButton.getActionCommand() + ".png"));
						cartaScar
								.setBorder(BorderFactory.createLineBorder(CartaController.coloreCornice(carta2[1]), 4));
					}
					mazzoCarteScartate.getMazzo().add(carta);
					FinestraBotDx.getPanel().remove(btnNewButton);

				}

				int carteMano = FinestraBotDx.getPanel().getComponents().length;

				if (carteMano >= 7 && var3 > 90 && pos3 < 0) {
					pos3 += 9;
				}
				if (carteMano <= 7) {
					pos3 = 0;
				}
				FinestraBotDx.getPanel()
						.setLayout(new ButtonLayout(ButtonLayout.Alignment.VERTICAL, ButtonLayout.Anchor.CENTER, pos3));
				if (carteMano >= 7) {
					var3 = FinestraBotDx.getPanel().getComponents()[0].getY();
				}
				// per uscire dalla window del gioco
				if (FinestraBotDx.getPanel().getComponents().length == 0) {
					// CartaController.ranInt = 96;
					UtenteDAO utenteDAO = new UtenteDAO();
					utenteDAO.updateStatsLose(FinestraGioco.getUtenteLog().getId());
					FinestraGioco.btnNewButton.doClick();
					showError();
					// CartaController.ranInt = 96;

				}

				FinestraBotDx.getPanel().repaint();
				FinestraBotDx.getPanel().validate();

			}

		});

		Dimension d = new Dimension();
		d.width = 111;
		d.height = 74;
		btnNewButton.setPreferredSize(d);

		int carteMano = FinestraBotDx.getPanel().getComponents().length;

		if (var3 < 74) {
			pos3 -= 5;
		}

		if (carteMano > 7) {

			FinestraBotDx.getPanel()
					.setLayout(new ButtonLayout(ButtonLayout.Alignment.VERTICAL, ButtonLayout.Anchor.CENTER, pos3));
		}

		if (carteMano <= 7) {

			FinestraBotDx.getPanel()
					.setLayout(new ButtonLayout(ButtonLayout.Alignment.VERTICAL, ButtonLayout.Anchor.CENTER, 0));

		}

		btnNewButton.setEnabled(false);

		FinestraBotDx.getPanel().add(btnNewButton);
		FinestraBotDx.getPanel().repaint();
		FinestraBotDx.getPanel().validate();

		var3 = FinestraBotDx.getPanel().getComponents()[0].getY();
	}

}
