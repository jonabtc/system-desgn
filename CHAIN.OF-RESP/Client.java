/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dfellig
 */
public class Client implements ExpertiseAreas {

    public static void main(String[] args) {
        
        /* Para probar el codigo que van a escribir, asumir que solo hay los siguientes tecnicos en la compania*/
      
        Technician tech1 = new TechnicianImpl("Joseph", "Mongolfier", OS);
        Technician tech2 = new TechnicianImpl("Jose", "Smith", WIN2000);
        Technician tech3 = new TechnicianImpl("Juan", "Paez", WIN_XP);
        Technician tech4 = new TechnicianImpl("Pedro", "Cobo", WIN7);
        Technician tech5 = new TechnicianImpl("Esteban", "Aguirre", OS8);
        Technician tech6 = new TechnicianImpl("Fausto", "Lema", OS9);
        Technician tech7 = new TechnicianImpl("Miguel", "Leon", OSX);
        Technician tech8 = new TechnicianImpl("David", "Davalos", HW);
        Technician tech9 = new TechnicianImpl("Dennis", "Moore", RAM);
        Technician tech10 = new TechnicianImpl("Donald", "Sierra", CPU);
        Technician tech11 = new TechnicianImpl("Luis", "Ramirez", DISK);
       

        // Entra un cliente con un problema de HW, y se le asigna primero el problema  
        // al tecnico tope en la jerarquia de HW
        ComputerProblem computerProblem1 = new ComputerProblem(HW, RAM, tech8);
        
        // Despues se le asigna el problema al tecnico especialista en RAM  
        ProblemItem problemItem11 = new ComputerComponentProblem(computerProblem1, RAM, "RAM problem", tech9);
        
        // Como esta libre el tecnico especialista en RAM, el se apodera del problema y es el owner.
        System.out.println(problemItem11.getOwner());
        
        // Entra un cliente con un problema de HW, y se le asigna primero el problema  
        // al tecnico tope en la jerarquia de HW
        ComputerProblem computerProblem2 = new ComputerProblem(HW, RAM, tech8);
        
         // Despues se le asigna el problema al tecnico especialista en RAM  
        ProblemItem problemItem21 = new ComputerComponentProblem(computerProblem2, RAM, "RAM problem", tech9);
        
        // Como no esta libre el tecnico especialista en RAM, el "owner" sube en la jerarquia de responsabilidad.
        System.out.println(problemItem21.getOwner());
        
        ComputerProblem compus = new ComputerProblem(HW, RAM, tech8);
        
        ProblemItem problema = new ComputerComponentProblem(compus, RAM, "RAM problem", tech9);
        System.out.println(problema.getOwner());
        // ****** OS Problems  ***********
        
        // Entra un cliente con un problema de OS, especificamente con WIN2000, y se le asigna el problema  
        // al tecnico tope en la jerarquia de OS
        ComputerProblem computerProblem3 = new ComputerProblem(OS, WIN2000, tech1);
        
        // Despues se le asigna el problema al tecnico especialista en WIN2000  
        ProblemItem problemItem31 = new ComputerComponentProblem(computerProblem3, WIN2000, WIN2000, tech2);
         
        // Como esta libre el tecnico especialista en WIN2000, el se apodera del problema y es el owner.
        System.out.println(problemItem31.getOwner());

        // Entra un cliente con un problema de OS, especificamente con WIN2000, y se le asigna el problema  
        // al tecnico tope en la jerarquia de OS.  Al especialista en OS general.
        ComputerProblem computerProblem4 = new ComputerProblem(OS, "WIN2000", tech1);
        
         // Despues se le asigna el problema al tecnico especialista en WIN2000 especificamente  
        ProblemItem problemItem41 = new ComputerComponentProblem(computerProblem4, WIN2000, "Drivers problem", tech2);
        
        // Como no esta libre el tecnico especialista en WIN2000, el "owner" sube en la jerarquia de responsabilidad.
        // En este case el tecnico responsable por todos los problemas el OS se vuelve el "owner" del problema
        System.out.println(problemItem41.getOwner());

       
       
    }
}
