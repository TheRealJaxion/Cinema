/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fis.poo.cinemalayout.model.services;

import fis.poo.cinemalayout.controller.SMainController;
import fis.poo.cinemalayout.model.entities.Reservation;
import java.util.ArrayList;
import java.util.Set;
import javax.swing.JToggleButton;

/**
 *
 * @author jordy
 */
public class ClientReserv implements MarkReservation{
    
    private SMainController smc;
    private int seats;
    
    @Override
    public void checkSeats() {
        smc.setIsClient(true);
        smc.setIsCashier(false);
        seats = smc.getCounter();
    }
    
}
