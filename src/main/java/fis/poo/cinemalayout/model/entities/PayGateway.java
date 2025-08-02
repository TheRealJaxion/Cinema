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
    private int seats = rs.getSeats(); 
    private char hallS = rs.getFunction().getHall();

    public PayGateway(PricePolicy prc, Reservation rs) {
        this.prc = prc;
        this.rs = rs;
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
        return setInitialPrice()*prc.promS(rs.getProms()); 
    }
    
    public double setFinalPrice(){
        return (setDiscount() * prc.getTaxPer()) + setDiscount(); 
    }
    
}
