/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fis.poo.cinemalayout.controller;

import fis.poo.cinemalayout.model.entities.Function;
import fis.poo.cinemalayout.view.Loginoptions;
import fis.poo.cinemalayout.view.MainLayout;
import fis.poo.cinemalayout.view.SeatsSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author jordy
 */
public class MLController implements ActionListener{
    
    private MainLayout ml;
    private Loginoptions logn; 
    private ArrayList<Function> functions; 
    private SeatsSelection st; 
    
    public MLController(MainLayout ml, SeatsSelection st) {
        this.ml = ml;
        this.ml.signB.addActionListener(this); 
        this.ml.movie1B.addActionListener(this);
        this.ml.movie2B.addActionListener(this);
        this.ml.movie3B.addActionListener(this);
        this.ml.movie4B.addActionListener(this);
        this.ml.gbbM.addActionListener(this);
        
    }    

    @Override
    public void actionPerformed(ActionEvent ev) {
        if(ml.isAct(ml)){
            if(ev.getSource() == ml.movie1B){
                ImageIcon img = new ImageIcon("");
                
                
            }
        }
    }
    
    
    
}
