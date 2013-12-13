package graphs;

import org.apache.log4j.Logger;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;

import org.junit.runners.MethodSorters;


/**
 * @author  vsutskever + jmr
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestDijkstra {

    static Logger log = Logger.getLogger("graphs");

    static GraphNode A;
    static GraphNode B;
    static GraphNode C;
    static GraphNode D;
    static GraphNode E;

    /**
     * Antes de la Clase.
     *
     * @throws  Exception  por error
     */
    @BeforeClass
    public static void setUpBeforeClass()
            throws Exception {
        TestDijkstra.A = new GraphNode("A");
        Assert.assertNotNull("El objeto A es nulo", TestDijkstra.A);

        TestDijkstra.B = new GraphNode("B");
        Assert.assertNotNull("El objeto B es nulo", TestDijkstra.B);

        TestDijkstra.C = new GraphNode("C");
        Assert.assertNotNull("El objeto C es nulo", TestDijkstra.C);

        TestDijkstra.D = new GraphNode("D");
        Assert.assertNotNull("El objeto D es nulo", TestDijkstra.D);

        TestDijkstra.E = new GraphNode("E");
        Assert.assertNotNull("El objeto E es nulo", TestDijkstra.E);

        TestDijkstra.log.error("Vladimir Sutskever + JMR");
    }

    /**
     * Tras la clase.
     *
     * @throws  Exception  por error
     */
// @AfterClass
    public static void tearDownAfterClass()
            throws Exception {
        System.out.println("tearDownAfterClass");
    }

    /**
     * Antes de cada Test.
     *
     * @throws  Exception  por error
     */
// @Before
    public void setUp()
            throws Exception {
        System.out.println("setUp");
    }

    /**
     * Tras cada Test.
     *
     * @throws  Exception  por error.
     */
// @After
    public void tearDown()
            throws Exception {
    }

    /**
     * Añadir borde exterior.
     */
    @Test
    public void addOutgoingEdge() {
        TestDijkstra.A.AddOutgoingEdge(TestDijkstra.B, 5);
        TestDijkstra.A.AddOutgoingEdge(TestDijkstra.C, 20);
        Assert.assertTrue("La lista no tiene 2 elementos",
            TestDijkstra.A.getOutGoingEdges().size() == 2);

        TestDijkstra.B.AddOutgoingEdge(TestDijkstra.D, 1);
        Assert.assertTrue("La lista no tiene 1 elemento",
            TestDijkstra.B.getOutGoingEdges().size() == 1);

        TestDijkstra.C.AddOutgoingEdge(TestDijkstra.D, 3);
        TestDijkstra.C.AddOutgoingEdge(TestDijkstra.E, 1);
        Assert.assertTrue("La lista no tiene 2 elementos",
            TestDijkstra.C.getOutGoingEdges().size() == 2);

        TestDijkstra.D.AddOutgoingEdge(TestDijkstra.E, 100);
        Assert.assertTrue("La lista no tiene 1 elemento",
            TestDijkstra.D.getOutGoingEdges().size() == 2);
    }

    /**
     * Objeto Graph.
     */
    @Test
    public void graph() {
        final Graph myGraph = new Graph(TestDijkstra.A);
        final Dijkstra dAlg = new Dijkstra(myGraph);
        dAlg.go();
        dAlg.PrintStatusOfPriorityQ();
        myGraph.print();
    }

}
