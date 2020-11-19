package cn.com.kou.test;

import cn.com.kou.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author dell
 * @create 2020-10-27  16:26
 * 1、向books表新增10000条数据，内容自定义
 */
public class Test1 {
    public static void main(String[] args) throws SQLException {
        Connection conn = JDBCUtils.getConnection();
        //执行前不允许事务的提交
        conn.setAutoCommit(false);
        String sql = "insert into books(title, author, price, sales, stock, img_path) VALUES (?,?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        for (int i = 0; i < 10000; i++) {
            ps.setObject(1, "司寇大人"+i);
            ps.setObject(2, "司寇佳军");
            ps.setObject(3, 100);
            ps.setObject(4, 1200);
            ps.setObject(5, 130);
            ps.setObject(6, "/c");
            //积攒sql
            ps.addBatch();
            if (i%1000==0){
                //执行batch积攒的sql
                ps.executeBatch();
                //清空batch
                ps.clearBatch();
            }
        }
        //提交事务
        conn.commit();

    }
}
