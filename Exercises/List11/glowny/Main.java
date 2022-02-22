package glowny;


public class Main {

    public static void main(String[] args) {
        Graph g = new Graph(6);

        g.addEdge(0,1,4);
        g.addEdge(0,4,2);
        g.addEdge(2,1,7);
        g.addEdge(4,2,8);
        g.addEdge(1,3,1);
        g.addEdge(5,0,3);

        g.dijkstra(1);
        g.BFS(5);
        g.DFS(5);

    }
}
