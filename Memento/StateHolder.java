import java.util.ArrayList;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dfellig
 */
public class StateHolder {
    private ArrayList<TicTacToeApp.Memento> backup;
    StateHolder(){
    	backup = new ArrayList<TicTacToeApp.Memento>();
    }
    public TicTacToeApp.Memento getBackup(int index){
    	return backup.get(backup.size()-1);
    }
    public void setBackup(TicTacToeApp.Memento ob){
    	backup.add(ob);
    }
    public int getSize(){
    	return backup.size();
    }
}
