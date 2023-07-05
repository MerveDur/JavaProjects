package com.homework4;
import java.util.Stack;
/**
 * This is the Password1 class
 */
public class Password1 {
    /**
     * This variable holds string password1
     */
    String password1;

    /**
     * Constructs a new Password1 object with the given password.
     * @param password1 the password as a string
     */
    public Password1(String password1)
    {
        // Check if the password is valid before setting the password
        if(isValidPassword1(password1))
        {
            this.password1 = password1;
        }
       else
        {
            System.out.println("The string password is invalid due to because it cannot provide the number of characters or parentheses");
        }
    }

    /**
     * Returns the password as a string.
     * @return the password
     */
    public String getPassword1() { return password1; }

    /**
     * Sets the password to the given string if it is valid according to the rules defined in isValidPassword1 method.
     * @param password1 the new password
     */
    public void setPassword1(String password1)
    {
        try{
            // Check if the password is valid before setting the password
            if (isValidPassword1(password1)) {
                this.password1 = password1;
            }
        }
        catch(Exception e)
        {
            System.out.println("The string password is invalid due to because it cannot provide the number of characters or parentheses");
        }
    }

    /**
     * * This function checks if the given password is at least 8 characters, contains at least 2 square brackets and
     * all other characters are letters.
     *
     * @param password the password to check
     * @return true if the password is valid, false otherwise
     */
    private boolean isValidPassword1(String password)
    {
        int bracketCount = 0;
        boolean returnFlag=false;
        // Check if the password is long enough
        if(password == null || password.length() < 8)
        {
            return false;
        }
        // The characters in the password are checked
        for(int i = 0; i < password.length(); i++)
        {
            char ch = password.charAt(i);

            if(ch == '{' || ch == '}' || ch == '[' || ch == ']' || ch == '(' || ch == ')')//Increment bracketCount if the character is a bracket
            {
                bracketCount++;
            }
            else if(!Character.isLetter(ch))//Return false if the character is not a letter
            {
                return false;
            }
        }
        if(bracketCount>=2)//Check if there are enough brackets
        {
            returnFlag= true;
        }
        return returnFlag;
    }

    /**
     * Checks if the password contains any character from the given username.
     * @param username the username to check against
     * @return true if the password contains any character from the username, false otherwise
     */
    public boolean containsUserNameSpirit(String username)
    {
        if(username == null || password1 == null || username=="" || password1=="")//Check if the username and password are not null
        {
            throw new IllegalArgumentException("Username and password1 must not be null.");
        }

        Stack<Character> stack = new Stack<Character>();//Create a stack to hold the characters in the password
        for(int i = 0; i < password1.length(); i++)
        {
            stack.push(password1.charAt(i));
        }
        for(int i = 0; i <username.length() ; i++)//The characters in the username are checked
        {
            if(stack.contains(username.charAt(i)))//Check if the password contains the current character of the username
            {
                return true;
            }
        }
        return false;// If no matching characters are found, return false
    }

    /**
     * Checks if the password has balanced brackets.
     * @return true if the password has balanced brackets, false otherwise
     */
    public boolean isBalancedPassword()
    {
        String balancedStr=removeLetters(password1);// Remove letters from the password and keep only the brackets
        Stack<Character> stack = new Stack<Character>();

        for(int i = 0; i < balancedStr.length(); i++)//check the characters in the balanceStr
        {
            char ch = balancedStr.charAt(i);
            if(ch == '{' || ch == '[' || ch == '(')//If the character is an opening bracket, push it onto the stack
            {
                stack.push(ch);
            }
            else if(ch == '}' || ch == ']' || ch == ')')//If the character is a closing bracket
            {
                if(stack.isEmpty())//Return false if the stack is empty
                {
                    return false;
                }
                char top = stack.pop();//Pop the last opening bracket from the stack and check if it matches the closing bracket
                if((ch == '}' && top != '{') || (ch == ']' && top != '[') || (ch == ')' && top != '('))
                {
                    return false;
                }
            }
        }

        if(stack.isEmpty())// If the stack is empty after the iteration, the brackets are balanced
        {
            return  true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Removes all letters from the input string and returns a string with only brackets.
     * @param input the input string
     * @return a string with only brackets
     */
    private String removeLetters(String input)//Control the characters in the input string, if the character is a bracket, push it onto the stack
    {
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < input.length(); i++)
        {
            if(input.charAt(i)=='(' || input.charAt(i)==')' ||
                input.charAt(i)=='{' || input.charAt(i)=='}' ||
                input.charAt(i)=='[' || input.charAt(i)==']')
            {
                stack.push(input.charAt(i));
            }
        }
        return stack.toString();// Convert the stack to a string and return it
    }

    /**
     * Removes all brackets from the input string and returns a string with only letters.
     * @param input the input string
     * @return a string with only letters
     */
    private String removeBrackets(String input)//Control the characters in the input string, if the character is not a bracket, push it onto the stack
    {
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < input.length(); i++)
        {
            if(input.charAt(i)!='(' && input.charAt(i)!=')' &&
                input.charAt(i)!='{' && input.charAt(i)!='}' &&
                input.charAt(i)!='[' && input.charAt(i)!=']')
            {
                stack.push(input.charAt(i));
            }
        }
        return stack.toString();// Convert the stack to a string and return it
    }

    /**
     * Checks if it is possible to obtain a palindrome by rearranging the letters in the given string.
     * @return true if a palindrome can be formed, false otherwise
     */
    public boolean isPalindromePossible()
    {
        if(password1 == null)// Check if the password is null
        {
            throw new IllegalArgumentException("Password1 must not be null.");
        }

        String cleanedPassword1 = removeBrackets(password1);//Remove brackets from the password and store the cleaned string
        int[] charFrequency = new int[26];//Initialize an array to store the frequency of each character
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();//Define two arrays containing lowercase and uppercase letters of the alphabet
        char[] alphabet2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        for(int i = 0; i < cleanedPassword1.length(); i++)//Check the characters in the cleanedPassword1
        {
            char ch = cleanedPassword1.charAt(i);
            for(int j = 0; j < alphabet.length; j++)//Check the alphabet arrays
            {
                //If the character in the cleaned password matches a character in the alphabet arrays, increment the frequency counter for that character
                if(ch == alphabet[j] || ch == alphabet2[j])
                {
                    charFrequency[j]+=1;
                }
            }
        }
        //Call the recursive helper method to check if a palindrome can be formed from the character frequencies
        return isPalindromePossibleRecursively(charFrequency, 0, 0);
    }
    /**
     * A recursive helper method for isPalindromePossible() that checks if a palindrome can be formed
     * from the given character frequencies.
     * @param charFrequency the array of character frequencies
     * @param index the current index of the character frequencies array
     * @param oddCount the size of odd number for check
     * @return recursively isPalindromePossibleRecursively
     */
    private boolean isPalindromePossibleRecursively(int[] charFrequency, int index, int oddCount)
    {
        if (index == charFrequency.length)//If the index reaches the end of the charFrequency array,oddCount is checked
        {
            if(oddCount <= 1)// If there is one or no odd frequencies, a palindrome can be formed
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        //If the current character's frequency is odd, increment the oddCount
        if(charFrequency[index] % 2 == 1)
        {
            oddCount++;
        }
        //Call the next index and update the oddCount
        return isPalindromePossibleRecursively(charFrequency, index + 1, oddCount);
    }
}