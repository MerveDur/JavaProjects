package com.homework1;
/**
 * This class represents the users' Like in social media software.This class inherited from Interaction class
 * @author Merve Dur
 * @version 1.0
 *
 */
public class Like extends Interaction
{
     /**This constructs a Like with a specified
     * @param interactionId id of interaction(inherit from Interaction )
     * @param accountId id of sender account(inherit from Interaction )
     * @param postId id of post(inherit from Interaction )
     */
    public Like(int interactionId, int accountId, int postId) {
        super(interactionId, accountId, postId);
    }
}
