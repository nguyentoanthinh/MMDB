/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.soict.hust.k57.mmdb.entities;

import java.io.File;
import org.opencv.core.Mat;

/**
 *
 * @author thinhnt
 */
public class ImgEnt {
    private File f;
    private Mat rHistogram;
    private Mat gHistogram;
    private Mat bHistogram;
    private int bin;
    private double distance;

    public ImgEnt() {
        bin = 256;
    }
    
    public ImgEnt(File f){
        this();
        this.f = f;
    }

    public File getF() {
        return f;
    }

    public void setF(File f) {
        this.f = f;
    }

    public Mat getrHistogram() {
        return rHistogram;
    }

    public void setrHistogram(Mat rHistogram) {
        this.rHistogram = rHistogram;
    }

    public Mat getgHistogram() {
        return gHistogram;
    }

    public void setgHistogram(Mat gHistogram) {
        this.gHistogram = gHistogram;
    }

    public Mat getbHistogram() {
        return bHistogram;
    }

    public void setbHistogram(Mat bHistogram) {
        this.bHistogram = bHistogram;
    }

    public int getBin() {
        return bin;
    }

    public void setBin(int bin) {
        this.bin = bin;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
