package homework8;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Class that uses Dijkstra's algorithm to find the shortest path between two nodes in a CSE222Graph
 */
public class CSE222Dijkstra {
    /**
     * The graph on which Dijkstra's algorithm will be performed
     */
    private CSE222Graph graph;
    /**
     * Maps each node (Point) to a corresponding Node object that contains additional information needed for Dijkstra's algorithm
     */
    private Map<Point, Node> nodeMap;

    /**
     * Constructs a CSE222Dijkstra object for the given graph
     *
     * @param graph The graph on which Dijkstra's algorithm will be performed
     */
    public CSE222Dijkstra(CSE222Graph graph)
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
     * Inner class that represents a node for Dijkstra's algorithm
     * Contains a point, a reference to the previous node in the path, and a distance
     */
    public class Node
    {
        /**
         * The point in the graph represented by this node
         */
        Point point;
        /**
         * The previous node in the shortest path
         */
        Node previous;
        /**
         * The shortest distance from the source to this node
         */
        int distance;

        Node(Point point)
        {
            this.point = point;
            distance = Integer.MAX_VALUE;
            previous = null;
        }
    }

    /**
     * Comparator class for Node objects. Nodes are compared based on their distance
     */
    private static class NodeComparator implements Comparator<Node>
    {
        @Override //The node with smaller distance has higher priority
        public int compare(Node n1, Node n2)
        {
            if (n1.distance < n2.distance)
            {
                return -1;
            }
            else if(n1.distance == n2.distance)
            {
                return 0;
            }
            else
            {
                return 1;
            }
        }
    }

    /**
     * Applies Dijkstra's algorithm to find the shortest path from a source to a destination
     *
     * @param source The starting node of the path.
     * @param destination The ending node of the path.
     * @return The shortest path from the source to the destination, as a list of Points.
     */
    public List<Point> findPath(Point source, Point destination)
    {
        if(!nodeMap.containsKey(source) || !nodeMap.containsKey(destination))//Ensure source and destination are in the graph
        {
            throw new IllegalArgumentException("Source or destination is not in the graph.");
        }

        //Initialize source node's distance to 0
        Node sourceNode = nodeMap.get(source);
        sourceNode.distance = 0;

        //Initialize priority queue with the source node
        PriorityQueue<Node> queue = new PriorityQueue<Node>(10, new NodeComparator());
        queue.add(sourceNode);

        while (!queue.isEmpty()) //Take the node with smallest distance from the queue
        {
            Node u = queue.poll();
            if (u.point.equals(destination)) //Stop when we reach the destinatio
            {
                break;
            }

            //Update the distances of the neighboring nodes
            for(Point adjacentPoint : graph.getAdjacencyMap().get(u.point))
            {
                Node v = nodeMap.get(adjacentPoint);
                int altDistance = u.distance + 1; //Assuming each edge has weight of 1
                if(altDistance < v.distance)
                {
                    queue.remove(v);
                    v.distance = altDistance;
                    v.previous = u;
                    queue.add(v);
                }
            }
        }

        //Construct shortest path from source to destination
        List<Point> path = new ArrayList<Point>();
        Node current = nodeMap.get(destination);
        while (current != null)
        {
            path.add(0, current.point);
            current = current.previous;
        }
        if(nodeMap.get(destination).previous == null)
        {
            System.out.println("No path found from source to destination.");
            return new ArrayList<Point>();
        }
        return path;
    }
}
