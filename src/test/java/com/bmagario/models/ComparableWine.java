package com.bmagario.models;

public class ComparableWine implements Comparable<ComparableWine> {
    private Wine wine;

    public ComparableWine(Wine wine) {
        this.wine = wine;
    }

    @Override
    public int compareTo(ComparableWine other) {
        return (int) (wine.getPrice() - other.getWine().getPrice());
    }

    public Wine getWine() {
        return wine;
    }

    @Override
    public String toString() {
        return "ComparableWine{" +
                "wine=" + wine +
                '}';
    }
}
