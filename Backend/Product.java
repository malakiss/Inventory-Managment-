package Backend;



public class Product implements ProdGeneric{
private String productId;
private String productName;
private String manufacturerName;
private String supplierName;
private int quantity;
private float price;

    

    public int getQuantity() {
        setQuantity(quantity);
        return quantity;
    }

    public void setQuantity(int quantity) {
        if(quantity>=0)
        this.quantity = quantity;
        else {
            System.out.println("Invalid quantity");
            this.quantity=0;
        }
    }

    public float getPrice() {
        return price;
    }
    
  public Product(String productId, String productName, String manufacturerName, String supplierName, int quantity, float price) {
        this.productId = productId;
        this.productName = productName;
        this.manufacturerName = manufacturerName;
        this.supplierName = supplierName;
        setQuantity(quantity);
        this.price = price;
    }
  
@Override
    public String lineRepresentation()
{return productId + ","+productName + "," +manufacturerName +","+supplierName +","+quantity+","+price;
}
        

    @Override
 public String getSearchKey()
{
    return this.productId;
}
  @Override
    public String toString() {
        return lineRepresentation();
    }
}
