/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fis.poo.cinemalayout.controller;

import fis.poo.cinemalayout.model.entities.Cashier;
import fis.poo.cinemalayout.model.entities.Function;
import fis.poo.cinemalayout.model.entities.Movie;
import fis.poo.cinemalayout.model.entities.Reservation;
import fis.poo.cinemalayout.model.services.CinemaManager;
import fis.poo.cinemalayout.model.services.PersonManager;
import fis.poo.cinemalayout.model.services.PricePolicy;
import fis.poo.cinemalayout.model.services.Recipe;
import fis.poo.cinemalayout.view.AdminPanel;
import fis.poo.cinemalayout.view.HiddenView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author jordy
 */
public class APController implements ActionListener{
    
    private AdminPanel adm;
    private HiddenView hdn;
    private Movie movie;
    private Cashier cshr;
    private PricePolicy prp;
    private Recipe rp;
    private Function fn;
    private PersonManager pm;
    private CinemaManager cn;
    

    public APController(AdminPanel adm, HiddenView hdn, PricePolicy prp, PersonManager pm) {
        this.adm = adm;
        this.prp = prp;
        this.pm = pm;
        this.hdn = hdn; 
        this.adm.showInfo.addActionListener(this);
        this.adm.nCashier.addActionListener(this);
        this.adm.setMovies.addActionListener(this);
        this.adm.setPr.addActionListener(this);
        this.adm.logout.addActionListener(this);    
        this.adm.gbB.addActionListener(this);
        this.adm.model.addColumn("Name");
        this.adm.model.addColumn("Duration");
        this.adm.model.addColumn("Restriction");
        adm.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ev) {
        if(ev.getSource() == adm.logout){
            if(adm.confirmLogOut()){
                hdn.setVisible(true);
                adm.setVisible(false);
            }
        } else if(ev.getSource() == adm.showInfo){
            ArrayList<Movie> movies = cn.movies();
            for(Movie movie : movies){
                Object data = movie;
                adm.model.addRow((Object[]) data);
            }
            
            adm.info.setVisible(true);
            adm.setVisible(false);
            
        } else if(ev.getSource() == adm.gbB){
            adm.setVisible(true);
            adm.info.setVisible(false);
        } else if(ev.getSource() == adm.setMovies){
            adm.movieSet.setVisible(true);
            adm.setVisible(false);
        } else if(ev.getSource() == adm.gbM){
            adm.setVisible(true);
            adm.movieSet.setVisible(false);
        } else if(ev.getSource() == adm.cancelB){
            adm.movieSet.setVisible(true);
            adm.functionGenerator.setVisible(false);
        } else if(ev.getSource() == adm.backB){
            adm.setVisible(true);
            adm.newCashier.setVisible(false);
        } else if(adm.isAct("nc")){
            
            if(ev.getSource() == adm.regcashB){
                if(adm.isEmpt(adm.ncs())){
                    adm.alertM(adm.ncs());
                } else{
                    pm.registerCashier(adm.getTI(adm.nT), adm.getTI(adm.unT), adm.getTI(adm.lnT), adm.getTI(adm.pwT));
                    adm.setVisible(true);
                    adm.newCashier.setVisible(false);
                }
            }
        } else if(adm.isAct("sp")){
            
        }
    }
    
}
