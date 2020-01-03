
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
public class ComputerComponentProblem implements ProblemItem {

    private String name;
    private ArrayList problemItems = new ArrayList();
    private Technician owner;
    private Technician assignedTech;
    private String techExpertise;
    private String details;
    private ProblemItem parent;

    public ComputerComponentProblem(ProblemItem newParent) {
        this(newParent, "", "", null);
    }

    public ComputerComponentProblem(ProblemItem newParent, String newName,
            String newDetails, Technician newAssignedTech) {
        Integer numTechs;
        parent = newParent;
        name = newName;
        assignedTech = newAssignedTech;
        details = newDetails;
        techExpertise = newAssignedTech.getExpertise();
        owner=newParent.getOwner();
        
        
    }

    public Technician getOwner() {
        
            determineOwner();
        
        return owner;
    }

    public String getDetails() {
        if (details != null) {
            return details;
        } else {
            return parent.getDetails() + EOL_STRING + "\t" + details;
        }
    }

    private void determineOwner() {
       if(!techExpertise.equals(assignedTech.HW)||!techExpertise.equals(assignedTech.OS)){
    	   if(((TechnicianImpl)assignedTech).getEstado()==false)
    	   owner = assignedTech;
       }
       addProblemItem(parent);
    }

    public String getName() {
        return name;
    }

    public ArrayList getProblemItems() {
        return problemItems;
    }

    public ProblemItem getParent() {
        return parent;
    }

    public void setName(String newName) {
        name = newName;
    }

    public void setOwner(Technician newOwner) {
        owner = newOwner;
    }

    public void setParent(ProblemItem newParent) {
        parent = newParent;
    }

    public void setDetails(String newDetails) {
        details = newDetails;
    }

    public void addProblemItem(ProblemItem element) {
        if (!((TechnicianImpl)assignedTech).getEstado()) {
            problemItems.add(element);
            ((TechnicianImpl)assignedTech).setEstado(true);
        }
    }

    public void removeProblemItem(ProblemItem element) {
        problemItems.remove(element);
    }

    public String toString() {
        return name;
    }
}
