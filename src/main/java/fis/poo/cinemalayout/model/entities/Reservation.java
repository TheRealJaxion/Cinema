/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fis.poo.cinemalayout.model.entities;

import java.util.ArrayList;

/**
 *
 * @author jordy
 */
public class Reservation {
    private Function function;
    private int seats; 
    private String promo; 

    public Reservation(Function fn, int seats) {
        this.function = fn;
        this.seats = seats;
        
    }

    public Function getFunction() {
        return function;
    }

    public int getSeats() {
        return seats;
    }

    public String getProms() {
        return promo;
    }

    public void setFunction(Function function) {
        this.function = function;
    }

    public void setSeats(int seat) {
        seats = seat; 
        if(seats > 3){
            promo = "TPO";
        } else if(seats == 2){
            promo = "FEBR14";
        } else{
            promo = "NS";
        }
    }

    public void setProms(String promo) {
        this.promo = promo; 
    }
    
}
