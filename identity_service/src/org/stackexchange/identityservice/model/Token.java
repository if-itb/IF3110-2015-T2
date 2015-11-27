package org.stackexchange.identityservice.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Token {

    private long id;

    private String token;

    private long userId;

    private Date expire;

    public Token(long id, String token, long userId, String expire) {
        this.id = id;
        this.token = token;
        this.userId = userId;
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
        try {
            this.expire = formatter.parse(expire);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getToken() {
        return token;
    }

    public long getUserId() {
        return userId;
    }

    public Date getExpireTime() {
        return  expire;
    }
}
