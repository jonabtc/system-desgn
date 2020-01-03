public class Factory{
   public static Currency factoryMhetod(String abr){      
      if(abr.equals("USD")) return new USDollarFactory().createCurrency();
      if(abr.equals("JPY")) return new JapaneseYenFactory().createCurrency();
      if(abr.equals("AUD")) return new AustralianDollarFactory().createCurrency();
      return null;
   }
}