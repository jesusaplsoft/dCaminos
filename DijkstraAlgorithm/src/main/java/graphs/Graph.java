package graphs;

import java.util.ArrayList;


/**
 * @author  vsutskever Collections of functinos
 */
public class Graph {

    private GraphNode startNode;
    private ArrayList<GraphNode> allNodes = new ArrayList<GraphNode>();
    private ArrayList<Integer> visitedNodes = new ArrayList<Integer>();

    /**
     * @param  startNode  nodo de arranque
     */
    public Graph(final GraphNode startNode) {
        this.startNode = startNode;
        this.discoverGraph();
    }

    /**
     * @return  the start node
     */
    public GraphNode getStartNode() {
        return this.startNode;
    }

    /**
     * @return  una lista con todos los nodos
     */
    public ArrayList<GraphNode> getAllNodes() {
        return this.allNodes;
    }

    /**
     * Breath First Search traversal of the Graph.
     */
    private void discoverGraph() {
        this.allNodes.add(this.startNode);
        this.visit(this.startNode);

        for (final Edge e : this.startNode.getOutGoingEdges()) {

            if (!this.isVisited(e.getNode())) {
                this.bfs(e.getNode());
            }
        }
    }

    /**
     * @param  n
     */
    private void bfs(final GraphNode n) {
        this.visit(n);
        this.allNodes.add(n);

        for (final Edge e : n.getOutGoingEdges()) {

            if (!this.isVisited(e.getNode())) {
                this.bfs(e.getNode());
            }
        }
    }

    /**
     * @param   n
     *
     * @return
     */
    private boolean isVisited(final GraphNode n) {
        return this.visitedNodes.contains(n.getID());
    }

    /**
     * @param  n
     */
    private void visit(final GraphNode n) {
        this.visitedNodes.add(n.getID());
    }

    /**
     */
    public void print() {

        for (final GraphNode n : this.allNodes) {
            System.out.println(n.getVal() + " - " + n.getDistance());
        }

    }

}
