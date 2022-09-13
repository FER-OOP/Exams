package hr.fer.oop.zad1;

public interface Calculation {

      String makeDescription();

      static double calculateAverage(double[] data) {
        double s = 0;
        for(int i = 0; i < data.length; i++) {
            s += data[i];
        }
        return s / (data.length);
    }
}
