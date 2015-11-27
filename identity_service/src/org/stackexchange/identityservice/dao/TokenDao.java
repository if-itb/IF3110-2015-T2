package org.stackexchange.identityservice.dao;

import org.stackexchange.identityservice.core.MySQLDao;
import org.stackexchange.identityservice.model.Token;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class TokenDao extends MySQLDao {

    public boolean existByToken(String token) {
        String query = "SELECT * FROM `token` WHERE token='" + token + "'";
        Statement statement;
        boolean exist = false;

        try {
            getConnection();
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);

            if (rs.next()) {
                exist = true;
            }
            rs.close();
            statement.close();
            closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return exist;
    }

    public boolean existByUserid(long userId) {
        String query = "SELECT * FROM `token` WHERE user_id='" + userId + "'";
        Statement statement;
        boolean exist = false;

        try {
            getConnection();
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);

            if (rs.next()) {
                exist = true;
            }
            rs.close();
            statement.close();
            closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return exist;
    }

    public Token getFromToken(String token) {
        String query = "SELECT * FROM `token` WHERE token='" + token + "'";
        Statement statement;

        try {
            getConnection();
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);

            boolean exist = false;
            long id = 0;
            long userId = 0;

            String date = "";

            while (rs.next()) {
                id = rs.getInt("id");
                userId = rs.getInt("user_id");
                date = rs.getString("expire");
                exist = true;
            }

            rs.close();
            statement.close();
            closeConnection();
            if (exist) {
                return new Token(id, token, userId, date);
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Token insert(long userId, String token, Date expire) {
        java.sql.Timestamp sqlDate = new java.sql.Timestamp(expire.getTime());
        String query = "INSERT INTO `token` (`user_id`, `token`, `expire`) VALUES (" + userId + ", '" + token + "', '" + sqlDate + "')";
        System.out.println(query);
        Statement statement;

        try {
            getConnection();
            statement = conn.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = statement.getGeneratedKeys();
            int insertedId = 0;
            if (rs.next()) {
                insertedId = rs.getInt(1);
            }

            Token insertedToken = new Token(insertedId, token, userId, sqlDate.toString());

            rs.close();
            statement.close();
            closeConnection();

            return insertedToken;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deleteByUserid(long userId) {
        String query = "DELETE FROM `token` WHERE user_id=" + userId;
        Statement statement;

        try {
            getConnection();
            statement = conn.createStatement();
            statement.execute(query);

            statement.close();
            closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
