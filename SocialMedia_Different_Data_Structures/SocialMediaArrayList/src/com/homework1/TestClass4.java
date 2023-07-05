package com.homework1;
import java.util.ArrayList;
/**
 * This class for test
 * @author Merve Dur
 * @version 1.0
 *
 */

public class TestClass4 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        /**
         * accounts keep the accounts in the social media software
         */
        ArrayList<Account> accounts = new ArrayList<Account>();
        /**
         * accountsListSize keep the accounts array size
         */
        int accountsListSize=0;
        System.out.println("SCENARIO 4\n");
        System.out.println("CSE222 - HW3\n");
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

        Account cansevinc = new Account(accounts, accountsListSize, 4, "cansevinc", "15.05.1992", "Bursa", false);
        accounts.add(cansevinc);
        accountsListSize++;

        Account elifsahin = new Account(accounts, accountsListSize, 5, "elifsahin", "20.11.1994", "Eskişehir", false);
        accounts.add(elifsahin);
        accountsListSize++;

        Account mehmetturan = new Account(accounts, accountsListSize, 6, "mehmetturan", "05.02.1985", "İzmir", true);
        accounts.add(mehmetturan);
        accountsListSize++;

        Account ebruyildirim = new Account(accounts, accountsListSize, 7, "ebruyildirim", "12.07.1996", "Ankara", false);
        accounts.add(ebruyildirim);
        accountsListSize++;

        Account berkanak = new Account(accounts, accountsListSize, 8, "berkanak", "27.09.1999", "Kocaeli", false);
        accounts.add(berkanak);
        accountsListSize++;

        Account aysenurcetin = new Account(accounts, accountsListSize, 9, "aysenurcetin", "08.04.1998", "Adana", true);
        accounts.add(aysenurcetin);
        accountsListSize++;

        Account aliyilmaz = new Account(accounts, accountsListSize, 10, "aliyilmaz", "19.12.1991", "Istanbul", false);
        accounts.add(aliyilmaz);
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

        System.out.println("Step 8...");
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
        System.out.println("\nStep 9...");
        sibelgulmez.displayHistory();

        System.out.println("Step 10...");
        sibelgulmez.viewProfile(gizemsungu);
        sibelgulmez.viewPost(gizemsungu);
        sibelgulmez.viewingPostsInteractions(gizemsungu,accounts,accountsListSize);

        System.out.print("\nStep 11...unLiking a post of "+gizemsungu.getUsername()+"...\n");
        post1.unLike(like1,accounts,sibelgulmez);

        System.out.println("\nStep 12...");
        sibelgulmez.displayHistory();

        System.out.println("Step 13...");
        sibelgulmez.viewProfile(gizemsungu);
        sibelgulmez.viewPost(gizemsungu);
        sibelgulmez.viewingPostsInteractions(gizemsungu,accounts,accountsListSize);


        System.out.print("\nStep 14...");
        sibelgulmez.logout();

        System.out.print("\nStep 15... ");
        gokhankaya.login();






        System.out.print("\nStep 15... ");
        gokhankaya.login();

        System.out.print("\nStep 16...");
        if(isMember(accounts,gizemsungu)==1)
        {
            gokhankaya.viewProfile(gizemsungu);
        }
        else
            System.out.println("This person not a member in this socialmedia!");

        System.out.print("\nStep 17...Adding a comment on a post of "+gizemsungu.getUsername()+"...\n");
        Comment comment1=new Comment(2, gokhankaya.getAccountid(), post2.getPostId(),"Nice!");
        post2.addComment(comment1,accounts,gokhankaya);

        System.out.println("\nStep 18...");
        gokhankaya.displayHistory();

        System.out.println("\nStep 19...");
        gokhankaya.viewProfile(gizemsungu);
        gokhankaya.viewPost(gizemsungu);
        gokhankaya.viewingPostsInteractions(gizemsungu,accounts,accountsListSize);

        System.out.println("\nStep 20...");
        post2.unComment(comment1,accounts,gokhankaya);

        System.out.println("\nStep 21...");
        gokhankaya.viewProfile(gizemsungu);
        gokhankaya.viewPost(gizemsungu);
        gokhankaya.viewingPostsInteractions(gizemsungu,accounts,accountsListSize);

        System.out.println("\nStep 22... Non comment deletion attempt!");
        Comment comment2=new Comment(7, gokhankaya.getAccountid(), post1.getPostId(),"Good!");
        post2.unComment(comment2,accounts,gokhankaya);


        System.out.print("\nStep 23...");
        gokhankaya.logout();

        System.out.print("\nStep 24... ");
        gizemsungu.login();

        System.out.print("\nStep 25...");
        gizemsungu.follow(sibelgulmez);
        gizemsungu.displayHistory();
        gizemsungu.viewProfile(gizemsungu);

        System.out.print("\nStep 26...");
        gizemsungu.unFollow(sibelgulmez);
        gizemsungu.viewProfile(gizemsungu);
        gizemsungu.displayHistory();

        System.out.print("\nStep 27...");
        gizemsungu.block(sibelgulmez);
        gizemsungu.displayHistory();
        gizemsungu.viewProfile(gizemsungu);

        System.out.print("\nStep 28...");
        gizemsungu.unBlock(sibelgulmez);
        gizemsungu.displayHistory();
        gizemsungu.viewProfile(gizemsungu);

        System.out.print("\nStep 29... ");
        gizemsungu.logout();
        System.out.print("\nStep 30... ");
        mehmetturan.login();
        System.out.print("\nStep 31... ");
        mehmetturan.viewProfile(gizemsungu);
        mehmetturan.viewPost(gizemsungu);
        mehmetturan.viewingPostsInteractions(gizemsungu,accounts,accountsListSize);
        System.out.print("\nStep 32... ");
        Like like3 = new Like(3, mehmetturan.getAccountid(), post1.getPostId());
        post1.addLike(like3,accounts,mehmetturan);

        System.out.print("\nStep 33... ");
        mehmetturan.viewProfile(gizemsungu);
        mehmetturan.viewPost(gizemsungu);
        mehmetturan.viewingPostsInteractions(gizemsungu,accounts,accountsListSize);
        System.out.print("\nStep 34...unLiking a post of "+gizemsungu.getUsername()+"...\n");
        post1.unLike(like3,accounts,mehmetturan);
        mehmetturan.viewProfile(gizemsungu);
        mehmetturan.viewPost(gizemsungu);
        mehmetturan.viewingPostsInteractions(gizemsungu,accounts,accountsListSize);


        System.out.print("\nStep 35...Adding a comment on a post of "+gizemsungu.getUsername()+"...\n");
        Comment comment3=new Comment(3, mehmetturan.getAccountid(), post2.getPostId(),"Good look picture!");
        post2.addComment(comment3,accounts,mehmetturan);


        System.out.println("\nStep 36...");
        mehmetturan.displayHistory();

        System.out.println("\nStep 37...");
        mehmetturan.viewProfile(gizemsungu);
        mehmetturan.viewPost(gizemsungu);
        mehmetturan.viewingPostsInteractions(gizemsungu,accounts,accountsListSize);

        System.out.println("\nStep 38...");
        post2.unComment(comment3,accounts,mehmetturan);

        System.out.println("\nStep 39...");
        gokhankaya.viewProfile(gizemsungu);
        gokhankaya.viewPost(gizemsungu);
        gokhankaya.viewingPostsInteractions(gizemsungu,accounts,accountsListSize);

        System.out.println("\nStep 40...");
        mehmetturan.logout();
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
    public static int isMember(ArrayList<Account> accounts, Account member)
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