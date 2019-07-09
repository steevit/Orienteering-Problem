package alg_projekt3;

import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.Math.floor;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.util.ArrayList;
import java.util.Scanner;

public class Graph {
    private Integer miasta;
    private ArrayList<Node> mapa;
    private int[][] dist;
    private boolean[] visited;
    private ArrayList<Node> path;

    public Graph() {}

    public Graph(Integer miasta, ArrayList<Node> mapa) {
        this.miasta = miasta;
        this.mapa = mapa;
        this.dist = new int[miasta][miasta];
        this.visited = new boolean[miasta];
        this.path = new ArrayList<Node>();
    }

    public Graph(Graph graph) {
        this.miasta = graph.miasta;
        this.mapa = graph.mapa;
        this.dist = graph.dist;
        this.visited = graph.visited;
        this.path = graph.path;
    }

    public Integer getMiasta() {
        return miasta;
    }

    public void setMiasta(Integer miasta) {
        this.miasta = miasta;
    }

    public ArrayList<Node> getMapa() {
        return mapa;
    }

    public void setMapa(ArrayList<Node> mapa) {
        this.mapa = mapa;
    }

    public int[][] getDist() {
        return dist;
    }

    public void setDist(int[][] dist) {
        this.dist = dist;
    }

    public boolean[] getVisited() {
        return visited;
    }

    public void setVisited(boolean[] visited) {
        this.visited = visited;
    }

    public ArrayList<Node> getPath() {
        return path;
    }

    public void setPath(ArrayList<Node> path) {
        this.path = path;
    }

    public void compDist() {
        int i = 0;
        int ii=0;
        int[][] dist = new int[this.getMiasta()+5][this.getMiasta()+5];
        for(Node n1 : this.getMapa()) {
            for(Node n2 : this.getMapa()) {
                if(n1!=n2) {
                    dist[i][ii] = Double.valueOf(floor(sqrt(pow(n2.getX()-n1.getX(),2)+pow(n2.getY()-n1.getY(),2)))).intValue();
                }
                ii++;
            }
            ii=0;
            i++;
        }
        this.setDist(dist);
    }
    
    public void loadData(String plik) throws FileNotFoundException {
        File file = new File(plik);
        Scanner in = new Scanner(file);
        
        this.setMiasta(in.nextInt());

        ArrayList<Node> mapa = new ArrayList<Node>();
        for(int i=1;i<this.getMiasta()+1;i++)
        {
            Double x = Double.valueOf(in.next());
            Double y = Double.valueOf(in.next());
            Integer w = in.nextInt();

            mapa.add(new Node(i,x,y,w));
        }

        this.setMapa(mapa);
    }
    
    public Graph run2opt(int start, int DMax){
        double startTime = System.currentTimeMillis();
        Graph graph = TwoOptWithBestNeighbour.build(this, start, DMax);
        double time = System.currentTimeMillis() - startTime;
        System.out.println("Time taken for 2-opt optimisation: " + time);
        return graph;
    }

}
