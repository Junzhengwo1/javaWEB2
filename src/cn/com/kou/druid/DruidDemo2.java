package cn.com.kou.druid;

import cn.com.kou.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author JIAJUN KOU
 *
 * 使用工具类 测试
 */
public class DruidDemo2 {
    public static void main(String[] args) {
        /**
         * 完成添加操作 给account表添加一条记录
         *
         */
        Connection conn=null;
        PreparedStatement pstmt=null;

        //1.获取连接
        try {
            conn = JDBCUtils.getConnection();
            //定义sql语句
            String sql="insert into account values(null,?,?)";
            //获取pstmt对象
            pstmt=conn.prepareStatement(sql);
            //给？赋值
            pstmt.setString(1,"王五");
            pstmt.setDouble(2,1020);
            //执行sql
            int count = pstmt.executeUpdate();
            System.out.println(count);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(pstmt,conn);
        }

    }
}
