package it.giococarteuno.view.gioco;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

final class createProfilePage extends JFrame implements ActionListener {

    Container container = getContentPane();

   
    JLabel picLabel = new JLabel();

    
    JButton uploadPic = new JButton("Upload Profile Picture");

    createProfilePage() {
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        //setting container
        setLayoutManager();
        setLocationAndSize();
        addComponents();
        addActionEvent();

        setTitle("Welcome");
        setSize(600, 500);
    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        //Setting location and Size of each components using setBounds() method.
       

       
        uploadPic.setBounds(350, 380, 150, 30);

        
        picLabel.setBounds(350, 50, 150, 150);
        picLabel.setBorder(BorderFactory.createLineBorder((Color.blue),4));
    }

    public void addComponents() {
        container.add(picLabel);
        
        container.add(uploadPic);
    }

    public void addActionEvent() {
//        submit.addActionListener(this);
//        deleteProfile.addActionListener(this);
        uploadPic.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == uploadPic) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            int result = fileChooser.showOpenDialog(getParent());
            if (result == JFileChooser.APPROVE_OPTION) {
                try {
                    File file = fileChooser.getSelectedFile();
                    BufferedImage picture = ImageIO.read(file);
                  //  BufferedImage picture1 = ImageIO.read(file);
                    Image dimg = picture.getScaledInstance(picLabel.getWidth(), picLabel.getHeight(),
                            Image.SCALE_SMOOTH);
                    
                   // ImageIcon imageIcon = new ImageIcon(dimg);

                    picLabel.setIcon(new ImageIcon(dimg));
                    add(picLabel);
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                    JOptionPane.showMessageDialog(null, "ERROR");
                }
            }
        }
    }

    public static void main(String[] args) {
        Runnable r = () -> {
            new createProfilePage().setVisible(true);
        };
        SwingUtilities.invokeLater(r);
    }
}
