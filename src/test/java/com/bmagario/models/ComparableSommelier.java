package com.bmagario.models;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ComparableSommelier that = (ComparableSommelier) o;
        return Objects.equals(sommelier, that.sommelier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sommelier);
    }

    @Override
    public String toString() {
        return "ComparableSommelier{" +
                "sommelier=" + sommelier +
                '}';
    }
}
