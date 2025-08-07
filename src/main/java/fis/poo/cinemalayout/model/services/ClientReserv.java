/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fis.poo.cinemalayout.model.services;

import fis.poo.cinemalayout.controller.SeatManager;
import fis.poo.cinemalayout.model.entities.Function;
import fis.poo.cinemalayout.model.entities.Movie;
import fis.poo.cinemalayout.model.entities.Recipe;
import fis.poo.cinemalayout.model.entities.Reservation;
import fis.poo.cinemalayout.view.MainLayout;
import java.awt.Component;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author jordy
 */
public class ClientReserv extends MarkReservation{
    
    public ClientReserv(Movie mv, Function fn, SeatManager smn, JFrame fr1, JFrame fr2) {
        super(mv, fn, smn, fr1, fr2, "Client");
    }
    
    @Override
    public Reservation markSeats(Component fr1) {
        return smn.getRsrv();
    }
    
    public ActionListener getAct(){
        return smn.getSsc();
    }

    public boolean status(){
        return smn.isHasEnded();
    }
    
}
