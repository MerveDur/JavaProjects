package com.homework4;
/**
 * Main Class consturct
 * @author Merve Dur
 * This is the main class for running the test scenarios.
 */

public class Main {

    /**
     * Default constructor of Main class
     */
    public Main() {
    }
    /**
     * Main method
     * @param args command line argument
     */
    public static void main(String[] args)
    {
        /**
         * This variable holds array of denominations
         */
        int[] denominations = {4, 17, 29};

        //Examples are created for tests
        System.out.println("SCENARIO 1");
        Username user1 = new Username("gokhan123");
        Password1 pass1_1 = new Password1("{[aaddaa]}");
        Password2 pass2_1 = new Password2(75);
        try
        {
            testScenario(user1.getUsername(), pass1_1.getPassword1(), pass2_1.getPassword2(), denominations);
        }
        catch (Exception e)
        {
            //System.out.println("An error occurred: " + e.getMessage());
        }
        System.out.println("SCENARIO 2");
        Username user2 = new Username("elif");
        Password1 pass1_2 = new Password1("{[xy(xyxyx)]}");
        Password2 pass2_2 = new Password2(56);
        try
        {
            testScenario(user2.getUsername(),pass1_2.getPassword1(),pass2_2.getPassword2(),denominations);
        }
        catch (Exception e)
        {
            //System.out.println("An error occurred: " + e.getMessage());
        }
        System.out.println("SCENARIO 3");
        Username user3 = new Username("ahmet");
        Password1 pass1_3 = new Password1("]{[abc(abc)abc]}");
        Password2 pass2_3 = new Password2(88);
        try
        {
            testScenario(user3.getUsername(),pass1_3.getPassword1(),pass2_3.getPassword2(),denominations);
        }
        catch (Exception e)
        {
            //System.out.println("An error occurred: " + e.getMessage());
        }
        System.out.println("SCENARIO 4");
        Username user4 = new Username("mehmet");
        Password1 pass1_4 = new Password1("{[(wacaceacay)]}");
        Password2 pass2_4 = new Password2(68);
        try
        {
            testScenario(user4.getUsername(),pass1_4.getPassword1(),pass2_4.getPassword2(),denominations);
        }
        catch (Exception e)
        {
            //System.out.println("An error occurred: " + e.getMessage());
        }
        System.out.println("SCENARIO 5");
        Username user5 = new Username("ayse");
        Password1 pass1_5 = new Password1("{[xyy]x}");
        Password2 pass2_5 = new Password2(35);
        try
        {
            testScenario(user5.getUsername(),pass1_5.getPassword1(),pass2_5.getPassword2(),denominations);
        }
        catch (Exception e)
        {
            //System.out.println("An error occurred: " + e.getMessage());
        }
        System.out.println("SCENARIO 6");
        Username user6 = new Username("zeynep");
        Password1 pass1_6 = new Password1("{[(ecarcar)]}");
        Password2 pass2_6 = new Password2(75);
        try
        {
            testScenario(user6.getUsername(),pass1_6.getPassword1(),pass2_6.getPassword2(),denominations);
        }
        catch (Exception e)
        {
            //System.out.println("An error occurred: " + e.getMessage());
        }
    }
    /**
     * Tests a scenario with a given username, password1, password2, and denominations.
     * Prints the result of each check and whether the door can be opened or not.
     *
     * @param username       the username to be tested
     * @param password1      the string password to be tested
     * @param password2      the integer password to be tested
     * @param denominations  the denominations to be used for the exact division check
     */
    public static void testScenario(String username, String password1, int password2, int[] denominations)
    {
        Username user = new Username(username);
        Password1 pass1 = new Password1(password1);
        Password2 pass2 = new Password2(password2);

        boolean checkIfValidUsernameControl = user.checkIfValidUsername();
        boolean containsUsernameSpiritControl = pass1.containsUserNameSpirit(username);
        boolean isBalancedPasswordControl = pass1.isBalancedPassword();
        boolean isPalindromePossibleControl = pass1.isPalindromePossible();
        boolean isExactDivisionControl = pass2.isExactDivision(denominations);

        if(checkIfValidUsernameControl==true && containsUsernameSpiritControl==true
                && isBalancedPasswordControl==true && isPalindromePossibleControl==true
                && isExactDivisionControl==true)
        {
            System.out.println("The username and passwords are valid. The door is opening, please wait...");
        }
        else if(checkIfValidUsernameControl==false)
        {
            System.out.println("The username is invalid due to  it has not at least 1 character or not all of its characters are letters. Try again...");
        }
        else if(containsUsernameSpiritControl==false)
        {
            System.out.println("The string password is invalid due to does not contain at least one letter from the username. Try again...");
        }
        else if(isBalancedPasswordControl==false)
        {
            System.out.println("The string password is invalid due to because the brackets don't match. Try again...");
        }
        else if(isPalindromePossibleControl==false)
        {
            System.out.println("The string password is invalid due to because palindrome is not available. Try again...");
        }
        else if(isExactDivisionControl==false)
        {
            System.out.println("The integer password is invalid due to because it can't provide exact division. Try again...");
        }
        else
        {
            System.out.println("Unidentified Error");
        }
    }
}