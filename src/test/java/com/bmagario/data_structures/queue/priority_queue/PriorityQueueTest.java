package com.bmagario.data_structures.queue.priority_queue;

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

public class PriorityQueueTest {

    @Test
    public void testEnqueue() throws IOException {
        PriorityQueue<ComparableSommelier> sommelierQueue = new PriorityQueue<>();

        List<Sommelier> sommeliersData = JsonMockData.getSommeliers();
        sommeliersData.forEach(
                sommelier -> sommelierQueue.enqueue(new ComparableSommelier(sommelier)));

        List<ComparableSommelier> comparableSommeliers = new ArrayList<>();
        sommeliersData.forEach(
                sommelier -> comparableSommeliers.add(new ComparableSommelier(sommelier)));
        Collections.sort(comparableSommeliers);

        assertEquals(comparableSommeliers.get(0).getSommelier(),
                sommelierQueue.dequeue().getSommelier());

        assertFalse(sommelierQueue.isEmpty());
    }


    @Test
    public void testDequeu() throws IOException {
        List<Sommelier> sommeliersData = JsonMockData.getSommeliers();

        PriorityQueue<ComparableSommelier>
                sommelierQueue = new PriorityQueue<>();
        sommeliersData.forEach(
                sommelier -> sommelierQueue.enqueue(new ComparableSommelier(sommelier)));

        List<ComparableSommelier> comparableSommeliers = new ArrayList<>();
        sommeliersData.forEach(
                sommelier -> comparableSommeliers.add(new ComparableSommelier(sommelier)));
        Collections.sort(comparableSommeliers);

        assertEquals(comparableSommeliers.get(0).getSommelier(),
                sommelierQueue.dequeue().getSommelier());
    }

    @Test
    public void testIsEmpty() throws IOException {
        PriorityQueue<ComparableSommelier> sommelierQueue = new PriorityQueue<>();

        assertTrue(sommelierQueue.isEmpty());

        List<Sommelier> sommeliersData = JsonMockData.getSommeliers();
        sommeliersData.forEach(
                sommelier -> sommelierQueue.enqueue(new ComparableSommelier(sommelier)));

        assertFalse(sommelierQueue.isEmpty());
    }
}