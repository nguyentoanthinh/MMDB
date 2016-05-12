/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.soict.hust.k57.mmdb.controller;

import edu.soict.hust.k57.mmdb.components.DistanceCaculable;
import edu.soict.hust.k57.mmdb.components.EuclidCaculator;
import edu.soict.hust.k57.mmdb.components.HistogramCaculator;
import edu.soict.hust.k57.mmdb.components.CosinDistanceCaculator;
import edu.soict.hust.k57.mmdb.exeptions.InvalidInputExeption;
import edu.soict.hust.k57.mmdb.model.AbstractModel;
import edu.soict.hust.k57.mmdb.model.QueryModel;
import edu.soict.hust.k57.mmdb.view.QueryView;
import java.io.File;

/**
 *
 * @author thinhnt
 */
public class QueryController extends AbstractController {

    public QueryController() {
    }

    public void changeInputFile(File inputFile) {
        for (AbstractModel model : models) {
            if (model instanceof QueryModel) {
                ((QueryModel) model).setInputFile(inputFile, new HistogramCaculator());
            }
        }
    }

    public void changeBin(int bin) {
        for (AbstractModel model : models) {
            if (model instanceof QueryModel) {
                ((QueryModel) model).setBin(bin, new HistogramCaculator());
            }
        }
    }

    public void queryHistogramChanelChanged() {
        for (AbstractModel model : models) {
            if (model instanceof QueryModel) {
                ((QueryModel) model).changeSelectedChanel();
            }
        }
    }

    public void onClickSearchButton() throws InvalidInputExeption {
        for (AbstractModel model : models) {
            if (model instanceof QueryModel) {
                DistanceCaculable distCalc = null;
                QueryModel qModel = ((QueryModel) model);
                switch (qModel.getDistanceType()){
                    case EUCLID:
                        distCalc = new EuclidCaculator();
                        break;
                    case COSIN_DISTANCE:
                        distCalc = new CosinDistanceCaculator();
                        break;
                }
                qModel.search(new HistogramCaculator(), distCalc);
            }
        }
    }

    public void changeDistanceType(String distanceType) {
        QueryModel.DistanceType dt = null;
        if (distanceType.equals(QueryView.EUCLID_DISTANCE)) {
            dt = QueryModel.DistanceType.EUCLID;
        }else if (distanceType.equals(QueryView.C_DISTANCE)){
            dt = QueryModel.DistanceType.COSIN_DISTANCE;
        }
        
        for (AbstractModel model : models) {
            if (model instanceof QueryModel) {
                ((QueryModel) model).setDistanceType(dt);
            }
        }
    }

}
