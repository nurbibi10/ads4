
public interface Interface<Vertex> {
    void addVertex(Vertex v);
    void addEdge(Vertex s, Vertex d);
    int getVerticesCount();
    int getEdgesCount();
    boolean hasVertex(Vertex v);
    boolean hasEdge(Vertex s, Vertex d);
    List<Vertex> adjacencyList(Vertex v);
}