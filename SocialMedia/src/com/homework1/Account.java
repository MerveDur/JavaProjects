package com.homework1;
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
    private Post[] posts = new Post[1000];
    /**
     * The Array size of posts
     */
    private int postSize;
    /**
     * The Array of messages
     */
    private Message[] messages = new Message[1000];
    /**
     * The Array size of messages
     */
    private int messagesSize;// Array size of messages
    /**
     * The Array of following accounts
     */
    private Account[] following = new Account[1000];
    /**
     * The Array size of following
     */
    private int followingSize;
    /**
     * The Array of follower accounts
     */
    private Account[] followers = new Account[1000];
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
    private Account[] blockedAccounts=new Account[1000];
    /**
     * The Array size of blocked accounts
     */
    private int blocksSize;
    /**
     * This constructs an account with a specified
     * accountid username, birthdate, location, loginStatus
     * @param accountid user's id
     * @param username user's user name
     * @param birthdate user's birthdate
     * @param location user's location
     * @param loginStatus user's login status
    */
    public Account(Account[] accounts,int accontSize,int accountid, String username, String birthdate, String location, boolean loginStatus)
    {
        int usernameControl=0,accountIdControl=0;
        for (int i = 0; i < accontSize; i++) {
            if(accounts[i].getUsername()==username)
            {
                usernameControl=1;
            }
            if(accounts[i].getAccountid()==accountid)
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
    public Post[] getPosts() {
        return posts;
    }
    /** Sets the account’s posts.
     * @param posts A Post array containing the account’s posts
     */
    public void setPosts(Post[] posts) {
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
    public Message[] getMessages() {
        return messages;
    }
    /** Sets the account’s messages.
     * @param messages A Message array containing the account’s messages
     */
    public void setMessages(Message[] messages) {
        this.messages = messages;
    }
    /** Gets the account’s following accounts array.
     * @return An Account array representing the account’s following accounts array.
     */
    public Account[] getFollowing() {
        return following;
    }
    /** Sets the account’s following.
     * @param following An Account array containing the account’s following
     */
    public void setFollowing(Account[] following,int newFollowingSize)
    {
        for (int i = 0; i < newFollowingSize; i++)
        {
            this.following[i]=following[i];
        }
        this.setFollowingSize(newFollowingSize);
    }
    /** Gets the account’s followers accounts array.
     * @return An Account array representing the account’s followers accounts array.
     */
    public Account[] getFollowers() {
        return followers;
    }
    /** Sets the account’s followers.
     * @param followers An Account array containing the account’s followers
     */
    public void setFollowers(Account[] followers,int newFollowerSize)
    {
        for (int i = 0; i < newFollowerSize; i++)
        {
            this.followers[i]=followers[i];
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
    public Account[] getBlockedAccounts() {
        return blockedAccounts;
    }
    /** Sets the account’s blocked accounts.
     * @param blockedAccounts An Account array containing the account’s blocked accounts
     */
    public void setBlockedAccounts(Account[] blockedAccounts) {
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
            this.getPosts()[this.postSize] = newPost;
            this.postSize++;
        }
        else
            System.out.println("Error: " + username + " are not logged in!");
    }
    /** This method allows you to follow another user.
     * @param newFollow An Account containing a new account object
     */
    public void follow(Account newFollow) {
        // Increase the size of the following array and add the new following
        try
        {
            if(this.isLoginStatus() == true)//In order to follow the account, the account must be logged in.
            {
                if(this.isBlocked(newFollow)==0)//To be able to follow the account, it must not be blocked by the other account.
                {
                    this.getFollowing()[this.followingSize] = newFollow;
                    this.followingSize++;
                    addFollower(newFollow);
                    System.out.println("Following " + newFollow.getUsername() + "...");
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
    /**This method adds this account to the followers of the followed account.
     * @param follower An Account containing an account object
     */
    public void addFollower(Account follower)
    {// Increase the size of the follower array and add the new follower
        follower.getFollowers()[follower.getFollowersSize()] = this;
        follower.setFollowersSize(follower.getFollowersSize()+1);
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
                        System.out.println("(PostID: "+ tempAccount.getPosts()[i].getPostId()+") " +tempAccount.getUsername()
                                +": "+ tempAccount.getPosts()[i].getContent());
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
            if (receiver.getMessages()[i].getMessageId()==tempMessage.getMessageId())
            {
                messageIdControl=1;
            }
        }
        for (int i = 0; i <receiver.getFollowersSize(); i++)
        {//That account must be followed in order to send a message.
            if(receiver.getFollowers()[i]==this)
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
                            this.messages[this.messagesSize]=tempMessage;
                            messagesSize++;
                            receiver.getMessages()[receiver.getMessagesSize()]=tempMessage;
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
                    if (messages[i].getReceiverId() == this.getAccountid()) {//According to the sender/receiver account IDs, the message is considered as an incoming or outgoing message.
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
                    if(messages[i].getSenderId()==this.getAccountid())
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
    public  void viewingInbox(Account[] senderList,int senderListSize)
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
                    if (messages[i].getReceiverId() == this.getAccountid()) {//If the receiver id and this account id are equal, those messages are displayed as inbox.
                        System.out.println("----------------------");
                        System.out.println("Message ID: " + messages[i].getMessageId());
                        for (int j = 0; j < senderListSize; j++) {
                            if (senderList[j].getAccountid() == messages[i].getSenderId()) {//According to the sender/receiver account IDs, the message is considered as an incoming or outgoing message.
                                System.out.println("From: " + senderList[j].getUsername());
                                j = senderListSize;
                            }
                        }
                        System.out.println("To: " + this.getUsername());
                        System.out.println("Message: " + messages[i].getContent());
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
    public  void viewingOutbox(Account[] senderList,int senderListSize)
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
                    if (messages[i].getSenderId() == this.getAccountid()) {//If the sender id and this account id are equal, those messages are displayed as inbox.
                        System.out.println("----------------------");
                        System.out.println("Message ID: " + messages[i].getMessageId());
                        for (int j = 0; j < senderListSize; j++) {
                            if (senderList[j].getAccountid() == messages[i].getReceiverId()) {//According to the sender/receiver account IDs, the message is considered as an incoming or outgoing message.
                                System.out.println("From: " + senderList[j].getUsername());
                                j = senderListSize;
                            }
                        }
                        System.out.println("To: " + this.getUsername());
                        System.out.println("Message: " + messages[i].getContent());
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
    public void  viewingPostsInteractions(Account tempAccount,Account[] senderList,int senderListSize)
    {
        int commentOrder=1;
        if(tempAccount.viewingStatus==true)
        {
            System.out.println("Viewing "+tempAccount.getUsername()+"'s posts' interactions...");
            for (int i = 0; i < tempAccount.getPostSize(); i++)
            {
                System.out.println("----------------------");
                System.out.println("(PostID: "+ tempAccount.getPosts()[i].getPostId()+") " +
                        ": "+ tempAccount.getPosts()[i].getContent());
                if (tempAccount.getPosts()[i].getLikesSize()>0)//The number of likes is checked
                {//Followers who like the post are displayed
                    System.out.print("The post was liked by the following account(s): ");
                    for (int j = 0; j <tempAccount.getPosts()[i].getLikesSize();j++)
                    {
                        try
                        {
                            for (int k = 0; k < senderListSize; k++)
                            {
                                if(senderList[k].getAccountid()==tempAccount.getPosts()[i].getLikes()[j].getAccountId())
                                {
                                    System.out.print(" "+senderList[k].getUsername()+",");
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

                if (tempAccount.getPosts()[i].getCommentsSize()>0)
                {
                    for (int j = 0; j <tempAccount.getPosts()[i].getCommentsSize();j++)
                    {// Comments on the post are displayed
                        System.out.println("The post has "+tempAccount.getPosts()[i].getCommentsSize()+" comment(s)...");
                        try
                        {
                            for (int k = 0; k < senderListSize; k++)
                            {
                                if(senderList[k].getAccountid()==tempAccount.getPosts()[i].getComments()[j].getAccountId())
                                {
                                    System.out.println("Comment "+commentOrder+": '"+senderList[k].getUsername()+"' said '"+
                                            tempAccount.getPosts()[i].getComments()[j].getContent()+"'");
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
        Account[] newfollowers = new Account[1000];
        Account[] newfollowing = new Account[1000];
        int j=0;
        try
        {
            if (this.isLoginStatus() == true)//Checking that the account is logged in
            {
                this.getBlockedAccounts()[this.blocksSize] = tempAccount;
                this.blocksSize++;
                System.out.println("Blocking " + tempAccount.getUsername() + "...");
                for (int i = 0; i <this.getFollowersSize(); i++)
                {
                    if (this.getFollowers()[i].getAccountid()!= tempAccount.getAccountid())
                    {
                        newfollowers[j]= this.getFollowers()[i];
                        j++;
                    }
                }
                this.setFollowers(newfollowers,(this.getFollowersSize()-1));
                j=0;
                for (int i = 0; i <tempAccount.getFollowingSize(); i++)
                {
                    if (tempAccount.getFollowing()[i].getAccountid()!= this.getAccountid())
                    {
                        newfollowing[j]= tempAccount.getFollowing()[i];
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
                if (member.getBlockedAccounts()[i]==this)
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

    /**
     * This method is used to get a String object representing the value of the Account Object.
     * @return Returns the value of the Account Object as a String object
     */
    @Override
    public String toString()
    {

        String stringFollowings="",stringFollowers="";
        if(followingSize<=0)
        {
            stringFollowings="This account doesn't follow anyone yet.";
        }
        else
        {//Following who follow the account are collected as a string
            for (int i = 0; i <followingSize ; i++)
            {
                stringFollowings=stringFollowings+" "+getFollowing()[i].getUsername()+",";
            }
        }
        if(followersSize<=0)
        {
            stringFollowers="No one follows this account yet.";
        }
        else
        {//Followers who follow the account are collected as a string
            for (int i = 0; i <followersSize ; i++)
            {
                stringFollowers=stringFollowers+" "+getFollowers()[i].getUsername()+",";
            }
        }
        return "----------------------"+ '\n' +
                "User ID: " + accountid + '\n' +
                "Username: " + username + '\n' +
                "Location: " + location + '\n' +
                "Birth Date: " + birthdate + '\n' +
                username+" is following "+followingSize+" account(s) and has "+followersSize+" follower(s)."+ '\n' +
                "The followers of "+username+" are: "+stringFollowers+ '\n' +
                username+" is following: "+stringFollowings+ '\n' +
                username+" has "+ postSize +" posts" + '\n';
    }
}