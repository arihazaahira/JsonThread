package Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class Order {
    private int id;
    private String date;
    private BigDecimal amount;
    @JsonProperty("customer_id")
    private int customerId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    @Override
    public String toString() {
        return "Order{id=" + id + ", customerId=" + customerId + ", date='" + date + "', price=" + amount + "}";
    }

}
