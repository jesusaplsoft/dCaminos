package graphs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.PriorityQueue;


/**
 * @author  vsutskever
 */
public class GraphNodePriorityQueue {

    private PriorityQueue<GraphNode> pQueue = new PriorityQueue<GraphNode>();

    /**
     * Constructor.
     */
    public GraphNodePriorityQueue() {

    }

    /**
     * @param  n  a añadir como nodo
     */
    public void add(final GraphNode n) {
        this.pQueue.add(n);
    }

    /**
     * @param  nodeCollection  a añadir como colección
     */
    public void add(final Collection<GraphNode> nodeCollection) {
        this.pQueue.addAll(nodeCollection);
    }

    /**
     * @return  si tiene más
     */
    public Boolean hasMore() {
        return !this.pQueue.isEmpty();
    }

    /**
     * @return  nodo quitado
     */
    public GraphNode remove() {
        return this.pQueue.remove();
    }

    /**
     * Removes desired graph node, then inserts into appropriate slot.
     *
     * @param  n  a actualizar
     */
    public void updateGraphNodeDistance(final GraphNode n) {
        this.pQueue.remove(n);
        this.pQueue.add(n);
    }

    /**
     * Print Contents.
     */
    public void PrintContents() {
        // it appears that order is preserved when items are removed from the
        // collections
        final ArrayList<GraphNode> _temp = new ArrayList<GraphNode>();
        System.out.println("Size of Q=" + this.pQueue.size());

        while (!this.pQueue.isEmpty()) {
            final GraphNode n = this.pQueue.remove();
            _temp.add(n);
            System.out.println(n.getVal() + " distance=" + n.getDistance());
        }

        this.pQueue.addAll(_temp);
    }

}
