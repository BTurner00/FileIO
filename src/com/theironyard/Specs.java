package com.theironyard;

/**
 * Created by Ben on 5/25/16.
 */
public class Specs {
    String brand;
    double screen;
    double weight;
    String OS;
    int year;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getScreen() {
        return screen;
    }

    public void setScreen(double screen) {
        this.screen = screen;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Specs{" +
                "brand='" + brand + '\'' +
                ", screen=" + screen +
                ", weight=" + weight +
                ", OS='" + OS + '\'' +
                ", year=" + year +
                '}';
    }
}
