/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fis.poo.cinemalayout.model.services;

import fis.poo.cinemalayout.model.entities.Cashier;
import fis.poo.cinemalayout.model.entities.Client;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author jordy
 */
public class PersonManager {
    public void registerClient(String username, String namesP, String lastnamesP, String password, String email, int age){
        String fileName = "clientReg.txt";
        File file = new File(fileName);   
        Client client = new Client(username, namesP, lastnamesP, password, email, age); 
        String content = client.toCSV();        
            try{
            //if the file doesn't exist, it will be generated. 
            if(file.exists()){
                file.createNewFile();   
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true); 
            fw.write(content);
            fw.close(); 
            JOptionPane.showConfirmDialog(null, "The user has been created successfully!", "Policinema", JOptionPane.OK_OPTION);
        }catch(IOException e){
            e.printStackTrace(); 
            JOptionPane.showConfirmDialog(null, "FATAL ERROR", "Alert!", JOptionPane.ERROR_MESSAGE);            
        }       
    }
    
    public void registerCashier(String username, String namesP, String lastnamesP, String password){
        String fileName = "cahsierReg.txt";
        File file = new File(fileName);
        Cashier cashier = new Cashier(username, namesP, lastnamesP, password);
        String content = cashier.toCSV();        
            try{
            //if the file doesn't exist, it will be generated. 
            if(file.exists()){
                file.createNewFile();   
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true); 
            fw.write(content);
            fw.close(); 
            JOptionPane.showConfirmDialog(null, "The cashier has been created successfully!", "Policinema", JOptionPane.OK_OPTION);
        }catch(IOException e){
            e.printStackTrace();
            JOptionPane.showConfirmDialog(null, "FATAL ERROR", "Alert!", JOptionPane.ERROR_MESSAGE);
        }       
    }
}
