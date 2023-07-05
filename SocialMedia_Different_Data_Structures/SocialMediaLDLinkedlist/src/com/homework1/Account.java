package com.homework1;
import java.util.LinkedList;
//LDLinkedList<Account> followers = new LDLinkedList<Account>();

/**
 * This class represents accounts that users maintain properties in social media software.
 * @author Merve Dur
 * @version 1.0
 *
 */

public class Account {

    /**
     * The Id of the account
     */
    private int accountid;
    /**
     * The Username of the account
     */
    private String username;
    /**
     * The Birth date of the account
     */
    private String birthdate;
    /**
     * The Location of the account
     */
    private String location;
    /**
     * The Array of posts
     */
    private LDLinkedList<Post> posts = new LDLinkedList<Post>(); // works fine
    /**
     * The Array size of posts
     */
    private int postSize;
    /**
     * The Array of messages
     */
    private LDLinkedList<Message> messages = new LDLinkedList<Message>();
    /**
     * The Array size of messages
     */
    private int messagesSize;// Array size of messages
    /**
     * The Array of following accounts
     */
    private LDLinkedList<Account> following = new LDLinkedList<Account>();
    /**
     * The Array size of following
     */
    private int followingSize;
    /**
     * The Array of follower accounts
     */
    private LDLinkedList<Account> followers = new LDLinkedList<Account>();
    /**
     * The Array size of follower
     */
    private int followersSize;
    /**
     * The User login control status
     */
    private boolean loginStatus;
    /**
     * The User view control post status
     */
    private boolean viewingStatus;
    /**
     * The Array of bloked accounts
     */
    private LDLinkedList<Account> blockedAccounts = new LDLinkedList<Account>();
    /**
     * The Array size of blocked accounts
     */
    private int blocksSize;
    /**
     * The Array of history of account
     */
    private LDLinkedList<String> history = new LDLinkedList<String>();
    /**
     * This constructs an account with a specified
     * accountid username, birthdate, location, loginStatus
     * @param accountid user's id
     * @param username user's user name
     * @param birthdate user's birthdate
     * @param location user's location
     * @param loginStatus user's login status
    */
    public Account(LDLinkedList<Account> accounts,int accontSize,int accountid, String username, String birthdate, String location, boolean loginStatus)
    {
        int usernameControl=0,accountIdControl=0;
        for (int i = 0; i < accontSize; i++) {
            if(accounts.get(i).getUsername()==username)
            {
                usernameControl=1;
            }
            if(accounts.get(i).getAccountid()==accountid)
            {
                accountIdControl=1;
            }
        }
        if (usernameControl==0)
        {
            if(accountIdControl==0)
            {
                this.accountid = accountid;
                this.username = username;
                this.birthdate = birthdate;
                this.location = location;
                this.loginStatus = loginStatus;
                this.postSize = 0;//initial value set to 0
                this.messagesSize = 0;//initial value set to 0
                this.followersSize = 0;//initial value set to 0
                this.followingSize = 0;//initial value set to 0
                this.viewingStatus=false;//initial value set to false
                this.blocksSize=0;//initial value set to 0
                System.out.println("An account with username " + this.username + " has been created.");
            }
            else
                System.out.println("Account id must be unique!");
        }
        else
            System.out.println("This username has been used before!");

    }
    /**
     * This constructs an account with a specified
     * username
     * @param username user's user name
     */
    public Account(String username) {
        this.username = username;
        this.loginStatus = false;
        this.postSize = 0;
        this.messagesSize = 0;
        this.followersSize = 0;
        this.followingSize = 0;
        this.viewingStatus=false;
        this.blocksSize=0;
        System.out.println("An account with username " + this.username + " has been created.");
    }
    /** Gets the account’s account id.
     * @return An int representing the account’s account
     *     id.
     */
    public int getAccountid() {
        return accountid;
    }
    /** Sets the account’s account id.
     * @param accountid An int containing the account’s account id
     */
    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }
    /** Gets the account’s user name.
     * @return A String representing the account’s user name.
     */
    public String getUsername() {
        return username;
    }
    /** Sets the account’s username.
     * @param username A String containing the account’s username
     */
    public void setUsername(String username) {
        this.username = username;
    }
    /** Gets the account’s birthdate.
     * @return A String representing the account’s birthdate.
     */
    public String getBirthdate() {
        return birthdate;
    }
    /** Sets the account’s birthdate.
     * @param birthdate A String containing the account’s birthdate
     */
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
    /** Gets the account’s location.
     * @return A String representing the account’s location.
     */
    public String getLocation() {
        return location;
    }
    /** Sets the account’s location.
     * @param location A String containing the account’s location
     */
    public void setLocation(String location) {
        this.location = location;
    }
    /** Gets the account’s Posts array.
     * @return A Post array representing the account’s  Posts array.
     */
    public LDLinkedList<Post> getPosts() {
        return posts;
    }
    /** Sets the account’s posts.
     * @param posts A Post array containing the account’s posts
     */
    public void setPosts(LDLinkedList<Post> posts) {
        this.posts = posts;
    }
    /** Gets the account’s size of posts array.
     * @return An int representing the account’s size of posts array.
     */
    public int getPostSize() {
        return postSize;
    }
    /** Sets the account’s post size.
     * @param postSize An int containing the account’s post size
     */
    public void setPostSize(int postSize) {
        this.postSize = postSize;
    }
    /** Gets the account’s Messages array.
     * @return A Message array representing the account’s Messages array.
     */
    public LDLinkedList<Message> getMessages() {
        return messages;
    }
    /** Sets the account’s messages.
     * @param messages A Message array containing the account’s messages
     */
    public void setMessages(LDLinkedList<Message> messages) {
        this.messages = messages;
    }
    /** Gets the account’s following accounts array.
     * @return An Account array representing the account’s following accounts array.
     */
    public LDLinkedList<Account> getFollowing() {
        return following;
    }
    /** Sets the account’s following.
     * @param following An Account array containing the account’s following
     */
    public void setFollowing(LDLinkedList<Account> following,int newFollowingSize)
    {
        for (int i = 0; i < newFollowingSize; i++)
        {
            this.following.add(i, following.get(i));
        }
        this.setFollowingSize(newFollowingSize);
    }
    /** Gets the account’s followers accounts array.
     * @return An Account array representing the account’s followers accounts array.
     */
    public LDLinkedList<Account> getFollowers() {
        return followers;
    }
    /** Sets the account’s followers.
     * @param followers An Account array containing the account’s followers
     */
    public void setFollowers(LDLinkedList<Account> followers, int newFollowerSize)
    {
        for (int i = 0; i < newFollowerSize; i++)
        {
            this.followers.add(i, followers.get(i));
        }
        this.setFollowersSize(newFollowerSize);
    }
    /** Gets the account’s login status.
     * @return A boolean representing the account’s login status
     */
    public boolean isLoginStatus() {
        return loginStatus;
    }
    /** Sets the account’s login status.
     * @param loginStatus A boolean array containing the account’s login status
     */
    public void setLoginStatus(boolean loginStatus) {
        this.loginStatus = loginStatus;
    }
    /** Gets the account’s size of messages array.
     * @return An int representing the account’s size of messages array.
     */
    public int getMessagesSize() {
        return messagesSize;
    }
    /** Sets the account’s messages size.
     * @param messagesSize An int containing the account’s messages size
     */
    public void setMessagesSize(int messagesSize) {
        this.messagesSize = messagesSize;
    }
    /** Gets the account’s size of following accounts array.
     * @return An int representing the account’s size of following accounts array.
     */
    public int getFollowingSize() {
        return followingSize;
    }
    /** Sets the account’s following size.
     * @param followingSize An int containing the account’s following size
     */
    public void setFollowingSize(int followingSize) {
        this.followingSize = followingSize;
    }
    /** Gets the account’s size of follower accounts array.
     * @return An int representing the account’s size of follower accounts array.
     */
    public int getFollowersSize() {
        return followersSize;
    }
    /** Sets the account’s follower size.
     * @param followersSize An int containing the account’s follower size
     */
    public void setFollowersSize(int followersSize) {
        this.followersSize = followersSize;
    }
    /** Gets the account’s viewing status.
     * @return A boolean representing the account’s viewing status
     */
    public boolean isViewingStatus() {
        return viewingStatus;
    }
    /** Sets the account’s view status.
     * @param viewvingStatus A boolean containing the account’s view status
     */
    public void setViewingStatus(boolean viewvingStatus) {
        this.viewingStatus = viewvingStatus;
    }
    /** Gets the account’s blocked accounts array.
     * @return An Account array representing the account’s blocked accounts array.
     */
    public LDLinkedList<Account> getBlockedAccounts() {
        return blockedAccounts;
    }
    /** Sets the account’s blocked accounts.
     * @param blockedAccounts An Account array containing the account’s blocked accounts
     */
    public void setBlockedAccounts(LDLinkedList<Account> blockedAccounts) {
        this.blockedAccounts = blockedAccounts;
    }
    /** Gets the account’s size of blocked accounts array.
     * @return An int representing the account’s size of blocked accounts array.
     */
    public int getBlocksSize() {
        return blocksSize;
    }
    /** Sets the account’s blocked accounts array size.
     * @param blocksSize An int containing the account’s blocked accounts array size
     */
    public void setBlocksSize(int blocksSize) {
        this.blocksSize = blocksSize;
    }

    public void setFollowing(LDLinkedList<Account> following) {
        this.following = following;
    }

    public void setFollowers(LDLinkedList<Account> followers) {
        this.followers = followers;
    }

    public LDLinkedList<String> getHistory() {
        return history;
    }

    public void setHistory(LDLinkedList<String> history) {
        this.history = history;
    }

    /**
     * This method allows you to log in to your social media account.
     */

    public void login()
    {
        loginStatus = true;//Login status changes true
        System.out.println("Logging into an account (username: " + this.getUsername() + ")...");
    }
    /** This method allows you to log in to your social media account.
     * @param newPost A Post containing a new post object
     */
    public void addPost(Post newPost) {
        if (this.isLoginStatus() == true)
        {// Increase the size of the post array and add the new post
            this.getPosts().add(newPost);
            this.postSize++;
        }
        else
            System.out.println("Error: " + username + " are not logged in!");
    }
    /** This method allows you to follow another user.
     * @param newFollow An Account containing a new account object
     */
    public void follow(Account newFollow)
    {
        String follow_History;
        // Increase the size of the following array and add the new following
        try
        {
            if(this.isLoginStatus() == true)//In order to follow the account, the account must be logged in.
            {
                if(this.isBlocked(newFollow)==0)//To be able to follow the account, it must not be blocked by the other account.
                {
                    this.getFollowing().add(newFollow);
                    this.followingSize++;
                    addFollower(newFollow);
                    System.out.println("Following " + newFollow.getUsername() + "...");
                    follow_History="You followed "+newFollow.getUsername();
                    this.getHistory().add(follow_History);
                }
                else
                    System.out.println("You cannot follow this user!\nYou have been blocked by : " + newFollow.getUsername());
            }
            else
                System.out.println("Error: " + username + " are not logged in!");
        }
        catch (Exception e)
        {
            System.out.println("Following Error!");
        }
    }
    public void unFollow(Account removeFollow)
    {
        String unFollow_History;
        int unfollowControl=0;
        //Decrease the size of the following array and remove the following
        try
        {
            if(this.isLoginStatus() == true)//In order to follow the account, the account must be logged in.
            {
                if(this.isBlocked(removeFollow)==0)//To be able to follow the account, it must not be blocked by the other account.
                {
                    for (int i = 0; i <this.getFollowing().size() ; i++)
                    {
                        if(this.getFollowing().get(i)==removeFollow)
                        {
                            this.getFollowing().remove(removeFollow);
                            System.out.println("Unfollowing " + removeFollow.getUsername() + "...");
                            unFollow_History="You unfollowed "+removeFollow.getUsername();
                            this.getHistory().add(unFollow_History);
                           // this.followingSize--;
                            unfollowControl=1;
                            i=this.getFollowing().size();
                        }
                    }
                    if(unfollowControl==1)
                    {
                        deleteFollower(removeFollow);
                    }
                    else
                        System.out.println("You are not already following this person!");

                }
                else
                    System.out.println("You cannot unfollow this user!\nYou have been blocked by : " + removeFollow.getUsername());
            }
            else
                System.out.println("Error: " + username + " are not logged in!");
        }
        catch (Exception e)
        {
            System.out.println("Unfollowing Error!");
        }
    }
    /**This method adds this account to the followers of the followed account.
     * @param follower An Account containing an account object
     */
    public void addFollower(Account follower)
    {// Increase the size of the follower array and add the new follower
        follower.getFollowers().add(this);
        follower.setFollowersSize(follower.getFollowersSize()+1);
    }
    public void deleteFollower(Account follower)
    {// Decrease the size of the follower array and delete the new follower
        follower.getFollowers().remove(this);
        follower.setFollowersSize(follower.getFollowersSize()-1);
    }
    /**
     * This method allows you to log out of your social media account.
     */
    public void logout()
    {
        try {
            if (this.isLoginStatus() == true)//Checking that the account is logged in
            {
                this.setLoginStatus(false);// Change login status to false
                System.out.println("Logging out from account '" + this.getUsername() + "'...");
            } else
                System.out.println("Error: Not logged in with this account!");
        }
        catch (Exception e)
        {
            System.out.println("Log out Error!");
        }

    }

    /**This method allows to view profile information of other account.
     * @param tempAccount An Account containing an account object
     */
    public void viewProfile(Account tempAccount)
    {
        try
        {
            if(this.loginStatus==true)//Checking that the account is logged in
            {
                if(this.isBlocked(tempAccount)==0)//To be able to view the account profile, it must not be blocked by the other account.
                {
                    System.out.println("Viewing "+tempAccount.getUsername()+"'s profile...");
                    System.out.println(tempAccount);//call toString
                    tempAccount.viewingStatus=true;
                }
                else
                    System.out.println("You cannot view profile this user!\nYou have been blocked by : " + tempAccount.getUsername());
            }
            else
                System.out.println("Error: Not logged in with this account!");

        }
        catch (Exception e)
        {
            System.out.println("View Profile error");
        }

    }
    /**This method allows to view profile post information of other account.
     * @param tempAccount An Account containing an account object
     */
    public void viewPost(Account tempAccount)
    {
        try
        {
            if(this.isBlocked(tempAccount)==0)//To be able to view the account profile, it must not be blocked by the other account.
            {
                if(tempAccount.viewingStatus==true)//To be able to view the account profile post, it must be view status true
                {
                    System.out.println("Viewing "+tempAccount.getUsername()+"'s posts...");
                    for (int i = 0; i < tempAccount.getPostSize(); i++)
                    {
                        if(tempAccount.getPosts().getLazy_Deletion()==0)
                        {
                            System.out.println("(PostID: "+ tempAccount.getPosts().get(i).getPostId()+") " +tempAccount.getUsername()
                                    +": "+ tempAccount.getPosts().get(i).getContent());
                        }
                    }
                }
                else
                    System.out.println("You are not on this account!");
            }
            else
                System.out.println("You cannot view posts this user!\nYou have been blocked by : " + tempAccount.getUsername());
        }
        catch (Exception e)
        {
            System.out.println("View Profile Post error");
        }

    }
    /**This method allows to send a message to other account.
     * @param receiver An Account containing an account object
     * @param tempMessage A Message containing a message object
     */
    public void  sendMessage(Message tempMessage,Account receiver)
    {// Increase the size of the messages array and add the new message
        int followerControl=0,messageIdControl=0;
        for (int i = 0; i <receiver.getMessagesSize() ; i++)
        {//Message id control
            if (receiver.getMessages().get(i).getMessageId()==tempMessage.getMessageId())
            {
                messageIdControl=1;
            }
        }
        for (int i = 0; i <receiver.getFollowersSize(); i++)
        {//That account must be followed in order to send a message.
            if(receiver.getFollowers().get(i) ==this)
            {
                followerControl=1;
                i=receiver.getFollowersSize();
            }
        }
        if(messageIdControl==0)//Message id unique control
        {
            if(followerControl==1)
            {
                try
                {
                    if(this.loginStatus==true)//Checking that the account is logged in
                    {
                        if(this.isBlocked(receiver)==0)//To be able to send a message to another account, it must not be blocked by the other account.
                        {
                            System.out.println("Sending a message to "+receiver.getUsername()+"...");
                            this.messages.add(tempMessage);
                            messagesSize++;
                            receiver.getMessages().add(tempMessage);
                            receiver.setMessagesSize(receiver.getMessagesSize()+1);
                        }
                        else
                            System.out.println("You cannot send a message to this user!\nYou have been blocked by : " + receiver.getUsername());
                    }
                    else
                        System.out.println("Error: Not logged in with this account!");
                }
                catch (Exception e)
                {
                    System.out.println("Send message error");
                }
            }
            else
                System.out.println("You must follow "+receiver.getUsername()+" account to send message!");
        }
        else
            System.out.println("Message id must be unique!");
    }
    /**This method checks the number of messages in the inbox.
     */
    public void checkingInbox()
    {//Message inbox count is checked
        int inboxCount=0;
        if(this.loginStatus==true)//Checking that the account is logged in
        {
            if(messagesSize==0)
            {
                System.out.println("There is/are "+0+" message(s) in the inbox.");
            }
            else
            {
                for (int i = 0; i < messagesSize; i++) {
                    System.out.println("Checking inbox...");
                    if (messages.get(i).getReceiverId() == this.getAccountid()) {//According to the sender/receiver account IDs, the message is considered as an incoming or outgoing message.
                        inboxCount++;
                    }
                    System.out.println("There is/are " + inboxCount + " message(s) in the inbox.");
                }
            }
        }
        else
            System.out.println("Error: Not logged in with this account!");
    }
    /**This method checks the number of messages in the outbox.
     */
    public void checkingOutbox()
    {//Message outbox count is checked
        int outboxCount=0;
        if(this.loginStatus==true)//Checking that the account is logged in
        {
            if(messagesSize==0)
            {
                System.out.println("There is/are "+0+" message(s) in the outbox.");
            }
            else
            {
                for (int i = 0; i < messagesSize; i++)
                {
                    System.out.println("Checking outbox...");
                    if(messages.get(i).getSenderId()==this.getAccountid())
                    {//According to the sender/receiver account IDs, the message is considered as an incoming or outgoing message.
                        outboxCount++;
                    }
                    System.out.println("There is/are "+outboxCount+" message(s) in the outbox.");
                }
            }

        }
        else
            System.out.println("Error: Not logged in with this account!");
    }

    /**This method displays messages in the inbox.
     * @param senderList  An Account array containing an account object array
     * @param senderListSize  An int containing a sender list size
     */
    public  void viewingInbox(LDLinkedList<Account> senderList,int senderListSize)
    {
        if(this.loginStatus==true)//Checking that the account is logged in
        {
            System.out.println("Viewing inbox...");
            if(messagesSize==0)
            {
                System.out.println("You don't have any messages to show in your inbox yet!");
            }
            else {
                for (int i = 0; i < messagesSize; i++) {
                    if (messages.get(i).getReceiverId() == this.getAccountid()) {//If the receiver id and this account id are equal, those messages are displayed as inbox.
                        System.out.println("----------------------");
                        System.out.println("Message ID: " + messages.get(i).getMessageId());
                        for (int j = 0; j < senderListSize; j++) {
                            if (senderList.get(j).getAccountid() == messages.get(i).getSenderId()) {//According to the sender/receiver account IDs, the message is considered as an incoming or outgoing message.
                                System.out.println("From: " + senderList.get(j).getUsername());
                                j = senderListSize;
                            }
                        }
                        System.out.println("To: " + this.getUsername());
                        System.out.println("Message: " + messages.get(i).getContent());
                    }
                }
            }
        }
        else
            System.out.println("Error: Not logged in with this account!");
    }
    /**This method displays messages in the outbox.
     * @param senderList  An Account array containing an account object array
     * @param senderListSize  An int containing a sender list size
     */
    public  void viewingOutbox(LDLinkedList<Account> senderList,int senderListSize)
    {
        if(this.loginStatus==true)//Checking that the account is logged in
        {
            System.out.println("Viewing outbox...");
            if(messagesSize==0)
            {
                System.out.println("You don't have any messages to show in your outbox yet!");
            }
            else {
                for (int i = 0; i < messagesSize; i++) {
                    if (messages.get(i).getSenderId() == this.getAccountid()) {//If the sender id and this account id are equal, those messages are displayed as inbox.
                        System.out.println("----------------------");
                        System.out.println("Message ID: " + messages.get(i).getMessageId());
                        for (int j = 0; j < senderListSize; j++) {
                            if (senderList.get(j).getAccountid() == messages.get(i).getReceiverId()) {//According to the sender/receiver account IDs, the message is considered as an incoming or outgoing message.
                                System.out.println("From: " + senderList.get(j).getUsername());
                                j = senderListSize;
                            }
                        }
                        System.out.println("To: " + this.getUsername());
                        System.out.println("Message: " + messages.get(i).getContent());
                    }
                }
            }
        }
        else
            System.out.println("Error: Not logged in with this account!");
    }

    /**
     * This method shows interactions on posts
     * @param tempAccount An Account containing an account object
     * @param senderList An Account array containing an account array object in all social media
     * @param senderListSize  An int containing the account’s list size
     */
    public void  viewingPostsInteractions(Account tempAccount,LDLinkedList<Account> senderList,int senderListSize)
    {
        int commentOrder=1;//tempCommentSize=0,tempLikeSize=0;
        if(tempAccount.viewingStatus==true)
        {
            System.out.println("Viewing "+tempAccount.getUsername()+"'s posts' interactions...");
            for (int i = 0; i < tempAccount.getPostSize(); i++)
            {
                System.out.println("----------------------");
                System.out.println("(PostID: "+ tempAccount.getPosts().get(i).getPostId()+") " +
                        ": "+ tempAccount.getPosts().get(i).getContent());
                if (tempAccount.getPosts().get(i).getLikesSize()>0)//The number of likes is checked
                {//Followers who like the post are displayed
                    System.out.print("The post was liked by the following account(s): ");
                    for (int j = 0; j < tempAccount.getPosts().get(i).getLikesSize(); j++)
                    {
                        try
                        {
                            for (int k = 0; k < senderListSize; k++)
                            {
                                if(tempAccount.getPosts().get(i).getLikes().getLazy_Deletion()==0 && senderList.get(k).getAccountid()== tempAccount.getPosts().get(i).getLikes().get(j).getAccountId())
                                {
                                    System.out.print(" "+ senderList.get(k).getUsername()+",");
                                }
                            }
                        }
                        catch (Exception e)
                        {
                            System.out.println("Post Interaction Viewving error!");
                        }
                    }
                    System.out.println("");
                }
                else
                    System.out.println("The post has no likes.");

                if (tempAccount.getPosts().get(i).getCommentsSize()>0)
                {
                   // tempCommentSize=tempAccount.getPosts().get(i).getComments().size();
                    for (int j = 0; j < tempAccount.getPosts().get(i).getCommentsSize(); j++)
                    {// Comments on the post are displayed
                        System.out.println("The post has "+ tempAccount.getPosts().get(i).getCommentsSize()+" comment(s)...");
                        try
                        {
                            for (int k = 0; k < senderListSize; k++)
                            {
                                if(tempAccount.getPosts().get(i).getComments().getLazy_Deletion()==0 && senderList.get(k).getAccountid()== tempAccount.getPosts().get(i).getComments().get(j).getAccountId())
                                {
                                    System.out.println("Comment "+commentOrder+": '"+ senderList.get(k).getUsername()+"' said '"+
                                            tempAccount.getPosts().get(i).getComments().get(j).getContent()+"'");
                                    commentOrder++;
                                }
                            }
                            System.out.println("");
                        }
                        catch (Exception e)
                        {
                            System.out.println("Comment display error!");
                        }
                    }
                }
                else
                    System.out.println("The post has no comments.");
            }
        }
        else
            System.out.println("You are not on this account!");
    }

    /**
     * This method blocks the requested user
     * @param tempAccount An Account containing an account object
     */
    public void block(Account tempAccount)
    {// Increase the size of the block array and add the new block account
        String block_History;
        LDLinkedList<Account> newfollowers = new LDLinkedList<Account>();
        LDLinkedList<Account> newfollowing = new LDLinkedList<Account>();
        int j=0;
        try
        {
            if (this.isLoginStatus() == true)//Checking that the account is logged in
            {
                this.getBlockedAccounts().add(tempAccount);
                this.blocksSize++;
                System.out.println("Blocking " + tempAccount.getUsername() + "...");
                block_History= "You blocked "+tempAccount.getUsername() ;
                this.getHistory().add(block_History);
                for (int i = 0; i <this.getFollowersSize(); i++)
                {
                    if (this.getFollowers().get(i).getAccountid()!= tempAccount.getAccountid())
                    {
                        newfollowers.add(j, this.getFollowers().get(i));
                        j++;
                    }
                }
                this.setFollowers(newfollowers,(this.getFollowersSize()-1));
                j=0;
                for (int i = 0; i <tempAccount.getFollowingSize(); i++)
                {
                    if (tempAccount.getFollowing().get(i).getAccountid()!= this.getAccountid())
                    {
                        newfollowing.add(j, tempAccount.getFollowing().get(i));
                        j++;
                    }
                }
                tempAccount.setFollowing(newfollowing,tempAccount.getFollowingSize()-1);
            }
            else
                System.out.println("Error: " + username + " are not logged in!");
        }
        catch (Exception e) {
            System.out.println("Blocking Error!");
        }
    }
    public void unBlock(Account tempAccount)
    {
        // Decrease the size of the block array and delete the new block account
        String unblock_History;
        try
        {
            if(this.isLoginStatus() == true)//Checking that the account is logged in
            {
                for (int i = 0; i < this.getBlockedAccounts().size(); i++)
                {
                    if(this.getBlockedAccounts().get(i)==tempAccount)
                    {
                        this.getBlockedAccounts().remove(tempAccount);
                        //this.blocksSize--;
                        System.out.println("Unblocking " + tempAccount.getUsername() + "...");
                        unblock_History= "You unblocked "+tempAccount.getUsername() ;
                        this.getHistory().add(unblock_History);
                    }
                }
            }
            else
                System.out.println("Error: " + username + " are not logged in!");
        }
        catch (Exception e) {
            System.out.println("Unblocking Error!");
        }
    }
    /**
     * This method Check if this account is a blocked user
     * @param member An Account containing an account object
     * @return The blocking status is checked. Returns 1 if the person is blocked, 0 if not disabled
     */
    public int isBlocked(Account member)
    {//Check if this account is a blocked user
        int findValue=0;
        try
        {
            for (int i = 0; i < member.getBlocksSize(); i++)//Blocked list is checked
            {
                if (member.getBlockedAccounts().get(i) ==this)
                {
                    findValue=1;
                    i=member.getBlocksSize();//for finish loop
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("Blocking Control Error!");
        }

        return findValue;
    }

    public void displayHistory()
    {
        if(loginStatus==true)
        {
            System.out.println("----- "+this.getUsername()+"'s History ------");
            try {
                for (int i = 0; i < this.getHistory().size(); i++)
                {
                    System.out.println( this.getHistory().get(i));
                }
                System.out.println("\n");
            }
            catch (Exception e)
            {
                System.out.println("Displaying History Error!");
            }
        }
        else
            System.out.println("You can display only history of your own account!\n");

    }
    /**
     * This method is used to get a String object representing the value of the Account Object.
     * @return Returns the value of the Account Object as a String object
     */
    @Override
    public String toString()
    {
        String stringFollowings="",stringFollowers="";
        int followerstempSize=getFollowers().size(),followingtempSize=getFollowing().size();
        if(getFollowing().size()<=0)
        {
            stringFollowings="This account doesn't follow anyone yet.";
        }
        else
        {//Following who follow the account are collected as a string
            for (int i = 0; i <getFollowing().size() ; i++)
            {
                if (getFollowing().getLazy_Deletion()!=1)
                {
                    stringFollowings=stringFollowings+" "+ getFollowing().get(i).getUsername()+",";
                }
                else
                    followingtempSize--;
            }
        }
        if(followersSize<=0)
        {
            stringFollowers="No one follows this account yet.";
        }
        else
        {//Followers who follow the account are collected as a string
            for (int i = 0; i <getFollowers().size() ; i++)
            {
                if (getFollowers().getLazy_Deletion()!=1)
                {
                    stringFollowers=stringFollowers+" "+ getFollowers().get(i).getUsername()+",";
                }
                else
                    followerstempSize--;
            }
        }
        return "----------------------"+ '\n' +
                "User ID: " + accountid + '\n' +
                "Username: " + username + '\n' +
                "Location: " + location + '\n' +
                "Birth Date: " + birthdate + '\n' +
                username+" is following "+followingtempSize+" account(s) and has "+followerstempSize+" follower(s)."+ '\n' +
                "The followers of "+username+" are: "+stringFollowers+ '\n' +
                username+" is following: "+stringFollowings+ '\n' +
                username+" has "+ getPosts().size() +" posts" + '\n';
    }
}