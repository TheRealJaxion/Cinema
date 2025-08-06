/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fis.poo.cinemalayout.controller;

import fis.poo.cinemalayout.model.entities.Function;
import fis.poo.cinemalayout.model.entities.Movie;
import fis.poo.cinemalayout.model.services.CinemaManager;
import fis.poo.cinemalayout.view.CashierPanel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

/**
 *
 * @author jordy
 */
public class CJCBController implements ItemListener{
    private CashierPanel csh;
    private CinemaManager cnm = new CinemaManager();
    private ArrayList<Movie> mvs = cnm.movies(csh);

    public CJCBController(CashierPanel csh) {
        this.csh = csh;
        csh.movieCB.addItemListener(this);
        csh.functionCB.addItemListener(this);
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
          
        if(csh.movieCB.isShowing()){ 
            
            ArrayList<Movie> mvs = cnm.movies(csh);
            ArrayList<String> mn = new ArrayList<>();
            
            for(Movie mv : mvs){
                mn.add(mv.getNameM());
            }
            
            if(ie.getSource() == csh.movieCB){
                if(csh.functionCB.getItemCount() != 0){
                    csh.functionCB.removeAllItems();
                }    
                
                for(int i=0; i<mn.size(); i++){
                    if(csh.movieCB.getSelectedItem().equals(mn.get(i))){
                        ArrayList<Function> fns = cnm.functions(csh, mn.get(i));
                        for(Function fn : fns){
                            csh.functionCB.addItem(fn.getFunctionId());
                        }
                        break;
                    }
                }
            }
            
        }
    }
}

