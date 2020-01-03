/*
 * To change this license header, choose License Headers in ComputerProblem Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dfellig
 */
import java.util.ArrayList;


public class ComputerProblem implements ProblemItem, ExpertiseAreas {

    private String expertise;
    private Technician assignedTech;
    private Technician owner;
    private String details;
    private ArrayList problemItems = new ArrayList();
   

    public ComputerProblem() {
        
    }

    
    public ComputerProblem(String newExpertise, String newDetails, Technician newAssignedTech) {
        expertise = newExpertise;
        assignedTech = newAssignedTech;
        details = newDetails;
        owner = newAssignedTech;
    }

    public String getExpertise() {
        return expertise;
    }

    public String getDetails() {
        return details;
    }

    public Technician getOwner() {
        return owner;
    }

    public ProblemItem getParent() {
        return null;
    }

    public ArrayList getProblemItems() {
        return problemItems;
    }

    public void setName(String newName) {
        expertise = newName;
    }

    public void setOwner(Technician newOwner) {
        owner = newOwner;
    }

    public void setDetails(String newDetails) {
        details = newDetails;
    }

    public void addProblemItem(ProblemItem element) {
        if (!problemItems.contains(element)) {
            problemItems.add(element);
        }
    }

    public void removeProblemItem(ProblemItem element) {
        problemItems.remove(element);
    }

    public String toString() {
        return expertise;
    }
}
