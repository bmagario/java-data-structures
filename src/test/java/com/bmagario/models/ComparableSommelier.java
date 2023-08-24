package com.bmagario.models;

public class ComparableSommelier implements Comparable<ComparableSommelier> {
    private Sommelier sommelier;

    public ComparableSommelier(Sommelier sommelier) {
        this.sommelier = sommelier;
    }

    @Override
    public int compareTo(ComparableSommelier other) {
        return sommelier.getAge() - other.getSommelier().getAge();
    }

    public Sommelier getSommelier() {
        return sommelier;
    }

    @Override
    public String toString() {
        return "ComparableSommelier{" +
                "sommelier=" + sommelier +
                '}';
    }
}
