/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import edu.soict.hust.k57.mmdb.view.QueryView;
import javax.swing.JFrame;

/**
 *
 * @author thinhnt
 */
public class QueryViewTest {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setContentPane(new QueryView());
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
