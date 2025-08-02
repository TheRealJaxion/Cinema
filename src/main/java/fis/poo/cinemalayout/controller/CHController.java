/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fis.poo.cinemalayout.controller;

import fis.poo.cinemalayout.model.entities.Cashier;
import fis.poo.cinemalayout.model.entities.Recipe;
import fis.poo.cinemalayout.model.entities.Reservation;
import fis.poo.cinemalayout.model.services.CinemaManager;
import fis.poo.cinemalayout.model.services.PersonManager;
import fis.poo.cinemalayout.view.AdminPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author jordy
 */
public class CHController implements ActionListener{
    private CinemaManager cnm;
    private Reservation rsr;
    private Recipe rcp;
    private AdminPanel adm;
    private APController ap;

    public CHController(Reservation rsr, Recipe rcp, AdminPanel adm) {
        this.rsr = rsr;
        this.rcp = rcp;
        this.adm = adm;
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        Object sr = ev.getSource();
    }
    
    
     
}
