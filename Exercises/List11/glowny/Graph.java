package glowny;

import java.util.*;

public class Graph {

    class Node implements Comparator<Node> {
        public int value;
        public int weight;

        public Node() {
        }

        public Node(int node, int cost) {
            this.value = node;
            this.weight = cost;
        }

        @Override
        public int compare(Node node1, Node node2) {
            if (node1.weight < node2.weight)
                return -1;
            if (node1.weight > node2.weight)
                return 1;
            return 0;
        }
    }

    private int dist[];
    private Set<Integer> visited;
    private PriorityQueue<Node> pq;
    private int verticles;
    LinkedList<Node> adj[];
    int[] previousTab;
    String[] colorTab;

    public Graph(int V) {
        this.verticles = V;
        dist = new int[V];
        visited = new HashSet<Integer>();
        pq = new PriorityQueue<Node>(V, new Node());
        adj = new LinkedList[V];

        for(int i=0; i<V; i++){
            LinkedList<Node> item = new LinkedList<>();
            adj[i] = item;
        }
    }

    public void addEdge(int start, int end, int weight) {
        adj[start].add(new Node(end, weight));
        adj[end].add(new Node(start, weight));
    }

    public void dijkstra(int src) {
        int newDistance;
        for (int i = 0; i < verticles; i++)
            dist[i] = Integer.MAX_VALUE;


        pq.add(new Node(src, 0));

        dist[src] = 0;
        while (visited.size() != verticles) {

            int u = pq.remove().value;

            visited.add(u);

            for (int i = 0; i < adj[u].size(); i++) {
                Node v = adj[u].get(i);
                if (!visited.contains(v.value)) {
                    newDistance = dist[u] + v.weight;
                    if (newDistance < dist[v.value])
                        dist[v.value] = newDistance;

                    pq.add(new Node(v.value, dist[v.value]));
                }
            }
        }
        printResultDijkstra(src);
    }

    public void printResultDijkstra(int src) {
        System.out.println("najkrotsze sciezki z wezla");
        for (int i = 0; i < dist.length; i++)
            System.out.println(src + " do " + i + " - "
                    + dist[i]);
    }

    void BFS(int src) {

        colorTab = new String[verticles];
        int[] distanceTab = new int[verticles];
        previousTab = new int[verticles];
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < verticles; i++) {

            colorTab[i] = "WHITE";
            distanceTab[i] = Integer.MAX_VALUE;
            previousTab[i] = -2;
        }

        colorTab[src] = "GREY";
        distanceTab[src] = 0;
        previousTab[src] = -1;
        queue.add(src);
        int u;
        int z;

        System.out.println("Sciezka przeszukiwan BFS wyglada nastepujaco:");
        while (queue.size() != 0) {
            u = queue.remove();

            for (int i = 0; i < adj[u].size(); i++) {
                z = adj[u].get(i).value;

                if (colorTab[z].equals("WHITE")) {
                    colorTab[z] = "GREY";
                    distanceTab[z] = distanceTab[u] + 1;
                    previousTab[z] = u;
                    queue.add(z);
                }
            }
            colorTab[u] = "BLACK";
            System.out.print(u + ", ");
        }
    }

    public void printPathBFS(int s, int v) {
        System.out.println(" ");
        if (s == v) {
            System.out.print(s + ", ");
        } else if (previousTab[v] == -2) {
            System.out.println("Brak takiej sciezki");
        } else {
            printPathBFS(s, previousTab[v]);
            System.out.print(v + ", ");
        }

    }

    public void DFS(int src) {

        colorTab = new String[verticles];
        previousTab = new int[verticles];

        for (int i = 0; i < verticles; i++) {
            colorTab[i] = "WHITE";
            previousTab[i] = -2;
        }

        System.out.println("\nSciezka przeszukiwan DFS wyglada nastepujaco: ");

        DFS_Visit(src);


    }

    private void DFS_Visit(int u) {

        colorTab[u] = "GREY";
        int z;

        for (int i = 0; i < adj[u].size(); i++) {
            z = adj[u].get(i).value;
            if (colorTab[z].equals("WHITE")) {
                previousTab[z] = u;
                DFS_Visit(z);
            }
        }
        colorTab[u] = "BLACK";
        System.out.print(u + ", ");
    }

}





