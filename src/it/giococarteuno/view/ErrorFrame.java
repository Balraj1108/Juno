package it.giococarteuno.view;
import java.awt.FlowLayout;

import javax.swing.*;

public class ErrorFrame extends JFrame {

    private JButton errorButton;

    public ErrorFrame() {
        setTitle("Error Frame");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        errorButton = new JButton("Mostra errore");
        errorButton.addActionListener(e -> showError());
        add(errorButton);
    }

    private void showError() {
        JOptionPane.showMessageDialog(this, "Errore: il file non esiste.", "Errore", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        ErrorFrame frame = new ErrorFrame();
        frame.setVisible(true);
    }
}
