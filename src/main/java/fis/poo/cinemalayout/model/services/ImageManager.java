/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fis.poo.cinemalayout.model.services;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author jordy
 */
public class ImageManager {
    File imgSelPath;
    String imgType = "png";
    
    public void functImg(File imgSelPath){
        String mainPath = "CinemaLayout\\src\\main\\resources\\funcl"; 
        try{
           BufferedImage img = ImageIO.read(imgSelPath);
           
           if(img == null){
               JOptionPane.showConfirmDialog(null, "The image selected couldn't be read", "Alert", JOptionPane.ERROR_MESSAGE); 
               return;
           }
           
           File saveImg = new File(mainPath);
           ImageIO.write(img, imgType, saveImg);
           JOptionPane.showConfirmDialog(null, "The image has been succesfully saved!", "Image Saved", JOptionPane.OK_OPTION); 
            
        }catch(IOException e){
            JOptionPane.showConfirmDialog(null,"FATAL ERROR!", "Warning!", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
    public void mainImg(File imgSelPath){
        String mainPath = "CinemaLayout\\src\\main\\resources\\mainl"; 
        try{
           BufferedImage img = ImageIO.read(imgSelPath);
           
           if(img == null){
               JOptionPane.showConfirmDialog(null, "The image selected couldn't be read", "Alert", JOptionPane.ERROR_MESSAGE); 
               return;
           }
           
           File saveImg = new File(mainPath);
           ImageIO.write(img, imgType, saveImg);
           JOptionPane.showConfirmDialog(null, "The image has been succesfully saved!", "Image Saved", JOptionPane.OK_OPTION); 
            
        }catch(IOException e){
            JOptionPane.showConfirmDialog(null,"FATAL ERROR!", "Warning!", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
}
