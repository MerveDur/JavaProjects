package com.homework1;
/**
 * This class represents the users' messages in social media software.
 * @author Merve Dur
 * @version 1.0
 *
 */
public class Message {
    /**
     * The ID of the messages
     */
    private int messageId;
    /**
     * The ID of sender account
     */
    private int senderId;
    /**
     * The ID of receiver account
     */
    private int receiverId;
    /**
     * The Content of messages
     */
    private String content;

    /**
     * This constructs a Message with a specified
     * @param messageId id of messages
     * @param senderId id of sender
     * @param receiverId id of receiver
     * @param content content of messages
     */
    public Message(int messageId, int senderId, int receiverId, String content)
    {
        this.messageId = messageId;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.content = content;
    }
    /** Gets the id of message
     * @return An int representing the id of message
     */
    public int getMessageId() {
        return messageId;
    }
    /** Sets the id of message
     * @param messageId An int containing the id of message
     */
    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }
    /** Gets the sender account's id
     * @return An int representing the sender account's id
     */
    public int getSenderId() {
        return senderId;
    }
    /** Sets the sender account's id
     * @param senderId An int containing the sender account's id
     */
    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }
    /** Gets the receiver account's id
     * @return An int representing the receiver account's id
     */
    public int getReceiverId() {
        return receiverId;
    }
    /** Sets the receiver account's id
     * @param receiverId An int containing the receiver account's id
     */
    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }
    /** Gets the content of messages
     * @return A String representing the content of messages
     */
    public String getContent() {
        return content;
    }
    /** Sets the content of messages
     * @param content An int containing the content of messages
     */
    public void setContent(String content) {
        this.content = content;
    }

}
