/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fis.poo.cinemalayout.model.services;

import fis.poo.cinemalayout.model.entities.Reservation;

/**
 *
 * @author jordy
 */
public class Recipe {
    private Reservation res;
    private PricePolicy prp; 
    private char hallS = res.getFunction().getHall();
    private int seats = res.getSeats().size();
    private String promo = res.getProms(); 
    
    public double setInitialPrice(){
        return  prp.hallSl(hallS)* seats; 
    }
    
    public double setDiscount(){
        return setInitialPrice()*prp.promS(promo); 
    }
    
    public double setFinalPrice(){
        return (setDiscount() * prp.getTaxPer()) + setDiscount(); 
    }
    
}
