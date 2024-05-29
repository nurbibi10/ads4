import java.util.*;

public class DijkstraSearch<V> extends Search<V> {
    public DijkstraSearch(WeightedGraph<V> graph) {
        super(graph);
    }

    @Override
    public List<V> getPath(V start, V end) {
        Map<V, V> edgeTo = new HashMap<>();
        Map<V, Double> distTo = new HashMap<>();
        PriorityQueue<VertexDistance<V>> pq = new PriorityQueue<>();

        for (V vertex : graph.getVertices().keySet()) {
            distTo.put(vertex, Double.POSITIVE_INFINITY);
        }
        distTo.put(start, 0.0);
        pq.add(new VertexDistance<>(start, 0.0));

        while (!pq.isEmpty()) {
            V current = pq.poll().vertex;

            if (current.equals(end)) {
                break;
            }

            for (Map.Entry<Vertex<V>, Double> neighborEntry : graph.getAdjacentVertices(graph.getVertex(current)).entrySet()) {
                V neighbor = neighborEntry.getKey().getData();
                double weight = neighborEntry.getValue();
                double newDist = distTo.get(current) + weight;

                if (newDist < distTo.get(neighbor)) {
                    distTo.put(neighbor, newDist);
                    edgeTo.put(neighbor, current);
                    pq.add(new VertexDistance<>(neighbor, newDist));
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

    private static class VertexDistance<V> implements Comparable<VertexDistance<V>> {
        V vertex;
        double distance;

        VertexDistance(V vertex, double distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(VertexDistance<V> other) {
            return Double.compare(this.distance, other.distance);
        }
    }
}