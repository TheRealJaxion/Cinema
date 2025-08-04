/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fis.poo.cinemalayout.model.services;

import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author jordy
 */
public class ImageManager {
    String imgType = "png";
    
    public void functImg(Component parent, File imgSelPath) {
        String mainPath = "C:\\Users\\jordy\\Documents\\NetBeansProjects\\CinemaLayout\\src\\main\\resources\\funcl\\"; 
        String fileName = JOptionPane.showInputDialog(parent, "Please, type the image name.");
        
        try {

            BufferedImage img = ImageIO.read(imgSelPath);

            if (img == null) {
                JOptionPane.showMessageDialog(parent,"The image selected couldn't be read.", "Read Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            File dir = new File(mainPath);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            File saveImg = new File(mainPath + fileName + "." + imgType);
            ImageIO.write(img, imgType, saveImg);
            JOptionPane.showMessageDialog(parent, "The image has been successfully saved!","Image Saved",JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(parent, "FATAL ERROR while saving image!", "Saving Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }    
    
    public void mainImg(Component parent, File imgSelPath) {
        String mainPath = "C:\\Users\\jordy\\Documents\\NetBeansProjects\\CinemaLayout\\src\\main\\resources\\mainl\\"; 
        String fileName = JOptionPane.showInputDialog(parent, "Please, type the image name.");
        try {

            BufferedImage img = ImageIO.read(imgSelPath);

            if (img == null) {
                JOptionPane.showMessageDialog(parent,"The image selected couldn't be read.", "Read Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            File dir = new File(mainPath);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            File saveImg = new File(mainPath + fileName +"." + imgType);
            ImageIO.write(img, imgType, saveImg);
            JOptionPane.showMessageDialog(parent, "The image has been successfully saved!","Image Saved",JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(parent, "FATAL ERROR while saving image!", "Saving Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }   
    
}
