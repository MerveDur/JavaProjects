package com.homework1;
import java.util.LinkedList;
/**
 * This class for test
 * @author Merve Dur
 * @version 1.0
 *
 */

public class TestClass2 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        /**
         * accounts keep the accounts in the social media software
         */
        LinkedList<Account> accounts = new LinkedList<Account>();
        /**
         * accountsListSize keep the accounts array size
         */
        int accountsListSize=0;
        System.out.println("SCENARIO 2\n");
        System.out.println("CSE222 - HW1\n");
        System.out.println("Step 1... Creating accounts ...");
        Account gizemsungu = new Account(accounts,accountsListSize,1, "gizemsungu", "01.01.1990", "Ankara", false);
        accounts.add(gizemsungu);
        accountsListSize++;
        Account sibelgulmez = new Account(accounts,accountsListSize,2, "sibelgulmez", "10.03.1995", "Istanbul", false);
        accounts.add(sibelgulmez);
        accountsListSize++;
        Account gokhankaya = new Account(accounts,accountsListSize,3, "gokhankaya", "01.01.1980", "Izmir", false);
        accounts.add(gokhankaya);
        accountsListSize++;
        System.out.print("\nStep 2... ");
        gizemsungu.login();

        System.out.println("\nStep 3... Sharing two post... \n");
        Post post1=new Post(1,gizemsungu.getAccountid()," I like Java.");
        gizemsungu.addPost(post1);
        Post post2=new Post(2,gizemsungu.getAccountid()," Java the coffee...");
        gizemsungu.addPost(post2);

        System.out.print("\nStep 4...");
        gizemsungu.logout();

        System.out.print("\nStep 5... ");
        sibelgulmez.login();

        System.out.print("\nStep 6...");
        if(isMember(accounts,gizemsungu)==1)
        {
            sibelgulmez.viewProfile(gizemsungu);
        }
        else
            System.out.println("This person not a member in this socialmedia!");

        System.out.print("\nStep 7...Liking a post of "+gizemsungu.getUsername()+"...\n");
        Like like1=new Like(1,sibelgulmez.getAccountid(),post1.getPostId());
        post1.addLike(like1,accounts,sibelgulmez);
       // System.out.println(sibelgulmez.getHistory()+"lşöşlöş");

        System.out.print("\nStep 8...");
        sibelgulmez.logout();

        System.out.print("\nStep 9... ");
        gokhankaya.login();

        System.out.print("\nStep 10...");
        if(isMember(accounts,gizemsungu)==1)
        {
            gokhankaya.viewProfile(gizemsungu);
        }
        else
            System.out.println("This person not a member in this socialmedia!");

        System.out.print("\nStep 11...Adding a comment on a post of "+gizemsungu.getUsername()+"...\n");
        Comment comment1=new Comment(2, gokhankaya.getAccountid(), post2.getPostId(),"Nice!");
        post2.addComment(comment1,accounts,gokhankaya);

        System.out.print("\nStep 12...");
        Message message1=new Message(1,gokhankaya.getAccountid(),gizemsungu.getAccountid(),"Hello!");
        gokhankaya.sendMessage(message1,gizemsungu);

        System.out.print("\nStep 13...");
        gokhankaya.logout();

        System.out.print("\nStep 14... ");
        gizemsungu.login();

        System.out.print("\nStep 15...");
        if(isMember(accounts,gizemsungu)==1)
        {
            gizemsungu.viewProfile(gizemsungu);
        }
        else
            System.out.println("This person not a member in this socialmedia!");

        System.out.print("Step 16...");
        gizemsungu.viewPost(gizemsungu);

        System.out.print("\nStep 17...");
        gizemsungu.viewingPostsInteractions(gizemsungu,accounts,accountsListSize);

        System.out.print("\nStep 18...");
        gizemsungu.checkingInbox();

        System.out.print("\nStep 19...");
        gizemsungu.viewingInbox(accounts,accountsListSize);

        long end = System.currentTimeMillis();
        double elapsedTimeInSeconds = (end - start) / 1000.0; // milisaniyeden saniyeye çevirme işlemi

        System.out.println("Execution Time: "+elapsedTimeInSeconds);

    }

    /**
     * This method checks if an account is a member of this social media
     * @param accounts An Account array containing the account’s in this social media
     * @param member An Account object
     * @return a int value: 1 if a member, 0 otherwise.
     */
    public static int isMember(LinkedList<Account> accounts, Account member)
    {
        int findValue=0;
        for (int i = 0; i < 1000; i++) {
            if (accounts.get(i) ==member)
            {
                findValue=1;
                i=1000;//for finish loop
            }
        }
        return findValue;
    }
}
