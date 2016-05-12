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
public class CosinDistanceCaculator implements DistanceCaculable {

    @Override
    public double caculateDistance(ImgEnt imgEnt1, ImgEnt imgEnt2) {
        EuclidCaculator euclidCaculator = new EuclidCaculator();
        double rScalarProduct = 0;
        double gScalarProduct = 0;
        double bScalarProduct = 0;
        int len = imgEnt1.getBin();
        for (int i = 0; i < len; i++) {
            rScalarProduct += imgEnt1.getrHistogram().get(i, 0)[0] * imgEnt2.getrHistogram().get(i, 0)[0];
            gScalarProduct += imgEnt1.getgHistogram().get(i, 0)[0] * imgEnt2.getgHistogram().get(i, 0)[0];
            bScalarProduct += imgEnt1.getbHistogram().get(i, 0)[0] * imgEnt2.getbHistogram().get(i, 0)[0];
        }
        return 1 - (rScalarProduct + gScalarProduct + bScalarProduct) / (calcLength(imgEnt1) * calcLength(imgEnt2));
    }

    private double calcLength(ImgEnt img) {
        double rSquare = 0;
        double gSquare = 0;
        double bSquare = 0;

        int len = img.getBin();
        for (int i = 0; i < len; i++) {
            rSquare += Math.pow(img.getrHistogram().get(i, 0)[0], 2);
            gSquare += Math.pow(img.getgHistogram().get(i, 0)[0], 2);
            bSquare += Math.pow(img.getbHistogram().get(i, 0)[0], 2);
        }

        return Math.sqrt(rSquare + gSquare + bSquare);
    }
}
