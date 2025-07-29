/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fis.poo.cinemalayout.model.services;

import fis.poo.cinemalayout.controller.SMainController;
import java.util.HashSet;

/**
 *
 * @author jordy
 */
public class CashierReserv implements MarkReservation{
    
    private SMainController smc;
    private int seats; 
    
    @Override
    public void checkSeats() {
        smc.setIsCashier(true); 
        smc.setIsClient(false);
        seats = smc.getCounter();
    }
    
}
