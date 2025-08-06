/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package fis.poo.cinemalayout;

import fis.poo.cinemalayout.controller.Controller;
import fis.poo.cinemalayout.model.entities.Cashier;
import fis.poo.cinemalayout.model.entities.Client;
import fis.poo.cinemalayout.model.entities.Recipe;
import fis.poo.cinemalayout.model.entities.Reservation;
/**
 *
 * @author jordy
 */
public class CinemaLayout {
    
    public static void main(String[] args) {
        Client cln = new Client();
        Cashier csh = new Cashier();
        
        Controller cinema = new Controller(cln, csh);
    }
}
