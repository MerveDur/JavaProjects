package homework8;

/**
 * This class contains the `Main` class
 */
public class Main {
    /**
     * The starting point of the program. It performs tests on different files by creating
     * objects from the TestCases class
     *
     * @param args Command line arguments
     */
        public static void main(String args[]){
            //  public TestCases(String FileName, int X_SIZE, int Y_SIZE)
            new Thread(new TestCases("C:\\Users\\Merve\\IdeaProjects\\GraphProject\\src\\homework8\\map01.txt", 500, 500)).start();
            /*new Thread(new TestCases("Map02.txt", 500, 500)).start();
            new Thread(new TestCases("Map03.txt", 500, 500)).start();
            new Thread(new TestCases("Map04.txt", 500, 500)).start();*/
            new Thread(new TestCases("C:\\Users\\Merve\\IdeaProjects\\GraphProject\\src\\homework8\\map05.txt", 500, 500)).start();/*
            new Thread(new TestCases("Map06.txt", 500, 500)).start();
            new Thread(new TestCases("Map07.txt", 500, 500)).start();
            new Thread(new TestCases("Map08.txt", 500, 500)).start();
            new Thread(new TestCases("Map09.txt", 500, 500)).start();
            new Thread(new TestCases("Map10.txt", 500, 500)).start();*/
        }
}
