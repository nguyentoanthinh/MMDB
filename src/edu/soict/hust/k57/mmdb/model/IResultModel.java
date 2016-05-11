/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.soict.hust.k57.mmdb.model;

import javax.swing.ImageIcon;

/**
 *
 * @author thinhnt
 */
public interface IResultModel {
    // Get distance of specified image
    double getDistance(int i, int j);
    
    // Get name of specified image
    String getImgName(int i, int j);
    
    // Get Icon of specified image
    ImageIcon getImageIcon(int i, int j);
    
    // Get Red Histogram Icon of selected image
    ImageIcon getRHistogramImageIcon();
    
    // Get Green Histogram Icon of selected image
    ImageIcon getGHistogramImageIcon();
    
    // Get Blue Histogram Icon of selected image
    ImageIcon getBHistogramImageIcon();
    
    
    //  Set specified image to selected image
    void setSelectedImage(int i, int j);
}
