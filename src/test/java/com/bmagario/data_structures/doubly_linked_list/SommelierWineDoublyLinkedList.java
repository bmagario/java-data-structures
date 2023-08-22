package com.bmagario.data_structures.doubly_linked_list;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.bmagario.models.JsonMockData;
import com.bmagario.models.Sommelier;
import com.bmagario.models.Wine;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.Test;

public class SommelierWineDoublyLinkedList {

    private DoublyLinkedList<Sommelier> sommeliers;
    private DoublyLinkedList<Wine> wines;

    public SommelierWineDoublyLinkedList() throws IOException {
        this.sommeliers = new DoublyLinkedList<>();
        this.wines = new DoublyLinkedList<>();

        List<Sommelier> sommeliersData = JsonMockData.getSommeliers();
        List<Wine> winesData = JsonMockData.getWines();

        sommeliersData.forEach(this.sommeliers::add);
        winesData.forEach(this.wines::add);
    }

    public Sommelier getSommelier(int index) {
        return this.sommeliers.get(index);
    }

    public Wine getWine(int index) {
        return this.wines.get(index);
    }

    public void removeSommelier(int index) {
        this.sommeliers.remove(index);
    }

    public void removeWine(int index) {
        this.wines.remove(index);
    }

    @Test
    public void testGetSommelier() throws IOException {
        SommelierWineDoublyLinkedList sommelierWineLinkedList = new SommelierWineDoublyLinkedList();

        Sommelier sommelier = sommelierWineLinkedList.getSommelier(0);
        assertEquals("Brian Magario", sommelier.getName());
    }

    @Test
    public void testGetWine() throws IOException {
        SommelierWineDoublyLinkedList sommelierWineLinkedList = new SommelierWineDoublyLinkedList();

        Wine wine = sommelierWineLinkedList.getWine(0);
        assertEquals("Cabernet Sauvignon", wine.getName());
    }

    @Test
    public void testRemoveSommelier() throws IOException {
        SommelierWineDoublyLinkedList sommelierWineLinkedList = new SommelierWineDoublyLinkedList();

        Sommelier sommelierIndexOne = sommelierWineLinkedList.getSommelier(1);
        sommelierWineLinkedList.removeSommelier(0);
        Sommelier sommelierNewIndexZero = sommelierWineLinkedList.getSommelier(0);

        assertEquals(sommelierNewIndexZero, sommelierIndexOne);
    }

    @Test
    public void testRemoveWine() throws IOException {
        SommelierWineDoublyLinkedList sommelierWineLinkedList = new SommelierWineDoublyLinkedList();

        Wine wineIndexOne = sommelierWineLinkedList.getWine(1);
        sommelierWineLinkedList.removeWine(0);
        Wine wineNewIndexZero = sommelierWineLinkedList.getWine(0);

        assertEquals(wineNewIndexZero, wineIndexOne);
    }
}