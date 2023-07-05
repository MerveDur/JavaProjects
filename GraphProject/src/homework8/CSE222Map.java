package homework8;

import java.awt.*;
import java.io.*;
import java.util.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

/**
 * This class represents a `CSE222Map` object that reads and processes the map file
 */
public class CSE222Map {

    /**
     * The starting point of the map represented by a Point object
     */
    private Point startPoint;
    /**
     * The ending point of the map represented by a Point object
     */
    private Point endPoint;
    /**
     * The 2D map represented as an ArrayList of ArrayLists of Integers
     */
    private ArrayList<ArrayList<Integer>> map;

    /**
     * Returns the starting point
     * @return starting point
     */
    public Point getStartPoint() {return startPoint;}

    /**
     * Sets the starting point
     * @param start_Point New starting point
     */
    public void setStart_Point(Point start_Point) {
        this.startPoint = start_Point;
    }

    /**
     * Returns the endpoint
     * @return endpoint
     */
    public Point getEndPoint() {
        return endPoint;
    }

    /**
     * Sets the endpoint point.
     * @param end_Point New endpoint point
     */
    public void setEndPoint(Point end_Point) {
        this.endPoint = end_Point;
    }

    /**
     * Returns the map
     * @return map
     */
    public ArrayList<ArrayList<Integer>> getMap() {
        return map;
    }

    /**
     * Sets the map
     * @param map New map object
     */
    public void setMap(ArrayList<ArrayList<Integer>> map) {
        this.map = map;
    }

    /**
     * Constructor for CSE222Map.
     *
     * @param filename The name of the file from which to parse the map.
     * @param X_SIZE The maximum X size of the map.
     * @param Y_SIZE The maximum Y size of the map.
     */
    public CSE222Map(String filename,int X_SIZE, int Y_SIZE)
    {
        //Initialize map
        try
        {
            map = new ArrayList<ArrayList<Integer>>();
            List<String> lines=new ArrayList<String>();
            File file = new File(filename);  //Read file lines
            Scanner scanner = new Scanner(file);
            file.getTotalSpace();
            while(scanner.hasNextLine()) //Collect all lines
            {
                String line = scanner.nextLine();
                lines.add(line);
            }
            scanner.close();
            startPoint = createPoint(lines.get(0)); // Create start and end points from the first two lines
            endPoint = createPoint(lines.get(1));

            //Parse the map data from the rest of the lines
            for(int i = 0; i < X_SIZE; i++)
            {
                String[] values = lines.get(i + 2).split(",");
                map.add(new ArrayList<Integer>());
                for(int j = 0; j < Y_SIZE; j++)
                {
                    map.get(i).add(j,Integer.parseInt(values[j]));
                    if(map.get(i).get(j) == -1)//Replaces -1's with 1's
                    {
                        map.get(i).add(j,1);
                    }
                }
            }
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Converts a line from the map file into a Point object.
     *
     * The line is split on the comma (,) character. The first part is treated as the y coordinate,
     * and the second part is treated as the x coordinate. A new Point object is created with these
     * coordinates and returned.
     *
     * @param line A line from the map file, containing the x and y coordinates separated by a comma
     * @return The Point object representing the coordinates from the line
     */
    private Point createPoint(String line)//Method to convert a line into a Point
    {
        String[] parts = line.split(",");
        int y = Integer.parseInt(parts[0]);
        int x = Integer.parseInt(parts[1]);
        return new Point(x, y);
    }

    /**
     * Method to convert the map to a PNG file
     * @param outputPath The file path where the PNG will be saved.
     */
    public void convertPNG(String outputPath)
    {
        //Initialize a new BufferedImage
        BufferedImage image = new BufferedImage(map.size(), map.get(0).size(), BufferedImage.TYPE_INT_ARGB);

        //Convert map values to pixel colors
        for(int i = 0; i < map.size(); i++)
        {
            for(int j = 0; j < map.get(0).size(); j++)
            {
                int value = map.get(i).get(j);
                int pixelValue=0;

                //Convert 1 to white pixel, 0 to black pixel
                if(value == 1)
                {
                    pixelValue = 0xFFFFFFFF;
                }
                else
                {
                    pixelValue = 0xFF000000;
                }
                image.setRGB(j, i, pixelValue);//Set pixel color
            }
        }
        try //Write the BufferedImage to PNG file
        {
            File output = new File(outputPath);
            ImageIO.write(image, "PNG", output);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Method to draw a line (path) on the map
     * @param path The list of points forming the path
     * @param colorName The color of the path line
     * @param inputFilePath The file path of the input PNG
     * @param outputFilePath The file path where the output PNG will be saved
     */
    public void drawLine(List<Point> path,Color colorName, String inputFilePath, String outputFilePath)
    {
        try
        {
            //Read PNG file and get BufferedImage object
            BufferedImage image = ImageIO.read(new File(inputFilePath));

            //Get Graphics2D object to draw on BufferedImage
            Graphics2D graphics = image.createGraphics();

            //Set the drawing color to red
            graphics.setColor(colorName);

            //Draw all points on the shortest path
            for(Point point : path)
            {
                graphics.fillOval(point.x, point.y, 5, 5);//Draw a 5x5 circle
            }

            //Release the graphic object
            graphics.dispose();

            //Write the BufferedImage object to the PNG file
            File output = new File(outputFilePath);
            ImageIO.write(image, "PNG", output);

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    /**
     * Method to write the path to a file
     * @param path The list of points forming the path
     * @param filename The file where the path will be saved.
     */
    public void writePath(List<Point> path, String filename) {
        PrintWriter out = null;
        try
        {
            //Open the output file
            out = new PrintWriter(new FileWriter(filename));
            for(Point point : path)//Write all points in the path to the file
            {
                out.println(point.x + "," + point.y);
            }
        }
        catch (IOException e)
        {
            System.err.println("Error writing to file " + filename);
        }
        finally
        {
            if (out != null)
            {
                out.close();
            }
        }
    }
}
