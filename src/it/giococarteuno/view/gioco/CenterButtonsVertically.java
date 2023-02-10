package it.giococarteuno.view.gioco;

import java.awt.*;
import javax.swing.*;

public class CenterButtonsVertically {
   private static void createAndShowGUI() {
      JFrame frame = new JFrame("Center Buttons Vertically");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      Container contentPane = frame.getContentPane();
      contentPane.setLayout(new GridBagLayout());

      JButton button1 = new JButton("Button 1");
      JButton button2 = new JButton("Button 2");
      JButton button3 = new JButton("Button 3");
      JButton button4 = new JButton("Button 4");
      JButton button5 = new JButton("Button 5");
      JButton button6 = new JButton("Button 6");

      GridBagConstraints constraints = new GridBagConstraints();
      constraints.gridx = 0;
      constraints.gridy = 0;
      constraints.gridwidth = 2; // questo aumenta la larghezza dei bottoni
      constraints.insets = new Insets(5, 5, 5, 5);
      constraints.fill = GridBagConstraints.HORIZONTAL;
      contentPane.add(button1, constraints);

      constraints.gridx = 2; // questo sposta il bottone 2 alla colonna successiva
      constraints.gridwidth = 1; // questo imposta la larghezza del bottone 2 a quella predefinita
      constraints.gridy = 0;
      contentPane.add(button2, constraints);

      constraints.gridx = 0;
      constraints.gridy = 1;
      contentPane.add(button3, constraints);

      constraints.gridx = 0;
      constraints.gridy = 2;
      contentPane.add(button4, constraints);

      constraints.gridx = 0;
      constraints.gridy = 3;
      contentPane.add(button5, constraints);

      constraints.gridx = 0;
      constraints.gridy = 4;
      contentPane.add(button6, constraints);


      frame.pack();
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      javax.swing.SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGUI();
         }
      });
   }
}
