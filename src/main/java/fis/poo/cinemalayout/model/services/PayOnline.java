/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fis.poo.cinemalayout.model.services;

import fis.poo.cinemalayout.model.entities.PayGateway;
import fis.poo.cinemalayout.model.entities.Recipe;
import javax.swing.JOptionPane;

/**
 *
 * @author jordy
 */
public class PayOnline implements PayOptions{
    private boolean isLogged; 
    private PayGateway total; 

    public void setTotal(PayGateway total) {
        this.total = total;
    }

    public void setIsLogged(boolean isLogged) {
        this.isLogged = isLogged;
    }

    @Override
    public void payment() {

    }

    @Override
    public boolean successPay(boolean check) {
        if(check){
            JOptionPane.showMessageDialog(null, "Thanks for preffer us! ", "Policinema", JOptionPane.OK_OPTION);            
            return true; 
        }else{
            return false; 
        }
    }
}
