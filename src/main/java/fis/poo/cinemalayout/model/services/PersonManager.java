/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fis.poo.cinemalayout.model.services;

import fis.poo.cinemalayout.model.entities.Cashier;
import fis.poo.cinemalayout.model.entities.Client;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author jordy
 */
public class PersonManager {
    String fileNameCl = "clientReg.txt";
    String fileNameCs = "cahsierReg.txt";    
    
    public void registerClient(Component fr, String username, String namesP, String lastnamesP, String password, String email, int id){
        File file = new File(fileNameCl);   
        Client client = new Client(username, namesP, lastnamesP, password, id, email); 
        String content = client.toCSV();        
            try{
            //if the file doesn't exist, it will be generated. 
            if(file.exists()){
                file.createNewFile();   
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true); 
            fw.write(content);
            fw.close(); 
            JOptionPane.showMessageDialog(fr, "The user has been created successfully!", "Policinema", JOptionPane.OK_OPTION);
        }catch(IOException e){
            e.printStackTrace(); 
            JOptionPane.showMessageDialog(fr, "FATAL ERROR", "Alert!", JOptionPane.ERROR_MESSAGE);            
        }       
    }
    
    public void registerCashier(Component fr, String username, String namesP, String lastnamesP, String password){
        File file = new File(fileNameCs);
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
        JOptionPane.showMessageDialog(fr, "The cashier has been created successfully!", "Policinema", JOptionPane.DEFAULT_OPTION);
        }catch(IOException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(fr, "FATAL ERROR", "Alert!", JOptionPane.ERROR_MESSAGE);
        }       
    }
    public ArrayList<Client> clients(Component fr){
        String line; 
        String csvSeparator = ","; 
        ArrayList<Client> clients = new ArrayList<>();
        
        try(BufferedReader br = new BufferedReader(new FileReader(fileNameCl))){
            
            while((line = br.readLine()) != null){
                String[] data = line.split(csvSeparator);
                Client client = new Client(data[0], data[1], data[2], Integer.parseInt(data[3]), data[4], data[5]);
                clients.add(client); 
            }
            
        }catch(IOException e){
            JOptionPane.showMessageDialog(fr,"There was an exception at FileReader.", "WARNING!", JOptionPane.ERROR_MESSAGE);
            clients.clear(); 
        }
        
        return clients; 
    }
    
    public ArrayList<Cashier> cashiers(Component fr){
        String line; 
        String csvSeparator = ","; 
        ArrayList<Cashier> cashiers = new ArrayList<>();
        
        try(BufferedReader br = new BufferedReader(new FileReader(fileNameCs))){

            while((line = br.readLine()) != null){
                String[] data = line.split(csvSeparator);
                Cashier cashier = new Cashier(data[0], data[1], data[2], data[3]);
                cashiers.add(cashier); 
            }
            
        }catch(IOException e){
            JOptionPane.showMessageDialog(fr,"There was an exception at FileReader.", "WARNING!", JOptionPane.ERROR_MESSAGE);
            cashiers.clear(); 
        }       
        return cashiers;         
    }    
}
