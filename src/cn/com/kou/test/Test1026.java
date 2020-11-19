package cn.com.kou.test;

import org.junit.Test;
import cn.com.kou.utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author JIAJUN KOU
 */
public class Test1026 {
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 使用JDBC实现查询所有图书信息
     */
   @Test
    public  void test1(){
        //2.定义Sql
        String sql="select * from books";
        //3.执行sql
       List<Map<String, Object>> list = template.queryForList(sql);
       for (Map<String, Object> map : list) {
           System.out.println(map);
       }

    }




    /**
     * 使用JDBC实现删除订单“15275760194821”的相关信息，注意涉
     * 及到两张表
     */
    @Test
    public void test3(){

    }

}
