package com.homework4;
/**
 * This is the Password2 class
 */
public class Password2 {
    /**
     * This variable holds integer password2
     */
    int password2;

    /**
     * Constructs a new Password2 object with the given integer password.
     * @param password2 the password as an int
     */
    public Password2(int password2)
    {
        if(password2>=10 && password2<=10000)
        {
            this.password2 = password2;
        }
        else
            System.out.println("The integer password is invalid due to because it is not between 10-10000. Try again...”");
    }

    /**
     * Returns the password as an integer.
     * @return the password
     */
    public int getPassword2() {return password2;}

    /**
     * Sets the password to the given integer.
     * @param password2 the new password
     */
    public void setPassword2(int password2) { this.password2 = password2; }

    /**
     * Checks if the password is exactly divisible by a combination of the given denominations.
     * @param denominations an int[] array representing the denominations to test for divisibility
     * @return true if the password is exactly divisible by a combination of the denominations, false otherwise
     */
    public boolean isExactDivision(int[] denominations)
    {
        return isExactDivisionHelper(password2, denominations, 0);
    }

    /**
     * Helper function for isExactDivision(). Works recursively.
     * @param password2 an int representing the password
     * @param denominations an int[] array representing the denominations to test for divisibility
     * @param index an int representing the current index
     * @return true if the password is exactly divisible by a combination of the denominations, false otherwise
     */
    private boolean isExactDivisionHelper(int password2, int[] denominations, int index)
    {
        if(password2 == 0)
        {
            return true;
        }
        if(index >= denominations.length || password2 < 0)
        {
            return false;
        }
        // Check if the current denomination can be used to achieve exact division
        boolean divisonFlag = isExactDivisionHelper(password2 - denominations[index], denominations, index);

        if(divisonFlag)
        {
            return true;
        }
        // Call to the next denomination
        return isExactDivisionHelper(password2, denominations, index + 1);
    }
}