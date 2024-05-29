import java.util.List;

public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>();
        graph.addVertex("Almaty");
        graph.addVertex("Astana");
        graph.addVertex("Shymkent");
        graph.addVertex("Saryagash");
        graph.addVertex("Karagandy");
        graph.addVertex("Kyzylorda");
        graph.addEdge("Almaty", "Astana", 3.5);
        graph.addEdge("Shymkent", "Saryagash", 1.5);
        graph.addEdge("Saryagash", "Astana", 7.5);
        graph.addEdge("Almaty", "Shymkent", 7.2);
        graph.addEdge("Shymkent", "Astana", 5.1);
        graph.addEdge("Astana", "Karagandy", 1.8);
        graph.addEdge("Shymkent", "Kyzylorda", 4.4);

        Search<String> bfs = new BreadthFirstSearch<>(graph);
        List<String> bfsPath = bfs.getPath("Almaty", "Saryagash");
        System.out.println("BFS Path: " + bfsPath);

        Search<String> dijkstra = new DijkstraSearch<>(graph);
        List<String> dijkstraPath = dijkstra.getPath("Almaty", "Saryagash");
        System.out.println("Dijkstra Path: " + dijkstraPath);
    }
}