package com.homework5;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.tree.DefaultMutableTreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * The TreeProject class reads the data in the tree.txt file and displays it in the JTree structure.
 */
public class TreeProject {
    /**
     * It keeps a variable from the JFrame class to create the interface.
     */
    JFrame frame = new JFrame();
    /**
     * It keeps a variable holding root of tree
     */
    DefaultMutableTreeNode root;

    /**
     * Constructor for the TreeProject class.
     */
    TreeProject()
    {
        try {
            //A scanner object is created to read the file
            File file = new File("C:\\Users\\Merve\\IdeaProjects\\TreeProject\\src\\com\\homework5\\tree.txt");
            Scanner scanner = new Scanner(file);

            //The read data is saved in the 2D arraylist
            List<List<String>> data = new ArrayList<List<String>>();

            //Data in the file is read line by line and saves to ArrayList
            while(scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                String[] columns = line.split(";");
                List<String> row = new ArrayList<String>();
                for(String column_Data : columns)
                {
                    row.add(column_Data);
                }
                data.add(row);
            }
            scanner.close();//Scanner object close

            //JTree created with root node
            root = new DefaultMutableTreeNode("Root");
            JTree tree = new JTree(root);

            //Add the data from the ArrayList to the appropriate nodes in the tree
            for(int i = 0; i < data.size(); i++)
            {
                List<String> columns = data.get(i);
                DefaultMutableTreeNode parentNode = root;
                for(int j = 0; j < columns.size(); j++)
                {
                    String column = columns.get(j).trim();
                    parentNode = addNode(parentNode, column);
                }
            }

            //JTree is added to JFrame
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.add(new JScrollPane(tree));
            frame.setSize(500, 500);
            frame.setVisible(true);

        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not exist.");
            e.printStackTrace();
        }
    }

    /**
     * It checks if there is a child node under a specified parent node, if not, it is created and added.
     *
     * @param parent The parent node.
     * @param new_Data The value of the child node.
     * @return The existing or newly created child node.
     */
    private DefaultMutableTreeNode addNode(DefaultMutableTreeNode parent, String new_Data)
    {
        for(int i = 0; i < parent.getChildCount(); i++)
        {
            DefaultMutableTreeNode childNode = (DefaultMutableTreeNode) parent.getChildAt(i);
            if(new_Data.equals(childNode.getUserObject().toString()))
            {
                return childNode;
            }
        }

        //If no child node exists, it is created and added
        DefaultMutableTreeNode child_Node = new DefaultMutableTreeNode(new_Data);
        parent.add(child_Node);
        return child_Node;
    }
    /**
     * Search for a node in the tree using the Breadth-First Search (BFS) algorithm.
     *
     * @param root The root node of the tree.
     * @param search_Value The value of the node to search for.
     */
    public void BFS(DefaultMutableTreeNode root, String search_Value)
    {
        System.out.println("Using BFS to find \'"+search_Value+"\' in the tree..");
        //Initializes the queue and adds the root node
        Queue<DefaultMutableTreeNode> queue = new LinkedList<DefaultMutableTreeNode>();
        queue.add(root);
        int step =1,flag=0;

        //Continues searching if queue is not empty and node is found
        while (!queue.isEmpty() && flag==0)
        {
            //Display the current step and node value
            DefaultMutableTreeNode currentNode = queue.poll();
            System.out.println("Step " + step + " -> " + currentNode.getUserObject());

            //The current node and the node to be searched are compared
            if(currentNode.getUserObject().toString().equals(search_Value))
            {
                //If node is found, flag 1 is set
                System.out.println(search_Value +" (Found!)");
                flag=1;
            }
            else
            {
                //If node is found, the child nodes of the current node are added to the queue
                for(int i = 0; i < currentNode.getChildCount(); i++)
                {
                    queue.add((DefaultMutableTreeNode) currentNode.getChildAt(i));
                }
                step++;
            }
        }
        //If the node was not found, display a message
        if(flag==0)
        {
            System.out.println(search_Value + " not found!");
        }
    }

    /**
     * Performs a Depth-First Search (DFS) on the tree to find a node with the specified search value.
     *
     * @param node The current node being explored.
     * @param searchValue The value of the node to search for.
     * @param step The current step in the search process.
     * @return true if the node is found, false otherwise.
     */
    public int DFS(DefaultMutableTreeNode node, String searchValue, int step)
    {
        //Display the current step and node value
        System.out.println("Step " + step + " -> " + node.getUserObject());

        //Check if the current node matches the search value
        if(node.getUserObject().toString().equals(searchValue))
        {
            System.out.println(searchValue + " (Found!)");
            return -1; // return -1 to signal that the node has been found
        }

        //Find child nodes in reverse order
        for(int  i= node.getChildCount()-1; i >=0; i--)
        {
            //Recursively call DFS on child nodes, incrementing the step before the call
            int result = DFS((DefaultMutableTreeNode) node.getChildAt(i), searchValue, step+1);
            if(result == -1) // if the node was found in the recursive call
            {
                return -1;
            }
            step = result; // update the current step with the highest step number returned by the recursive call
        }
        return step;
    }



    /**
     * Performs a Post-Order Traversal on the tree to find a node with the specified search value.
     *
     * @param node The current node being explored.
     * @param searchValue The value of the node to search for.
     * @param step The current step in the search process.
     * @return The next step number if the node is found, -1 otherwise.
     */
    public int postOrderTraversal(DefaultMutableTreeNode node, String searchValue, int step)
    {
        int nextStep= step;

        //Find child nodes
        for(int i = 0; i < node.getChildCount(); i++)
        {
            //Recursively call postOrderTraversal on child nodes
            int result = postOrderTraversal((DefaultMutableTreeNode) node.getChildAt(i), searchValue, nextStep);
            if(result != -1)
            {
                nextStep = result;
            }
        }

        //Display the current step and node value if not the root node
        if(!node.getUserObject().toString().equals("Root"))
        {
            System.out.println("Step " + (nextStep) + " -> " + node.getUserObject());
        }

        //Check if the current node matches the search value
        if(node.getUserObject().toString().equals(searchValue))
        {
            System.out.println(searchValue + " (Found!)");
            return -1;
        }

        return nextStep+1;
    }




    /** The main method of the TreeProject class.
     *  @param args Command-line arguments .
     */
    public static void main(String[] args)
    {
        TreeProject treeProject = new TreeProject();
        Scanner inputScanner = new Scanner(System.in);

        //The node name to be searched is taken from the user.
        System.out.print("Enter the value to search for in the tree using BFS: ");
        String searchValue = inputScanner.nextLine();

        //BFS algorithm is called
        treeProject.BFS(treeProject.root, searchValue);

        System.out.print("Enter the value to search for in the tree using DFS: ");
        String searchValueDFS = inputScanner.nextLine();
        System.out.println("Using DFS to find '" + searchValueDFS + "' in the tree.");
        int resultDFS = treeProject.DFS(treeProject.root, searchValueDFS, 1);

        if (resultDFS != -1) {
            System.out.println(searchValueDFS + " not found!");
        }


        System.out.print("Enter the value to search for in the tree using Post-Order traversal: ");
        String searchValuePostOrder = inputScanner.nextLine();
        System.out.println("Using Post-Order traversal to find '" + searchValuePostOrder + "' in the tree...");
        int resultPostOrder = treeProject.postOrderTraversal(treeProject.root, searchValuePostOrder, 1);

        if (resultPostOrder == -1) {
            System.out.println(searchValuePostOrder + " not found!");
        }


    }
}
