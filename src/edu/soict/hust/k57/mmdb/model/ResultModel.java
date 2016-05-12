/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.soict.hust.k57.mmdb.model;

import edu.soict.hust.k57.mmdb.components.Context;
import edu.soict.hust.k57.mmdb.components.HistogramImageBulder;
import edu.soict.hust.k57.mmdb.entities.ImgEnt;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.ImageIcon;

/**
 *
 * @author thinhnt
 */
public class ResultModel extends AbstractModel implements IResultModel, PropertyChangeListener {

    public final static String RESULT_PROPERTY_NAME = "resultmodel.imgEntResult";
    public final static String SELECTED_IMAGE_PROPERTY_NAME = "resultmodel.selectedImage";
    public static final String CHANEL_PROPERTY_NAME = "resultmodel.chanel";
    private final static int COL = 5;
    private ImgEnt[] imgEntResult;
    private HistogramImageBulder buiBulder;
    private int oldselectedIndex;
    private int selectedIndex = 0;

    public ResultModel() {
        buiBulder = new HistogramImageBulder();
    }

    public void changeSelectedChanel() {
        support.firePropertyChange(CHANEL_PROPERTY_NAME, null, this);
    }

    @Override
    public double getDistance(int i, int j) {
        return imgEntResult[COL * i + j].getDistance();
    }

    @Override
    public String getImgName(int i, int j) {
        return imgEntResult[COL * i + j].getF().getName();
    }

    @Override
    public ImageIcon getImageIcon(int i, int j) {
        return new ImageIcon(imgEntResult[COL * i + j].getF().getPath());
    }

    @Override
    public ImageIcon getRHistogramImageIcon() {
        return buiBulder.getImageIcon(HistogramImageBulder.Channel.R);
    }

    @Override
    public ImageIcon getGHistogramImageIcon() {
        return buiBulder.getImageIcon(HistogramImageBulder.Channel.G);
    }

    @Override
    public ImageIcon getBHistogramImageIcon() {
        return buiBulder.getImageIcon(HistogramImageBulder.Channel.B);
    }

    @Override
    public int getOldSelectedIndex() {
        return oldselectedIndex;
    }

    @Override
    public int getNewSelectedIndex() {
        return selectedIndex;
    }
    
     @Override
    public void setSelectedIndex(int i) {
        oldselectedIndex = selectedIndex;
        selectedIndex = i;
        buiBulder.createHistogramImages(imgEntResult[selectedIndex]);
        support.firePropertyChange(SELECTED_IMAGE_PROPERTY_NAME, null, this);
    }

    @Override
    public String getSelectedImageName() {
        return imgEntResult[selectedIndex].getF().getName();
    }

    @Override
    public ImageIcon getSelectedImageIcon() {
        return new ImageIcon(imgEntResult[selectedIndex].getF().getPath());
    }

    @Override
    public void setSelectedImage(int i, int j) {
        oldselectedIndex = selectedIndex;
        selectedIndex = COL * i + j;
        buiBulder.createHistogramImages(imgEntResult[selectedIndex]);
        support.firePropertyChange(SELECTED_IMAGE_PROPERTY_NAME, null, this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(Context.RESULT_PROPERTY_NAME)) {
            imgEntResult = (ImgEnt[]) evt.getNewValue();
            support.firePropertyChange(RESULT_PROPERTY_NAME, null, this);
        }
    }
}
