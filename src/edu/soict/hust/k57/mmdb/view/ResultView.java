/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.soict.hust.k57.mmdb.view;

import edu.soict.hust.k57.mmdb.controller.AbstractController;
import edu.soict.hust.k57.mmdb.controller.ResultController;
import edu.soict.hust.k57.mmdb.model.IResultModel;
import edu.soict.hust.k57.mmdb.model.ResultModel;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author thinhnt
 */
public class ResultView extends AbstractView {

    private final static int ROW = 20;
    private final static int COL = 5;
    private ResultImagePanel[][] panels;

    public ResultView() {
        initComponents();
//        setBorder(BorderFactory.createTitledBorder("Kết quả"));
    }

    public void initComponents() {
        panels = new ResultImagePanel[ROW][COL];
        setLayout(new GridLayout(0, 5, 5, 5));
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 5; j++) {
                panels[i][j] = new ResultImagePanel();
                ResultImagePanel p = panels[i][j];
                p.setImage(new ImageIcon(""));
                add(p);
                int ii = i;
                int jj = j;
                p.addMouseListener(new MouseAdapter() {

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        if (!p.isEmpty()) {
                            p.enableSelectedEffect();
                        }
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        super.mouseExited(e); //To change body of generated methods, choose Tools | Templates.
                        if (!p.isEmpty() && !p.isSelected()) {
                            p.disableSelectedEffect();
                        }
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                        super.mousePressed(e); //To change body of generated methods, choose Tools | Templates.
                        if (!p.isEmpty()) {
                            for (AbstractController controller : controllers) {
                                if (controller instanceof ResultController) {
                                    ((ResultController) controller).onSelectedImage(ii, jj);
                                }
                            }
                        }
                    }

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                        int count = e.getClickCount();
                        if (count == 2 && !p.isEmpty()) {
                            for (AbstractController controller : controllers) {
                                if (controller instanceof ResultController) {
                                    ((ResultController) controller).onDoubleClickedImage(ii, jj);
                                }
                            }
                        }
                    }
                });
            }
        }
//        panels[0][0].setImageName("ImgName");
//        panels[0][0].setDistance(0.02);
//        panels[0][0].setImage(new ImageIcon("data/6.jpg"));
    }

    @Override
    public void updateView(PropertyChangeEvent evt) {
//        System.out.println("Update result View");
        IResultModel model = (IResultModel) evt.getNewValue();
        if (evt.getPropertyName().equals(ResultModel.RESULT_PROPERTY_NAME)) {
            for (int i = 0; i < ROW; i++) {
                for (int j = 0; j < COL; j++) {
                    panels[i][j].setImage(model.getImageIcon(i, j));
                    panels[i][j].setImageName(model.getImgName(i, j));
                    panels[i][j].setDistance(model.getDistance(i, j));
                }
            }
//            panels[0][0].enableSelectedEffect();
        } else if (evt.getPropertyName().equals(ResultModel.SELECTED_IMAGE_PROPERTY_NAME)) {
            int oldSelectedIndex = model.getOldSelectedIndex();
            int selectedIndex = model.getNewSelectedIndex();
            if (oldSelectedIndex != selectedIndex) {
                int i = oldSelectedIndex / COL;
                int j = oldSelectedIndex % COL;
                panels[i][j].disableSelectedEffect();
                panels[i][j].setSelected(false);
                i = selectedIndex / COL;
                j = selectedIndex % COL;
                panels[i][j].enableSelectedEffect();
                panels[i][j].setSelected(true);
            }
        }
    }

}
