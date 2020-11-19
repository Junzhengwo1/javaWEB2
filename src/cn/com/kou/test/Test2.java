package cn.com.kou.test;



import cn.com.kou.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author dell
 * @create 2020-10-27  16:41
 * 2、在用户表中新增余额字段，默认为1000元，实现将admin的钱转账
 * 给admin2，要求开启事务
 */
public class Test2 {
    public static void update(Connection connection, String sql, Object... objects) {
        try {
            //预编译sql
            PreparedStatement ps = connection.prepareStatement(sql);
            //填充sql占位符
            for (int i = 0; i < objects.length; i++) {
                ps.setObject(i + 1, objects[i]);
            }
            //执行
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            //取消自动提交事务
            conn.setAutoCommit(false);
            String sql = "update users set balance=balance-1000 where username=?";
            update(conn, sql, "admin");
            sql = "update users set balance=balance+1000 where username=?";
            update(conn, sql, "admin2");
            //提交事务
            conn.commit();
        } catch (Exception e) {
            try {
                //出现错误事务回滚
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                if (conn != null){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
