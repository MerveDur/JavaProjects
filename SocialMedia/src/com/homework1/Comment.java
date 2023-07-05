package com.homework1;
/**
 * This class represents the users' Comment in social media software.This class inherited from Interaction class
 * @author Merve Dur
 * @version 1.0
 *
 */
public class Comment extends Interaction{
    /**
     * The Content of comment
     */
    private String content;

    /**
     *This constructs a Comment with a specified
     * @param interactionId id of interaction(inherit from Interaction )
     * @param accountId id of sender account(inherit from Interaction )
     * @param postId id of post(inherit from Interaction )
     * @param content Content of comment
     */
    public Comment(int interactionId, int accountId, int postId, String content) {
        super(interactionId, accountId, postId);
        this.content = content;
    }
    /** Gets the content of comment
     * @return A String representing the content of comment
     */
    public String getContent() {
        return content;
    }
    /** Sets the content of comment
     * @param content A String containing the content of comment
     */
    public void setContent(String content) {
        this.content = content;
    }
}
