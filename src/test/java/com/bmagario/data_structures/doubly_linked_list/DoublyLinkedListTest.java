package com.bmagario.data_structures.doubly_linked_list;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.bmagario.models.JsonMockData;
import com.bmagario.models.Sommelier;
import com.bmagario.models.Wine;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.Test;

public class DoublyLinkedListTest {

    @Test
    public void testGetSommelier() throws IOException {
        DoublyLinkedList<Sommelier> sommelierDoublyLinkedList =
                new DoublyLinkedList<>();

        List<Sommelier> sommeliersData = JsonMockData.getSommeliers();
        sommeliersData.forEach(sommelierDoublyLinkedList::add);

        Sommelier sommelier = sommelierDoublyLinkedList.get(0);
        assertEquals("Brian Magario", sommelier.getName());
    }

    @Test
    public void testGetWine() throws IOException {
        DoublyLinkedList<Wine> wineDoublyLinkedList = new DoublyLinkedList<>();

        List<Wine> winesData = JsonMockData.getWines();
        winesData.forEach(wineDoublyLinkedList::add);

        Wine wine = wineDoublyLinkedList.get(0);
        assertEquals("Cabernet Sauvignon", wine.getName());
    }

    @Test
    public void testRemoveSommelier() throws IOException {
        DoublyLinkedList<Sommelier> sommelierDoublyLinkedList =
                new DoublyLinkedList<>();

        List<Sommelier> sommeliersData = JsonMockData.getSommeliers();
        sommeliersData.forEach(sommelierDoublyLinkedList::add);

        Sommelier sommelierIndexOne = sommelierDoublyLinkedList.get(1);
        sommelierDoublyLinkedList.remove(0);
        Sommelier sommelierNewIndexZero = sommelierDoublyLinkedList.get(0);

        assertEquals(sommelierNewIndexZero, sommelierIndexOne);
    }

    @Test
    public void testRemoveWine() throws IOException {
        DoublyLinkedList<Wine> wineDoublyLinkedList = new DoublyLinkedList<>();

        List<Wine> winesData = JsonMockData.getWines();
        winesData.forEach(wineDoublyLinkedList::add);

        Wine wineIndexOne = wineDoublyLinkedList.get(1);
        wineDoublyLinkedList.remove(0);
        Wine wineNewIndexZero = wineDoublyLinkedList.get(0);

        assertEquals(wineNewIndexZero, wineIndexOne);
    }
}