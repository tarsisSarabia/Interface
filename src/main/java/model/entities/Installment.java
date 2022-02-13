package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Installment {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private Date duedate;
    private Double amount;

    public Installment(Date duedate, Double amount) {
        this.duedate = duedate;
        this.amount = amount;
    }

    public Date getDuedate() {
        return duedate;
    }

    public void setDuedate(Date duedate) {
        this.duedate = duedate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return sdf.format(duedate) + " - " + String.format("%.2f", amount);
    }
    
    
}
