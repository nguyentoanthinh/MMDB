/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import edu.soict.hust.k57.mmdb.view.ImagePanel;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author thinhnt
 */
public class ImagePanelTest {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(800, 600);
        f.getContentPane().setLayout(new GridLayout(0, 5,5,5));
        
        ImagePanel panel = new ImagePanel();
        panel.setBackground(Color.GRAY);
        panel.setImageName("6.jpg");
        panel.setImage(new ImageIcon(" "));
        f.getContentPane().add(panel);
        
        panel = new ImagePanel();
//        panel.setBackground(Color.GRAY);
        panel.setImageName("6.jpg");
        panel.setImage(new ImageIcon(" "));
        f.getContentPane().add(panel);
        
        panel = new ImagePanel();
//        panel.setBackground(Color.GRAY);
        panel.setImageName("6.jpg");
        panel.setImage(new ImageIcon("data/8.jpg"));
        f.getContentPane().add(panel);
        panel = new ImagePanel();
//        panel.setBackground(Color.GRAY);
        panel.setImageName("6.jpg");
        panel.setImage(new ImageIcon("data/9.jpg"));
        f.getContentPane().add(panel);
        panel = new ImagePanel();
//        panel.setBackground(Color.GRAY);
        panel.setImageName("6.jpg");
        panel.setImage(new ImageIcon("data/10.jpg"));
        f.getContentPane().add(panel);
        panel = new ImagePanel();
//        panel.setBackground(Color.GRAY);
        panel.setImageName("6.jpg");
        panel.setImage(new ImageIcon(".."));
        f.getContentPane().add(panel);
        
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
