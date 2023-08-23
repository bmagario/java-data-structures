package com.bmagario.data_structures.sorted_linked_list;

import com.bmagario.models.Wine;

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
}
