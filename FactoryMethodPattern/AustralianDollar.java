import java.util.ArrayList;
import java.util.List;

public class AustralianDollar implements Currency {
   private  List<String>countries;
   public AustralianDollar(List<String> lista){
      countries = lista;      
   }
   public String getAbbreviation(){
       return "AUD";
   }
   public double getPerUnitDollarExchange(){
       return 0.75;
   }
   public List<String> getCountriesUsingTheCurrency(){
      return  countries;
   }
   public void setCountriesUsingTheCurrency(String c){
      if(!countries.contains(c))countries.add(c);
   }    
}