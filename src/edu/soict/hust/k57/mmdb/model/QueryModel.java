/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.soict.hust.k57.mmdb.model;

import edu.soict.hust.k57.mmdb.components.Context;
import edu.soict.hust.k57.mmdb.components.DistanceCaculable;
import edu.soict.hust.k57.mmdb.entities.ImgEnt;
import edu.soict.hust.k57.mmdb.exeptions.InvalidInputExeption;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;
import javax.swing.SwingWorker;

/**
 *
 * @author thinhnt
 */
public class QueryModel extends AbstractModel {

    private final ImgEnt img;
    private DistanceType distanceType;
    public static final String IMG_PROPERTY_NAME = "querymodel.img";
    public static final String CHANEL_PROPERTY_NAME = "querymodel.chanel";

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
                support.firePropertyChange(IMG_PROPERTY_NAME, null, img);
            }
        }
    }

    public void setInputFile(File f, Consumer<ImgEnt> consumer) {
        if (img.getF() == null || !img.getF().getPath().equals(f.getPath())) {
            img.setF(f);
            consumer.accept(img);
            support.firePropertyChange(IMG_PROPERTY_NAME, null, img);
        }
    }

    public void changeSelectedChanel() {
        support.firePropertyChange(CHANEL_PROPERTY_NAME, null, img);
    }

    public void search(Consumer<ImgEnt> histCalc, DistanceCaculable distCalc) throws InvalidInputExeption {
        if (img.getF() == null) {
            throw new InvalidInputExeption("Bạn chưa lựa chọn tệp tin tìm kiếm!");
        }
        final ImgEnt[] dataImgEnts = (ImgEnt[]) Context.sharedInstance().get(Context.DATA_PROPERTY_NAME);

        new SwingWorker<Void, Void>() {

            @Override
            protected Void doInBackground() throws Exception {
                int chunkSize = dataImgEnts.length / 10;
                SwingWorker[] workers = new SwingWorker[10];
                for (int i = 0; i < 9; i++) {
                    workers[i] = new ComputeWorker(histCalc, distCalc, dataImgEnts,
                            i * chunkSize, (i + 1) * chunkSize - 1);
                    workers[i].execute();
                }
                workers[9] = new ComputeWorker(histCalc, distCalc, dataImgEnts,
                        9 * chunkSize, dataImgEnts.length  - 1);
                workers[9].execute();
                for (SwingWorker worker : workers) {
                    worker.get();
                }
                return null;
            }

            @Override
            protected void done() {
                super.done(); //To change body of generated methods, choose Tools | Templates.
                Arrays.sort(dataImgEnts,new Comparator<ImgEnt>(){

                    @Override
                    public int compare(ImgEnt o1, ImgEnt o2) {
                        if (o1.getDistance() > o2.getDistance()){
                            return 1;
                        }
                        if (o1.getDistance() < o2.getDistance()){
                            return -1;
                        }
                        return 0;
                    }
                    
                });
                Context.sharedInstance().put(Context.RESULT_PROPERTY_NAME, dataImgEnts);
            }
        }.execute();

    }

    class ComputeWorker extends SwingWorker<Void, Void> {

        private final ImgEnt[] dataImgEnts;
        private final int start;
        private final int end;
        private final Consumer<ImgEnt> histCalc;
        private final DistanceCaculable distCalc;

        public ComputeWorker(Consumer<ImgEnt> histCalc, DistanceCaculable distCalc,
                ImgEnt[] dataImgEnts, int start, int end) {
            this.histCalc = histCalc;
            this.distCalc = distCalc;
            this.dataImgEnts = dataImgEnts;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Void doInBackground() throws Exception {
            for (int i = start; i <= end; i++) {
                ImgEnt dataImg = dataImgEnts[i];
                if (dataImg.getgHistogram() == null || dataImg.getBin() != img.getBin()){
                    dataImg.setBin(img.getBin());
                    histCalc.accept(dataImg);
                }
                
                dataImg.setDistance(distCalc.caculateDistance(img, dataImg));
            }
            return null;
        }
    }

    public DistanceType getDistanceType() {
        return distanceType;
    }

    public void setDistanceType(DistanceType distanceType) {
        this.distanceType = distanceType;
    }

    public enum DistanceType {
        EUCLID, COSIN_DISTANCE
    }
}
