package alg_projekt3;

import java.util.ArrayList;

public class Length {
    public static int routeLength(Graph graph) {

        ArrayList<Node> cities = graph.getPath();

        int result = 0;
        Node prev = cities.get(cities.size() - 1);

        for (Node city : cities) {

            result += city.distance(graph, prev);

            prev = city;

        }
        return result;
    }
    
    public static int routeProfit(Graph graph) {

        ArrayList<Node> cities = graph.getPath();

        int result = 0;

        for (Node city : cities) {
            result += city.getWidownia();
        }
        return result;
    }
}
