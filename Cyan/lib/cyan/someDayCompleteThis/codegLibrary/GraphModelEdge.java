package meta.codegLibrary;

public class GraphModelEdge {

    private GraphModelVertice origin;
    private GraphModelVertice destiny;
    private Double cost;

    public GraphModelEdge(GraphModelVertice origin, GraphModelVertice destiny, Double cost) {
        this.origin = origin;
        this.destiny = destiny;
        this.cost = cost;
    }

    public GraphModelVertice getOrigin() {
        return origin;
    }

    public GraphModelVertice getDestiny() {
        return destiny;
    }

    public Double getCost() {
        return this.cost;
    }

}
