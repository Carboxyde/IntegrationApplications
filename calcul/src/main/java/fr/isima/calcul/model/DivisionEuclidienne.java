package fr.isima.calcul.model;

public class DivisionEuclidienne extends Operation {

    int reste;

    public DivisionEuclidienne(int a, int b) {
        super(a, b);
    }

    public void calculer(){
        result = a / b;
        reste = a % b;
    }

    public int getReste() {
        return reste;
    }
}
