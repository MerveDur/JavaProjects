package com.homework1;

/**
 * This class represents the users' posts in social media software.
 * @author Merve Dur
 * @version 1.0
 *
 */
public class Post {
    /**
     * The Id of the post
     */
    private int postId;
    /**
     * The Id of posted account
     */
    private int accountId;
    /**
     * The Array of likes
     */
    private Like[] likes=new Like[1000];
    /**
     * The Size of like array
     */
    private int likesSize;
    /**
     * The Array of comments
     */
    private Comment[] comments=new Comment[1000];
    /**
     * The Size of comment array
     */
    private int commentsSize;
    /**
     * The Content of post
     */
    private String content;

    /**
     * This constructs a Post with a specified
     * @param postId id of post
     * @param accountId id of posted account
     * @param content content of post
     */
    public Post(int postId, int accountId, String content) {
        this.postId = postId;
        this.accountId = accountId;
        this.content = content;
        likesSize=0;//initial value set to 0
        commentsSize=0;//initial value set to 0
    }
    /** Gets the id of post
     * @return An int representing the id of post
     */
    public int getPostId() {
        return postId;
    }
    /** Sets the id of post
     * @param postId An int containing the id of post
     */
    public void setPostId(int postId) {
        this.postId = postId;
    }
    /** Gets the id of posted account
     * @return An int representing the id of posted account
     */
    public int getAccountId() {
        return accountId;
    }
    /** Sets the id of posted account
     * @param accountId An int containing the id of posted account
     */
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
    /** Gets the like array
     * @return A Like array representing the like array of the post
     */
    public Like[] getLikes() {
        return likes;
    }
    /** Sets the like array
     * @param likes An int containing the like array
     */
    public void setLikes(Like[] likes) {
        this.likes = likes;
    }
    /** Gets the comments array of post
     * @return A Comment array representing the comments array of post
     */
    public Comment[] getComments() {
        return comments;
    }
    /** Sets the comments array of post
     * @param comments An int containing the comments array of post
     */
    public void setComments(Comment[] comments) {
        this.comments = comments;
    }
    /** Gets the content of message
     * @return A String representing the content of message
     */
    public String getContent() {
        return content;
    }
    /** Sets the content of message
     * @param content An int containing the content of message
     */
    public void setContent(String content) {
        this.content = content;
    }
    /** Gets the size of like array
     * @return An int representing the size of like array
     */
    public int getLikesSize() {
        return likesSize;
    }
    /** Sets the size of like array
     * @param likesSize An int containing the size of like array
     */
    public void setLikesSize(int likesSize) {
        this.likesSize = likesSize;
    }
    /** Gets the size of comment array
     * @return An int representing the size of comment array
     */
    public int getCommentsSize() {
        return commentsSize;
    }
    /** Sets the size of comment array
     * @param commentsSize An int containing the size of comment array
     */
    public void setCommentsSize(int commentsSize) {
        this.commentsSize = commentsSize;
    }
    /** This method adds a like in like array
     * @param tempLike A like containing a new like object
     */
    public void addLike(Like tempLike)
    {
        int likeIdControl=0;
        for (int i = 0; i < likesSize; i++)
        {
            if (likes[i].getInteractionId()==tempLike.getInteractionId())
                likeIdControl=1;
        }
        if (likeIdControl==0)
        {
            try
            {
                this.likes[likesSize]=tempLike;
                this.likesSize++;
            }
            catch (Exception e)
            {
                System.out.println("Like Error!");
            }
        }
        else
            System.out.println("Like Interaction id must be unique!");
    }
    /** This method adds a comment in comment array
     * @param tempComment A like containing a new comment object
     */
    public void addComment(Comment tempComment)
    {
        int commentIdControl=0;
        for (int i = 0; i < commentsSize; i++)
        {
            if (comments[i].getInteractionId()==tempComment.getInteractionId())
                commentIdControl=1;
        }
        if (commentIdControl==0)
        {
            try
            {
                this.comments[commentsSize]=tempComment;
                this.commentsSize++;
            }
            catch (Exception e)
            {
                System.out.println("Comment Error!");
            }
        }
        else
            System.out.println("Comment Interaction id must be unique!");
    }

}
