/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.soict.hust.k57.mmdb.view;

import edu.soict.hust.k57.mmdb.components.HistogramImageBulder;
import edu.soict.hust.k57.mmdb.entities.ImgEnt;
import java.beans.PropertyChangeEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author thinhnt
 */
public class HistogramView extends AbstractView {

    private HistogramImageBulder queryHistogramImageBulder;

    /**
     * Creates new form HistogramView
     */
    public HistogramView() {
        initComponents();
        queryHistogramImageBulder = new HistogramImageBulder();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        queryHistogram = new edu.soict.hust.k57.mmdb.view.HistogramPanel();
        selectedHistogram = new edu.soict.hust.k57.mmdb.view.HistogramPanel();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Histograms"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(queryHistogram, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(selectedHistogram, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(queryHistogram, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(selectedHistogram, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(149, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private edu.soict.hust.k57.mmdb.view.HistogramPanel queryHistogram;
    private edu.soict.hust.k57.mmdb.view.HistogramPanel selectedHistogram;
    // End of variables declaration//GEN-END:variables

    @Override
    public void updateView(PropertyChangeEvent evt) {
        System.out.println("Update.Histogram.View");

        // Update for query input change
        ImgEnt queryImgEnt = (ImgEnt) evt.getNewValue();
        queryHistogramImageBulder.createHistogramImages(queryImgEnt);
        ImageIcon imageIcon = null;
        if (queryHistogram.getChanelCombobox().getSelectedItem().equals("B")) {
            imageIcon = queryHistogramImageBulder.getImageIcon(HistogramImageBulder.Channel.B);
        } else if (queryHistogram.getChanelCombobox().getSelectedItem().equals("G")) {
            imageIcon = queryHistogramImageBulder.getImageIcon(HistogramImageBulder.Channel.G);
        } else {
            imageIcon = queryHistogramImageBulder.getImageIcon(HistogramImageBulder.Channel.R);
        }
        queryHistogram.setImage(imageIcon);
    }
}