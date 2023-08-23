package com.bmagario.data_structures.hash_table;

public class HashTable<K, V> {

    private static final int DEFAULT_CAPACITY = 10;

    private final Entry<K, V>[] table;
    private int size;

    public HashTable() {
        this(DEFAULT_CAPACITY);
    }

    public HashTable(int capacity) {
        this.table = new Entry[capacity];
    }

    public void put(K key, V value) {
        int index = hash(key);

        Entry<K, V> entry = table[index];

        if (entry == null) {
            table[index] = new Entry<>(key, value);
            size++;
        } else {
            while (entry.next != null) {
                if (entry.key.equals(key)) {
                    entry.value = value;
                    return;
                }
                entry = entry.next;
            }

            entry.next = new Entry<>(key, value);
            size++;
        }
    }

    public V get(K key) {
        int index = hash(key);
        Entry<K, V> entry = table[index];

        while (entry != null) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
            entry = entry.next;
        }

        return null;
    }

    public void remove(K key) {
        int index = hash(key);
        Entry<K, V> entry = table[index];

        if (entry == null) {
            return;
        }

        if (entry.key.equals(key)) {
            table[index] = entry.next;
            size--;
            return;
        }

        Entry<K, V> previous = entry;
        entry = entry.next;

        while (entry != null) {
            if (entry.key.equals(key)) {
                previous.next = entry.next;
                size--;
                return;
            }
            previous = entry;
            entry = entry.next;
        }
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    private static class Entry<K, V> {

        private K key;
        private V value;
        private Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}