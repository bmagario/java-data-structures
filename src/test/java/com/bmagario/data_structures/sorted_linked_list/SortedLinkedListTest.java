package com.bmagario.data_structures.sorted_linked_list;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.bmagario.models.ComparableSommelier;
import com.bmagario.models.ComparableWine;
import com.bmagario.models.JsonMockData;
import com.bmagario.models.Sommelier;
import com.bmagario.models.Wine;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.Test;

public class SortedLinkedListTest {

    @Test
    public void testGetSommelier() throws IOException {
        SortedLinkedList<ComparableSommelier> sommelierSortedLinkedList = new SortedLinkedList<>();

        List<Sommelier> sommeliersData = JsonMockData.getSommeliers();
        sommeliersData.forEach(
                sommelier -> sommelierSortedLinkedList.add(new ComparableSommelier(sommelier)));

        ComparableSommelier sommelier = sommelierSortedLinkedList.get(0);
        assertEquals("Chloe Miller", sommelier.getSommelier().getName());
    }

    @Test
    public void testGetWine() throws IOException {
        SortedLinkedList<ComparableWine> wineSortedLinkedList = new SortedLinkedList<>();

        List<Wine> winesData = JsonMockData.getWines();
        winesData.forEach(
                wine -> wineSortedLinkedList.add(new ComparableWine(wine)));

        ComparableWine wine = wineSortedLinkedList.get(0);
        assertEquals("Pinot Noir", wine.getWine().getName());
    }

    @Test
    public void testRemoveSommelier() throws IOException {
        SortedLinkedList<ComparableSommelier> sommelierSortedLinkedList = new SortedLinkedList<>();

        List<Sommelier> sommeliersData = JsonMockData.getSommeliers();
        sommeliersData.forEach(
                sommelier -> sommelierSortedLinkedList.add(new ComparableSommelier(sommelier)));

        ComparableSommelier sommelierIndexOne = sommelierSortedLinkedList.get(1);
        sommelierSortedLinkedList.remove(0);
        ComparableSommelier sommelierNewIndexZero = sommelierSortedLinkedList.get(0);

        assertEquals(sommelierNewIndexZero, sommelierIndexOne);
    }

    @Test
    public void testRemoveWine() throws IOException {
        SortedLinkedList<ComparableWine> wineSortedLinkedList =
                new SortedLinkedList<>();


        List<Wine> winesData = JsonMockData.getWines();
        winesData.forEach(
                wine -> wineSortedLinkedList.add(new ComparableWine(wine)));

        ComparableWine wineIndexOne = wineSortedLinkedList.get(1);
        wineSortedLinkedList.remove(0);
        ComparableWine wineNewIndexZero = wineSortedLinkedList.get(0);

        assertEquals(wineNewIndexZero, wineIndexOne);
    }
}