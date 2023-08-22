package com.bmagario.data_structures.linked_list;

import com.bmagario.models.JsonMockData;
import com.bmagario.models.Sommelier;
import com.bmagario.models.Wine;
import java.io.IOException;
import java.util.List;

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

    public static void main(String[] args) throws IOException {
        SommelierWineLinkedList sommelierWineLinkedList = new SommelierWineLinkedList();

        Sommelier sommelier = sommelierWineLinkedList.getSommelier(0);
        System.out.println(sommelier.getName());

        Wine wine = sommelierWineLinkedList.getWine(0);
        System.out.println(wine.getName());
    }
}
