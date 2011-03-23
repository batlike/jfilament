package snakeprogram3d;

/**
 *
 *       Copyright (c) 2010, Lehigh University
 *       All rights reserved.
 *       see COPYING for license.
 * 
 *    Simplest way to start the program either as a plugin or an application
 *
 **/


import ij.IJ;
import ij.ImagePlus;

import javax.swing.*;

public class SnakeApplication{
    
   public static int MAXLENGTH=1500;
    
   final public static String VERSION = "0.71";

   /**
    * From the command line.
    *
    * @param args cmd line arguments not used.
    */
   public static void main(String args[]) {

       setProperties();

       final SnakeModel sm = new SnakeModel();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                sm.getFrame().setVisible(true);
            }
        });
        
    }
    
    /**
     * As a plugin.
     */
    public static void runAsPlugin() {
            setProperties();
            final SnakeModel sm = new SnakeModel();
            sm.getFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            final ImagePlus implus = IJ.getImage();

            sm.loadImage(implus);
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    sm.getFrame().setVisible(true);
                }
            });
	}

    /**
     * Sets the Maximum Number of points in a filament.
     */
    public static void setProperties(){
        if(System.getProperty("max.length")!=null)
           try{
                MAXLENGTH=Integer.parseInt(System.getProperty("max.length"));
           } catch(Exception e){
                //MAXLENGTH remains 1500
           }

    }
   }
