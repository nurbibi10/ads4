
public class Vertex<T> {
    private T data;
    private Map<Vertex<T>, Double> adjacentVertices;

    public void addAdjacentVertex(Vertex<T> dest, double weight){
        adjacentVertices.put(dest, weight);
    }

    public Map<Vertex<T>, Double> getAdjacentVertices(){
        return adjacentVertices;
    }
}