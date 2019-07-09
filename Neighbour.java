package alg_projekt3;

import java.util.ArrayList;

public class Neighbour {
    public static void bestN(Graph graph, int v, ArrayList<Node> path) {
        int[][] dist = graph.getDist();
        boolean[] visited = graph.getVisited();
        int newV = v;
        double wspolczynnik = 0.00;

        for(Node n : graph.getMapa()) {
            if(dist[v-1][n.getNr()-1]!=0) {
                double p = n.getWidownia();
                double d = dist[v-1][n.getNr()-1];
                double ws=p/d;
                    if (ws > wspolczynnik && visited[n.getNr() - 1] != true) {
                        wspolczynnik =ws;
                        newV = n.getNr();
                    }
            }
        }

        if(newV!=v) {
            visited[newV-1]=true;
            int e = path.get(path.size()-1).getNr();
            path.remove(path.size()-1);
            path.add(graph.getMapa().get(newV-1));
            path.add(graph.getMapa().get(e-1));
            graph.setPath(path);
        }
    }
    
}
