package com.bmagario.data_structures.linked_list;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.bmagario.models.JsonMockData;
import com.bmagario.models.Sommelier;
import com.bmagario.models.Wine;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.Test;

public class LinkedListTest {

    @Test
    public void testGetSommelier() throws IOException {
        LinkedList<Sommelier> sommelierLinkedList =
                new LinkedList<>();

        List<Sommelier> sommeliersData = JsonMockData.getSommeliers();
        sommeliersData.forEach(sommelierLinkedList::add);

        Sommelier sommelier = sommelierLinkedList.get(0);
        assertEquals("Brian Magario", sommelier.getName());
    }

    @Test
    public void testGetWine() throws IOException {
        LinkedList<Wine> wineLinkedList = new LinkedList<>();

        List<Wine> winesData = JsonMockData.getWines();
        winesData.forEach(wineLinkedList::add);

        Wine wine = wineLinkedList.get(0);
        assertEquals("Cabernet Sauvignon", wine.getName());
    }

    @Test
    public void testRemoveSommelier() throws IOException {
        LinkedList<Sommelier> sommelierLinkedList =
                new LinkedList<>();

        List<Sommelier> sommeliersData = JsonMockData.getSommeliers();
        sommeliersData.forEach(sommelierLinkedList::add);

        Sommelier sommelierIndexOne = sommelierLinkedList.get(1);
        sommelierLinkedList.remove(0);
        Sommelier sommelierNewIndexZero = sommelierLinkedList.get(0);

        assertEquals(sommelierNewIndexZero, sommelierIndexOne);
    }

    @Test
    public void testRemoveWine() throws IOException {
        LinkedList<Wine> wineLinkedList = new LinkedList<>();

        List<Wine> winesData = JsonMockData.getWines();
        winesData.forEach(wineLinkedList::add);

        Wine wineIndexOne = wineLinkedList.get(1);
        wineLinkedList.remove(0);
        Wine wineNewIndexZero = wineLinkedList.get(0);

        assertEquals(wineNewIndexZero, wineIndexOne);
    }
}