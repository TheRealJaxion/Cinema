/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fis.poo.cinemalayout.model.entities;

import fis.poo.cinemalayout.model.services.PricePolicy;

/**
 *
 * @author jordy
 */
public class PayGateway {
    private PricePolicy prc;
    private Reservation rs;
    private int seats = 0; 
    private char hallS;

    public PayGateway(PricePolicy prc, Reservation rs) {
        this.prc = prc;
        prc = new PricePolicy();
        this.rs = rs;
        seats = rs.getSeats();
        hallS = rs.getFunction().getHall();
    }

    public Reservation getRs() {
        return rs;
    }

    public int getSeats() {
        return seats;
    }

    public char getHallS() {
        return hallS;
    }
    
    public double setInitialPrice(){
        return prc.hallSl(hallS)*seats; 
    }
    
    public double setDiscount(){
        return setInitialPrice()*(prc.promS(rs.getProms())/100); 
    }
    
    public double setFinalPrice(){
        return (setDiscount() * prc.getTaxPer()) + setDiscount(); 
    }
    
}
