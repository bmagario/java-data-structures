package com.bmagario.data_structures.set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.bmagario.models.ComparableSommelier;
import com.bmagario.models.JsonMockData;
import com.bmagario.models.Sommelier;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.Test;

public class SetTest {

    @Test
    public void testInsert() throws IOException {
        Set<ComparableSommelier> set = new Set<>();
        List<Sommelier> sommeliers = JsonMockData.getSommeliers();

        sommeliers.stream().map(ComparableSommelier::new).forEach(set::add);

        assertEquals(sommeliers.size(), set.size());
        assertTrue(set.contains(new ComparableSommelier(sommeliers.get(0))));
        assertFalse(set.contains(new ComparableSommelier(
                new Sommelier(
                        "Not Existing Sommelier",
                        "Wine",
                        25,
                        false,
                        null))));
    }

    @Test
    public void testRemove() throws IOException {
        Set<ComparableSommelier> set = new Set<>();
        List<Sommelier> sommeliers = JsonMockData.getSommeliers();

        sommeliers.stream().map(ComparableSommelier::new).forEach(set::add);

        set.remove(new ComparableSommelier(sommeliers.get(0)));

        assertEquals(sommeliers.size() - 1, set.size());
        assertFalse(set.contains(new ComparableSommelier(sommeliers.get(0))));
    }

    @Test
    public void testClear() throws IOException {
        Set<ComparableSommelier> set = new Set<>();
        List<Sommelier> sommeliers = JsonMockData.getSommeliers();

        sommeliers.stream().map(ComparableSommelier::new).forEach(set::add);

        set.clear();
        assertEquals(0, set.size());
        assertFalse(set.contains(new ComparableSommelier(sommeliers.get(0))));
    }

    @Test
    public void testIterator() throws IOException {
        Set<ComparableSommelier> set = new Set<>();
        List<Sommelier> sommeliers = JsonMockData.getSommeliers();

        sommeliers.stream().map(ComparableSommelier::new).forEach(set::add);

        Iterator<ComparableSommelier> iterator = set.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            iterator.next();
            i++;
        }
        assertEquals(i, set.size());
    }
}