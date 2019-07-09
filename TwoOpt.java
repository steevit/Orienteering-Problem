package alg_projekt3;

import java.util.ArrayList;

public class TwoOpt {
    public static Graph alternate(Graph graph) {
        Graph newTour;
        Graph graph2 = new Graph(graph);
        double bestDist = Length.routeLength(graph2);
        double newDist;
        int swaps = 1;
        int improve = 0;
        int iterations = 0;
        long comparisons = 0;

        while (swaps != 0) { 
            swaps = 0;

            for (int i = 1; i < graph2.getPath().size() - 2; i++) {
                for (int j = i + 1; j < graph2.getPath().size() - 1; j++) {
                    comparisons++;
                    
                    if ((graph2.getPath().get(i).distance(graph2, graph2.getPath().get(i - 1)) + graph2.getPath().get(j + 1).distance(graph2, graph2.getPath().get(j))) >=
                            (graph2.getPath().get(i).distance(graph2, graph2.getPath().get(j + 1)) + graph2.getPath().get(i - 1).distance(graph2, graph2.getPath().get(j)))) {

                        newTour = swap(graph2, i, j); 

                        newDist = Length.routeLength(newTour);

                        if (newDist < bestDist) { 
                            graph2.setPath(newTour.getPath());
                            bestDist = newDist;
                            swaps++;
                            improve++;
                        }
                    }
                }
            }
            iterations++;
        }
        System.out.println("Liczba porównań: " + comparisons);
        System.out.println("Liczba zamian: " + improve);
        System.out.println("Liczba iteracji: " + iterations);
        System.out.println();
        return graph2;
    }

    private static Graph swap(Graph graph, int i, int j) {
        ArrayList<Node> cities = graph.getPath();

        ArrayList<Node> newTour = new ArrayList<>();

        int size = cities.size();
        for (int c = 0; c <= i - 1; c++) {
            newTour.add(cities.get(c));
        }

        int dec = 0;
        for (int c = i; c <= j; c++) {
            newTour.add(cities.get(j - dec));
            dec++;
        }

        for (int c = j + 1; c < size; c++) {
            newTour.add(cities.get(c));
        }

        Graph graph2 = new Graph(graph);
        graph2.setPath(newTour);

        return graph2;
    }
}
