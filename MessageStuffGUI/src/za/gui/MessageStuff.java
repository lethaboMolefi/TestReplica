/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.gui;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import za.ac.tut.encryptmessage.EncryptMessage;
import za.ac.tut.message.Message;

/**
 *
 * @author Lethabom
 */
public class MessageStuff extends JFrame {

    private JPanel headingPnl;
    private JPanel textAreaPnl;
    private JPanel mainPnl;

    private JLabel headingLbl;

    private JTextArea textArea1;
    private JTextArea textArea2;
    private JScrollPane scroll1;
    private JScrollPane scroll2;

    private JMenuBar bar;

    private JMenuItem openFile;
    private JMenuItem encryptFile;
    private JMenuItem saveFile;
    private JMenuItem closeFile;
    private JMenuItem clearTextArea;

    private JMenu file;

    public MessageStuff() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocation(700, 300);

        bar = new JMenuBar();

        openFile = new JMenuItem("Open File...");
        openFile.addActionListener(new OpenFileClicked());
        encryptFile = new JMenuItem("Encrypt File...");
        encryptFile.addActionListener(new EncryptFileClicked());
        saveFile = new JMenuItem("Save File...");
        saveFile.addActionListener(new SaveFileClicked());
        clearTextArea = new JMenuItem("Clear...");
        clearTextArea.addActionListener(new ClearTextAreaClicked());
        closeFile = new JMenuItem("Close File...");
        closeFile.addActionListener(new CloseFileClicked());

        file = new JMenu("File");

        headingPnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
        textAreaPnl = new JPanel(new BorderLayout());
        mainPnl = new JPanel(new BorderLayout());

        headingLbl = new JLabel("Message Encrypt");
        headingLbl.setBorder(new BevelBorder(BevelBorder.RAISED, Color.yellow, Color.black));

        textArea1 = new JTextArea(10, 10);
        textArea1.setEditable(false);
        textArea2 = new JTextArea(10, 10);
        textArea2.setEditable(false);
        scroll1 = new JScrollPane(textArea1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll2 = new JScrollPane(textArea2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        file.add(openFile);
        file.add(encryptFile);
        file.add(saveFile);
        file.add(clearTextArea);
        file.add(closeFile);

        bar.add(file);

        headingPnl.add(headingLbl);

        textAreaPnl.add(scroll1, BorderLayout.LINE_START);
        textAreaPnl.add(scroll2, BorderLayout.LINE_END);

        mainPnl.add(bar, BorderLayout.NORTH);
        mainPnl.add(headingPnl, BorderLayout.CENTER);
        mainPnl.add(textAreaPnl, BorderLayout.SOUTH);

        add(mainPnl);
        setVisible(true);

        pack();

    }

    private class OpenFileClicked implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fl = new JFileChooser();
            String data, record = "";
            int choosen = fl.showOpenDialog(MessageStuff.this);
            if (choosen == JFileChooser.APPROVE_OPTION) {
                File f = (fl.getSelectedFile());
//            System.out.println(fl.getCurrentDirectory().getAbsolutePath());
                try {
                    FileReader fr = new FileReader(f);
                    BufferedReader br = new BufferedReader(fr);

                    while ((data = br.readLine()) != null) {
                        record += data + "\n";
                    }
                    textArea1.setText(record);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Bad");
                }

            }
        }

    }

    private class EncryptFileClicked implements ActionListener {

        public String encryptedMessage;

        @Override
        public void actionPerformed(ActionEvent e) {
            Message myMessage = new Message(textArea1.getText());
//            System.out.println("1"+textArea1.getText());
            textArea1.setText("");
//            System.out.println("2"+textArea1.getText());
//            System.out.println("3"+m.getPlainText());
            EncryptMessage encryptor = new EncryptMessage();
//            System.out.println("4"+textArea2.getText());
            encryptor.encryptMessage(myMessage);
            textArea2.setText(encryptor.getnText());
//            System.out.println("5"+textArea2.getText());
//            System.out.println("6"+em.getnText());
        }

    }

    private class SaveFileClicked implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fc = new JFileChooser();
            String path = "";
            int chosen = fc.showSaveDialog(rootPane);

            if (path.isEmpty()) {
                if (chosen == JFileChooser.APPROVE_OPTION) {
                    path = fc.getSelectedFile().getAbsolutePath();
                    File f = new File(path);
                    writeTo(f);
                }
            } else {
                if (chosen == JFileChooser.APPROVE_OPTION) {
                    File f = new File(path);
                    writeTo(f);
                }
            }

        }

    }

    private void writeTo(File f) {
        try {
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(textArea2.getText());

            bw.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, "boohoo IO");
        }
    }

    private class ClearTextAreaClicked implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            textArea1.setText("");
            textArea2.setText("");
        }

    }

    private class CloseFileClicked implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }

    }

}

