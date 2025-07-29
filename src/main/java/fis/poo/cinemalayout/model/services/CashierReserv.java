/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fis.poo.cinemalayout.model.services;

import fis.poo.cinemalayout.controller.SMainController;
import fis.poo.cinemalayout.model.entities.Function;
import fis.poo.cinemalayout.model.entities.Reservation;
import fis.poo.cinemalayout.view.SeatsSelection;
import java.util.HashSet;

/**
 *
 * @author jordy
 */
public class CashierReserv extends MarkReservation{

    public CashierReserv(Function fn, SMainController smc, SeatsSelection sl, Reservation rs) {
        super(fn, smc, sl, rs);
        smc.setRs(rs);
        smc.setIsCashier(true);
        smc.setIsClient(false);
    }
    
    
    
    @Override
    public void markSeats() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
