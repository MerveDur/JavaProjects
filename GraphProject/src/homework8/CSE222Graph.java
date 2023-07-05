package homework8;

import java.awt.Point;
import java.util.*;

/**
 * Represents a Graph constructed from a CSE222Map object, where nodes are points on the map and
 * edges connect adjacent nodes on the map
 */
public class CSE222Graph {
    /**
     * List of nodes (Points) in the graph
     */
    private List<Point> nodes;
    /**
     * Map that associates each node (Point) with a list of its adjacent nodes (Points) in the graph
     */
    private Map<Point, List<Point>> adjacencyMap;

    /**
     * Constructs a graph from a CSE222Map object
     * @param mapObject The map object from which the graph will be constructed
     */
    public CSE222Graph(CSE222Map mapObject)
    {
        //Initialize the nodes list and adjacency map
        nodes = new ArrayList<Point>();
        adjacencyMap = new HashMap<Point, List<Point>>();

        //Get the map from the map object
        ArrayList<ArrayList<Integer>> map = mapObject.getMap();
        int n = map.size();

        //Iterate over the map to create nodes and adjacency map
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                //Create a node for each 0 in the map
                if(map.get(i).get(j) == 0)
                {
                    Point point = new Point(j, i);  //x,y coordinates
                    nodes.add(point);
                    adjacencyMap.put(point, getAdjacentPoints(point, map));//For each node, compute its adjacency list
                }
            }
        }
    }

    /**
     * Gets the adjacent points of a given point in a map.
     *
     * @param point The point whose adjacent points will be found.
     * @param map The map in which to find the adjacent points.
     * @return A list of points adjacent to the given point.
     */
    public List<Point> getAdjacentPoints(Point point, ArrayList<ArrayList<Integer>> map)
    {
        List<Point> adjacents = new ArrayList<Point>();
        //Eight directions in which we can move from a point
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, 1}, {1, -1}};

        //Check each direction
        for(int[] direction : directions)
        {
            int newY = point.y + direction[0];
            int newX = point.x + direction[1];

            if(newY >= 0 && newY < map.size() && newX >= 0 && newX < map.size() && map.get(newY).get(newX) == 0)
            {
                adjacents.add(new Point(newX, newY));
            }
        }
        return adjacents;
    }

    /**
     * Returns the list of nodes in the graph.
     *
     * @return The list of nodes.
     */
    public List<Point> getNodes() {
        return nodes;
    }

    /**
     * Returns the adjacency map of the graph.
     *
     * @return The adjacency map.
     */
    public Map<Point, List<Point>> getAdjacencyMap() {
        return adjacencyMap;
    }

}
