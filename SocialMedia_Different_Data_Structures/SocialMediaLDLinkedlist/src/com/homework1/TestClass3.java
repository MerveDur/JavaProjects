package com.homework1;
import java.util.LinkedList;
/**
 * This class for test
 * @author Merve Dur
 * @version 1.0
 *
 */
public class TestClass3 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        /**
         * accounts keep the accounts in the social media software
         */

        LDLinkedList<Account> accounts = new LDLinkedList<Account>();
        /**
         * accountsListSize keep the accounts array size
         */
        int accountsListSize = 0;
        System.out.println("SCENARIO 3\n");
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
        sibelgulmez.login();
        sibelgulmez.follow(gizemsungu);
        sibelgulmez.logout();
        gokhankaya.login();
        gokhankaya.follow(gizemsungu);
        gokhankaya.logout();
        System.out.print("\nStep 3... ");
        gizemsungu.login();
        System.out.print("\nStep 4... ");
        gizemsungu.viewProfile(gizemsungu);
        System.out.print("\nStep 5...");
        gizemsungu.block(sibelgulmez);
        System.out.print("\nStep 6... ");
        gizemsungu.viewProfile(gizemsungu);
        System.out.print("\nStep 7...");
        gizemsungu.logout();
        System.out.print("\nStep 8... ");
        sibelgulmez.login();
        System.out.println("\nStep 9 try follow profile's gizemsungu...");
        sibelgulmez.follow(gizemsungu);
        System.out.println("\nStep 10 try view profile's gizemsungu...");
        sibelgulmez.viewProfile(gizemsungu);
        System.out.println("\nStep 11 try view post profile's gizemsungu...");
        sibelgulmez.viewPost(gizemsungu);
        System.out.println("\nStep 12 try send message gizemsungu...");
        sibelgulmez.sendMessage(new Message(1,2,1,"Hi!"),gizemsungu);

        long end = System.currentTimeMillis();
        double elapsedTimeInSeconds = (end - start) / 1000.0; // milisaniyeden saniyeye çevirme işlemi

        System.out.println("Execution Time: "+elapsedTimeInSeconds);
    }
}
