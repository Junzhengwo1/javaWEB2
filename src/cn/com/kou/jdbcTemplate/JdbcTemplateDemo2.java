package cn.com.kou.jdbcTemplate;

import cn.com.kou.domain.Account;
import cn.com.kou.utils.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author JIAJUN KOU
 *
 * JdbcTemplate 案例练习
 *      需求分析
 *      1.修改一号数据 balance为5200
 *      2.添加一条记录
 *      3.删除刚刚的记录
 *      4.查询id为2的记录，将其封装为Map集合
 *      5.查询所有记录，建其封装为list
 *      6.查询所有记录，将其封装为account对象的list集合
 *      7.查询总记录数
 */
public class JdbcTemplateDemo2 {
    //1.获取JDBCTemplate 对象

    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    //Junit 单元测试，可以让方法独立执行

    /**
     * 1.修改一号数据 balance为5200
     */
    @Test
    public  void test1(){
        System.out.println("我被执行了......");
        //2.定义Sql
        String sql="update account set balance=5200 where id=1";
        //3.执行sql
        int count = template.update(sql);
        System.out.println(count);
    }

    /**
     * 2.添加一条记录
     */
    @Test
    public void test2(){
        String sql="insert into account (id ,name,balance) values(?,?,?)";
        int count = template.update(sql, 11, "kou", 12345);
        System.out.println(count);
    }

    /**
     * 3.删除刚刚的记录
     */
    @Test
    public void test3(){
        String sql="delete from account where id=?";
        int count = template.update(sql, 10);
        System.out.println(count);

    }

    /**
     * 查询id为2的记录，将其封装为Map集合
     *
     */
    @Test
    public void test4(){
        String sql="select *from account where id=?";
        Map<String, Object> map = template.queryForMap(sql, 2);
        System.out.println(map);
    }

    /**
     * 查询所有记录，建其封装为list
     */
    @Test
    public void test5(){
        String sql="select *from account";
        List<Map<String, Object>> list = template.queryForList(sql);
        for (Map<String, Object> map : list) {
            System.out.println(map);
        }
    }

    /**
     * 6.查询所有记录，将其封装为account对象的list集合
     */
    @Test
    public void test6(){
        String sql="select * from account";
        List<Account> list = template.query(sql, new RowMapper<Account>() {
            @Override
            public Account mapRow(ResultSet resultSet, int i) throws SQLException {
                Account account=new Account();
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double balance = resultSet.getDouble("balance");
                account.setId(id);
                account.setName(name);
                account.setBalance(balance);
                return account;
            }
        });
        for (Account account : list) {
            System.out.println(account);
        }
    }
    /**
     * 6.查询所有记录，将其封装为account对象的list集合
     */
    @Test
    public void test6_2(){
        String sql="select * from account";
        List<Account> list = template.query(sql, new BeanPropertyRowMapper<Account>(Account.class));
        for (Account account : list) {
            System.out.println(account);
        }
    }

    /**
     * 7.查询总记录数
     */
    @Test
    public void test7(){
        String sql ="select count(id) from account";
        Long total = template.queryForObject(sql, long.class);
        System.out.println(total);
    }

}
