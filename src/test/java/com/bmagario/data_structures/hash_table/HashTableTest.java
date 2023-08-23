package com.bmagario.data_structures.hash_table;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.bmagario.models.JsonMockData;
import com.bmagario.models.Sommelier;
import com.bmagario.models.Wine;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.Test;

public class HashTableTest {

    @Test
    public void testPut() throws IOException {
        List<Sommelier> sommeliersData = JsonMockData.getSommeliers();
        HashTable<String, Sommelier> sommelierHashTable = new HashTable<>(sommeliersData.size());

        sommeliersData.forEach(sommelier -> sommelierHashTable.put(sommelier.getName(), sommelier));

        assertEquals(sommeliersData.get(0), sommelierHashTable.get("Brian Magario"));
    }

    @Test
    public void testRemove() throws IOException {
        List<Wine> winesData = JsonMockData.getWines();
        HashTable<String, Wine> wineHashTable = new HashTable<>(winesData.size());

        winesData.forEach(wine -> wineHashTable.put(wine.getName(), wine));

        assertEquals(winesData.get(0), wineHashTable.get("Cabernet Sauvignon"));

        wineHashTable.remove("Cabernet Sauvignon");

        assertNull(wineHashTable.get("Cabernet Sauvignon"));
    }
}