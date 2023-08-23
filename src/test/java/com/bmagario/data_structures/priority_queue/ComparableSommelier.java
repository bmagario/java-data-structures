package com.bmagario.data_structures.priority_queue;

import com.bmagario.models.Sommelier;

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
}
