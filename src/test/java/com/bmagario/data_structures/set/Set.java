package com.bmagario.data_structures.set;

import java.util.HashMap;
import java.util.Iterator;

public class Set<T> {

    private HashMap<T, Boolean> map;

    public Set() {
        map = new HashMap<>();
    }

    public void add(T element) {
        map.put(element, true);
    }

    public boolean contains(T element) {
        return map.containsKey(element);
    }

    public void remove(T element) {
        map.remove(element);
    }

    public int size() {
        return map.size();
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public void clear() {
        map.clear();
    }

    public Iterator<T> iterator() {
        return map.keySet().iterator();
    }
}