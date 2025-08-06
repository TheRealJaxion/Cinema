/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fis.poo.cinemalayout.model.services;

import fis.poo.cinemalayout.model.entities.Cashier;
import fis.poo.cinemalayout.model.entities.Client;
import java.awt.Component;

/**
 *
 * @author jordy
 */
public class Verificator {
    private PersonManager pm = new PersonManager();
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
    
    public boolean verifier(Component fr, String select, String username, String password){
        switch(select){
            case "client"->{
                for(int i=0; i<pm.clients(fr).size(); i++){
                    Client client = pm.clients(fr).get(i);
                    if(username.matches(client.getUsername()) && password.matches(client.getPassword())){
                        isLog = true; 
                        positionc = i; 
                        return true;
                    }
                }
                return false; 
            }
            case "cashier"->{
                for(int i=0; i<pm.cashiers(fr).size(); i++){
                    Cashier cashier = pm.cashiers(fr).get(i);
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
