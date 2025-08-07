/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fis.poo.cinemalayout.model.services;

import fis.poo.cinemalayout.controller.SeatManager;
import fis.poo.cinemalayout.model.entities.Function;
import fis.poo.cinemalayout.model.entities.Movie;
import fis.poo.cinemalayout.model.entities.Reservation;
import fis.poo.cinemalayout.view.SeatsSelection;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author jordy
 */
public class CashierReserv extends MarkReservation{

    public CashierReserv(Movie mv, Function fn, SeatManager smn, JFrame fr1) {
        super(mv, fn, smn, fr1, fr1, "Cashier");
    }

    @Override
    public Reservation markSeats(Component fr1) {
        if(smn.getRsrv() == null){
            JOptionPane.showMessageDialog(fr1, "There's no reservation (null exception)!", "Policinema", JOptionPane.ERROR_MESSAGE);
            System.out.println(smn.getRsrv() + " at mst /n");
            return null;
        } else{
            return smn.getRsrv();
        }
    }
    
}
