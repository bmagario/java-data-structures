package com.bmagario.data_structures.sorted_linked_list;

import com.bmagario.models.Sommelier;

public class ComparableSommelier implements Comparable<ComparableSommelier> {
    private Sommelier sommelier;

    public ComparableSommelier(Sommelier sommelier) {
        this.sommelier = sommelier;
    }

    @Override
    public int compareTo(ComparableSommelier other) {
        if (sommelier.getAge() > other.getSommelier().getAge()) {
            return 1;
        }
        return 0;
    }

    public Sommelier getSommelier() {
        return sommelier;
    }
}
