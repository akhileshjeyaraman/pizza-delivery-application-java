package com.company.AJ;

public class PizzaMain {

    public static void main(String[] args) {

        PizzaUI pizzaUI=new PizzaUI();

        pizzaUI.setTitle("Vidyalankar Pizzas");
        pizzaUI.setResizable(false);
        pizzaUI.setVisible(true);
        pizzaUI.setSize(900,850);

        /*Make the frame in center*/
        pizzaUI.setLocationRelativeTo(null);

    }
}
