package com.bmagario.models;

import java.util.Objects;

public class Wine {

    private String name;
    private String grapeVariety;
    private int year;
    private double price;
    private String foodPairing;

    public Wine(String name, String grapeVariety, int year, double price, String foodPairing) {
        this.name = name;
        this.grapeVariety = grapeVariety;
        this.year = year;
        this.price = price;
        this.foodPairing = foodPairing;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrapeVariety() {
        return grapeVariety;
    }

    public void setGrapeVariety(String grapeVariety) {
        this.grapeVariety = grapeVariety;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getFoodPairing() {
        return foodPairing;
    }

    public void setFoodPairing(String foodPairing) {
        this.foodPairing = foodPairing;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Wine wine = (Wine) o;
        return year == wine.year &&
                Double.compare(wine.price, price) == 0 &&
                Objects.equals(name, wine.name) &&
                Objects.equals(grapeVariety, wine.grapeVariety) &&
                Objects.equals(foodPairing, wine.foodPairing);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, grapeVariety, year, price, foodPairing);
    }

    @Override
    public String toString() {
        return "Wine{" +
                "name='" + name + '\'' +
                ", grapeVariety='" + grapeVariety + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", foodPairing='" + foodPairing + '\'' +
                '}';
    }
}