package com.bmagario.data_structures.linked_list;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.bmagario.models.JsonMockData;
import com.bmagario.models.Sommelier;
import com.bmagario.models.Wine;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.Test;

public class SommelierWineLinkedList {

    private LinkedList<Sommelier> sommeliers;
    private LinkedList<Wine> wines;

    public SommelierWineLinkedList() throws IOException {
        this.sommeliers = new LinkedList<>();
        this.wines = new LinkedList<>();

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
        SommelierWineLinkedList sommelierWineLinkedList = new SommelierWineLinkedList();

        Sommelier sommelier = sommelierWineLinkedList.getSommelier(0);
        assertEquals("Brian Magario", sommelier.getName());
    }

    @Test
    public void testGetWine() throws IOException {
        SommelierWineLinkedList sommelierWineLinkedList = new SommelierWineLinkedList();

        Wine wine = sommelierWineLinkedList.getWine(0);
        assertEquals("Cabernet Sauvignon", wine.getName());
    }

    @Test
    public void testRemoveSommelier() throws IOException {
        SommelierWineLinkedList sommelierWineLinkedList = new SommelierWineLinkedList();

        Sommelier sommelierIndexOne = sommelierWineLinkedList.getSommelier(1);
        sommelierWineLinkedList.removeSommelier(0);
        Sommelier sommelierNewIndexZero = sommelierWineLinkedList.getSommelier(0);

        assertEquals(sommelierNewIndexZero, sommelierIndexOne);
    }

    @Test
    public void testRemoveWine() throws IOException {
        SommelierWineLinkedList sommelierWineLinkedList = new SommelierWineLinkedList();

        Wine wineIndexOne = sommelierWineLinkedList.getWine(1);
        sommelierWineLinkedList.removeWine(0);
        Wine wineNewIndexZero = sommelierWineLinkedList.getWine(0);

        assertEquals(wineNewIndexZero, wineIndexOne);
    }
}
