//import javax.lang.model.element.QualifiedNameable;

public class Item {
    private String name;
    private double price;
    private int quantity;

    public Item(String name, double price, int quantity){
        if(name.isBlank()|| name==null || price<=0 || quantity<0){
            throw new IllegalArgumentException("Enter Valid Item Details!");
        }
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
    
    public Item(Item source){
        this.name = source.name;
        this.price = source.price;
        this.quantity = source.quantity;
    }

    public void setName(String name) {
        if(name.isBlank()|| name==null){
            throw new IllegalArgumentException("Enter Valid Item Name!");
        }
        this.name = name;
    }

    public void setPrice(double price) {
        if(price<0){
            throw new IllegalArgumentException("Not Valid Price");
        }
        this.price = price;
    }
    
    public void setQuantity(int quantity) {
        if(quantity<0){
            throw new IllegalArgumentException("Not Valid Quantity");
        }
        this.quantity = quantity;
    }

    public String getName() {
        return this.name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public int getQuantity() {
        return quantity;
    }


    public String toString(){
        return ("\n"+this.name+" : "+this.price+" ("+this.quantity+")");
    }

}
