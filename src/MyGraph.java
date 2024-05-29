
import java.util.*;

public class MyGraph<Vertex> implements Interface<Vertex> {
    private final boolean undirected;
    private final Map<Vertex, List<Vertex>> map;

    public MyGraph(){
        this(true);
    }

    public MyGraph(boolean undirected){
        this.undirected = undirected;
        map = new java.util.Map<Vertex, java.util.List<Vertex>>();
    }

    @Override
    public void addVertex(Vertex v) {
        if(hasVertex(v)) return;
        map.put(v, new LinkedList<>());
    }

    @Override
    public void addEdge(Vertex s, Vertex d) {
        if(!hasVertex(s)) addVertex(s);
        if(!hasVertex(d)) addVertex(d);

        if(hasEdge(s, d) || s.equals(d)) return;

        map.get(s).add(d);
        if(undirected) map.get(d).add(s);
    }

    @Override
    public int getVerticesCount() {
        return map.size();
    }

    @Override
    public int getEdgesCount() {
        int count = 0;
        for(Vertex v : map.keySet()) count += map.get(v).size();
        return undirected ? count / 2 : count;
    }

    @Override
    public boolean hasVertex(Vertex v) {
        return map.containsKey(v);
    }

    @Override
    public boolean hasEdge(Vertex s, Vertex d) {
        if(!hasVertex(s)) return false;
        return map.get(s).contains(d);
    }

    @Override
    public List<Vertex> adjacencyList(Vertex v) {
        if(hasVertex(v)) return null;
        return map.get(v);
    }
}