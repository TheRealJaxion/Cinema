/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fis.poo.cinemalayout.model.entities;

/**
 *
 * @author jordy
 */
public class Cashier extends Person {
    
    public Cashier(String username, String namesP, String lastnamesP, String password) {
        super(username, namesP, lastnamesP, password);
    }

    public Cashier() {
    }
    
    @Override
    public String toCSV(){
        return username+","+namesP +","+lastnamesP +","+ password+"\n"; 
    }
    
}
