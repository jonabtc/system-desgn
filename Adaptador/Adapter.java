
import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dfellig
 */
public class Adapter {

    private static Adapter adapterInst = new Adapter();
     private JTextField cmdField;
    private static TicTacToeApp ticTacToeApp;
    private JPanel panel;
    private TextCmd textCmd;

    public Adapter(){
        ticTacToeApp = new TicTacToeApp();
        textCmd = new TextCmd();
    }
    public static Adapter getAdapterInst() {
        return adapterInst;
        
        	
    }
    
     public void initAdapter() {
         
     }
}
