package cn.com.kou.test;

import cn.com.kou.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author JIAJUN KOU
 */
public class Test5 {
    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        conn = JDBCUtils.getConnection();
        /**
         *开启事务
         */
        //conn.setAutoCommit(false);
        //1.先给表users添加一个balance字段
        String sql0="alter table users add balance int null;";

        PreparedStatement pstmt0 = conn.prepareStatement(sql0);
        pstmt0.executeUpdate();
    }
}
