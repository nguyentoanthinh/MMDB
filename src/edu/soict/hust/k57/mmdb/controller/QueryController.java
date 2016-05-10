/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.soict.hust.k57.mmdb.controller;

import edu.soict.hust.k57.mmdb.components.HistogramCaculator;
import edu.soict.hust.k57.mmdb.model.AbstractModel;
import edu.soict.hust.k57.mmdb.model.QueryModel;
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

    public void changeDistanceType(String distanceType) {
        QueryModel.DistanceType dt = null;
        if (distanceType.equals("Euclid")) {
            dt = QueryModel.DistanceType.EUCLID;
        }
    }

}
