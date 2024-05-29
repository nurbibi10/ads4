import java.util.*;

public class BreadthFirstSearch<V> extends Search<V> {
    public BreadthFirstSearch(WeightedGraph<V> graph) {
        super(graph);
    }

    @Override
    public List<V> getPath(V start, V end) {
        Map<V, V> edgeTo = new HashMap<>();
        Queue<V> queue = new LinkedList<>();
        Set<V> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            V current = queue.poll();
            if (current.equals(end)) {
                break;
            }

            for (Vertex<V> neighborVertex : graph.getVertex(current).getAdjacentVertices().keySet()) {
                V neighbor = neighborVertex.getData();
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                    edgeTo.put(neighbor, current);
                }
            }
        }

        return constructPath(start, end, edgeTo);
    }

    private List<V> constructPath(V start, V end, Map<V, V> edgeTo) {
        List<V> path = new LinkedList<>();
        for (V at = end; at != null; at = edgeTo.get(at)) {
            path.add(0, at);
        }

        if (path.isEmpty() || !path.get(0).equals(start)) {
            return Collections.emptyList(); // No path found
        }

        return path;
    }
}