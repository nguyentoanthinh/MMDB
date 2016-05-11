/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfFloat;
import org.opencv.core.MatOfInt;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

/**
 *
 * @author thinhnt
 */
public class HelloCV extends JFrame {

    public HelloCV() {
        initComponents();
        setLocationRelativeTo(null);
        setSize(800,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void initComponents() {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat mat = Mat.eye(3, 3, CvType.CV_8UC1);
        Mat m = Imgcodecs.imread("data/0.jpg");
        List<Mat> images = new ArrayList<Mat>();
        Core.split(m, images);
        
        MatOfInt histSize = new MatOfInt(256);    // kích thước của histogram
        MatOfInt channels = new MatOfInt(0);    // Kênh màu muốn tính
        MatOfFloat histRange = new MatOfFloat(0, 256);

        Mat hist = new Mat();
        Imgproc.calcHist(images.subList(0, 1), channels, new Mat(), hist, histSize, histRange, false);
//        System.out.println(hist.dump());
        // Show histogram
        int hist_w = 150; // width of the histogram image
        int hist_h = 100; // height of the histogram image
//        System.out.println(histSize.get(0, 0)[0]);
        int bin_w = (int) Math.round(hist_w / histSize.get(0, 0)[0]);

        Mat histImage = new Mat(hist_h, hist_w, CvType.CV_8UC3, new Scalar(0, 0, 0));
        Core.normalize(hist, hist, 0, histImage.rows(), Core.NORM_MINMAX, -1, new Mat());
        System.out.println(hist.get(30, 0)[0]);

        for (int i = 1; i < histSize.get(0, 0)[0]; i++) {
            Imgproc.line(histImage, new Point(bin_w * (i - 1), hist_h - Math.round(hist.get(i - 1, 0)[0])),
                    new Point(bin_w * (i), hist_h - Math.round(hist.get(i - 1, 0)[0])), new Scalar(255, 0, 0), 1, 8, 0);
            Imgproc.line(histImage, new Point(bin_w * (i), hist_h - Math.round(hist.get(i - 1, 0)[0])),
                    new Point(bin_w * (i), hist_h - Math.round(hist.get(i, 0)[0])), new Scalar(255, 0, 0), 1, 8, 0);
        }

        ImageIcon histImg = mat2Image(histImage);
        getContentPane().add(new JLabel(histImg), BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new HelloCV();
    }

    private ImageIcon mat2Image(Mat frame) {
        // create a temporary buffer
        MatOfByte buffer = new MatOfByte();
        // encode the frame in the buffer, according to the PNG format
        Imgcodecs.imencode(".png", frame, buffer);
		// build and return an Image created from the image encoded in the
        // buffer
        return new ImageIcon(buffer.toArray());
    }
}
