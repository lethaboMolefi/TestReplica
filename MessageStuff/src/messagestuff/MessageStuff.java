/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package messagestuff;

import javax.swing.JFrame;
import za.gui.MessageStuffGUI;

/**
 *
 * @author Lethabom
 */
public class MessageStuff {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MessageStuffGUI frame =new MessageStuffGUI();
        
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLocation(700, 300);
        
//        frame.pack();
    }
    
}
