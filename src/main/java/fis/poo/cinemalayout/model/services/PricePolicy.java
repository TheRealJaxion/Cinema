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
public class PricePolicy {
    //The pricePolicy will display and calculate the total value to pay. 
    private String prom1 = "NIGHTF";
    private String prom2 = "FEBR14";
    private String prom3 = "BD";
    private String prom4 = "TPO";
    private double taxPer; 
    private double seatPriceH; //Prices for seats that are ubicated in a normal hall
    private double seatPriceI; //Prices for seats that are ubicated in IMAX halls
    private double pprom1, pprom2, pprom3, pprom4; //Prices for each promo, it will give a discount in the final price.  

    public PricePolicy(double taxPer, double seatPriceH, double seatPriceI, double pprom1, double pprom2, double pprom3, double pprom4) {
        this.taxPer = taxPer;
        this.seatPriceH = seatPriceH;
        this.seatPriceI = seatPriceI;
        this.pprom1 = pprom1;
        this.pprom2 = pprom2;
        this.pprom3 = pprom3;
        this.pprom4 = pprom4;
    }

    
    
    public String getProm1() {
        return prom1;
    }

    public String getProm2() {
        return prom2;
    }

    public String getProm3() {
        return prom3;
    }

    public String getProm4() {
        return prom4;
    }

    public double getTaxPer() {
        return taxPer;
    }

    public double getSeatPriceH() {
        return seatPriceH;
    }

    public double getSeatPriceI() {
        return seatPriceI;
    }

    public double getPprom1() {
        return pprom1;
    }

    public double getPprom2() {
        return pprom2;
    }

    public double getPprom3() {
        return pprom3;
    }

    public double getPprom4() {
        return pprom4;
    }

    public void setTaxPer(double taxPer) {
        this.taxPer = taxPer;
    }

    public void setSeatPriceH(double seatPriceH) {
        this.seatPriceH = seatPriceH;
    }

    public void setSeatPriceI(double seatPriceI) {
        this.seatPriceI = seatPriceI;
    }

    public void setPprom1(double pprom1) {
        this.pprom1 = pprom1;
    }

    public void setPprom2(double pprom2) {
        this.pprom2 = pprom2;
    }

    public void setPprom3(double pprom3) {
        this.pprom3 = pprom3;
    }

    public void setPprom4(double pprom4) {
        this.pprom4 = pprom4;
    }
    
    public double promS(String selected){
        switch(selected){
            case "NS" ->{
                return 1; 
            }
            case "NIGHTF" ->{
                return pprom1;
            }
            case "FEBR14" ->{
                return pprom2;
            }
            case "BD" ->{
                return pprom3; 
            }
            case "TPO" ->{
                return pprom4;
            }
            default ->{
                return 1; 
            }
        
        }
    }
    
    public double hallSl(char selected){
        
        switch(selected){
            case 'H' ->{
                return seatPriceH;
            }
            case 'I' ->{
                return seatPriceI; 
            }
            default ->{
                return 1; 
            }
        }
    }
    
}
