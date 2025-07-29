/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fis.poo.cinemalayout.model.services;

import fis.poo.cinemalayout.model.entities.Cashier;
import fis.poo.cinemalayout.model.entities.Client;
import java.util.ArrayList;

/**
 *
 * @author jordy
 */
public class Verificator {
    private PersonManager pm;
    
    public boolean verifier(String select, String username, String password){
        switch(select){
            case "client"->{
                for(int i=0; i<pm.clients().size(); i++){
                    Client client = pm.clients().get(i);
                    if(username == client.getUsername() && password == client.getPassword()){
                        return true;
                    }
                }
                return false; 
            }
            case "cashier"->{
                for(int i=0; i<pm.clients().size(); i++){
                    Cashier cashier = pm.cashiers().get(i);
                    if(username == cashier.getUsername() && password == cashier.getPassword()){
                        return true;
                    }
                }
                return false; 
            }
            default ->{
                return false; 
            }
        }
    }
    
}
