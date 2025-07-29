/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fis.poo.cinemalayout.model.services;

/**
 *
 * @author jordy
 */
public class PayOnline implements PayOptions{
    private boolean isLogged; 
    private Recipe total; 

    public void setTotal(Recipe total) {
        this.total = total;
    }

    public void setIsLogged(boolean isLogged) {
        this.isLogged = isLogged;
    }

    @Override
    public void payment() {
        System.out.println(total.setInitialPrice());
        System.out.println(total.setDiscount());
        System.out.println(total.setFinalPrice());
    }

    @Override
    public boolean successPay(boolean check) {
        if(check){
            System.out.println("Thanks for preffer us!");
            return true; 
        }else{
            return false; 
        }
    }
}
