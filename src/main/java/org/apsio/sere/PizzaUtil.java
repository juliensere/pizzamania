package org.apsio.sere;

import org.apsio.sere.model.Pizza;

import java.util.ArrayList;
import java.util.List;

public class PizzaUtil {

    public static List<Pizza> getPizzas() {
        ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
        Pizza chevreMiel = new Pizza("Ch\u00e8vre-Miel", "fine", "tomate", true, false, false, false);
        Pizza magret = new Pizza("Magret", "fine", "tomate", false, false, true, true);
        Pizza fromage = new Pizza("4 Fromages", "epaisse", "creme", false, true, false, false);
        Pizza anchois = new Pizza("Anchois", "epaisse", "tomate", false, true, true, false);
        chevreMiel.setImage(PizzaImages.chevre);
        magret.setImage(PizzaImages.magret);
        fromage.setImage(PizzaImages.fromage);
        anchois.setImage(PizzaImages.anchois);
        pizzas.add(chevreMiel);
        pizzas.add(magret);
        pizzas.add(fromage);
        pizzas.add(anchois);
        return pizzas;
    }

}
