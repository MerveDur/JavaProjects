package homework8;

import java.awt.*;
import java.io.IOException;
import java.util.List;

/**
 * This class is used to run tests on a specific file and size
 */
public class TestCases implements Runnable {

    /**
     * Variable representing the name of the file to be tested
     */
    private  String FileName;
    /**
     * Variable representing the size of the map on the x axis
     */
    private int X_SIZE;
    /**
     * Variable representing the size of the map on the y axis
     */
    private int Y_SIZE;

    /**
     * It is the constructor method of the TestCases class
     * Retrieves filename and size information
     *
     * @param FileName Filename
     * @param X_SIZE The size of the map on the X-axis
     * @param Y_SIZE The size of the map on the Y-axis
     */
    public TestCases(String FileName, int X_SIZE, int Y_SIZE)
    {
        this.FileName = FileName;
        this.X_SIZE = X_SIZE;
        this.Y_SIZE = Y_SIZE;
    }

    /**
     * The method that performs the tests. It performs path finding and drawing operations using map,
     * graph,Dijkstra and BFS algorithms
     * @throws IOException If a file error occurs
     */
    public void test() throws IOException {
        System.out.println("\n\n*******************\nMap is " + this.FileName + " with X_SIZE " + this.X_SIZE + " and Y_SIZE " + this.Y_SIZE + "\n********************\n");
        CSE222Map Map = new CSE222Map(this.FileName, this.X_SIZE, this.Y_SIZE);
        CSE222Graph Graph = new CSE222Graph(Map);
        long startTime, endTime, duration;

        CSE222Dijkstra Dijkstra = new CSE222Dijkstra(Graph);
        startTime = System.nanoTime();
        List<Point> DijkstraPath = Dijkstra.findPath(Map.getStartPoint(),Map.getEndPoint());
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1000000;  // Convert from nanoseconds to milliseconds
        System.out.println("Dijkstra algorithm took: " + duration + " ms for" + this.FileName);

        CSE222BFS BFS = new CSE222BFS(Graph);
        startTime = System.nanoTime();
        List<Point> BFSPath = BFS.findPath(Map.getStartPoint(),Map.getEndPoint());
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1000000;
        System.out.println("BFS algorithm took: " + duration + " ms for" + this.FileName);
        String inputFilePath = this.FileName.replace(".txt", ".png");
        String outputFilePath = this.FileName.replace(".txt", "_line.png");

        Map.convertPNG(inputFilePath);

        //Map.convertPNG(this.FileName.replace(".txt",".png"));
        //Dijkstra path in RED
        Map.drawLine(DijkstraPath, Color.RED, inputFilePath, outputFilePath);
        inputFilePath = outputFilePath;
        outputFilePath = this.FileName.replace(".txt", "_line.png");

        // BFS path in BLUE
        Map.drawLine(BFSPath, Color.BLUE, inputFilePath, outputFilePath);
        Map.writePath(BFSPath, this.FileName.replace(".txt", "_BFS_path.txt"));
        Map.writePath(DijkstraPath, this.FileName.replace(".txt", "_Dijkstra_path.txt"));
        System.out.println("Dijkstra Path: " + DijkstraPath.size()+ "for" + this.FileName);
        System.out.println("BFS Path: " + BFSPath.size()+ "for" + this.FileName);
    }

    /**
     * Implements the method that starts the tests on the background thread
     */
    @Override
    public void run() {
        try {
            test();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
