package alg_projekt3;

import java.util.ArrayList;

public class TwoOptWithBestNeighbour {
    private static String[] trasa;
    private static int profit,dystans;
    public static Graph build(Graph graph, int s, int dMax) {
        ArrayList<Node> path = new ArrayList<Node>();

        path.add(graph.getMapa().get(s-1));
        boolean[] visited = new boolean[graph.getMiasta()];
        visited[s-1]=true;
        graph.setVisited(visited);
        path.add(graph.getMapa().get(s-1));
        graph.setPath(path);
        int i=1;

        while(Length.routeLength(graph) <= dMax) {
            Neighbour.bestN(graph, path.get(path.size()-2).getNr(), path);
            graph = TwoOpt.alternate(graph);
            System.out.println("Iteracja " + i + ": DYSTANS - " + Length.routeLength(graph) + ", PROFIT - " + Length.routeProfit(graph));
            i++;
        }
        while(true){
            if(Length.routeLength(graph) > dMax) {
                path.remove(path.size()-2);
                graph.setPath(path);
                graph = TwoOpt.alternate(graph);
            }else{
                break;
            }
        }
        printTrasa(graph);

        return graph;
    }

    private static void printTrasa(Graph graph) {
        System.out.println();
        int i=0;
        for(Node v : graph.getPath()) {
            System.out.print(v.getNr() + "(" + v.getWidownia() + ")" + " -> ");
            i++;
        }

        trasa = new String[i];
        i=0;
        for(Node v : graph.getPath()) {
           trasa[i++]=v.getNr().toString();
        }
        profit = Length.routeProfit(graph);
        dystans = Length.routeLength(graph);
        double proc = (profit*100)/13450;
        System.out.println();
        System.out.println("Profit: "+ profit+" (" + proc +"%), Dystans: " + dystans);
        
    }
    public String getTrasa(){
        if(trasa.length==0)return null;
        return String.join(" -> ",trasa);
    }
    public String getProfit(){
        return String.valueOf(profit);
    }
    public String getDystans(){
        return String.valueOf(dystans);
    }
}

