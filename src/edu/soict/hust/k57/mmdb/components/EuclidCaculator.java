/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.soict.hust.k57.mmdb.components;

import edu.soict.hust.k57.mmdb.entities.ImgEnt;

/**
 *
 * @author thinhnt
 */
public class EuclidCaculator implements DistanceCaculable{

    public EuclidCaculator() {
    }

    @Override
    public double caculateDistance(ImgEnt imgEnt1, ImgEnt imgEnt2) {
        if (imgEnt1.getF().getName().equals(imgEnt2.getF().getName())){
            System.out.println("");
        }
        double rSum = 0;
        double gSum = 0;
        double bSum = 0;
        for (int i = 0; i < imgEnt1.getBin(); i++) {
//            double a = imgEnt1.getrHistogram().get(i, 0)[0];
            rSum += Math.pow(imgEnt1.getrHistogram().get(i, 0)[0] - imgEnt2.getrHistogram().get(i, 0)[0], 2);
            gSum += Math.pow(imgEnt1.getgHistogram().get(i, 0)[0] - imgEnt2.getgHistogram().get(i, 0)[0], 2);
            bSum += Math.pow(imgEnt1.getbHistogram().get(i, 0)[0] - imgEnt2.getbHistogram().get(i, 0)[0], 2);
        }
        return Math.sqrt(rSum + gSum + bSum);
    }
}
