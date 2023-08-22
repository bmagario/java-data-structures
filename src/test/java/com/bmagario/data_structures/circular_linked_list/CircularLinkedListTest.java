package com.bmagario.data_structures.circular_linked_list;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.bmagario.models.JsonMockData;
import com.bmagario.models.Sommelier;
import com.bmagario.models.Wine;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.Test;

public class CircularLinkedListTest {

    @Test
    public void testGetSommelier() throws IOException {
        CircularLinkedList<Sommelier> sommelierCircularLinkedList = new CircularLinkedList<>();

        List<Sommelier> sommeliersData = JsonMockData.getSommeliers();
        sommeliersData.forEach(sommelierCircularLinkedList::add);

        Sommelier sommelier = sommelierCircularLinkedList.get(0);
        assertEquals("Brian Magario", sommelier.getName());
    }

    @Test
    public void testGetWine() throws IOException {
        CircularLinkedList<Wine> wineCircularLinkedList = new CircularLinkedList<>();

        List<Wine> winesData = JsonMockData.getWines();
        winesData.forEach(wineCircularLinkedList::add);

        Wine wine = wineCircularLinkedList.get(0);
        assertEquals("Cabernet Sauvignon", wine.getName());
    }

    @Test
    public void testRemoveSommelier() throws IOException {
        CircularLinkedList<Sommelier> sommelierCircularLinkedList = new CircularLinkedList<>();

        List<Sommelier> sommeliersData = JsonMockData.getSommeliers();
        sommeliersData.forEach(sommelierCircularLinkedList::add);

        Sommelier sommelierIndexOne = sommelierCircularLinkedList.get(1);
        sommelierCircularLinkedList.remove(0);
        Sommelier sommelierNewIndexZero = sommelierCircularLinkedList.get(0);

        assertEquals(sommelierNewIndexZero, sommelierIndexOne);
    }

    @Test
    public void testRemoveWine() throws IOException {
        CircularLinkedList<Wine> wineCircularLinkedList = new CircularLinkedList<>();

        List<Wine> winesData = JsonMockData.getWines();
        winesData.forEach(wineCircularLinkedList::add);

        Wine wineIndexOne = wineCircularLinkedList.get(1);
        wineCircularLinkedList.remove(0);
        Wine wineNewIndexZero = wineCircularLinkedList.get(0);

        assertEquals(wineNewIndexZero, wineIndexOne);
    }
}