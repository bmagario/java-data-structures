package com.bmagario.data_structures.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.bmagario.models.JsonMockData;
import com.bmagario.models.Sommelier;
import com.bmagario.models.Wine;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

public class StackTest {

    @Test
    public void testPush() throws IOException {
        List<Sommelier> sommeliersData = JsonMockData.getSommeliers();
        List<Sommelier> reversedSommeliers = new ArrayList<>(sommeliersData);
        Collections.reverse(reversedSommeliers);

        Stack<Sommelier> sommelierStack = new Stack<>();
        reversedSommeliers.forEach(sommelierStack::push);

        assertEquals(sommeliersData.get(0), sommelierStack.pop());
    }

    @Test
    public void testPop() throws IOException {
        Stack<Wine> wineStack = new Stack<>();

        List<Wine> winesData = JsonMockData.getWines();
        winesData.forEach(wineStack::push);

        assertEquals(winesData.get(winesData.size() - 1), wineStack.pop());
    }

    @Test
    public void testIsEmpty() throws IOException {
        Stack<Sommelier> sommelierStack = new Stack<>();

        assertTrue(sommelierStack.isEmpty());

        List<Sommelier> sommeliersData = JsonMockData.getSommeliers();
        sommeliersData.forEach(sommelierStack::push);

        assertFalse(sommelierStack.isEmpty());
    }

}