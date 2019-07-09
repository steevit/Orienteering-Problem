package alg_projekt3;

public class Node {

    private Integer nr;
    private Double x;
    private Double y;
    private Integer widownia;

    public Node(Integer nr, Double x, Double y, Integer widownia) {
        this.nr = nr;
        this.x = x;
        this.y = y;
        this.widownia = widownia;
    }

    public Integer getNr() {
        return nr;
    }

    public void setNr(Integer nr) {
        this.nr = nr;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Integer getWidownia() {
        return widownia;
    }

    public void setWidownia(Integer widownia) {
        this.widownia = widownia;
    }

    public int distance(Graph graph, Node n) {
        int[][] dist = graph.getDist();
        return dist[this.getNr()-1][n.getNr()-1];
    }
}

