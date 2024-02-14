
package Backend;



import java.time.LocalDate;


public class CustomerProduct implements ProdGeneric {
    private String customerSSN;
    private String productId;
    private LocalDate purchaseDate;

    public CustomerProduct(String customerSSN, String productId, LocalDate purchaseDate) {
        this.customerSSN = customerSSN;
        this.productId = productId;
        this.purchaseDate = purchaseDate;
    }

    public String getCustomerSSN() {
        return customerSSN;
    }

    public String getProductId() {
        return productId;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }
    @Override
    public  String lineRepresentation(){
        int day=purchaseDate.getDayOfMonth();
        int month=purchaseDate.getMonthValue();
        int year =purchaseDate.getYear();
        return customerSSN+","+productId+","+day+"-"+month+"-"+year;
    }
    @Override
    public String getSearchKey(){
         return lineRepresentation();
    }
     @Override
    public String toString() {
        return lineRepresentation();
    }

   
}