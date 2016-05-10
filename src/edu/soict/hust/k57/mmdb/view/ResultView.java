/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.soict.hust.k57.mmdb.view;

import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

/**
 *
 * @author thinhnt
 */
public class ResultView extends AbstractView {
    
    private ResultImagePanel[][] panels;
    
    public ResultView() {
        initComponents();
//        setBorder(BorderFactory.createTitledBorder("Kết quả"));
    }
    
    public void initComponents(){
        panels = new ResultImagePanel[20][5];
        setLayout(new GridLayout(0, 5, 5, 5));
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 5; j++) {
                panels[i][j] = new ResultImagePanel();
                panels[i][j].setImage(new ImageIcon(""));
                add(panels[i][j]);
            }
        }
        panels[0][0].setImageName("ImgName");
        panels[0][0].setDistance(0.02);
        panels[0][0].setImage(new ImageIcon("data/6.jpg"));
    }

    @Override
    public void updateView(PropertyChangeEvent evt) {
        
    }

}
