
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

// https://www.dropbox.com/sh/6qedwvrutk39xo7/AAC8rBF3SDG2ewMai4-rmCSoa?dl=0
// https://goo.gl/jT5qns

public interface Currency {
    String getAbbreviation();
    double getPerUnitDollarExchange();
    List<String> getCountriesUsingTheCurrency();   
}
