/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package za.ac.tut.message.Message;


/**
 *
 * @author Lethabom
 */
public class Message {

    /**
     * @param args the command line arguments
     */
    
    private String plainText;
    private int length;

    public Message() {
    }

    public Message(String plainText) {
        this.plainText = plainText;
    }

    public String getPlainText() {
        return plainText;
    }

    public void setPlainText(String plainText) {
        this.plainText = plainText;
    }
    
}
