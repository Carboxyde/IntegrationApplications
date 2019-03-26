package fr.isima.calcul.model;

public class Soustraction extends Operation {


    public Soustraction(int a, int b) {
        super(a, b);
    }

    public void calculer(){
        result = a - b;
    }

}
