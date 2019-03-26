package fr.isima.calcul.model;

public class Multiplication extends Operation {


    public Multiplication(int a, int b) {
        super(a, b);
    }

    public void calculer(){
        result = a * b;
    }

}
