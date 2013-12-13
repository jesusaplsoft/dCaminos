package graphs;

import java.util.Hashtable;


/**
 * @author  vsutskever
 */
public class Dijkstra {

    private Graph graph;
    // priority queue stores all of the nodes, reachable from the start node
    // The queue is sorted by the node.distance
    private GraphNodePriorityQueue priorityQ = new GraphNodePriorityQueue();
    private Hashtable<GraphNode, Integer> distance =
        new Hashtable<GraphNode, Integer>();

    // 1. needs to get the list of all nodes in the graph
    // 2. need to initialize distance vector to infinity
    // 3. Need Edge Cost function
    public Dijkstra(final Graph g) {
        this.graph = g;
        this.graph.getStartNode().setDistance(0);
        this.priorityQ.add(this.graph.getAllNodes());
    }

    /**
     * Actual algorithm.
     */
    public void go() {

        while (this.priorityQ.hasMore()) {
            final GraphNode n = this.priorityQ.remove();

            for (final Edge e : n.getOutGoingEdges()) {
                final GraphNode adjNode = e.getNode();
                final Integer newPossiblePathCost = e.getCost()
                    + n.getDistance();

                if (newPossiblePathCost < adjNode.getDistance()) {
                    adjNode.setDistance(newPossiblePathCost);
                    this.priorityQ.updateGraphNodeDistance(adjNode);
                }
            }
        }
    }

    /**
     */
    public void PrintStatusOfPriorityQ() {
        this.priorityQ.PrintContents();
    }

}
