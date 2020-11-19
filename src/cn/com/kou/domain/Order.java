package cn.com.kou.domain;

import java.util.Date;

/**
 * @author dell
 */
public class Order {
    private String id;
    private Date order_time;
    private int total_count;
    private  double total_amount;
    private   int state;
    private  int user_id;

    public Order() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getOrder_time() {
        return order_time;
    }

    public void setOrder_time(Date order_time) {
        this.order_time = order_time;
    }

    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

    public double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(double total_amount) {
        this.total_amount = total_amount;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", order_time=" + order_time +
                ", total_count=" + total_count +
                ", total_amount=" + total_amount +
                ", state=" + state +
                ", user_id=" + user_id +
                '}';
    }
}
