package cn.com.kou.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author JIAJUN KOU
 *
 * Druid 数据库连接池相关学习
 */
public class DruidDemo1 {
    public static void main(String[] args) throws Exception {
        //加载配置文件
        Properties pro=new Properties();
        InputStream is = DruidDemo1.class.getClassLoader().getResourceAsStream("druid.properties");
        pro.load(is);
        //获取数据库连接池对象
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);
        //获取连接
        Connection conn = ds.getConnection();
        System.out.println(conn);
    }
}
