/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.soict.hust.k57.mmdb.controller;

import edu.soict.hust.k57.mmdb.model.AbstractModel;
import edu.soict.hust.k57.mmdb.model.ResultModel;

/**
 *
 * @author thinhnt
 */
public class ResultController extends AbstractController{

    public ResultController() {
    }
    
    public void selectedHistogramChanelChanged(){
         for (AbstractModel model : models) {
            if (model instanceof ResultModel) {
                ((ResultModel) model).changeSelectedChanel();
            }
        }
    }
    
    public void onSelectedImaage(int i, int j){
         for (AbstractModel model : models) {
            if (model instanceof ResultModel) {
                ((ResultModel) model).setSelectedImage(i, j);
            }
        }
    }
}
