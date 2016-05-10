/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import edu.soict.hust.k57.mmdb.view.ResultView;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

/**
 *
 * @author thinhnt
 */
public class ResultViewTest {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(1000, 600);
        f.setContentPane(new JScrollPane(new ResultView()));
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
