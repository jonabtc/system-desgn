import java.util.ArrayList;
import java.util.List;

public class AustralianDollarFactory implements CurrencyCreator{
   private static List <String> lista;
   public AustralianDollarFactory(){
      lista = new ArrayList<String>();
      lista.add("Australia");lista.add("Cocos (Keeling) Islands");
      lista.add("Kiribati");lista.add("Norfolk Island");
      lista.add("Christmas Island");lista.add("Heard and McDonald Islands");
      lista.add("Nauru");lista.add("Tuvalu");
   }
   public Currency createCurrency(){
      return new USDollar(lista);
   }
}