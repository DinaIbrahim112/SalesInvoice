package app.model;

public class InvoiceLine {
    private int invNumber;
    private String itemName;
    private double itemPrice;
    private int count;

    public InvoiceLine(int inv, String itemName, int count, double itemPrice) {
        this.invNumber = inv;
        this.itemName = itemName;
        this.count = count;
        this.itemPrice = itemPrice;
    }

    public InvoiceLine() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public double getPrice() {
        return itemPrice;
    }

    public void setPrice(double price) {
        this.itemPrice = price;
    }

    public String getName() {
        return itemName;
    }

    public void setName(String name) {
        this.itemName = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Item{" + "name=" + itemName + ", count=" + count + ", price=" + itemPrice + '}';
    }
    public double getTotal()
    {
        return count * itemPrice;
    }

    public int getInvNumber() {
        return invNumber;
    }

    public void setInvNumber(int invNumber) {
        this.invNumber = invNumber;
    }
}
