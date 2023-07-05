package homework8;

import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.List;

/**
 * Class that uses Breadth-First Search (BFS) algorithm to find a path between two nodes in a CSE222Graph
 */
public class CSE222BFS {
    /**
     * The graph on which the BFS algorithm will be performed
     */
    private CSE222Graph graph;
    /**
     * Maps each node (Point) to a corresponding Node object that contains additional information needed for BFS algorithm.
     */
    private Map<Point, Node> nodeMap;

    /**
     * Constructs a CSE222BFS} object for the given graph
     *
     * @param graph The graph on which BFS algorithm will be performed.
     */
    public CSE222BFS(CSE222Graph graph)
    {
        this.graph = graph;
        //Initialize nodeMap with nodes from the graph
        nodeMap = new HashMap<Point, Node>();
        for(Point point : graph.getNodes())
        {
            nodeMap.put(point, new Node(point));
        }
    }

    /**
     * Inner class that represents a node for BFS algorithm
     * Contains a point and a reference to the previous node in the path
     */
    public class Node {
        Point point; //The point in the graph represented by this node
        Node previous; //The previous node in the BFS path

        Node(Point point)
        {
            this.point = point;
            previous = null;
        }
    }

    /**
     * Applies BFS algorithm to find a path from a source to a destination
     *
     * @param source The starting node of the path
     * @param destination The ending node of the path
     * @return The path from the source to the destination, as a list of Points
     */
    public List<Point> findPath(Point source, Point destination) throws IOException
    {
        //Ensure source and destination are in the graph
        if (!nodeMap.containsKey(source) || !nodeMap.containsKey(destination))
        {
            throw new IllegalArgumentException("Source or destination is not in the graph.");
        }

        Node sourceNode = nodeMap.get(source);
        sourceNode.previous = sourceNode;  //Mark the source node as visited by setting its previous node to itself

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(sourceNode);

        Node destinationNode = null;

        //Apply BFS algorithm
        while (!queue.isEmpty() && destinationNode == null)
        {
            Node u = queue.poll();

            for (Point adjacentPoint : graph.getAdjacencyMap().get(u.point))
            {
                Node v = nodeMap.get(adjacentPoint);
                if (v.previous == null)
                {
                    v.previous = u;
                    queue.add(v);

                    if (v.point.equals(destination))
                    {
                        destinationNode = v;
                        break;
                    }
                }
            }
        }

        // If the destination node was not reached, return an empty list.
        if (destinationNode == null)
        {
            System.out.println("No path found from source to destination.");
            return new ArrayList<Point>();
        }

        return constructPath(sourceNode, destinationNode);
    }

    /**
     * Constructs a path from source node to destination node.
     *
     * @param sourceNode The source node
     * @param destinationNode The destination node
     * @return The constructed path from source to destination.
     */
    private List<Point> constructPath(Node sourceNode, Node destinationNode) throws IOException
    {
        List<Point> path = new LinkedList<Point>();
        Node current = destinationNode;

        while (current != sourceNode)
        {
            path.add(0, current.point);
            current = current.previous;
        }
        path.add(0, sourceNode.point);
       return path;
    }
}
