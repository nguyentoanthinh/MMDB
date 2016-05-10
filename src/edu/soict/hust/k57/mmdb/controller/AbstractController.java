/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.soict.hust.k57.mmdb.controller;

import edu.soict.hust.k57.mmdb.model.AbstractModel;
import edu.soict.hust.k57.mmdb.view.AbstractView;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thinhnt
 */
public class AbstractController implements PropertyChangeListener{
    protected List<AbstractView> views;
    protected List<AbstractModel> models;

    public AbstractController() {
        views = new ArrayList<>();
        models = new ArrayList<>();
    }
    
    public void addView(AbstractView v){
        views.add(v);
    }
    
    public void removeView(AbstractView v){
        views.remove(v);
    }
    
    public void addModel(AbstractModel model){
        models.add(model);
        model.addPropertyChangeListener(this);
    }
    
    public void removeModel(AbstractModel model){
        models.remove(model);
        model.removePropertyChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        views.stream().forEach((view) -> {
            view.updateView(evt);
        });
    }
}
