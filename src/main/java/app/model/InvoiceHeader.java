package app.model;

import java.util.ArrayList;
import java.util.Date;

public class InvoiceHeader {
    private int invoiceNum;
    private Date invoiceDate;
    private String customerName;
    private ArrayList<InvoiceLine> items;

    public InvoiceHeader(int invoiceNum, Date invoiceDate, String customerName) {
        this.invoiceNum = invoiceNum;
        this.invoiceDate = invoiceDate;
        this.customerName = customerName;
    }

    public InvoiceHeader() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getName() {
        return customerName;
    }

    public void setName(String name) {
        this.customerName = name;
    }

    public int getNum() {
        return invoiceNum;
    }

    public void setNum(int num) {
        this.invoiceNum = num;
    }

    public Date getDate() {
        return invoiceDate;
    }

    public void setDate(Date date) {
        this.invoiceDate = date;
    }

    public ArrayList<InvoiceLine> getItems() {
        if (items == null)
        {
            items = new ArrayList();
        }
        return items;
    }

    @Override
    public String toString() {
        return "Header{" + "num=" + invoiceNum + ", date=" + invoiceDate + ", name=" + customerName + ", items=" + items + '}';
    }
     
    public double getTotal()
{
    double total = 0.0;
    for (InvoiceLine item : getItems())
    {
        total += item.getTotal();
    }
    return total;
}
}
