/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fis.poo.cinemalayout.model.services;

import fis.poo.cinemalayout.controller.SeatController;
import fis.poo.cinemalayout.model.entities.Function;
import fis.poo.cinemalayout.model.entities.Reservation;
import fis.poo.cinemalayout.view.SeatsSelection;

/**
 *
 * @author jordy
 */
public class CashierReserv extends MarkReservation{

    public CashierReserv(Function fn, SeatController smc, SeatsSelection sl, Reservation rs) {
        super(fn, smc, sl, rs);
        smc.setIsCashier(true);
        smc.setIsClient(false);
    }

    public Function getFn() {
        return fn;
    }
    
    @Override
    public void markSeats() {
        rs.setSeats(smc.getCounter());
        smc.setCounter(0);
    }
    
}
