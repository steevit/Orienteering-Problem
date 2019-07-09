package alg_projekt3;

import java.io.FileNotFoundException;

public class OP {
    
    public static void main(String[] args) throws FileNotFoundException {
        
        Graph graph = new Graph();
        graph.loadData("test.txt");
        graph.compDist();
        graph = graph.run2opt(1, 7600);
        
    }
    
}
