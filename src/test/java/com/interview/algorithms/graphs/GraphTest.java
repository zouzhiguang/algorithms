package com.interview.algorithms.graphs;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.google.common.base.Joiner;
import com.interview.algorithms.graphs.undirected.search.impls.BFSGraph;
import com.interview.algorithms.graphs.undirected.search.impls.DFSGraph;
import com.interview.algorithms.graphs.undirected.search.Graph;
import com.interview.algorithms.princeton.CommonTest;

/**
 * @author: vzou
 * *
 * @since: 6/1/2016.
 */
public class GraphTest extends CommonTest
{

    @Test(dataProvider = "prepareInstance")
    public void test(String description, Graph graph)
    {
        logger.debug(description);

        graph.addEdge(0, 5);
        graph.addEdge(4, 3);
        graph.addEdge(0, 1);
        graph.addEdge(9, 12);
        graph.addEdge(6, 4);
        graph.addEdge(5, 4);
        graph.addEdge(0, 2);
        graph.addEdge(11, 12);
        graph.addEdge(9, 10);
        graph.addEdge(0, 6);
        graph.addEdge(7, 8);
        graph.addEdge(9, 11);
        graph.addEdge(5, 3);

        // search all that connected to 0
        graph.search(0);

        for (int v = 0; v < graph.V(); v++)
            if (graph.marked(v))
                logger.debug(v + " is connected to 0");

        // connected to itself!
        Assert.assertTrue(graph.hasPathTo(0));
        // should be connected to 1,2,3,4,5,6
        Assert.assertTrue(graph.hasPathTo(1));
        Assert.assertTrue(graph.hasPathTo(3));
        Assert.assertTrue(graph.hasPathTo(5));

        Assert.assertFalse(graph.hasPathTo(7));
        Assert.assertFalse(graph.hasPathTo(9));
        Assert.assertFalse(graph.hasPathTo(11));

        logger.debug("path from 0 to 6 is: {}", Joiner.on('-').join(graph.pathTo(6)));
    }

    @DataProvider
    @Override
    protected Object[][] prepareInstance()
    {
        return new Object[][]{
            {"Graph test, Deep First Search Implementation.", new DFSGraph(13)},
            {"Graph test, Breadth First Search Implementation.", new BFSGraph(13)}
        };
    }
}
