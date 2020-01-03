import java.util.ArrayList;
import java.util.List;

public class USDollarFactory implements CurrencyCreator{
   private static List<String> lista;
   public USDollarFactory(){
      lista = new ArrayList<String>();
      lista.add("United States of America");lista.add("The British Virgin Islands");
      lista.add("The British Turks");lista.add("Caicos islands");
      lista.add("Republic of Palau");lista.add("Marshall Islands");
      lista.add("Federated States of Micronesia");lista.add("Commonwealth of the Northern Mariana Islands");
      lista.add("Democratic Republic of Timor-Leste");lista.add("American Samoa");
      lista.add("Guam");lista.add("Virgin islands of the United States");
      lista.add("Republic of El Salvador");lista.add("Republic of Zimbabwe");
      lista.add("Commonwealth of Puerto Rico");lista.add("Ecuador");    
   }
   public Currency createCurrency(){
      return new USDollar(lista);
   }
}