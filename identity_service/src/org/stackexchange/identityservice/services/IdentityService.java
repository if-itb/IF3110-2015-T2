package org.stackexchange.identityservice.services;

import org.stackexchange.identityservice.dao.TokenDao;
import org.stackexchange.identityservice.model.Token;

import java.util.Date;
import java.util.UUID;

public class IdentityService {

    public Token generateToken(long userId) {
        TokenDao tokenDao = new TokenDao();
        tokenDao.deleteByUserid(userId);

        UUID tokenString = UUID.randomUUID();

        Date date = new Date((new Date()).getTime() + (1 * 60 * 60 * 1000));

        Token token = tokenDao.insert(userId, tokenString.toString(), date);
        return token;
    }

    public boolean tokenValid(String token) {
        TokenDao tokenDao = new TokenDao();

        if (tokenDao.existByToken(token)) {
            Date currentDate = new Date();
            Token tokenObject = tokenDao.getFromToken(token);

            return !currentDate.after(tokenObject.getExpireTime());
        } else {
            return false;
        }
    }

}
