package graphs;

import java.util.ArrayList;


/**
 * @author  vsutskever
 */
final class Edge {

    private GraphNode node;
    private Integer cost;

    public Edge(final GraphNode nodeTo, final Integer cost) {
        this.node = nodeTo;
        this.cost = cost;
    }

    /**
     * @return  nodo
     */
    public GraphNode getNode() {
        return this.node;
    }

    /**
     * @return  costo
     */
    public Integer getCost() {
        return this.cost;
    }
}

/**
 * @author  vsutskever
 */
public class GraphNode
    implements Comparable<GraphNode> {

    private static int nodeCount = 0;

    private ArrayList<Edge> outGoingEdges = new ArrayList<Edge>();
    private String val;
    private Integer ID;
    private Integer distance = GraphConstants.INFINITY;

    /**
     * @param  value  inicial
     */
    public GraphNode(final String value) {
        this.init(value);
    }

    /**
     */
    public GraphNode() {
        this.init("");
    }

    /**
     * Initializes.
     *
     * @param  nodeVal
     */
    private void init(final String nodeVal) {
        this.val = nodeVal;
        this.ID = GraphNode.nodeCount++;
    }

    /**
     * @param  visited  si ha sido visitado
     */
    public void setVisited(final boolean visited) {

        System.out.println("Visited" + this.val);
    }

    /**
     * @param  node  exterior a añadir
     * @param  cost  costo del nodo
     */
    public void AddOutgoingEdge(final GraphNode node, final Integer cost) {
        this.outGoingEdges.add(new Edge(node, cost));
    }

    /**
     * @return  lista de bordes
     */
    public ArrayList<Edge> getOutGoingEdges() {
        return this.outGoingEdges;
    }

    public String getVal() {
        return this.val;
    }

    /**
     * @param  val  a poner
     */
    public void setVal(final String val) {
        this.val = val;
    }

    /**
     * @return  id como Integer
     */
    public Integer getID() {
        return this.ID;
    }

    /**
     */
    public int compareTo(final GraphNode arg0) {
        return this.distance.compareTo(arg0.getDistance());
    }

    /**
     * @return  distancia como integer
     */
    public Integer getDistance() {
        return this.distance;
    }

    /**
     * @param  distance  a poner
     */
    public void setDistance(final Integer distance) {
        this.distance = distance;
    }

}
