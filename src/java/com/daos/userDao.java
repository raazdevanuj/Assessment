package com.daos;

import com.beans.users;
import com.pool.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class userDao {

    public users valid_details(String user_name, String password) {
        users user1 = null;
        ConnectionPool cp = ConnectionPool.getInstance();
        cp.initialize();
        Connection con = cp.getConnection();
        if (con != null) {
            try {
                String sql = "Select * from users where user_name=? and user_password=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setString(1, user_name);
                smt.setString(2, password);
                ResultSet rs = smt.executeQuery();
                if (rs.next()) {
                    user1 = new users();
                    user1.setUser_name(rs.getString("user_name"));
                    user1.setUser_id(rs.getInt("user_id"));
                }

                smt.close();
                cp.putConnection(con);
            } catch (Exception e) {
                System.out.println("DBError :" + e.getMessage());
            }
        }

        return user1;
    }
}
