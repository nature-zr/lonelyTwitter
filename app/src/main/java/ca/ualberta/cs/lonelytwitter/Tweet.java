package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public abstract class Tweet implements Tweetable {
    private Date date;
    private String message;
    //private String hiddenString;

    public Tweet(Date date, String message) throws TweetToLongException {
        this.date = date;
        this.message = message;
    }


    public Tweet(String message) throws TweetToLongException{
        this.message = message;
        this.date = new Date(); 
    }

    public abstract Boolean isImportant();

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) throws TweetToLongException{
        if(message.length() > 144) {
            throw new TweetToLongException();
        }else {
            this.message = message;
        }
    }

    @Override
    public String toString(){
        return date.toString() + " | " + message;
    }
}
