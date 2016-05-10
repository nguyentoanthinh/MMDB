/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.soict.hust.k57.mmdb.view;

import edu.soict.hust.k57.mmdb.controller.AbstractController;
import java.beans.PropertyChangeEvent;
import javax.swing.JPanel;

/**
 *
 * @author thinhnt
 */
public abstract class AbstractView extends JPanel{
    protected AbstractController controller;
    
    public abstract void updateView(PropertyChangeEvent evt);
    
    public void setController(AbstractController controller){
        this.controller = controller;
    }
}
