import java.util.ArrayList;
import java.util.List;

public class JapaneseYen implements Currency {
   private  List<String> countries;
   
   public JapaneseYen(List<String> lista){
      countries = lista;      
   }
   public String getAbbreviation(){
       return "JPY";
   }
   public double getPerUnitDollarExchange(){
       return 0.0088;
   }
   public List<String> getCountriesUsingTheCurrency(){
      return  countries;
   }
   public void setCountriesUsingTheCurrency(String c){
      if(!countries.contains(c))countries.add(c);
   }
    
}