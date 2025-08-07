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
public class Recipe {
    private Reservation res;
    private PricePolicy prp;
    private PayGateway pgt;
    private String clientName; 
    private String clientId; 
    private String promo;

    public Recipe(Reservation res) {
        this.res = res;
        promo = res.getProms();
        prp = new PricePolicy(); 
        pgt = new PayGateway(prp, res);
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
    
    public void setRes(Reservation res) {
        this.res = res;
    }
    
    public String displayRecipe(){
        StringBuilder stb = new StringBuilder("===============================================");
        stb.append("\n").append("                                     POLICINEMA S.A                  ").append("\n");
        stb.append("Client Name:                                                         ").append(clientName).append("\n");
        stb.append("Client ID:                                                               ").append(clientId).append("\n");
        stb.append("===============================================").append("\n");
        stb.append("Amount	    ").append("Item            ").append("Description           ").append("Price/u    ").append("\n");
        stb.append("   "+res.getSeats()+"                          ").append(pgt.getHallS()+"S                ").append(pgt.getHallS()+"Seat/s                   ").append(prp.hallSl(pgt.getHallS())).append("\n");
        stb.append("===============================================").append("\n");
        stb.append("Total Initial:                                                               ").append(pgt.setInitialPrice()).append("\n");
        stb.append("Taxes:                                                                      ").append(prp.getTaxPer()).append("\n"); 
        stb.append("Offer/Discounts:                                                      ").append(pgt.setDiscount()).append("\n");
        stb.append("TOTAL:                                                                    ").append(pgt.setFinalPrice()).append("\n");
        stb.append("===============================================").append("\n");
        stb.append("Thanks por preffer us! :)").append("\n");
        stb.append("===============================================").append("\n");
        return stb.toString();
    }    
    
}
