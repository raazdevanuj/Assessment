package com.daos;

import com.pool.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class users_queryDao {

    public boolean add(String url, String response, int user_id) {
        boolean status = false;
        ConnectionPool cp = ConnectionPool.getInstance();
        cp.initialize();
        Connection con = cp.getConnection();
        if (con != null) {
            try {
                PreparedStatement smt = null;
                String sql = "Delete from users_query where url=? and user_id=?";
                smt = con.prepareStatement(sql);
                smt.setString(1, url);
                smt.setInt(2, user_id);
                smt.executeUpdate();

                String sql1 = "insert into users_query(user_id,url,response)values(?,?,?)";
                smt = con.prepareStatement(sql1);
                smt.setInt(1, user_id);
                smt.setString(2, url);
                smt.setString(3, response);
                if (smt.executeUpdate() > 0) {
                    status = true;
                }
                smt.close();
                cp.putConnection(con);
            } catch (Exception e) {
                System.out.println("Error :" + e.getMessage());

            }
        }
        return status;
    }
}
