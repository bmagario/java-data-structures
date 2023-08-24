package com.bmagario.data_structures.avl_tree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.bmagario.models.ComparableSommelier;
import com.bmagario.models.JsonMockData;
import com.bmagario.models.Sommelier;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.Test;

public class AvlTreeTest {

    @Test
    public void testInsert() throws IOException {
        AvlTree<ComparableSommelier> tree = new AvlTree<>();
        ComparableSommelier sommelier1 =
                new ComparableSommelier(new Sommelier("John", "Expert", 35, true, "France"));
        ComparableSommelier sommelier2 =
                new ComparableSommelier(new Sommelier("Alice", "Master", 40, true, "Italy"));
        ComparableSommelier sommelier3 =
                new ComparableSommelier(new Sommelier("David", "Apprentice", 28, false, "Spain"));

        tree.insert(sommelier1);
        tree.insert(sommelier2);
        tree.insert(sommelier3);

        assertEquals(sommelier1, tree.getRootData());
        assertEquals(sommelier2, tree.getRootRightData());
        assertEquals(sommelier3, tree.getRootLeftData());
    }

    @Test
    public void testSearch() throws IOException {
        AvlTree<ComparableSommelier> tree = new AvlTree<>();
        List<Sommelier> sommeliers = JsonMockData.getSommeliers();

        sommeliers.stream()
                .map(ComparableSommelier::new)
                .forEach(tree::insert);

        assertTrue(tree.search(new ComparableSommelier(sommeliers.get(0))));
        assertTrue(tree.search(new ComparableSommelier(sommeliers.get(1))));
        assertTrue(tree.search(new ComparableSommelier(sommeliers.get(2))));
    }
}