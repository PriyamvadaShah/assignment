package Speed;

import java.util.Random;

public class DataStructure {

    private double[] a;
    private int size;

    public DataStructure() {
        this.size = 0;
        this.a = new double[0];
    }

    public void setSize(int n) {
        this.size = n;
        this.a = new double[n];
    }

    public double[] getArray() {
        return a;
    }

    public int getSize() {
        return size;
    }

    public void setArray(double[] arr) {
        this.size = arr.length;
        this.a = arr;
    }

    public void initArrayRandom(int n, int min, int max) {
        setSize(n);
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            a[i] = min + r.nextInt(max - min + 1);
        }
    }

    public void displayArray() {
        for (double v : a) {
            System.out.print(v + " ");
        }
        System.out.println();
    }

    public void displayArrayln() {
        for (double v : a) {
            System.out.println(v);
        }
    }
}
