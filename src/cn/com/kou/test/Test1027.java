package cn.com.kou.test;

import cn.com.kou.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author JIAJUN KOU
 */
public class Test1027 {

    public static void main(String[] args) throws SQLException {
        //test1();

        test2();
    }


    public static void test1() throws SQLException {
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

    public static void test2() throws SQLException {
        Connection conn=null;
        PreparedStatement pstmt=null;
        PreparedStatement pstmt2=null;
        //1.获取连接
        try {
            conn = JDBCUtils.getConnection();
            /**
             *开启事务
             */
            conn.setAutoCommit(false);

            //2.定义sql
            String sql1="update account set balance =balance- ? where id= ? ";
            String sql2="update account set balance =balance + ?  where id= ?";
            //3.获取执行sql对象
            pstmt = conn.prepareStatement(sql1);
            pstmt2 = conn.prepareStatement(sql2);
            //4.设置参数
            pstmt.setDouble(1,500);
            pstmt.setInt(2,1);
            pstmt2.setDouble(1,500);
            pstmt2.setInt(2,2);
            //5.执行sql
            pstmt.executeUpdate();
            pstmt2.executeUpdate();
            /**
             *提交事务
             */
            conn.commit();

        } catch (Exception e) {
            try {
                if(conn!=null){
                    conn.rollback();
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            JDBCUtils.close(pstmt,conn);
            JDBCUtils.close(pstmt2,null);

        }
    }

}
