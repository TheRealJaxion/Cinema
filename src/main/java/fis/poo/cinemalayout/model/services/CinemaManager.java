/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fis.poo.cinemalayout.model.services;

import fis.poo.cinemalayout.model.entities.Function;
import fis.poo.cinemalayout.model.entities.Movie;
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
public class CinemaManager {

    String fileNameM = "movieReg.txt";
    String fileNameD = "movieDesc.txt";
    String fileNameF = "functionReg.txt";
    File fileM = new File(fileNameM);
    File fileD = new File(fileNameD);
    File fileF = new File(fileNameF);    
    
    public void setMovies(String nameM, int duration, String restriction){
        Movie movie = new Movie(nameM, duration, restriction);
        String content = movie.toCSV();
        
        try{
            if(fileM.exists()){
                fileM.createNewFile();   
            }
            FileWriter fw = new FileWriter(fileM.getAbsoluteFile(), true); 
            fw.write(content);
            fw.close(); 
            JOptionPane.showConfirmDialog(null, "Movie saved succesfully!", "Policinema", JOptionPane.DEFAULT_OPTION);
        }catch(IOException e){
            JOptionPane.showConfirmDialog(null,"There was an exception at FileWritter.(cn.fw.mv)", "WARNING!", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(); 
        } 
    }
    
    public void setDesc(String description){
        String content = " "+description + "||"; 
        
        try{
            if(fileD.exists()){
                fileD.createNewFile();   
            }
            FileWriter fw = new FileWriter(fileD.getAbsoluteFile(), true); 
            fw.write(content);
            fw.close(); 
            JOptionPane.showConfirmDialog(null, "Movie saved succesfully!", "Policinema", JOptionPane.DEFAULT_OPTION);
        }catch(IOException e){
            JOptionPane.showConfirmDialog(null,"There was an exception at FileWritter.(cn.fw.mv)", "WARNING!", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(); 
        } 
    }
    
    public void setFunction(Movie movieD, String schedule, char hall, int nHall){
        Function func = new Function(movieD, schedule, hall, nHall);
        String content = func.toCSV(); 
        try{
            if(fileF.exists()){
                fileF.createNewFile();   
            }
            FileWriter fw = new FileWriter(fileF.getAbsoluteFile(), true); 
            fw.write(content);
            fw.close(); 
            JOptionPane.showConfirmDialog(null, "Function saved succesfully!", "Policinema", JOptionPane.DEFAULT_OPTION);
        }catch(IOException e){
            JOptionPane.showConfirmDialog(null,"There was an exception at FileWritter.(cnm.fw.fc)", "WARNING!", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(); 
        }         
    }
    
    public ArrayList<Movie> movies(){
        String line; 
        String csvSeparator = ","; 
        ArrayList<Movie> movies = new ArrayList<>();
        
        try(BufferedReader br = new BufferedReader(new FileReader(fileNameM))){
            
            br.readLine();
            
            while((line = br.readLine()) != null){
                String[] data = line.split(csvSeparator);
                Movie movie = new Movie(data[0], Integer.parseInt(data[1]), data[2]);
                movies.add(movie); 
                System.out.println("readed!");
            }
            
        }catch(IOException e){
            JOptionPane.showConfirmDialog(null,"There was an exception at FileReader.(cnm.fr.mvA)", "WARNING!", JOptionPane.ERROR_MESSAGE);
            movies.clear(); 
        }
        
        return movies; 
    }
    
    public ArrayList<String> descriptions(){
        String line;
        String csvSeparator = "||";
        ArrayList<String> descriptions = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(fileNameF))){
                        
            while((line = br.readLine()) != null){
                String[] data = line.split(csvSeparator);
                String description = data[0];
                descriptions.add(description); 
            }
            
        }catch(IOException e){
            JOptionPane.showConfirmDialog(null,"There was an exception at FileReader.(cnm.fr.fcA)", "WARNING!", JOptionPane.ERROR_MESSAGE);
            descriptions.clear(); 
        }       
        return descriptions;         
    }
    
    public ArrayList<Function> functions(){
        String line; 
        String csvSeparator = ","; 
        ArrayList<Function> functions = new ArrayList<>();
        
        try(BufferedReader br = new BufferedReader(new FileReader(fileNameF))){
            
            br.readLine();
            
            while((line = br.readLine()) != null){
                String[] data = line.split(csvSeparator);
                Function function = new Function(data[0], Integer.parseInt(data[1]), data[2], data[3].charAt(0), Integer.parseInt(data[4]));
                functions.add(function); 
            }
            
        }catch(IOException e){
            JOptionPane.showConfirmDialog(null,"There was an exception at FileReader.(cnm.fr.fcA)", "WARNING!", JOptionPane.ERROR_MESSAGE);
            functions.clear(); 
        }       
        return functions;         
    }        
}
