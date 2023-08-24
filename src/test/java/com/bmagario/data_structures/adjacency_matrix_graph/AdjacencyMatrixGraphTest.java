package com.bmagario.data_structures.adjacency_matrix_graph;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.bmagario.models.ComparableSommelier;
import com.bmagario.models.JsonMockData;
import com.bmagario.models.Sommelier;
import java.io.IOException;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

public class AdjacencyMatrixGraphTest {

    @Test
    public void testInsertSommelier() throws IOException {
        List<Sommelier> sommeliers = JsonMockData.getSommeliers();
        AdjacencyMatrixGraph<ComparableSommelier> graph =
                new AdjacencyMatrixGraph<>(sommeliers.size());

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
        assertEquals(sommeliers.size(), graph.getAdjacencyMatrix().length);
        assertEquals(1, graph.getAdjacencyMatrix()[0][1]);
        assertEquals(1, graph.getAdjacencyMatrix()[1][0]);
    }
}