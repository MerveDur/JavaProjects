package com.homework1;
/**
 * This class for test
 * @author Merve Dur
 * @version 1.0
 *
 */
public class TestClass1 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        /**
         * accounts keep the accounts in the social media software
         */
        Account[] accounts = new Account[1000];
        /**
         * accountsListSize keep the accounts array size
         */
        int accountsListSize=0;
        System.out.println("SCENARIO 1\n");
        System.out.println("CSE222 - HW1\n");
        System.out.println("Step 1... Creating accounts ...");
        Account gizemsungu = new Account(accounts,accountsListSize,1, "gizemsungu", "01.01.1990", "Ankara", false);
        accounts[0] = gizemsungu;
        accountsListSize++;
        Account sibelgulmez = new Account(accounts,accountsListSize,2, "sibelgulmez", "10.03.1995", "Istanbul", false);
        accounts[1] = sibelgulmez;
        accountsListSize++;
        Account gokhankaya = new Account(accounts,accountsListSize,3, "gokhankaya", "01.01.1980", "Izmir", false);
        accounts[2] = gokhankaya;
        accountsListSize++;
        System.out.print("\nStep 2... ");
        sibelgulmez.login();
        System.out.println("\nStep 3... Sharing two post... \n");
        Post post1=new Post(1,sibelgulmez.getAccountid()," I like Java.");
        sibelgulmez.addPost(post1);
        Post post2=new Post(2,sibelgulmez.getAccountid()," Java the coffee...");
        sibelgulmez.addPost(post2);
       // gokhankaya.addPost(post1); // control
        System.out.println("Step 4...");
        if(isMember(accounts,gizemsungu)==1)
        {
            sibelgulmez.follow(gizemsungu);
        }
        else
            System.out.println("This person not a member in this socialmedia!");
        if(isMember(accounts,gokhankaya)==1)
        {
            sibelgulmez.follow(gokhankaya);
        }
        else
            System.out.println("This person not a member in this socialmedia!");
        System.out.print("\nStep 5...");
        sibelgulmez.logout();
        System.out.print("\nStep 6...");
        if(isMember(accounts,gokhankaya)==1)
        {
            gokhankaya.login();
        }
        else
            System.out.println("This person not a member in this socialmedia!");
        System.out.print("\nStep 7...");
        if(isMember(accounts,sibelgulmez)==1)
        {
            gokhankaya.viewProfile(sibelgulmez);
        }
        else
            System.out.println("This person not a member in this socialmedia!");
        System.out.print("\nStep 8...");
        if(isMember(accounts,sibelgulmez)==1)
        {
            gokhankaya.viewPost(sibelgulmez);
        }
        else
            System.out.println("This person not a member in this socialmedia!");
        System.out.print("\nStep 9...Liking a post of "+sibelgulmez.getUsername()+"...\n");
        Like like1=new Like(1,gokhankaya.getAccountid(),post1.getPostId());
        post1.addLike(like1);

        System.out.print("\nStep 10...Adding a comment on a post of "+sibelgulmez.getUsername()+"...\n");
        Comment comment1=new Comment(2, gokhankaya.getAccountid(), post1.getPostId(),"me too!");
        post1.addComment(comment1);

        System.out.println("\nStep 11... ");
        gokhankaya.follow(sibelgulmez);
        gokhankaya.follow(gizemsungu);

        System.out.print("\nStep 12...");
        Message message1=new Message(1,gokhankaya.getAccountid(),gizemsungu.getAccountid(),"This homework is too easy!");
        gokhankaya.sendMessage(message1,gizemsungu);

        System.out.print("\nStep 13...");
        gokhankaya.logout();

        System.out.print("\nStep 14...");
        gizemsungu.login();
        //gokhankaya.login();//control

        System.out.print("\nStep 15...");
        gizemsungu.checkingOutbox();

        System.out.print("\nStep 16...");
        gizemsungu.checkingInbox();
        /*gokhankaya.checkingOutbox();
        gokhankaya.checkingInbox();*///control

        System.out.print("\nStep 17...");
        gizemsungu.viewingInbox(accounts,accountsListSize);

        System.out.print("\nStep 18...");
        gizemsungu.viewProfile(sibelgulmez);

        System.out.print("Step 19...");
        gizemsungu.viewPost(sibelgulmez);

        System.out.print("\nStep 20...");
        gizemsungu.viewingPostsInteractions(sibelgulmez,accounts,accountsListSize);

        System.out.print("\nStep 21...Liking "+sibelgulmez.getUsername()+"'s posts...\n");
        Like like2=new Like(2,gizemsungu.getAccountid(),post1.getPostId());
        post1.addLike(like2);
        Like like3=new Like(3,gizemsungu.getAccountid(),post2.getPostId());
        post2.addLike(like3);

        System.out.print("\nStep 22...");
        gizemsungu.viewingPostsInteractions(sibelgulmez,accounts,accountsListSize);

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
    public static int isMember(Account[] accounts, Account member)
    {
        int findValue=0;
        for (int i = 0; i < 1000; i++) {
            if (accounts[i]==member)
            {
                findValue=1;
                i=1000;//for finish loop
            }
        }
        return findValue;
    }

}
