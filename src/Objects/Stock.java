
package Objects;

public class Stock {
    
    private String Stock_ID;
    private String Stock_Name;
    private String Stock_Type;
    private String Stock_Quantity;

    public Stock(String Stock_ID, String Stock_Name, String Stock_Type, String Stock_Quantity) {
        this.Stock_ID = Stock_ID;
        this.Stock_Name = Stock_Name;
        this.Stock_Type = Stock_Type;
        this.Stock_Quantity = Stock_Quantity;
    }
    
    public String getString() {
        return Stock_ID + " " + Stock_Name + " " + Stock_Type + " " + Stock_Quantity;
    }

    public String getStock_ID() {
        return Stock_ID;
    }

    public void setStock_ID(String Stock_ID) {
        this.Stock_ID = Stock_ID;
    }

    public String getStock_Name() {
        return Stock_Name;
    }

    public void setStock_Name(String Stock_Name) {
        this.Stock_Name = Stock_Name;
    }

    public String getStock_Type() {
        return Stock_Type;
    }

    public void setStock_Type(String Stock_Type) {
        this.Stock_Type = Stock_Type;
    }

    public String getStock_Quantity() {
        return Stock_Quantity;
    }

    public void setStock_Quantity(String Stock_Quantity) {
        this.Stock_Quantity = Stock_Quantity;
    }
    
    
    
}
