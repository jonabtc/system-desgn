
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dfellig
 */
public class USDollar implements Currency {
   private  List<String>countries;// = new List<String>();;
   public USDollar(List<String> lista){
      countries = lista;      
   }
   public String getAbbreviation(){
       return "USD";
   }
   public double getPerUnitDollarExchange(){
       return 1.0;
   }
   public List<String> getCountriesUsingTheCurrency(){
      return  countries;
   }
   public void setCountriesUsingTheCurrency(String c){
      if(!countries.contains(c))countries.add(c);
   }    
}
