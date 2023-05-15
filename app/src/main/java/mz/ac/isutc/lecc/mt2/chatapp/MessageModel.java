package mz.ac.isutc.lecc.mt2.chatapp;

import java.util.Date;

public class MessageModel {

    private String msgId;
    private String senderId;
    private String message;

    private Date created;

    public MessageModel(String msgId, String senderId, String message, Date created) {
        this.msgId = msgId;
        this.senderId = senderId;
        this.message = message;
        this.created = created;
    }

    public MessageModel() {
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
