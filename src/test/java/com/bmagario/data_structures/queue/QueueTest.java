package com.bmagario.data_structures.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.bmagario.models.JsonMockData;
import com.bmagario.models.Sommelier;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

public class QueueTest {

    @Test
    public void testEnqueue() throws IOException {
        Queue<Sommelier> sommelierQueue = new Queue<>();

        List<Sommelier> sommeliersData = JsonMockData.getSommeliers();
        sommeliersData.forEach(sommelierQueue::enqueue);

        assertEquals(sommeliersData.get(0), sommelierQueue.dequeue());
    }

    @Test
    public void testDequeu() throws IOException {
        List<Sommelier> sommeliersData = JsonMockData.getSommeliers();
        List<Sommelier> reversedSommeliers = new ArrayList<>(sommeliersData);
        Collections.reverse(reversedSommeliers);

        Queue<Sommelier> sommelierQueue = new Queue<>();
        reversedSommeliers.forEach(sommelierQueue::enqueue);

        assertEquals(sommeliersData.get(sommeliersData.size() - 1), sommelierQueue.dequeue());
    }

    @Test
    public void testIsEmpty() throws IOException {
        Queue<Sommelier> sommelierQueue = new Queue<>();

        assertTrue(sommelierQueue.isEmpty());

        List<Sommelier> sommeliersData = JsonMockData.getSommeliers();
        sommeliersData.forEach(sommelierQueue::enqueue);

        assertFalse(sommelierQueue.isEmpty());
    }
}