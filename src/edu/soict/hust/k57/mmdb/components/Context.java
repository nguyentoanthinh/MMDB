/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.soict.hust.k57.mmdb.components;

import edu.soict.hust.k57.mmdb.entities.ImgEnt;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author thinhnt
 */
public class Context {
    private static final Context instance = new Context();
    public final static String RESULT_PROPERTY_NAME = "RESULT";
    public final static String DATA_PROPERTY_NAME = "DATA";
    private final static String DATA_PATH = "data";
    private PropertyChangeSupport support;
    private Map map;

    private Context() {
        support = new PropertyChangeSupport(this);
        map = new HashMap();
        File f = new File(DATA_PATH);
        File[] childFiles = f.listFiles();
        ImgEnt[] imgEnts = new ImgEnt[childFiles.length];
        for (int i = 0; i < imgEnts.length; i++) {
            imgEnts[i] = new ImgEnt(childFiles[i]);
        }
        map.put(DATA_PROPERTY_NAME, imgEnts);
    }

    public static Context sharedInstance() {
        return instance;
    }

    public void put(String k, Object v) {
//        Object old = map.get(k);
        map.put(k, v);
        support.firePropertyChange(k, null, v);
    }
    
    public Object get(String k){
        return map.get(k);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }
}
