package com.bmagario.data_structures.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.bmagario.models.ComparableSommelier;
import com.bmagario.models.ComparableWine;
import com.bmagario.models.JsonMockData;
import com.bmagario.models.Sommelier;
import com.bmagario.models.Wine;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.Test;

public class TreeTest {

    @Test
    public void testInsert() throws IOException {
        Tree<ComparableSommelier> sommelierTree = new Tree<>();

        List<Sommelier> sommeliersData = JsonMockData.getSommeliers();
        sommeliersData.forEach(
                sommelier -> sommelierTree.insert(new ComparableSommelier(sommelier)));

        assertEquals(sommeliersData.get(0), sommelierTree.getRoot().getData().getSommelier());
    }

    @Test
    public void testInorderTraversal() throws IOException {
        Tree<ComparableWine> wineTree = new Tree<>();

        List<Wine> winesData = JsonMockData.getWines();
        winesData.forEach(wine -> wineTree.insert(new ComparableWine(wine)));

        wineTree.inorderTraversal();
    }

    @Test
    public void testPreorderTraversal() throws IOException {
        Tree<ComparableSommelier> sommelierTree = new Tree<>();

        List<Sommelier> sommeliersData = JsonMockData.getSommeliers();
        sommeliersData.forEach(
                sommelier -> sommelierTree.insert(new ComparableSommelier(sommelier)));

        sommelierTree.preorderTraversal();
    }

    @Test
    public void testPostorderTraversal() throws IOException {
        Tree<ComparableWine> wineTree = new Tree<>();

        List<Wine> winesData = JsonMockData.getWines();
        winesData.forEach(wine -> wineTree.insert(new ComparableWine(wine)));

        wineTree.postorderTraversal();
    }
}