import java.util.List;

public abstract class Search<V> {
    protected WeightedGraph<V> graph;

    public Search(WeightedGraph<V> graph) {
        this.graph = graph;
    }

    public abstract List<V> getPath(V start, V end);
}