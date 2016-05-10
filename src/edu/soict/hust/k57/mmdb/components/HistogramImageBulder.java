/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.soict.hust.k57.mmdb.components;

import edu.soict.hust.k57.mmdb.entities.ImgEnt;
import javax.swing.ImageIcon;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

/**
 *
 * @author thinhnt
 */
public class HistogramImageBulder {

    private ImageIcon bImage;
    private ImageIcon gImage;
    private ImageIcon rImage;

    public HistogramImageBulder() {
    }

    public void createHistogramImages(ImgEnt imgEnt) {
        bImage = createImageIcon(imgEnt.getbHistogram(), imgEnt.getBin(), Channel.B);
        gImage = createImageIcon(imgEnt.getgHistogram(), imgEnt.getBin(), Channel.G);
        rImage = createImageIcon(imgEnt.getrHistogram(), imgEnt.getBin(), Channel.R);
    }

    private ImageIcon createImageIcon(Mat hist, int bin, Channel c) {
        int hist_w = 150; // width of the histogram image
        int hist_h = 100; // height of the histogram image
        int bin_w = (int) Math.round(hist_w * 1.0 / bin);

        Mat histImage = new Mat(hist_h, hist_w, CvType.CV_8UC3, new Scalar(0, 0, 0));
        Mat normalizeHist = hist.clone();
        Core.normalize(normalizeHist, normalizeHist, 0, histImage.rows(), Core.NORM_MINMAX, -1, new Mat());

        Scalar scalar = null;
        switch (c) {
            case B:
                scalar = new Scalar(255, 0, 0);
                break;
            case G:
                scalar = new Scalar(0, 255, 0);
                break;
            case R:
                scalar = new Scalar(0, 0, 255);
        }

        for (int i = 1; i < bin; i++) {
            Imgproc.line(histImage, new Point(bin_w * (i - 1), hist_h - Math.round(normalizeHist.get(i - 1, 0)[0])),
                    new Point(bin_w * (i), hist_h - Math.round(normalizeHist.get(i - 1, 0)[0])), scalar, 1, 8, 0);
            Imgproc.line(histImage, new Point(bin_w * (i), hist_h - Math.round(normalizeHist.get(i - 1, 0)[0])),
                    new Point(bin_w * (i), hist_h - Math.round(normalizeHist.get(i, 0)[0])), scalar, 1, 8, 0);
        }
        MatOfByte buffer = new MatOfByte();
        Imgcodecs.imencode(".png", histImage, buffer);
        return new ImageIcon(buffer.toArray());
    }

    public ImageIcon getImageIcon(Channel c) {
        switch (c) {
            case R:
                return rImage;
            case G:
                return gImage;
            case B:
                return bImage;
        }
        return null;
    }

    public static enum Channel {
        R, G, B
    }
}
