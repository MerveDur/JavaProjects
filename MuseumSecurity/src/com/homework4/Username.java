package com.homework4;
/**
 * This is the Username class
 */
public class Username{
    /**
     * This variable holds string username
     */
    private String username;
    /**
     * Constructs a new Username object with the given username.
     * @param username the username as a string
     */
    public Username(String username) {
        this.username = username;
    }

    /**
     * Returns the username as a string.
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username to the given string.
     * @param username the new username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Checks that the username contains at least one character and all characters are letters.
     * @return true if the username is valid, false otherwise
     */
    public boolean checkIfValidUsername()
    {
        if(this.username == null || this.username=="")// If 'username' is null or empty, it is not valid. In this case false is returned.
        {
            return false;
        }
        if(this.username.length() == 1)// If 'username' is only 1 character long, this character is checked for a letter and the result is returned.
        {
            return Character.isLetter(this.username.charAt(0));
        }
        //The first character of the 'username' String is extracted and a new 'Username' object is created.
        Username tempUsername=new Username(this.username.substring(1));
        // If 'username' is longer than 1 character, the first character is checked if it is a letter and the 'checkIfValidUsername' method is called again on the new object
        return Character.isLetter(this.username.charAt(0)) && tempUsername.checkIfValidUsername();
    }
}