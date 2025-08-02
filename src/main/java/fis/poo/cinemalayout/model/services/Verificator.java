/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fis.poo.cinemalayout.model.services;

import fis.poo.cinemalayout.model.entities.Cashier;
import fis.poo.cinemalayout.model.entities.Client;

/**
 *
 * @author jordy
 */
public class Verificator {
    private PersonManager pm;
    private int positionc; 
    private int posCh;
    private boolean isLog = false;

    public boolean isIsLog() {
        return isLog;
    }

    public int getPosition() {
        return positionc;
    }

    public int getPosCh() {
        return posCh;
    }
    
    public boolean verifier(String select, String username, String password){
        switch(select){
            case "client"->{
                for(int i=0; i<pm.clients().size(); i++){
                    Client client = pm.clients().get(i);
                    if((username == null ? client.getUsername() == null : username.equals(client.getUsername())) && (password == null ? client.getPassword() == null : password.equals(client.getPassword()))){
                        isLog = true; 
                        positionc = i; 
                        return true;
                    }
                }
                return false; 
            }
            case "cashier"->{
                for(int i=0; i<pm.clients().size(); i++){
                    Cashier cashier = pm.cashiers().get(i);
                    if((username == null ? cashier.getUsername() == null : username.equals(cashier.getUsername())) && (password == null ? cashier.getPassword() == null : password.equals(cashier.getPassword()))){
                        posCh = i;
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
