package com.bmagario.data_structures.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.bmagario.models.ComparableSommelier;
import com.bmagario.models.JsonMockData;
import com.bmagario.models.Sommelier;
import java.io.IOException;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

public class GraphTest {

    @Test
    public void testInsert() throws IOException {
        Graph<ComparableSommelier> graph = new Graph<>();
        List<Sommelier> sommeliers = JsonMockData.getSommeliers();

        sommeliers.stream().map(ComparableSommelier::new).forEach(graph::addVertex);

        IntStream.range(0, sommeliers.size())
                .forEach(i ->
                        IntStream.range(i + 1, sommeliers.size())
                                .forEach(j ->
                                        graph.addEdge(new ComparableSommelier(sommeliers.get(i)),
                                                new ComparableSommelier(sommeliers.get(j)))
                                )
                );

        assertEquals(sommeliers.size(), graph.getVertices().size());
        assertEquals(sommeliers.size() * (sommeliers.size() - 1) / 2, graph.getEdges().size());
    }
}