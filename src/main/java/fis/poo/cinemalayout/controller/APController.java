/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fis.poo.cinemalayout.controller;

import fis.poo.cinemalayout.model.entities.Cashier;
import fis.poo.cinemalayout.model.entities.Function;
import fis.poo.cinemalayout.model.entities.Movie;
import fis.poo.cinemalayout.model.services.CinemaManager;
import fis.poo.cinemalayout.model.services.ImageManager;
import fis.poo.cinemalayout.model.services.PersonManager;
import fis.poo.cinemalayout.model.services.PricePolicy;
import fis.poo.cinemalayout.model.entities.Recipe;
import fis.poo.cinemalayout.model.services.Verificator;
import fis.poo.cinemalayout.view.AdminPanel;
import fis.poo.cinemalayout.view.CashierPanel;
import fis.poo.cinemalayout.view.HiddenView;
import fis.poo.cinemalayout.view.MainLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 *
 * @author jordy
 */
public class APController{
/*    
    private AdminPanel adm;
    private CHController ch; 
    private HiddenView hdn;
    private MainLayout mnl;
    private CashierPanel csh;
    private Cashier cshr;
    private PricePolicy prp = new PricePolicy();
    private Recipe rp;
    private ImageManager img = new ImageManager();
    private Function fn;
    private PersonManager pm = new PersonManager();
    private CinemaManager cn = new CinemaManager();
    private Verificator vf = new Verificator();

    public APController(AdminPanel adm, CHController ch, HiddenView hdn, MainLayout mnl, CashierPanel csh, Cashier cshr, Function fn, Recipe rp) {
        this.adm = adm;
        this.ch = ch;
        this.hdn = hdn;
        this.mnl = mnl;
        this.csh = csh;
        this.cshr = cshr;
        this.fn = fn;
        this.rp = rp;
        for(JButton btns : adm.buttons()){
            btns.addActionListener(this);
        }
        this.adm.model.addColumn("Name");
        this.adm.model.addColumn("Duration");
        this.adm.model.addColumn("Restriction");          
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent ev) {
        if(adm.isActive()){
            if(ev.getSource() == adm.showInfo){
                for(int i=0; i<cn.movies().size(); i++){
                    Movie movie = cn.movies().get(i);
                    Object ob = movie; 
                    adm.model.addRow((Object[]) ob);
                }
                adm.setV(adm.info, adm);
            } else if(ev.getSource() == adm.setMovies){
                adm.setV(adm.movieSet, adm);
            } else if(ev.getSource() == adm.nCashier){
                adm.setV(adm.newCashier, adm);
            } else if(ev.getSource() == adm.setPr){
                adm.promN1.setText(prp.getProm1());
                adm.promN2.setText(prp.getProm2());
                adm.promN3.setText(prp.getProm3());
                adm.promN4.setText(prp.getProm4());
                
                adm.pprom1.setText(Double.toString(prp.getPprom1()));
                adm.pprom2.setText(Double.toString(prp.getPprom2()));
                adm.pprom3.setText(Double.toString(prp.getPprom3()));
                adm.pprom4.setText(Double.toString(prp.getPprom4()));
                
                adm.priceSH.setText(Double.toString(prp.getSeatPriceH()));
                adm.priceSI.setText(Double.toString(prp.getSeatPriceI()));
                adm.taxT.setText(Double.toString(prp.getTaxPer()));
                
                adm.setV(adm.pricePanel, adm);
            } else if(ev.getSource() == adm.logout){
                adm.setVisible(false);
                hdn.setVisible(true);
            }
        }
        
        if(hdn.isActive()){
            if(ev.getSource() == hdn.hiddenAdm){
                String pass = JOptionPane.showInputDialog(hdn, "Type the secret code.", "Restringed Acces");
                if(pass.equals("admntest3")){
                    JOptionPane.showMessageDialog(null, "Access Guaranted!", "Policinema", JOptionPane.OK_OPTION);
                    hdn.setVisible(false);
                    adm.setVisible(true);
                } else{
                    JOptionPane.showMessageDialog(null, "Incorrect code!", "Alert!", JOptionPane.ERROR);
                }
                
            } else if(ev.getSource() == hdn.hiddenCash){
                hdn.loginCs.setVisible(true);
            }
        }
        
        if(ev.getSource() == hdn.loginCs){
            String username = hdn.cshT.getText();
            String password = new String(hdn.pwF.getPassword()); 
            if(vf.verifier("cashier", username, password)){
                cshr = pm.cashiers().get(vf.getPosCh());
                hdn.setVisible(false);
                hdn.loginCs.setVisible(false);
                csh.displayC.setText(cshr.getNamesP());
                for(Function fns : cn.functions()){
                    csh.functionCB.addItem(fns.getFunctionId());
                }
                csh.setVisible(true);
            } else{
                hdn.alertM();
                hdn.clear(hdn.cshT, hdn.pwF);
            }  
        }
        
        if(adm.isAct(adm.newCashier)){
            if(ev.getSource() == adm.backB){
                adm.setV(adm, adm.newCashier);
            } else if(ev.getSource() == adm.regcashB){
                if(adm.isEmp(adm.ncs())){
                    adm.alertM(adm.ncs());
                } else{
                    pm.registerCashier(adm.getTI(adm.nT), adm.getTI(adm.unT), adm.getTI(adm.lnT), adm.getTI(adm.pwT));
                    adm.refresh(adm.ncs());
                }
            }
        }
        
        if(adm.info.isActive()){
           if(ev.getSource() == adm.gbB){
               adm.info.setVisible(false);
               adm.setVisible(true);
           }
        }
        
        if(adm.pricePanel.isActive()){
            if(ev.getSource() == adm.svp1){
                if(adm.isEmpt(adm.pprom1T)){
                    adm.alertM(adm.pr());
                } else{
                    prp.setPprom1(Double.parseDouble(adm.getTI(adm.pprom1T)));
                }
            } else if(ev.getSource()== adm.svp2){
                
                if(adm.isEmpt(adm.pprom2T)){
                    adm.alertM(adm.pr());
                } else{
                    prp.setPprom2(Double.parseDouble(adm.getTI(adm.pprom2T)));
                }
            } else if(ev.getSource()== adm.svp3){
                
                if(adm.isEmpt(adm.pprom3T)){
                    adm.alertM(adm.pr());
                } else{
                    prp.setPprom3(Double.parseDouble(adm.getTI(adm.pprom3T)));
                }
            } else if(ev.getSource()== adm.svp4){
                
                if(adm.isEmpt(adm.pprom4T)){
                    adm.alertM(adm.pr());
                } else{
                    prp.setPprom4(Double.parseDouble(adm.getTI(adm.pprom4T)));
                }
            } else if(ev.getSource() == adm.svsH){
                if(adm.isEmpt(adm.priceH)){
                    adm.alertM(adm.pr());
                } else{
                    prp.setSeatPriceH(Double.parseDouble(adm.getTI(adm.priceH)));
                }
            } else if(ev.getSource() == adm.svsI){
                if(adm.isEmpt(adm.priceI)){
                    adm.alertM(adm.pr());
                } else{
                    prp.setSeatPriceI(Double.parseDouble(adm.getTI(adm.priceI)));
                }
            } else if(ev.getSource() == adm.svt){
                if(adm.isEmpt(adm.taxF)){
                    adm.alertM(adm.pr());
                } else{
                    prp.setSeatPriceI(Double.parseDouble(adm.getTI(adm.taxF)));
                }           
            }else if(ev.getSource() == adm.saveAll){
                if(adm.isEmp(adm.pr())){
                    adm.alertM(adm.pr());
                } else{
                    prp.setPprom1(Double.parseDouble(adm.getTI(adm.pprom1T)));
                    prp.setPprom2(Double.parseDouble(adm.getTI(adm.pprom2T)));
                    prp.setPprom3(Double.parseDouble(adm.getTI(adm.pprom3T)));
                    prp.setPprom4(Double.parseDouble(adm.getTI(adm.pprom4T)));
                    prp.setSeatPriceI(Double.parseDouble(adm.getTI(adm.priceI)));
                    prp.setSeatPriceH(Double.parseDouble(adm.getTI(adm.priceH)));
                    prp.setTaxPer(Double.parseDouble(adm.getTI(adm.taxF)));
                    JOptionPane.showConfirmDialog(null, "Prices has been set succesfully.", "Finished", JOptionPane.OK_OPTION);
                    adm.refresh(adm.pr());
                }    
            } else if(ev.getSource()== adm.gbpB){
                adm.pricePanel.setVisible(false);
                adm.setVisible(true);
                adm.setLocationRelativeTo(null);
            }   
        }
        
        if(adm.movieSet.isActive()){
            if(ev.getSource() == adm.selimgM){
                JFileChooser fc = new JFileChooser(); 
                fc.setDialogTitle("Save Imgage As");
                
                FileNameExtensionFilter pngF = new FileNameExtensionFilter("PNG Files (*.png)", "png");
                fc.addChoosableFileFilter(pngF);
                fc.setFileFilter(pngF);
                
                int userSel = fc.showSaveDialog(null);
                if(userSel == JFileChooser.APPROVE_OPTION){
                    File imgSelPath = fc.getSelectedFile();
                    img.mainImg(imgSelPath);
                }
            }else if(ev.getSource() == adm.selimgF){
                JFileChooser fc = new JFileChooser(); 
                fc.setDialogTitle("Save Imgage As");
                
                FileNameExtensionFilter pngF = new FileNameExtensionFilter("PNG Files (*.png)", "png");
                fc.addChoosableFileFilter(pngF);
                fc.setFileFilter(pngF);
                
                int userSel = fc.showSaveDialog(null);
                if(userSel == JFileChooser.APPROVE_OPTION){
                    File imgSelPath = fc.getSelectedFile();
                    img.functImg(imgSelPath);
                }
            } else if(ev.getSource() == adm.setF){
                if(adm.isEmp(adm.mvs())){
                    adm.alertM(adm.mvs());
                } else{
                    cn.setMovies(adm.getTI(adm.mN), Integer.parseInt(adm.getTI(adm.mD)), (String) adm.ageR.getSelectedItem());
                    mnl.addDes(adm.getTI(adm.mvdesc));
                    adm.mvTitle.setText(adm.getTI(adm.mN));
                    adm.refresh(adm.mvs());
                    adm.movieSet.setVisible(false);
                    adm.functionGenerator.setVisible(true);
                    adm.functionGenerator.setLocationRelativeTo(null);
                }                
            } else if(ev.getSource() == adm.gbM){
                adm.refresh(adm.mvs());
                adm.setV(adm, adm.movieSet);
            }
        }
        
        if(adm.functionGenerator.isActive()){
            if(ev.getSource() == adm.gnrtF){
                String movSel = adm.getTI(adm.mvTitle);
                for(int i=0; i<cn.movies().size(); i++){
                    Movie mv = cn.movies().get(i); 
                    if(mv.getNameM().equals(movSel)){
                        cn.setFunction(mv, (String) adm.scheduleSel.getSelectedItem(), adm.selH(adm.hallSet), (Integer) adm.numH.getSelectedItem());
                    }
                }
            } else if(ev.getSource() == adm.cancelB){
                adm.setV(adm, adm.functionGenerator);
            }   
        }   
    }*/
}
