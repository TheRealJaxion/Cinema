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
    private ArrayList <Integer> seats = new ArrayList<>(); 
    private String promo; 

    public Function getFunction() {
        return function;
    }

    public ArrayList<Integer> getSeats() {
        return seats;
    }

    public String getProms() {
        return promo;
    }

    public void setFunction(Function function) {
        this.function = function;
    }

    public void setSeats(int seat) {
        seats.add(seat); 
    }

    public void setProms(String promo) {
        this.promo = promo; 
    }
    
}
