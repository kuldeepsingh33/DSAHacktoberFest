import java.util.*;

class Dijkstra_algo {

    // Adjacency list to store (neighbor, weight) pairs
    List<List<Pair>> adj = new ArrayList<>();
    int[] dist;        // To store the shortest distances from the source
    boolean[] visited; // To track visited nodes

    // Class to represent a pair of (node, weight)
    static class Pair {
        int vertex, weight;

        Pair(int v, int w) {
            this.vertex = v;
            this.weight = w;
        }
    }

    // Constructor
    public Dijkstra_algo() {}

    // Dijkstra's algorithm to find the shortest path from source to all nodes
    void dijkstra(int src, int n) {
        // Priority queue (min-heap) to store nodes with their current distances
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.weight));

        dist = new int[n];              // Initialize distances to infinity
        Arrays.fill(dist, Integer.MAX_VALUE);
        visited = new boolean[n];       // Initialize all nodes as unvisited
        dist[src] = 0;                  // Distance to source is 0
        pq.add(new Pair(src, 0));       // Add source to priority queue

        while (!pq.isEmpty()) {
            int u = pq.poll().vertex;   // Get the node with the smallest distance

            if (visited[u]) continue;   // If already visited, skip it

            visited[u] = true;          // Mark node as visited

            // Explore neighbors of node u
            for (Pair neighbor : adj.get(u)) {
                int v = neighbor.vertex;
                int weight = neighbor.weight;

                // If a shorter path is found
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight; // Update distance
                    pq.add(new Pair(v, dist[v])); // Push updated distance into the queue
                }
            }
        }
    }

    // Method to add an edge between nodes u and v with weight w
    void addEdge(int u, int v, int w) {
        adj.get(u).add(new Pair(v, w));
        adj.get(v).add(new Pair(u, w)); // Since the graph is undirected
    }

    // Method to initialize the graph and find the shortest paths
    int[] shortestPath(int n, int src) {
        // Initialize adjacency list for n nodes
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        dijkstra(src, n); // Run Dijkstra's algorithm from the source
        return dist;      // Return the shortest distances
    }

    public static void main(String[] args) {
        int n = 6; // Number of vertices
        Dijkstra_algo solver = new Dijkstra_algo();

        // Add edges between nodes (u, v, weight)
        solver.addEdge(0, 1, 4);
        solver.addEdge(0, 2, 3);
        solver.addEdge(1, 2, 1);
        solver.addEdge(1, 3, 2);
        solver.addEdge(2, 3, 4);
        solver.addEdge(3, 4, 2);
        solver.addEdge(4, 5, 6);

        int[] dist = solver.shortestPath(n, 0); // Find the shortest path from node 0

        // Print the shortest distances from the source to each vertex
        System.out.println("Vertex \t Distance from Source");
        for (int i = 0; i < n; i++) {
            System.out.println(i + " \t\t " + dist[i]);
        }
    }
}
