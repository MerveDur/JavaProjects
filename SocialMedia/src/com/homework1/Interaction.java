package com.homework1;
/**
 * This class represents the users' interaction in social media software.
 * @author Merve Dur
 * @version 1.0
 *
 */
public class Interaction {
    /**
     * The Id of the interaction
     */
    private int interactionId;
    /**
     * The Id of interacted account
     */
    private int accountId;
    /**
     * The Id of the post
     */
    private int postId;

    /**
     * This constructs a Interaction with a specified
     * @param interactionId id of interaction
     * @param accountId  id of sender account
     * @param postId id of post
     */
    public Interaction(int interactionId, int accountId, int postId) {
        this.interactionId = interactionId;
        this.accountId = accountId;
        this.postId = postId;
    }

    /**
     * This default constructs a Interaction with a specified
     */
    public Interaction() {
    }
    /** Gets the id of interaction
     * @return An int representing the id of interaction
     */
    public int getInteractionId() {
        return interactionId;
    }
    /** Sets the id of interaction
     * @param interactionId An int containing the id of interaction
     */
    public void setInteractionId(int interactionId) {
        this.interactionId = interactionId;
    }
    /** Gets the sender account's id
     * @return An int representing the sender account's id
     */
    public int getAccountId() {
        return accountId;
    }
    /** Sets the sender account's id
     * @param accountId An int containing the sender account's id
     */
    public void setAccountId(int accountId) {
        this.accountId = accountId;
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
}
