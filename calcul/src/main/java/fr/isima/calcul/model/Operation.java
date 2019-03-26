package fr.isima.calcul.model;

public abstract class Operation {
    int a;
    int b;
    int result;

    public Operation(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public abstract void calculer();

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getResult() {
        return result;
    }
}
