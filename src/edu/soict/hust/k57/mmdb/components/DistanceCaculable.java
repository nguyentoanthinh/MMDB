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
public interface DistanceCaculable {

    double caculateDistance(ImgEnt imgEnt1, ImgEnt imgEnt2);
}
