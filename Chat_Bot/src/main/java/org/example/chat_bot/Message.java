package org.example.chat_bot;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {
    private String UserName;
    private String Message;
    private Date date;

    public Message(String userName,String message){
        UserName = userName;
        Message = message;
        date = new Date();
    }

    public Message(String userName,String message, long time){
        UserName = userName;
        Message = message;
        date = new Date(time);
    }

    public String getMessage() {
        return Message;
    }

    public Date getDate() {
        return date;
    }

    public String getUserName() {
        return UserName;
    }

    @Override
    public String toString(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.YY H:mm");
        return formatter.format(date) + " " + UserName + ": " + Message;
    }
}
