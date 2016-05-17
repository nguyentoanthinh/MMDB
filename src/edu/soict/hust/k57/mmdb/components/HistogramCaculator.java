/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.soict.hust.k57.mmdb.components;

import edu.soict.hust.k57.mmdb.entities.ImgEnt;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfFloat;
import org.opencv.core.MatOfInt;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

/**
 *
 * @author thinhnt
 */
public class HistogramCaculator implements Consumer<ImgEnt> {

    public HistogramCaculator() {
    }

    @Override
    public void accept(ImgEnt t) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat mat = Mat.eye(3, 3, CvType.CV_8UC1);
        Mat m = Imgcodecs.imread(t.getF().getPath());
        List<Mat> images = new ArrayList<Mat>();
        Core.split(m, images);

        MatOfInt histSize = new MatOfInt(t.getBin());    // kích thước của histogram
        MatOfInt channels = new MatOfInt(0);    // Kênh màu muốn tính
        MatOfFloat histRange = new MatOfFloat(0, 256);

        Mat bHist = new Mat();
        Mat gHist = new Mat();
        Mat rHist = new Mat();

        Imgproc.calcHist(images.subList(0, 1), channels, new Mat(), bHist, histSize, histRange, false);
        Core.normalize(bHist, bHist, 0, 1, Core.NORM_MINMAX, -1, new Mat());
        Imgproc.calcHist(images.subList(1, 2), channels, new Mat(), gHist, histSize, histRange, false);
        Core.normalize(gHist, gHist, 0, 1, Core.NORM_MINMAX, -1, new Mat());
        Imgproc.calcHist(images.subList(2, 3), channels, new Mat(), rHist, histSize, histRange, false);
        Core.normalize(rHist, rHist, 0, 1, Core.NORM_MINMAX, -1, new Mat());
        t.setbHistogram(bHist);
        t.setgHistogram(gHist);
        t.setrHistogram(rHist);
    }
}
