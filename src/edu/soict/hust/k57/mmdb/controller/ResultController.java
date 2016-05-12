/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.soict.hust.k57.mmdb.controller;

import edu.soict.hust.k57.mmdb.model.AbstractModel;
import edu.soict.hust.k57.mmdb.model.ResultModel;
import edu.soict.hust.k57.mmdb.view.ImageView;
import edu.soict.hust.k57.mmdb.view.ImageViewer;

/**
 *
 * @author thinhnt
 */
public class ResultController extends AbstractController {

    public ResultController() {
    }

    public void selectedHistogramChanelChanged() {
        for (AbstractModel model : models) {
            if (model instanceof ResultModel) {
                ((ResultModel) model).changeSelectedChanel();
            }
        }
    }

    public void onSelectedImage(int i, int j) {
        for (AbstractModel model : models) {
            if (model instanceof ResultModel) {
                ((ResultModel) model).setSelectedImage(i, j);
            }
        }
    }

    public void onDoubleClickedImage(int i, int j) {
        for (AbstractModel model : models) {
            if (model instanceof ResultModel) {
                ((ResultModel) model).setSelectedImage(i, j);
                ImageViewer.sharedInstance().setVisible(true);
            }
        }
    }

    public void onclickNextButton() {
        for (AbstractModel model : models) {
            if (model instanceof ResultModel) {
                ResultModel m = (ResultModel) model;
                m.setSelectedIndex(m.getNewSelectedIndex() + 1);
            }
        }
    }

    public void onclickPrevtButton() {
        for (AbstractModel model : models) {
            if (model instanceof ResultModel) {
                ResultModel m = (ResultModel) model;
                m.setSelectedIndex(m.getNewSelectedIndex() - 1);
            }
        }
    }
}
