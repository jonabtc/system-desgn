import java.util.ArrayList;
import java.util.List;
public class JapaneseYenFactory implements CurrencyCreator{
   private static List <String> lista;

   public JapaneseYenFactory(){
      lista = new ArrayList<String>();
      lista.add("Japan");
   }
   public Currency createCurrency(){
      return new USDollar(lista);
   }
}