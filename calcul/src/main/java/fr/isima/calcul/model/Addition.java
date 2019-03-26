package fr.isima.calcul.model;

public class Addition extends Operation {


    public Addition(int a, int b) {
        super(a, b);
    }

    public void calculer(){
        result = a + b;
    }

}
