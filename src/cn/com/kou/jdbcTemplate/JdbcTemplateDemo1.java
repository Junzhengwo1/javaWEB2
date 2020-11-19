package cn.com.kou.jdbcTemplate;

import cn.com.kou.utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author JIAJUN KOU
 * JdbcTemplate 快速入门
 */
public class JdbcTemplateDemo1 {
    public static void main(String[] args) {
        //1.导入相关包
        //2.创建JDBCTemplate对象
        JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
        //3.调用方法
        String sql="update account set balance=6000 where id=?";
        int count = template.update(sql, 3);
        System.out.println(count);

    }
}
