/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.soict.hust.k57.mmdb.view;

import edu.soict.hust.k57.mmdb.components.Context;
import edu.soict.hust.k57.mmdb.controller.AbstractController;
import edu.soict.hust.k57.mmdb.controller.QueryController;
import edu.soict.hust.k57.mmdb.entities.ImgEnt;
import edu.soict.hust.k57.mmdb.exeptions.InvalidInputExeption;
import edu.soict.hust.k57.mmdb.model.QueryModel;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author thinhnt
 */
public class QueryView extends AbstractView implements PropertyChangeListener{

    public final static String EUCLID_DISTANCE = "Euclid";
    public final static String C_DISTANCE = "Cosin Distance";

    /**
     * Creates new form QueryView
     */
    public QueryView() {
        initComponents();
        Context.sharedInstance().addPropertyChangeListener(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        chooseFileButton = new javax.swing.JButton();
        numOfBinCbb = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        distanceCbb = new javax.swing.JComboBox();
        imagePanel = new edu.soict.hust.k57.mmdb.view.ImagePanel();
        searchButton = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Truy vấn"));

        jLabel1.setText("Tệp tin truy vấn:");

        jLabel2.setText("Số Bin:");

        chooseFileButton.setText("...");
        chooseFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseFileButtonActionPerformed(evt);
            }
        });

        numOfBinCbb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "256", "128", "64", "32", "16" }));
        numOfBinCbb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numOfBinCbbActionPerformed(evt);
            }
        });

        jLabel3.setText("Hàm khoản cách:");

        distanceCbb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { EUCLID_DISTANCE, C_DISTANCE }));
        distanceCbb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                distanceCbbActionPerformed(evt);
            }
        });

        searchButton.setText("Tìm kiếm");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(numOfBinCbb, 0, 122, Short.MAX_VALUE)
                                    .addComponent(chooseFileButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(distanceCbb, 0, 122, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(imagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(chooseFileButton))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(numOfBinCbb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(distanceCbb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(imagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {chooseFileButton, distanceCbb, jLabel1, jLabel2, jLabel3, numOfBinCbb});

    }// </editor-fold>//GEN-END:initComponents

    private void chooseFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseFileButtonActionPerformed
        JFileChooser chooser = new JFileChooser(new File(System.getProperty("user.dir")));
        int value = chooser.showOpenDialog(this);
        if (value == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            for (AbstractController controller : controllers) {
                if (controller instanceof QueryController) {
                    ((QueryController) controller).changeInputFile(selectedFile);
                }
            }
        }
    }//GEN-LAST:event_chooseFileButtonActionPerformed

    private void numOfBinCbbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numOfBinCbbActionPerformed
        for (AbstractController controller : controllers) {
            if (controller instanceof QueryController) {
                ((QueryController) controller).changeBin(
                        Integer.parseInt(numOfBinCbb.getSelectedItem().toString()));
            }
        }
    }//GEN-LAST:event_numOfBinCbbActionPerformed

    private void distanceCbbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_distanceCbbActionPerformed
        for (AbstractController controller : controllers) {
            if (controller instanceof QueryController) {
                ((QueryController) controller).changeDistanceType(distanceCbb.getSelectedItem().toString());
            }
        }
    }//GEN-LAST:event_distanceCbbActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        for (AbstractController controller : controllers) {
            if (controller instanceof QueryController) {
                searchButton.setEnabled(false);
                MMDBProgress.sharedInstace().start();
                try {
                    ((QueryController) controller).onClickSearchButton();
                } catch (InvalidInputExeption ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Lỗi",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_searchButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton chooseFileButton;
    private javax.swing.JComboBox distanceCbb;
    private edu.soict.hust.k57.mmdb.view.ImagePanel imagePanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JComboBox numOfBinCbb;
    private javax.swing.JButton searchButton;
    // End of variables declaration//GEN-END:variables

    @Override
    public void updateView(PropertyChangeEvent evt) {
//        System.out.println("Update.Query.View");
        if (evt.getPropertyName().equals(QueryModel.IMG_PROPERTY_NAME)) {
            ImgEnt queryImgEnt = (ImgEnt) evt.getNewValue();
            imagePanel.setImage(new ImageIcon(queryImgEnt.getF().getPath()));
            imagePanel.setImageName(queryImgEnt.getF().getName());
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        MMDBProgress.sharedInstace().stop();
        searchButton.setEnabled(true);
    }
}
