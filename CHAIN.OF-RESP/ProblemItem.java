/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dfellig
 */
import java.io.Serializable;
import java.util.ArrayList;

public interface ProblemItem extends Serializable {

    public static final String EOL_STRING = System.getProperty("line.separator");

    public ProblemItem getParent();

    public Technician getOwner();

    public String getDetails();

    public ArrayList getProblemItems();
    
    public void addProblemItem(ProblemItem element);
    
    public void removeProblemItem(ProblemItem element);
}
