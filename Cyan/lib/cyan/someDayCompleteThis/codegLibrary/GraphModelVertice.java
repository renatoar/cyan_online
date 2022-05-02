package meta.codegLibrary;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;

public class GraphModelVertice {

    private ArrayList<GraphModelEdge> edges;

    private int label;
    private Point point;

    private GraphModelVertice() {
    	edges = new ArrayList<GraphModelEdge>();
        point = new Point();
    }

    public GraphModelVertice(int x, int y, int label) {
        this();
        this.label = label;
        this.setXY(x, y);
    }

    public int getLabel() {
        return this.label;
    }

    public Point getPoint() {
        return point;
    }

    public int getX() {
        return this.point.x;
    }

    public void setX(int x) {
        this.point.x = x;
    }

    public int getY() {
        return this.point.y;
    }

    public void setY(int y) {
        this.point.y = y;
    }

    public void setXY(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    public double distance(GraphModelVertice vertice) {
        return this.point.distance(vertice.getPoint());
    }

    public void addOrigin(GraphModelEdge edge) {
        this.edges.add(edge);
    }

    public void addDestiny(GraphModelEdge edge) {
        this.edges.add(edge);
    }

    public void removeOrigin(GraphModelEdge edge) {
        Iterator<GraphModelEdge> it = this.edges.iterator();

        int i = 0;
        while (it.hasNext()) {
            GraphModelEdge e = it.next();

            if (e.getOrigin().getLabel() == edge.getOrigin().getLabel()) {
                this.edges.remove(i);
                break;
            }
            ++i;
        }
    }

    public void removeDestiny(GraphModelEdge edge) {
        Iterator<GraphModelEdge> it = this.edges.iterator();

        int i = 0;
        while (it.hasNext()) {
            GraphModelEdge e = it.next();

            if (e.getDestiny().getLabel() == edge.getDestiny().getLabel()) {
                this.edges.remove(i);
                break;
            }
            ++i;
        }
    }

    boolean isOnVertice(int x, int y) {
        return ((x >= point.getX() -25 && x <= point.getX() + 50) && (y >= point.getY() - 25 && y <= point.getY() + 50));
    }


    public ArrayList<GraphModelEdge> getEdges() {
        return edges;
    }

}
