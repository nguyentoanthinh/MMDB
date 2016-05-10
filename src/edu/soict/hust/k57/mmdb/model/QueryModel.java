/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.soict.hust.k57.mmdb.model;

import edu.soict.hust.k57.mmdb.entities.ImgEnt;
import java.io.File;
import java.util.function.Consumer;

/**
 *
 * @author thinhnt
 */
public class QueryModel extends AbstractModel {

    private final ImgEnt img;
    private DistanceType distanceType;

    public QueryModel() {
        super();
        img = new ImgEnt();
        distanceType = DistanceType.EUCLID;
    }

    public void setBin(int bin, Consumer<ImgEnt> consumer) {
        if (bin != img.getBin()) {
            img.setBin(bin);
            if (img.getF() != null) {
                consumer.accept(img);
                support.firePropertyChange("querymodel.img", null, img);
            }
        }
    }

    public void setInputFile(File f, Consumer<ImgEnt> consumer) {
        if (img.getF() == null || !img.getF().getPath().equals(f.getPath())) {
            img.setF(f);
            consumer.accept(img);
            support.firePropertyChange("querymodel.img", null, img);
        }
    }

    public DistanceType getDistanceType() {
        return distanceType;
    }

    public void setDistanceType(DistanceType distanceType) {
        this.distanceType = distanceType;
    }

    public enum DistanceType {
        EUCLID
    }
}
