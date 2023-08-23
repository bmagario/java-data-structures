package com.bmagario.data_structures.binary_tree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.bmagario.models.JsonMockData;
import com.bmagario.models.Sommelier;
import com.bmagario.models.Wine;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BinaryTreeTest {

    private BinaryTree<ComparableSommelier> sommelierBinaryTree;
    private BinaryTree<ComparableWine> wineBinaryTree;
    private List<Sommelier> sommeliersData;
    private List<Wine> winesData;

    @BeforeEach
    public void setup() throws IOException {
        sommelierBinaryTree = new BinaryTree<>();
        wineBinaryTree = new BinaryTree<>();

        sommeliersData = JsonMockData.getSommeliers();
        sommeliersData.forEach(
                sommelier -> sommelierBinaryTree.insert(new ComparableSommelier(sommelier)));

        winesData = JsonMockData.getWines();
        winesData.forEach(wine -> wineBinaryTree.insert(new ComparableWine(wine)));
    }

    @Test
    public void testInsert() {
        assertEquals(sommeliersData.get(0),
                sommelierBinaryTree.getRootData().getSommelier());
        assertEquals(winesData.get(0), wineBinaryTree.getRootData().getWine());
    }

    @Test
    public void testSearch() {
        ComparableSommelier sommelier = new ComparableSommelier(sommeliersData.get(0));
        assertTrue(sommelierBinaryTree.search(sommelier));

        ComparableWine wine = new ComparableWine(winesData.get(0));
        assertTrue(wineBinaryTree.search(wine));
    }

    @Test
    public void testDelete() {
        sommelierBinaryTree.delete(new ComparableSommelier(sommeliersData.get(0)));
        assertFalse(sommelierBinaryTree.search(new ComparableSommelier(sommeliersData.get(0))));

        wineBinaryTree.delete(new ComparableWine(winesData.get(0)));
        assertFalse(wineBinaryTree.search(new ComparableWine(winesData.get(0))));
    }
}