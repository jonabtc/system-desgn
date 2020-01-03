
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
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
public class TextCmd implements ActionListener {

    private JTextField cmdField;
    private static TicTacToeApp ticTacToeApp;
    private JPanel panel;
    private ArrayList<JButton> panelBtns;
    private Adapter adapter = null;

    TextCmd() {
        adapter = Adapter.getAdapterInst();
        ticTacToeApp = TicTacToeApp.getTicTacToeInst();
        cmdField = ticTacToeApp.getCmdField();
        cmdField.addActionListener(this);
        panel = ticTacToeApp.getPanel();
        Font f = new java.awt.Font(Font.SANS_SERIF, Font.PLAIN, 32);
        for (int i = 0; i < 9; i++) {
            JButton square = new JButton("");
            square.setFont(f);
            square.setBackground(Color.WHITE);
            square.addActionListener(this);
        }

    }
    public void setcmdField(JTextField field){
    	cmdField = field;
    }

    public void actionPerformed(ActionEvent evt) {
    	int numero = Integer.parseInt(cmdField.getText());
    	ActionEvent e;
    	for (int i=0;i<9;i++)
    		if(evt.getSource().equals(panelBtns.get(i))){
    			e = evt;
    			numero = i;
    		}
    	if(evt.getSource().equals(cmdField))
    		panel.setTransferHandler();
    		panelBtns.get(numero).doClick();
    				
    			
    	
    }
}
