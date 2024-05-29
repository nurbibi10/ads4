import java.util.HashMap;
import java.util.Map;

public class WeightedGraph<V> {
    private Map<V, Vertex<V>> vertices = new HashMap<>();

    public void addVertex(V data) {
        vertices.put(data, new Vertex<>(data));
    }

    public Vertex<V> getVertex(V data) {
        return vertices.get(data);
    }

    public Map<V, Vertex<V>> getVertices() {
        return vertices;
    }

    public void addEdge(V source, V dest, double weight) {
        Vertex<V> sourceVertex = vertices.get(source);
        Vertex<V> destVertex = vertices.get(dest);
        if (sourceVertex != null && destVertex != null) {
            sourceVertex.addAdjacentVertex(destVertex, weight);
        }
    }

    public Map<Vertex<V>, Double> getAdjacentVertices(Vertex<V> vertex) {
        return vertex.getAdjacentVertices();
    }
}